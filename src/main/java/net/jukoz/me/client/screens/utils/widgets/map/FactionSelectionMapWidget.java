package net.jukoz.me.client.screens.utils.widgets.map;

import net.jukoz.me.client.screens.controllers.FactionSelectionController;
import net.jukoz.me.resources.datas.factions.data.SpawnData;
import net.jukoz.me.resources.datas.factions.data.SpawnDataHandler;
import net.jukoz.me.utils.LoggerUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.joml.Vector2d;
import org.joml.Vector2i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FactionSelectionMapWidget extends MapWidget {
    MapMarkerWidget[] spawnMapMarkers;
    FactionSelectionController controller;
    public FactionSelectionMapWidget(FactionSelectionController controller, int mapWidth, int mapHeight) {
        super(mapWidth, mapHeight);
        this.controller = controller;
        final int[] maxSpawnCount = {0};
        this.controller.getFactions().values().forEach(factionList -> factionList.forEach(faction -> {
            SpawnDataHandler spawnDataHandler = faction.getSpawnData();
            if(spawnDataHandler != null && spawnDataHandler.getSpawnList() != null){
                int count = spawnDataHandler.getSpawnList().size();
                if(count > maxSpawnCount[0]){
                    maxSpawnCount[0] = count;
                }
            }
        }));
        spawnMapMarkers = new MapMarkerWidget[maxSpawnCount[0]];
        for(int i = 0; i< maxSpawnCount[0]; i++){
            int finalIndex = i;
            spawnMapMarkers[i] = new MapMarkerWidget("SpawnButton_" + i, x -> selectSpawn(finalIndex));
            spawnMapMarkers[i].setType(MapMarkerType.DYNAMIC_SPAWN);
        }
    }
    public ButtonWidget[] getButtons() {
        ButtonWidget[] spawnButtonArray = new ButtonWidget[spawnMapMarkers.length];
        for(int i = 0; i < spawnMapMarkers.length; i++){
            spawnButtonArray[i] = spawnMapMarkers[i].getButton();
        }
        return spawnButtonArray;
    }

    private void selectSpawn(int index){
        LoggerUtil.logDebugMsg("Clicked on spawn #" + index);
    }

    protected double getMarkerGroupUpRadius(){
        return 15;
    }
    @Override
    protected void draw(DrawContext context, int startX, int startY) {
        super.draw(context, startX, startY);
        SpawnDataHandler handler = controller.getCurrentSpawnDataHandler();
        if(handler == null || handler.getSpawnList() == null) return;
        List<SpawnData> spawns = handler.getSpawnList();
        HashMap<Integer, List<Vector2i>> uniqueIndexes = new HashMap<>();
        for(int i = 0; i < spawns.size(); i++){
            SpawnData spawnData = spawns.get(i);
            Vector2d coordinates = new Vector2d(spawnData.getCoordinates().getX(), spawnData.getCoordinates().getZ());
            MapMarkerWidget mapMarker = spawnMapMarkers[i];
            if(spawnData.isDynamic()){
                mapMarker.setType(MapMarkerType.DYNAMIC_SPAWN);
                mapMarker.computeFromMapPosition(this, coordinates);
            } else {
                mapMarker.setType(MapMarkerType.CUSTOM_SPAWN);
                mapMarker.computeFromWorldPosition(this, coordinates);
            }
            Vector2i currentCenterCoordinate = mapMarker.getCenterCoordinates();
            boolean isSeperate = true;
            int currentUniqueIndex = 0;
            for(int j = 0; j < uniqueIndexes.size() && isSeperate; j++){
                currentUniqueIndex = uniqueIndexes.keySet().stream().toList().get(j);
                List<Vector2i> currentList = uniqueIndexes.get(currentUniqueIndex);
                for (Vector2i vector2i : currentList) {
                    double distance = currentCenterCoordinate.distance(vector2i);
                    if (distance < getMarkerGroupUpRadius()) {
                        isSeperate = false;
                    }
                }
            }
            if(isSeperate){
                mapMarker.hasMany = false;
                uniqueIndexes.put(i, List.of(currentCenterCoordinate));
            } else {
                List<Vector2i> currentList = new ArrayList<>(uniqueIndexes.get(currentUniqueIndex).stream().toList());
                currentList.add(currentCenterCoordinate);
                uniqueIndexes.put(currentUniqueIndex, currentList);
                spawnMapMarkers[currentUniqueIndex].hasMany = true;
                if(mapMarker.type == MapMarkerType.CUSTOM_SPAWN){
                    spawnMapMarkers[currentUniqueIndex].updateMarkerType(MapMarkerType.CUSTOM_SPAWN);
                }
            }
        }
        for (Integer index : uniqueIndexes.keySet()) {
            spawnMapMarkers[index].assignNewCenter(averagePosition(uniqueIndexes.get(index)));
            spawnMapMarkers[index].draw(context);
        }
    }

    private Vector2i averagePosition(List<Vector2i> listOfPositions){
        Vector2i average = new Vector2i();
        for(Vector2i position : listOfPositions){
            average.x += position.x;
            average.y += position.y;
        }
        average.x /= listOfPositions.size();
        average.y /= listOfPositions.size();
        return average;
    }
}

package net.jukoz.me.client.screens.utils.widgets.map;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.client.screens.utils.widgets.ModWidget;
import net.jukoz.me.client.screens.utils.widgets.UiDirections;
import net.jukoz.me.world.map.MiddleEarthMapConfigs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import org.joml.Vector2d;
import org.joml.Vector2i;

public class MapWidget extends ModWidget {
    public boolean canZoomIn;
    public boolean canZoomOut;
    protected final static double MAP_TO_WORLD_RATIO = (double) MiddleEarthMapConfigs.REGION_SIZE / MiddleEarthMapConfigs.FULL_MAP_SIZE;
    protected final int uiWidth, uiHeight;
    protected int startX, startY = 0;
    protected float uiCurrentWidth, uiCurrentHeight;

    private final static int DRAG_COOLDOWN = 25;
    protected double uvX;
    protected double uvY = 0;
    protected float zoomLevel = getMinZoom();
    private float zoomTarget = zoomLevel;
    private boolean isForcingTargetMovement = false;
    private Vector2d forcedCurrentMapCenterTargetRatio;
    protected Vector2d currentPointRatio;
    private Vector2d currentMapTargetRatio;
    private Vector2d currentUiTargetRatio;
    private boolean isDragging = false;
    private Vector2d nextUvs = null;
    private float cooldown = 0;

    public MapWidget(int mapWidth, int mapHeight) {
        this.uiWidth = mapWidth;
        this.uiHeight = mapHeight;
        this.uiCurrentWidth = uiWidth;
        this.uiCurrentHeight = uiHeight;
        this.canZoomOut = false;
        this.canZoomIn = true;
        this.currentPointRatio = new Vector2d(.5, .5);
        updateCurrentMapTargetRatio();
    }
    private float getZoomTransitionSpeed(){
        return 0.35f * (zoomLevel / 4f);
    }
    private float getMovementSpeed(){
        return zoomLevel / 4;
    }
    private float getMaxZoom(){
        return 100f;
    }
    private float getMinZoom(){
        return 1f;
    }
    protected Identifier getMapTexture(){
        return Identifier.of(MiddleEarth.MOD_ID,"textures/map.png");
    }


    public boolean haveForcedMapTarget(){
        return isForcingTargetMovement;
    }
    public Vector2d getMapPointFromMapCoordinate(Vector2d point){
        int mapSize = MiddleEarthMapConfigs.REGION_SIZE;
        point.x = (point.x / mapSize * getCurrentWidth()) - uvX + startX;
        point.y = (point.y / mapSize * getCurrentWidth()) - uvY + startY;
        return point;
    }

    public Vector2d getMapPointFromWorldCoordinate(Vector2d point){
        point.x *= MAP_TO_WORLD_RATIO;
        point.y *= MAP_TO_WORLD_RATIO;
        return getMapPointFromMapCoordinate(point);
    }

    public void drawCentered(DrawContext context, int centerX, int startY){
        int startX = centerX - (uiWidth / 2);
        draw(context, startX, startY);
    }

    public void drawAnchored(DrawContext context, int anchorX, int startY, boolean isLeftAnchor){
        int startX = anchorX;
        if(!isLeftAnchor)
            startX -= uiWidth;

        draw(context, startX, startY);
    }

    protected void draw(DrawContext context, int startX, int startY){
        this.startX = startX;
        this.startY = startY;

        if(cooldown > 0) {
            cooldown = Math.max(cooldown - 1, 1);
        }
        if(nextUvs != null){
            this.uvX = nextUvs.x;
            this.uvY = nextUvs.y;
            nextUvs = null;
            zoomLevel = zoomTarget;
        }
        computeZoom();
        if(forcedCurrentMapCenterTargetRatio != null){
          computeForcedMovement();
        }
        drawMapTexture(context, startX, startY);
    }

    protected void drawMapTexture(DrawContext context, int startX, int startY) {
        int size = Math.max(getCurrentWidth(), getCurrentHeight());
        context.drawTexture(getMapTexture(),
                startX, startY,
                (float) uvX, (float) uvY,
                getWidth(), getHeight(),
                size, size
        );
    }

    protected int getCurrentWidth() {
        return (int) uiCurrentWidth;
    }
    protected int getCurrentHeight() {
        return (int) uiCurrentHeight;
    }
    private void computeForcedMovement() {
        Vector2d currentUvs = new Vector2d((int) this.uvX, (int) this.uvY);
        Vector2d targetUV = new Vector2d(
                (getCurrentWidth() * forcedCurrentMapCenterTargetRatio.x) - (getWidth() / 2.0),
                (getCurrentWidth() * forcedCurrentMapCenterTargetRatio.y) - (getHeight() / 2.0)
        );
        if((int) targetUV.x == (int) currentUvs.x && (int) targetUV.y == (int) currentUvs.y){
            forcedCurrentMapCenterTargetRatio = null;
        } else {
            targetUV = verifyUvs(targetUV.x, targetUV.y);

            double distanceForSpeed = targetUV.distance(currentUvs);
            float basicSpeed = getMovementSpeed();
            double speed = Math.max(basicSpeed, basicSpeed * (distanceForSpeed / 20));
            double radians = Math.toRadians(getDegreeAngleFromVectors(targetUV, currentUvs));
            double directionX = (Math.cos(radians)) * speed;
            if(currentUvs.x > targetUV.x)
                directionX *= -1;

            double directionY = (Math.sin(radians)) * speed;
            if(directionX < 0)
                directionY *= -1;

            int distance = (int) Math.round(targetUV.distance(currentUvs));
            if(distance <= 4)
                forcedCurrentMapCenterTargetRatio = null;
            else
                computeUvs(uvX + directionX, uvY + directionY);
        }
    }

    protected int getWidth() {
        return uiWidth;
    }
    protected int getHeight() {
        return uiHeight;
    }

    private double getDegreeAngleFromVectors(Vector2d source, Vector2d target) {
        double m = (target.y - source.y) / (target.x - source.x);
        double radians = Math.atan(m);
        return radians * (180 / Math.PI);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if(cooldown <= 1 && mouseIsInside(mouseX, mouseY)){
            isDragging = true;
        }
        return true;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        isDragging = false;
        cooldown = 0;
        return true;
    }

    public void setCurrentPointRatioToCursor(double mouseX, double mouseY){
        currentPointRatio.x = (-startX + mouseX) / getWidth();
        currentPointRatio.y = (-startY + mouseY) / getHeight();
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if(button == 0 && cooldown == 0 && (isDragging || mouseIsInside(mouseX, mouseY))) {
            forcedCurrentMapCenterTargetRatio = null;
            isForcingTargetMovement = false;
            int newUvX = (int) (uvX - deltaX);
            int newUvY = (int) (uvY - deltaY);
            setCurrentPointRatioToCursor(mouseX, mouseY);
            updateCurrentMapTargetRatio();
            zoomTarget = zoomLevel; // Cancels the zoom

            computeUvs(newUvX, newUvY);
            this.nextUvs = null;
        }
        return true;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if(mouseIsInside(mouseX, mouseY)){
            forcedCurrentMapCenterTargetRatio = null;
            isForcingTargetMovement = false;
            float zoomAmount = 1f + (zoomTarget / 4f);
            if(verticalAmount > 0 && zoomLevel != getMaxZoom()){
                setCurrentPointRatioToCursor(mouseX, mouseY);
                zoom(zoomAmount);
            } else if(verticalAmount < 0 && zoomLevel != getMinZoom()) {
                setCurrentPointRatioToCursor(mouseX, mouseY);
                dezoom(zoomAmount);
            }

        }
        return true;
    }

    protected boolean mouseIsInside(double mouseX, double mouseY) {
        return ((mouseX > startX && mouseX < startX + getWidth()) && (mouseY > startY && mouseY < startY + getHeight()));
    }

    public void zoomClick(){
        addCooldown();
        isDragging = false;
        this.currentPointRatio = new Vector2d(0.5, 0.5);
        zoom(1f + (zoomTarget / 2f));
    }

    public void dezoomClick(){
        addCooldown();
        isDragging = false;
        this.currentPointRatio = new Vector2d(0.5, 0.5);
        dezoom(1f + (zoomTarget / 2f));

    }

    public void addCooldown(){
        cooldown = DRAG_COOLDOWN;
    }

    public void zoom(float amount) {
        forcedCurrentMapCenterTargetRatio = null;
        isForcingTargetMovement = false;

        float maxZoom = getMaxZoom();
        if(zoomTarget != maxZoom) {
            this.canZoomOut = true;
            double newZoom = Math.min(maxZoom,  zoomTarget + amount);
            zoomTarget = (float)newZoom;
            if(zoomTarget == maxZoom){
                this.canZoomIn = false;
            }
            updateCurrentMapTargetRatio();
        }
    }
    public void dezoom(float amount) {
        forcedCurrentMapCenterTargetRatio = null;
        isForcingTargetMovement = false;

        float minZoom = getMinZoom();
        if(zoomTarget != minZoom) {
            this.canZoomIn = true;
            double newZoom = Math.max(minZoom, zoomTarget - amount);
            zoomTarget = (float)newZoom;
            if(zoomTarget == minZoom){
                this.canZoomOut = false;
            }
            updateCurrentMapTargetRatio();
        }
    }

    public Vector2d getCurrentMapCenterRatio() {
        int maxSize = Math.max(getCurrentWidth(), getCurrentHeight());
        double ratioX = (this.uvX + (getWidth() * 0.5)) / maxSize;
        double ratioY = (this.uvY + (getHeight() * 0.5)) / maxSize;
        return new Vector2d(ratioX, ratioY);
    }
    protected void instantCenterOnRatio(Vector2d mapCenter) {
        int maxSize = Math.max(getCurrentWidth(), getCurrentHeight());
        double newUvX = (maxSize * mapCenter.x) - (getWidth() * 0.5);
        double newUvY = (maxSize * mapCenter.y) - (getHeight() * 0.5);
        computeUvs(newUvX, newUvY);
        this.currentPointRatio = new Vector2d(0.5,0.5);
        updateCurrentMapTargetRatio();
        computeZoom();
    }

    private void updateCurrentMapTargetRatio(){
        double ratioX = (this.uvX + (getWidth() * currentPointRatio.x)) / getCurrentWidth();
        double ratioY = (this.uvY + (getHeight() * currentPointRatio.y)) / getCurrentHeight();

        this.currentMapTargetRatio = new Vector2d(ratioX, ratioY);
        this.currentUiTargetRatio = new Vector2d(currentPointRatio.x, currentPointRatio.y);
    }

    protected void computeZoom(){
        if(zoomLevel == zoomTarget)
            return;
        float zoomModifier = getZoomTransitionSpeed();
        if(zoomLevel > zoomTarget){
            zoomLevel = Math.max(zoomTarget, zoomLevel - zoomModifier);
        } else {
            zoomLevel = Math.min(zoomTarget, zoomLevel + zoomModifier);
        }

        float newUiCurrentWidth = getWidth() * zoomLevel;
        float newUiCurrentHeight = getHeight() * zoomLevel;

        uiCurrentWidth = newUiCurrentWidth;
        uiCurrentHeight = newUiCurrentHeight;

        double newUvX = getCurrentWidth() * currentMapTargetRatio.x - (getWidth() * currentUiTargetRatio.x);
        double newUvY = getCurrentHeight() * currentMapTargetRatio.y  - (getHeight() * currentUiTargetRatio.y);

        computeUvs(newUvX, newUvY);
    }

    protected void computeUvs(double newUvX, double newUvY){
        Vector2d computedUvs = verifyUvs(newUvX, newUvY);
        this.uvX = computedUvs.x;
        this.uvY = computedUvs.y;
    }

    protected Vector2d verifyUvs(double newUvX, double newUvY){
        int height = getHeight();
        int width = getWidth();

        int maxSquareSize = Math.max(height, width);

        int maxWidth = (int) ((maxSquareSize * zoomLevel) - width);
        int maxHeight = (int) ((maxSquareSize * zoomLevel) - height);

        double computedX = Math.min(maxWidth, newUvX);
        computedX = Math.max(0, computedX);

        double computedY = Math.min(maxHeight, newUvY);
        computedY = Math.max(0, computedY);

        return new Vector2d(computedX, computedY);
    }

    public void moveTo(Vector2i worldCoordinates, float desiredZoomTarget){
        zoomTarget = Math.min(getMaxZoom(), Math.max(getMinZoom(), desiredZoomTarget));
        forcedCurrentMapCenterTargetRatio = new Vector2d(
                (double)worldCoordinates.x * MAP_TO_WORLD_RATIO / MiddleEarthMapConfigs.REGION_SIZE,
                (double)worldCoordinates.y * MAP_TO_WORLD_RATIO / MiddleEarthMapConfigs.REGION_SIZE
        );
        isForcingTargetMovement = true;
        currentPointRatio = new Vector2d(0.5, 0.5);
    }

    public UiDirections isOutsideBounds(Vector2d uvs, int offsetX, int offsetY) {
        boolean outOfBoundNorth = uvs.y - offsetY < startY;
        boolean outOfBoundSouth = uvs.y + offsetY  > startY + getHeight();
        boolean outOfBoundEast = uvs.x + offsetX > startX + getWidth();
        boolean outOfBoundWest = uvs.x - offsetX < startX;

        if(outOfBoundNorth){
            if(outOfBoundEast)
                return UiDirections.NORTH_EAST;
            if(outOfBoundWest)
                return UiDirections.NORTH_WEST;
            return UiDirections.NORTH;
        }
        if(outOfBoundSouth){
            if(outOfBoundEast)
                return UiDirections.SOUTH_EAST;
            if(outOfBoundWest)
                return UiDirections.SOUTH_WEST;
            return UiDirections.SOUTH;
        }
        if(outOfBoundEast)
            return UiDirections.EAST;
        if(outOfBoundWest)
            return UiDirections.WEST;

        return UiDirections.NONE;
    }
}

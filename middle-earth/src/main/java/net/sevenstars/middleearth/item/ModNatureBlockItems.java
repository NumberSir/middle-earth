package net.sevenstars.middleearth.item;

import net.sevenstars.middleearth.MiddleEarth;
import net.sevenstars.middleearth.block.ModBlocks;
import net.sevenstars.middleearth.block.ModNatureBlocks;
import net.sevenstars.middleearth.item.utils.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModNatureBlockItems {

    public static final Item SMALL_LILY_PADS = registerItem("small_lily_pads",
            (settings) -> new PlaceableOnWaterItem(ModNatureBlocks.SMALL_LILY_PADS, settings), new Item.Settings());
    public static final Item SMALL_FLOWERING_LILY_PADS = registerItem("small_flowering_lily_pads",
            (settings) ->  new PlaceableOnWaterItem(ModNatureBlocks.SMALL_FLOWERING_LILY_PADS, settings), new Item.Settings());
    public static final Item LILY_PADS = registerItem("lily_pads",
            (settings) ->  new PlaceableOnWaterItem(ModNatureBlocks.LILY_PADS, settings), new Item.Settings());
    public static final Item DUCKWEED = registerItem("duckweed",
            (settings) ->  new PlaceableOnWaterItem(ModNatureBlocks.DUCKWEED, settings), new Item.Settings());

    public static final Item FLOATING_ICE = registerItem("floating_ice",
            (settings) -> new PlaceableOnWaterItem(ModNatureBlocks.FLOATING_ICE, settings), new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = (Item)factory.apply(settings.registryKey(ModBlocks.keyOfItem(name)));
        ModItemGroups.NATURE_BLOCKS_CONTENTS.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarth.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarth.LOGGER.logDebugMsg("Registering Mod Nature Items for " + MiddleEarth.MOD_ID);
    }
}

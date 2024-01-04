package net.jukoz.me.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jukoz.me.MiddleEarth;
import net.jukoz.me.block.ModNatureBlocks;
import net.jukoz.me.item.utils.ModItemGroups;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFoodItems {

    public static final Item LEMBAS = registerItem("lembas",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(20).saturationModifier(20).build())));

    public static final Item RAW_CRAB_CLAW = registerItem("raw_crab_claw",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).meat().build())));
    public static final Item COOKED_CRAB_CLAW = registerItem("cooked_crab_claw",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).meat().build())));

    public static final Item RAW_GOOSE = registerItem("raw_goose",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build())));
    public static final Item COOKED_GOOSE = registerItem("cooked_goose",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).meat().build())));

    public static final Item RAW_DUCK = registerItem("raw_duck",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).meat().build())));
    public static final Item COOKED_DUCK = registerItem("cooked_duck",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(6).saturationModifier(0.7F).meat().build())));

    public static final Item RAW_SWAN = registerItem("raw_swan",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(3).saturationModifier(0.4F).meat().build())));
    public static final Item COOKED_SWAN = registerItem("cooked_swan",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build())));

    public static final Item RAW_HORSE = registerItem("raw_horse",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).meat().build())));
    public static final Item COOKED_HORSE = registerItem("cooked_horse",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(9).saturationModifier(1.0F).meat().build())));

    public static final Item MAGGOTY_BREAD = registerItem("maggoty_bread",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(5).saturationModifier(1.2f).build())));
    public static final Item TOUGH_BERRIES = registerItem("tough_berries",
            new AliasedBlockItem(ModNatureBlocks.TOUGH_BERRY_BUSH, new Item.Settings()));
    public static final Item STRAWBERRY = registerItem("strawberry",
            new AliasedBlockItem(ModNatureBlocks.STRAWBERRY_BUSH,
                    new FabricItemSettings().food(
                            new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build())));

    private static Item registerItem(String name, Item item) {
        ModItemGroups.FOOD_CONTENTS.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, new Identifier(MiddleEarth.MOD_ID, name), item);
    }
    public static void registerModItems() {
        MiddleEarth.LOGGER.debug("Registering Mod Food Items for " + MiddleEarth.MOD_ID);
    }
}

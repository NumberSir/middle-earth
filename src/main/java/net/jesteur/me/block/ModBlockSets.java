package net.jesteur.me.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jesteur.me.MiddleEarth;
import net.minecraft.block.*;

public class ModBlockSets {
    public static SimpleBlockSet ASHEN_BRICKS = registerBrickSet("ashen_bricks");
    public static SimpleBlockSet GONDOR_BRICKS = registerBrickSet("gondor_bricks");
    public static SimpleBlockSet ASHEN_ROCK = registerBrickSet("ashen_rock");


    public static SimpleBlockSet[] sets = new SimpleBlockSet[] {
            ASHEN_BRICKS,
            GONDOR_BRICKS,
            ASHEN_ROCK
    };

    public record SimpleBlockSet(Block base, Block slab, Block stairs, Block wall) {
    }

    private static SimpleBlockSet registerBrickSet(String name) {

        Block bricks = ModBlocks.registerBlock(name, new Block(FabricBlockSettings.of(Material.STONE)
                .strength(ModBlocks.STONE_STRENGTH).requiresTool()));

        Block slab = ModBlocks.registerBlock(name + "_slab", new SlabBlock(FabricBlockSettings
                .of(Material.STONE).strength(ModBlocks.STONE_STRENGTH, ModBlocks.SLAB_RESISTANCE).requiresTool()));

        Block stairs = ModBlocks.registerBlock(name + "_stairs", new StairsBlock(bricks.getDefaultState(), FabricBlockSettings
                .of(Material.STONE).strength(ModBlocks.STONE_STRENGTH).requiresTool()));

        Block wall = ModBlocks.registerBlock(name + "_wall", new WallBlock(AbstractBlock.Settings.copy(bricks)
                .strength(ModBlocks.STONE_STRENGTH).requiresTool()));


        return new SimpleBlockSet(bricks, slab, stairs, wall);
    }

    public static void registerModBlockSets() {
        MiddleEarth.LOGGER.debug("Registering ModBlockSets for " + MiddleEarth.MOD_ID);
    }
}
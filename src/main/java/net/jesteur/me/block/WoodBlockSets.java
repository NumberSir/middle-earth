package net.jesteur.me.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jesteur.me.MiddleEarth;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;

public class WoodBlockSets {
    public static final float WOOD_STRENGTH = 1.25f;

    public static SimpleBlockSet MALLORN = registerWoodSet("mallorn", WOOD_STRENGTH);


    public static SimpleBlockSet[] sets = new SimpleBlockSet[] {
            MALLORN,
    };

    public record SimpleBlockSet(Block leaves, Block log, Block wood, Block woodWall,
                                 Block planks, Block planksSlab, Block planksStairs, Block planksFence, Block planksGate,
                                 Block pressurePlate, Block button) {
    }

    private static SimpleBlockSet registerWoodSet(String name, float strength) {
        Block leaves = ModBlocks.registerBlock(name + "_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(strength)));
        // TODO : Fix the log top texture
        String nameBase = name + "_log";
        Block log = ModBlocks.registerBlock(nameBase, new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(strength)));

        nameBase = name + "_wood";
        Block wood = ModBlocks.registerBlock(nameBase, new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(strength)));

        Block woodWall = ModBlocks.registerBlock(nameBase + "_wall", new WallBlock(AbstractBlock.Settings.copy(wood).strength(strength)));

        nameBase = name + "_planks";
        Block planks = ModBlocks.registerBlock(nameBase, new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(strength)));

        Block slab = ModBlocks.registerBlock(nameBase + "_slab", new SlabBlock(FabricBlockSettings.copyOf(planks).strength(strength, ModBlocks.SLAB_RESISTANCE)));

        Block stairs = ModBlocks.registerBlock(nameBase + "_stairs", new StairsBlock(planks.getDefaultState(), FabricBlockSettings.copyOf(planks).strength(strength)));

        // TODO : item renders : fence, gate

        Block fence = ModBlocks.registerBlock(nameBase + "_fence", new FenceBlock(FabricBlockSettings.copyOf(planks)));
        Block gate = ModBlocks.registerBlock(nameBase + "_fence_gate",  new FenceGateBlock(FabricBlockSettings.copyOf(planks), WoodType.OAK));

        Block button = ModBlocks.registerBlock(nameBase + "_button",  new ButtonBlock(FabricBlockSettings.copyOf(planks), BlockSetType.OAK, 5, true));

        Block pressurePlate = ModBlocks.registerBlock(nameBase + "_pressure_plate",  new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(planks), BlockSetType.OAK));

        return new SimpleBlockSet(leaves, log, wood, woodWall, planks, slab, stairs, fence, gate, pressurePlate, button);
    }


    public static void registerModBlockSets() {
        MiddleEarth.LOGGER.debug("Registering WoodBlockSets for " + MiddleEarth.MOD_ID);
    }
}

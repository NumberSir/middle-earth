package net.jukoz.me;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.jukoz.me.block.*;
import net.jukoz.me.block.special.alloyfurnace.AlloyFurnaceEntityRenderer;
import net.jukoz.me.client.model.equipment.chest.CloakCapeModel;
import net.jukoz.me.client.model.equipment.InnerArmorModel;
import net.jukoz.me.client.model.equipment.head.CloakHoodModel;
import net.jukoz.me.client.model.equipment.head.RohirricHelmetArmorModel;
import net.jukoz.me.client.renderer.ModArmorRenderer;
import net.jukoz.me.datageneration.VariantsModelProvider;
import net.jukoz.me.datageneration.content.models.SimpleDoubleBlockModel;
import net.jukoz.me.datageneration.content.models.SimpleFlowerBedModel;
import net.jukoz.me.datageneration.content.models.TintableCrossModel;
import net.jukoz.me.datageneration.content.tags.Crops;
import net.jukoz.me.entity.ModEntities;
import net.jukoz.me.entity.barrow_wights.BarrowWightEntityRenderer;
import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollRenderer;
import net.jukoz.me.entity.beasts.trolls.stone.StoneTrollRenderer;
import net.jukoz.me.entity.crab.CrabRenderer;
import net.jukoz.me.entity.deer.DeerRenderer;
import net.jukoz.me.entity.duck.DuckRenderer;
import net.jukoz.me.entity.dwarves.longbeards.LongbeardDwarfRenderer;
import net.jukoz.me.entity.elves.galadhrim.GaladhrimElfRenderer;
import net.jukoz.me.entity.goose.GooseRenderer;
import net.jukoz.me.entity.hobbits.shire.ShireHobbitRenderer;
import net.jukoz.me.entity.humans.bandit.BanditHumanRenderer;
import net.jukoz.me.entity.humans.gondor.GondorHumanRenderer;
import net.jukoz.me.entity.humans.rohan.RohanHumanRenderer;
import net.jukoz.me.entity.model.ModEntityModels;
import net.jukoz.me.entity.nazguls.NazgulRenderer;
import net.jukoz.me.entity.orcs.misties.MistyGoblinRenderer;
import net.jukoz.me.entity.orcs.mordor.MordorOrcRenderer;
import net.jukoz.me.entity.pheasant.PheasantRenderer;
import net.jukoz.me.entity.projectile.boulder.BoulderEntityRenderer;
import net.jukoz.me.entity.projectile.spear.JavelinEntityRenderer;
import net.jukoz.me.entity.snail.SnailRenderer;
import net.jukoz.me.entity.spider.MirkwoodSpiderRenderer;
import net.jukoz.me.entity.swan.SwanRenderer;
import net.jukoz.me.entity.beasts.trolls.cave.CaveTrollRenderer;
import net.jukoz.me.entity.beasts.trolls.snow.SnowTrollRenderer;
import net.jukoz.me.entity.uruks.misties.MistyHobgoblinRenderer;
import net.jukoz.me.entity.uruks.mordor.MordorBlackUrukRenderer;
import net.jukoz.me.gui.alloyfurnace.AlloyFurnaceScreen;
import net.jukoz.me.gui.ModScreenHandlers;
import net.jukoz.me.gui.artisantable.ArtisanTableScreen;
import net.jukoz.me.gui.wood_pile.WoodPileScreen;
import net.jukoz.me.item.ModEquipmentItems;
import net.jukoz.me.item.ModResourceItems;
import net.jukoz.me.item.utils.ModArmors;
import net.jukoz.me.item.utils.ModModelPredicateProvider;
import net.jukoz.me.network.ModNetworks;
import net.jukoz.me.particles.ModParticleTypes;
import net.jukoz.me.particles.custom.LeavesParticle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class MiddleEarthClient implements ClientModInitializer {

    public static final EntityModelLayer INNER_ARMOR_MODEL_LAYER = new EntityModelLayer(new Identifier(MiddleEarth.MOD_ID, "armor"), "layer_0");
    public static final EntityModelLayer HELMET_ADDON_MODEL_LAYER = new EntityModelLayer(new Identifier(MiddleEarth.MOD_ID, "armor"), "helmet_addon");
    public static final EntityModelLayer CAPE_MODEL_LAYER = new EntityModelLayer(new Identifier(MiddleEarth.MOD_ID, "armor"), "cape");
    public static final EntityModelLayer HOOD_MODEL_LAYER = new EntityModelLayer(new Identifier(MiddleEarth.MOD_ID, "armor"), "hood");

    @Override
    public void onInitializeClient() {

        ModEntityModels.getModels();
        EntityRendererRegistry.register(ModEntities.BARROW_WIGHT, BarrowWightEntityRenderer::new);
        // Entities
        EntityRendererRegistry.register(ModEntities.CAVE_TROLL, CaveTrollRenderer::new);

        EntityRendererRegistry.register(ModEntities.HOBBIT_CIVILIAN, ShireHobbitRenderer::new);
        EntityRendererRegistry.register(ModEntities.HOBBIT_BOUNDER, ShireHobbitRenderer::new);
        EntityRendererRegistry.register(ModEntities.HOBBIT_SHIRRIFF, ShireHobbitRenderer::new);

        EntityRendererRegistry.register(ModEntities.GONDORIAN_MILITIA, GondorHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.GONDORIAN_SOLDIER, GondorHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.GONDORIAN_KNIGHT, GondorHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.GONDORIAN_VETERAN, GondorHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.GONDORIAN_LEADER, GondorHumanRenderer::new);

        EntityRendererRegistry.register(ModEntities.ROHIRRIM_MILITIA, RohanHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.ROHIRRIM_SOLDIER, RohanHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.ROHIRRIM_KNIGHT, RohanHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.ROHIRRIM_VETERAN, RohanHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.ROHIRRIM_LEADER, RohanHumanRenderer::new);

        EntityRendererRegistry.register(ModEntities.LONGBEARD_MILITIA, LongbeardDwarfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LONGBEARD_SOLDIER, LongbeardDwarfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LONGBEARD_ELITE, LongbeardDwarfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LONGBEARD_VETERAN, LongbeardDwarfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LONGBEARD_LEADER, LongbeardDwarfRenderer::new);

        EntityRendererRegistry.register(ModEntities.LORIEN_MILITIA, GaladhrimElfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LORIEN_SOLDIER, GaladhrimElfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LORIEN_KNIGHT, GaladhrimElfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LORIEN_VETERAN, GaladhrimElfRenderer::new);
        EntityRendererRegistry.register(ModEntities.LORIEN_LEADER, GaladhrimElfRenderer::new);
        
        EntityRendererRegistry.register(ModEntities.MORDOR_ORC_SNAGA, MordorOrcRenderer::new);
        EntityRendererRegistry.register(ModEntities.MORDOR_ORC_SOLDIER, MordorOrcRenderer::new);
        EntityRendererRegistry.register(ModEntities.MORDOR_BLACK_URUK_SOLDIER, MordorBlackUrukRenderer::new);
        EntityRendererRegistry.register(ModEntities.MORDOR_BLACK_URUK_VETERAN, MordorBlackUrukRenderer::new);
        EntityRendererRegistry.register(ModEntities.MORDOR_BLACK_URUK_LEADER, MordorBlackUrukRenderer::new);


        EntityRendererRegistry.register(ModEntities.MISTY_GOBLIN_SNAGA, MistyGoblinRenderer::new);
        EntityRendererRegistry.register(ModEntities.MISTY_GOBLIN_WARRIOR, MistyGoblinRenderer::new);
        EntityRendererRegistry.register(ModEntities.MISTY_HOBGOBLIN_SOLDIER, MistyHobgoblinRenderer::new);
        EntityRendererRegistry.register(ModEntities.MISTY_HOBGOBLIN_VETERAN, MistyHobgoblinRenderer::new);
        EntityRendererRegistry.register(ModEntities.MISTY_HOBGOBLIN_LEADER, MistyHobgoblinRenderer::new);

        EntityRendererRegistry.register(ModEntities.STONE_TROLL, StoneTrollRenderer::new);
        EntityRendererRegistry.register(ModEntities.PETRIFIED_TROLL, PetrifiedTrollRenderer::new);

        EntityRendererRegistry.register(ModEntities.NAZGUL, NazgulRenderer::new);

        EntityRendererRegistry.register(ModEntities.MIRKWOOD_SPIDER, MirkwoodSpiderRenderer::new);
        EntityRendererRegistry.register(ModEntities.SNOW_TROLL, SnowTrollRenderer::new);
        //EntityRendererRegistry.register(ModEntities.BALROG, BalrogRenderer::new);

        EntityRendererRegistry.register(ModEntities.BANDIT_MILITIA, BanditHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.BANDIT_SOLDIER, BanditHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.BANDIT_CHIEFTAIN, BanditHumanRenderer::new);

        // Items
        ModelLoadingRegistry.INSTANCE.registerModelProvider(((manager, out) -> new VariantsModelProvider().provideExtraModels(manager, out)));
        EntityRendererRegistry.register(ModEntities.PEBBLE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.PINECONE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LIT_PINECONE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SPEAR, JavelinEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOULDER, BoulderEntityRenderer::new);

        registerDyeableItem(ModEquipmentItems.TUNIC_CLOAK);
        registerDyeableItem(ModEquipmentItems.CLOAK);
        registerDyeableItem(ModEquipmentItems.CLOAK_HOOD);
        registerDyeableItem(ModEquipmentItems.GAMBESON);

        // Animals
        EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
        EntityRendererRegistry.register(ModEntities.GOOSE, GooseRenderer::new);
        EntityRendererRegistry.register(ModEntities.DUCK, DuckRenderer::new);
        EntityRendererRegistry.register(ModEntities.SWAN, SwanRenderer::new);
        EntityRendererRegistry.register(ModEntities.PHEASANT, PheasantRenderer::new);
        EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);
        EntityRendererRegistry.register(ModEntities.DEER, DeerRenderer::new);

        ModModelPredicateProvider.registerAllPredicates();

        HandledScreens.register(ModScreenHandlers.ALLOY_SCREEN_HANDLER, AlloyFurnaceScreen::new);
        HandledScreens.register(ModScreenHandlers.ARTISAN_SCREEN_HANDLER, ArtisanTableScreen::new);
        HandledScreens.register(ModScreenHandlers.WOOD_PILE_SCREEN_HANDLER, WoodPileScreen::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.ALLOY_FURNACE, AlloyFurnaceEntityRenderer::new);

        ModNetworks.registerS2CPackets();

        EntityModelLayerRegistry.registerModelLayer(INNER_ARMOR_MODEL_LAYER, InnerArmorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(HELMET_ADDON_MODEL_LAYER, RohirricHelmetArmorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CAPE_MODEL_LAYER, CloakCapeModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(HOOD_MODEL_LAYER, CloakHoodModel::getTexturedModelData);

        for (ModArmors armor : ModArmors.values()) {
        ArmorRenderer.register(new ModArmorRenderer(armor.getHelmetModel(), armor.getChestPlateModel(), armor.getSimpleName(), armor.hasInnerLayer() , armor.hasVanillaArmorModel(), armor.hasCape(), armor.hasHood(), armor.isDyeable()),
                    armor.getItems());
        }

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.MALLORN_LEAVES_PARTICLE, LeavesParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.MIRKWOOD_LEAVES_PARTICLE, LeavesParticle.Factory::new);

        initializeRenderLayerMap();
    }

    private void initializeRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MORDOR_LICHEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MORGUL_IVY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.HANGING_COBWEB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.CORNER_COBWEB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MIRKWOOD_SPIDER_EGG, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.BROWN_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.GREEN_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MALLOS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.TAN_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.STRAWBERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.TOUGH_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.YELLOW_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.GREEN_JEWEL_CORNFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MIRKWOOD_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MIRKWOOD_HANGING_ROOTS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.DYING_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.GRASS_TUFT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.HEATHER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.HEATHER_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.RED_HEATHER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WHEATGRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WILD_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WILDERGRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.BEACH_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.COASTAL_PANIC_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.HOROKAKA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.GIANT_HOROKAKA, RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) {
                return GrassColors.getDefaultColor();
            }
            return BiomeColors.getGrassColor(view, pos);
        }, ModNatureBlocks.WILD_GRASS, ModNatureBlocks.GRASS_TUFT, ModNatureBlocks.WHEATGRASS);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            BlockState blockState = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
            return FoliageColors.getDefaultColor();
        }, ModNatureBlocks.WILD_GRASS, ModNatureBlocks.GRASS_TUFT, ModNatureBlocks.WHEATGRASS);


        for(Block block : SimpleDoubleBlockModel.doubleBlocks){
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        for(Block block : SimpleFlowerBedModel.flowerBeds){
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MIRKWOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WHITE_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WHITE_MUSHROOM_TILLER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.MOSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.FOREST_MOSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.CORRUPTED_MOSS, RenderLayer.getCutout());

        for (Block block : Crops.crops){
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        for(Block block : TintableCrossModel.notTintedBlocks) {
            if(block != null) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
        for(Block block : TintableCrossModel.tintedBlocks) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        BlockRenderLayerMap.INSTANCE.putBlock(MushroomBlockSets.DARK_MUSHROOM.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MushroomBlockSets.GRAY_MUSHROOM.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MushroomBlockSets.MUSHROOM.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.WILLOW.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.PALM.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.MIRKWOOD.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.MALLORN.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.WHITE_LEBETHRON.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.BLACK_LEBETHRON.trapdoor(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.BEECH.trapdoor(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.BEECH.door(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.MALLORN.door(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.PALM.door(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodBlockSets.WILLOW.door(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MushroomBlockSets.GRAY_MUSHROOM.door(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MushroomBlockSets.DARK_MUSHROOM.door(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MushroomBlockSets.MUSHROOM.door(), RenderLayer.getCutout());
        
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.QUARTZ_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_QUARTZ_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_QUARTZ_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_QUARTZ_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_AGATE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_RED_AGATE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_RED_AGATE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_RED_AGATE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOWSTONE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GLOWSTONE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_GLOWSTONE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GLOWSTONE_BUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.DWARVEN_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WALL_DWARVEN_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.SILVER_LANTERN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SILVERS_BARS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WILD_CARROT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WILD_POTATO, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WILD_BEETROOT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WOOD_FRAMED_WINDOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WOOD_FRAMED_WINDOW_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WHITE_DAUB_HOBBIT_WINDOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WHITE_DAUB_HOBBIT_WINDOW_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.YELLOW_DAUB_HOBBIT_WINDOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.YELLOW_DAUB_HOBBIT_WINDOW_PANE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.EPMOSTO_CARVED_WINDOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.EPMOSTO_CARVED_WINDOW_PANE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.BLUE_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.BLACK_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.BROWN_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.CYAN_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.GRAY_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.GREEN_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LIGHT_BLUE_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LIGHT_GRAY_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LIME_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.MAGENTA_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.ORANGE_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.PINK_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.PURPLE_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.RED_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WHITE_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.YELLOW_STAINED_LEAD_GLASS, RenderLayer.getTranslucent());
        
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.BLUE_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.BLACK_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.BROWN_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.CYAN_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.GRAY_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.GREEN_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LIGHT_BLUE_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LIGHT_GRAY_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.LIME_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.MAGENTA_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.ORANGE_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.PINK_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.PURPLE_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.RED_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.WHITE_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModDecorativeBlocks.YELLOW_STAINED_LEAD_GLASS_PANE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModResourceItems.REEDS, RenderLayer.getCutout());
    }

    private void registerDyeableItem(Item item) {
        ColorProviderRegistry.ITEM.register((stack, layer) -> layer == 0 ? ((DyeableItem)stack.getItem()).getColor(stack) : 0xFFFFFF, item);
    }
}

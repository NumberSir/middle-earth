package net.jukoz.me.world.features.underground;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.world.chunkgen.MiddleEarthChunkGenerator;
import net.jukoz.me.world.features.tree.MushroomTreeConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class CavesPlacedFeatures {
    // region GEODES
    public static final RegistryKey<PlacedFeature> AMETHYST_GEODE = registerKey("amethyst_geode");
    public static final RegistryKey<PlacedFeature> CITRINE_GEODE = registerKey("citrine_geode");
    public static final RegistryKey<PlacedFeature> GLOWSTONE_GEODE = registerKey("glowstone_geode");
    public static final RegistryKey<PlacedFeature> RED_AGATE_GEODE = registerKey("red_agate_geode");
    public static final RegistryKey<PlacedFeature> QUARTZ_GEODE = registerKey("quartz_geode");
    // endregion
    public static final RegistryKey<PlacedFeature> ORE_MAGMA = registerKey("ore_magma");
    public static final RegistryKey<PlacedFeature> ORE_OBSIDIAN = registerKey("ore_obsidian");
    public static final RegistryKey<PlacedFeature> ORE_DIRT = registerKey("ore_dirt");
    public static final RegistryKey<PlacedFeature> ORE_MUD = registerKey("ore_mud");
    public static final RegistryKey<PlacedFeature> POOL_MUD = registerKey("pool_mud");
    public static final RegistryKey<PlacedFeature> DISK_MYCELIUM = registerKey("disk_mycelium");
    public static final RegistryKey<PlacedFeature> PILLAR_BASALT = registerKey("pillar_polished_basalt");
    public static final RegistryKey<PlacedFeature> PILLAR_BLACKSTONE = registerKey("pillar_blackstone");

    // region MATERIALS
    public static final RegistryKey<PlacedFeature> ORE_COAL = registerKey("ore_coal");
    public static final RegistryKey<PlacedFeature> ORE_COAL_UPPER = registerKey("ore_coal_upper");
    public static final RegistryKey<PlacedFeature> ORE_COPPER = registerKey("ore_copper");
    public static final RegistryKey<PlacedFeature> ORE_COPPER_UPPER = registerKey("ore_copper_upper");
    public static final RegistryKey<PlacedFeature> ORE_TIN = registerKey("ore_tin");
    public static final RegistryKey<PlacedFeature> ORE_LAPIS = registerKey("ore_lapis");
    public static final RegistryKey<PlacedFeature> ORE_LEAD = registerKey("ore_lead");
    public static final RegistryKey<PlacedFeature> ORE_IRON = registerKey("ore_iron");
    public static final RegistryKey<PlacedFeature> ORE_SILVER = registerKey("ore_silver");
    public static final RegistryKey<PlacedFeature> ORE_JADE = registerKey("ore_jade");
    public static final RegistryKey<PlacedFeature> ORE_GOLD = registerKey("ore_gold");
    public static final RegistryKey<PlacedFeature> ORE_MITHRIL = registerKey("ore_mithril");
    // endregion

    // region VEGETATION
    public static final RegistryKey<PlacedFeature> TREE_BROWN_BOLETTE = registerKey("brown_bolette_tree");
    public static final RegistryKey<PlacedFeature> PATCH_CAVE_AMANITA = registerKey("patch_cave_amanita");
    public static final RegistryKey<PlacedFeature> PATCH_CAVE_AMANITA_TILLER = registerKey("patch_cave_amanita_tiller");
    public static final RegistryKey<PlacedFeature> TREE_CAVE_AMANITA = registerKey("cave_amanita_tree");
    public static final RegistryKey<PlacedFeature> PATCH_DEEP_FIRECAP = registerKey("patch_deep_firecap");
    public static final RegistryKey<PlacedFeature> PATCH_DEEP_FIRECAP_TILLER = registerKey("patch_deep_firecap_tiller");
    public static final RegistryKey<PlacedFeature> TREE_DEEP_FIRECAP = registerKey("deep_firecap_tree");
    public static final RegistryKey<PlacedFeature> PATCH_GHOSTSHROOM = registerKey("patch_ghostshroom");
    public static final RegistryKey<PlacedFeature> PATCH_GHOSTSHROOM_TILLER = registerKey("patch_ghostshroom_tiller");
    public static final RegistryKey<PlacedFeature> PATCH_SKY_FIRECAP = registerKey("patch_sky_firecap");
    public static final RegistryKey<PlacedFeature> PATCH_SKY_FIRECAP_TILLER = registerKey("patch_sky_firecap_tiller");
    public static final RegistryKey<PlacedFeature> TREE_SKY_FIRECAP = registerKey("tree_sky_firecap");
    public static final RegistryKey<PlacedFeature> PATCH_TUBESHROOMS = registerKey("patch_tubeshrooms");
    public static final RegistryKey<PlacedFeature> PATCH_TALL_TUBESHROOMS = registerKey("patch_tall_ubeshrooms");
    public static final RegistryKey<PlacedFeature> PATCH_TRUMPET_SHROOM = registerKey("patch_trumpet_shroom");
    public static final RegistryKey<PlacedFeature> PATCH_TALL_TRUMPET_SHROOM = registerKey("patch_tall_trumpet_shroom");
    public static final RegistryKey<PlacedFeature> PATCH_VIOLET_CAPS = registerKey("patch_violet_caps");
    public static final RegistryKey<PlacedFeature> PATCH_VIOLET_CAPS_TILLER = registerKey("patch_violet_caps_tiller");
    public static final RegistryKey<PlacedFeature> PATCH_YELLOW_AMANITA = registerKey("patch_yellow_amanita");
    public static final RegistryKey<PlacedFeature> PATCH_YELLOW_AMANITA_TILLER = registerKey("patch_yellow_amanita_tiller");
    public static final RegistryKey<PlacedFeature> TREE_YELLOW_AMANITA = registerKey("tree_yellow_amanita");

    // endregion

    public static final RegistryKey<PlacedFeature> SPRING_LAVA = registerKey("spring_lava");

    static final HeightRangePlacementModifier mushroomsRange = HeightRangePlacementModifier.trapezoid(YOffset.fixed(-40), YOffset.fixed(32));
    static final HeightRangePlacementModifier diftominRange = HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.EPMOSTO_LEVEL), YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL));
    static final HeightRangePlacementModifier epmostoRange = HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(MiddleEarthChunkGenerator.EPMOSTO_LEVEL));

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> amethystGeode = registryEntryLookup.getOrThrow(UndergroundConfiguredFeatures.AMETHYST_GEODE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> citrineGeode = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.CITRINE_GEODE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> glowstoneGeode = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.GLOWSTONE_GEODE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> redAgateGeode = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.RED_AGATE_GEODE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> quartzGeode = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.QUARTZ_GEODE);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> oreMagma = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_MAGMA);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> oreObsidian = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_OBSIDIAN);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> oreDirt = registryEntryLookup.getOrThrow(OreConfiguredFeatures.ORE_DIRT);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> oreMud = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_MUD);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> poolMud = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.POOL_MUD);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> diskMycelium = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.DISK_MYCELIUM);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> pillarBasalt = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PILLAR_BASALT);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> pillarBlackstone = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PILLAR_BLACKSTONE);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> coalOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_COAL);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> copperOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_COPPER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> tinOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_TIN);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> lapisOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_LAPIS);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> leadOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_LEAD);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> ironOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_IRON);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> silverOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_SILVER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> jadeOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_JADE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> goldOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_GOLD);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> mithrilOre = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.ORE_MITHRIL);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> brownBoletteTree = registryEntryLookup.getOrThrow(MushroomTreeConfiguredFeatures.BROWN_BOLETTE_TREE_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> caveAmanita = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_CAVE_AMANITA);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> caveAmanitaTiller = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_CAVE_AMANITA_TILLER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> caveAmanitaTree = registryEntryLookup.getOrThrow(MushroomTreeConfiguredFeatures.CAVE_AMANITA_TREE_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> deepFirecap = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_DEEP_FIRECAP);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> deepFirecapTiller = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_DEEP_FIRECAP_TILLER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> deepFirecapTree = registryEntryLookup.getOrThrow(MushroomTreeConfiguredFeatures.DEEP_FIRECAP_TREE_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> ghostshrooms = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_GHOSTSHROOM);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> ghostshroomsTiller = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_GHOSTSHROOM_TILLER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> skyFirecap = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_SKY_FIRECAP);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> skyFirecapTiller = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_SKY_FIRECAP_TILLER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> skyFirecapTree = registryEntryLookup.getOrThrow(MushroomTreeConfiguredFeatures.SKY_FIRECAP_TREE_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> tubeshroom = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_TUBESHROOMS);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> tallTubeshroom = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_TALL_TUBESHROOMS);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> trumpetShroom = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_TRUMPET_SHROOM);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> tallTrumpetShroom = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_TALL_TRUMPET_SHROOM);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> violetCaps = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_VIOLET_CAPS);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> violetCapsTiller = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_VIOLET_CAPS_TILLER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> yellowAmanita = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_YELLOW_AMANITA);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> yellowAmanitaTiller = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.PATCH_YELLOW_AMANITA_TILLER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> yellowAmanitaTree = registryEntryLookup.getOrThrow(MushroomTreeConfiguredFeatures.YELLOW_AMANITA_TREE_KEY);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> springLava = registryEntryLookup.getOrThrow(CavesConfiguredFeatures.SPRING_LAVA);

        PlacedFeatures.register(featureRegisterable, AMETHYST_GEODE, amethystGeode, RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(30)), BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, CITRINE_GEODE, citrineGeode, RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-16), YOffset.fixed(24)), BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, GLOWSTONE_GEODE, glowstoneGeode, RarityFilterPlacementModifier.of(24), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-16), YOffset.fixed(24)), BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, RED_AGATE_GEODE, redAgateGeode, RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-32), YOffset.fixed(0)), BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, QUARTZ_GEODE, quartzGeode, RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(30)), BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, ORE_MAGMA, oreMagma, modifiersWithCount(11, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-128), YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL))));
        PlacedFeatures.register(featureRegisterable, ORE_OBSIDIAN, oreObsidian, modifiersWithCount(7, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-92), YOffset.fixed(MiddleEarthChunkGenerator.EPMOSTO_LEVEL))));
        PlacedFeatures.register(featureRegisterable, ORE_DIRT, oreDirt, modifiersWithCount(6, HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL), YOffset.fixed(120))));
        PlacedFeatures.register(featureRegisterable, ORE_MUD, oreMud, modifiersWithCount(15, HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL), YOffset.fixed(120))));
        PlacedFeatures.register(featureRegisterable, POOL_MUD, poolMud, modifiersWithCount(9, HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL), YOffset.fixed(120))));
        PlacedFeatures.register(featureRegisterable, DISK_MYCELIUM, diskMycelium, modifiersWithCount(40, mushroomsRange));

        PlacedFeatures.register(featureRegisterable, PILLAR_BASALT, pillarBasalt, modifiersWithCount(2, diftominRange));
        PlacedFeatures.register(featureRegisterable, PILLAR_BLACKSTONE, pillarBlackstone, modifiersWithCount(2, epmostoRange));

        PlacedFeatures.register(featureRegisterable, ORE_COAL_UPPER, coalOre, modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(60), YOffset.fixed(300))));
        PlacedFeatures.register(featureRegisterable, ORE_COAL, coalOre, modifiersWithCount(20, HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL), YOffset.fixed(100))));
        PlacedFeatures.register(featureRegisterable, ORE_COPPER_UPPER, copperOre, modifiersWithCount(12, HeightRangePlacementModifier.trapezoid(YOffset.fixed(80), YOffset.fixed(300))));
        PlacedFeatures.register(featureRegisterable, ORE_COPPER, copperOre, modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL), YOffset.fixed(120))));
        PlacedFeatures.register(featureRegisterable, ORE_TIN, tinOre, modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-8), YOffset.fixed(40))));
        PlacedFeatures.register(featureRegisterable, ORE_LAPIS, lapisOre, modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL), YOffset.fixed(MiddleEarthChunkGenerator.DEEPSLATE_LEVEL))));
        PlacedFeatures.register(featureRegisterable, ORE_LEAD, leadOre, modifiersWithCount(9, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-48), YOffset.fixed(16))));
        PlacedFeatures.register(featureRegisterable, ORE_IRON, ironOre, modifiersWithCount(14, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-128), YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL))));
        PlacedFeatures.register(featureRegisterable, ORE_SILVER, silverOre, modifiersWithCount(7, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-40), YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL))));
        PlacedFeatures.register(featureRegisterable, ORE_JADE, jadeOre, modifiersWithCount(1, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-40), YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL))));
        PlacedFeatures.register(featureRegisterable, ORE_GOLD, goldOre, modifiersWithCount(2, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-44), YOffset.fixed(-20))));
        PlacedFeatures.register(featureRegisterable, ORE_MITHRIL, mithrilOre, modifiersWithRarity(4, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-61), YOffset.fixed(-55))));

        PlacedFeatures.register(featureRegisterable, TREE_BROWN_BOLETTE, brownBoletteTree, List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
                CountMultilayerPlacementModifier.of(2), BiomePlacementModifier.of()));

        PlacedFeatures.register(featureRegisterable, PATCH_CAVE_AMANITA, caveAmanita, modifiersWithCount(1, mushroomsRange));
        PlacedFeatures.register(featureRegisterable, PATCH_CAVE_AMANITA_TILLER, caveAmanitaTiller, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, TREE_CAVE_AMANITA, caveAmanitaTree, List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
                CountMultilayerPlacementModifier.of(2), BiomePlacementModifier.of()));

        PlacedFeatures.register(featureRegisterable, PATCH_DEEP_FIRECAP, deepFirecap, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_DEEP_FIRECAP_TILLER, deepFirecapTiller, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, TREE_DEEP_FIRECAP, deepFirecapTree, List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
                CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of()));

        PlacedFeatures.register(featureRegisterable, PATCH_GHOSTSHROOM, ghostshrooms, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_GHOSTSHROOM_TILLER, ghostshroomsTiller, modifiersWithCount(1, mushroomsRange ));

        PlacedFeatures.register(featureRegisterable, PATCH_SKY_FIRECAP, skyFirecap, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_SKY_FIRECAP_TILLER, skyFirecapTiller, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, TREE_SKY_FIRECAP, skyFirecapTree, List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
                CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of()));

        PlacedFeatures.register(featureRegisterable, PATCH_TUBESHROOMS, tubeshroom, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_TALL_TUBESHROOMS, tallTubeshroom, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_TRUMPET_SHROOM, trumpetShroom, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_TALL_TRUMPET_SHROOM, tallTrumpetShroom, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_VIOLET_CAPS, violetCaps, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_VIOLET_CAPS_TILLER, violetCapsTiller, modifiersWithCount(1, mushroomsRange ));

        PlacedFeatures.register(featureRegisterable, PATCH_YELLOW_AMANITA, yellowAmanita, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, PATCH_YELLOW_AMANITA_TILLER, yellowAmanitaTiller, modifiersWithCount(1, mushroomsRange ));
        PlacedFeatures.register(featureRegisterable, TREE_YELLOW_AMANITA, yellowAmanitaTree, List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
                CountMultilayerPlacementModifier.of(2), BiomePlacementModifier.of()));

        PlacedFeatures.register(featureRegisterable, SPRING_LAVA, springLava, modifiersWithCount(20, HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(MiddleEarthChunkGenerator.DIFTOMIN_LEVEL)) ));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MiddleEarth.MOD_ID, name));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}

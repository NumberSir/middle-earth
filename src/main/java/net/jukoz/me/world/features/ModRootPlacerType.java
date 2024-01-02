package net.jukoz.me.world.features;

import com.mojang.serialization.Codec;
import net.jukoz.me.MiddleEarth;
import net.jukoz.me.world.features.roots.MirkwoodRootPlacer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.root.RootPlacer;
import net.minecraft.world.gen.root.RootPlacerType;

public class ModRootPlacerType {
    public static final RootPlacerType<MirkwoodRootPlacer> MIRKWOOD_ROOT_PLACER = register(
            "mirkwood_root_placer", MirkwoodRootPlacer.CODEC);

    private static <P extends RootPlacer> RootPlacerType register(String id, Codec<P> codec) {
        return Registry.register(Registries.ROOT_PLACER_TYPE, new Identifier(MiddleEarth.MOD_ID, id), new RootPlacerType(codec));
    }
}

package net.jukoz.me.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.jukoz.me.resources.ModFactionRegistry;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class FactionProvider extends FabricDynamicRegistryProvider {
    public FactionProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(ModFactionRegistry.FACTION_KEY));
    }

    @Override
    public String getName() {
        return "Biomes";
    }
}
package net.sevenstars.middleearth.mixin;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.sevenstars.middleearth.MiddleEarth;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ShearsItem.class)
public class ShearItemMixin {

    @Inject(method = "createToolComponent", at = @At(value = "HEAD"), cancellable = true)
    private static void createToolComponent(CallbackInfoReturnable<ToolComponent> cir) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        cir.setReturnValue(new ToolComponent(List.of(
                ToolComponent.Rule.of(registryEntryLookup.getOrThrow(TagKey.of(RegistryKeys.BLOCK, Identifier.of(MiddleEarth.MOD_ID, "cobwebs"))), 15.0F),
                ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.LEAVES), 15.0F),
                ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.WOOL), 5.0F),
                ToolComponent.Rule.of(RegistryEntryList.of(Blocks.VINE.getRegistryEntry(), Blocks.GLOW_LICHEN.getRegistryEntry()), 2.0F)), 1.0F, 1));

    }

    @Inject(method = "postMine", at = @At(value = "HEAD"), cancellable = true)
    public void isSuitableFor(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state.isIn(BlockTags.LEAVES) || state.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of(MiddleEarth.MOD_ID, "cobwebs"))) || state.isOf(Blocks.SHORT_GRASS) || state.isOf(Blocks.FERN) || state.isOf(Blocks.DEAD_BUSH) || state.isOf(Blocks.HANGING_ROOTS) || state.isOf(Blocks.VINE) || state.isOf(Blocks.TRIPWIRE) || state.isIn(BlockTags.WOOL));
    }
}

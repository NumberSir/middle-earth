package net.jukoz.me.recipe;

import net.jukoz.me.item.ModDataComponentTypes;
import net.jukoz.me.item.ModEquipmentItems;
import net.jukoz.me.item.dataComponents.CapeDataComponent;
import net.jukoz.me.item.dataComponents.HoodDataComponent;
import net.jukoz.me.item.items.CapeChestplateItem;
import net.jukoz.me.item.items.CustomChestplateItem;
import net.jukoz.me.item.items.CustomHelmetItem;
import net.jukoz.me.item.items.HoodHelmetItem;
import net.jukoz.me.item.utils.ModCapes;
import net.jukoz.me.item.utils.ModHoods;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;


public class ArmorHoodRecipe extends SpecialCraftingRecipe {

    public ArmorHoodRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    public boolean matches(RecipeInputInventory recipeInputInventory, World world) {
        ItemStack itemStackHelmet = ItemStack.EMPTY;
        ItemStack itemStackHood = ItemStack.EMPTY;

        for(int i = 0; i < recipeInputInventory.size(); ++i) {
            ItemStack itemStack2 = recipeInputInventory.getStack(i);
            if (!itemStack2.isEmpty()) {
                if (itemStack2.getItem() instanceof CustomHelmetItem) {
                    if (!itemStackHelmet.isEmpty()) {
                        return false;
                    }
                    itemStackHelmet = itemStack2;
                } else {
                    if (!(itemStack2.getItem() instanceof HoodHelmetItem)) {
                        return false;
                    }
                    itemStackHood = itemStack2;
                }
            }
        }
        return !itemStackHelmet.isEmpty() && !itemStackHood.isEmpty();
    }

    public ItemStack craft(RecipeInputInventory recipeInputInventory, RegistryWrapper.WrapperLookup wrapperLookup) {
        ItemStack itemStack = ItemStack.EMPTY;
        ItemStack hood = ItemStack.EMPTY;

        for(int i = 0; i < recipeInputInventory.size(); ++i) {
            ItemStack itemStack2 = recipeInputInventory.getStack(i);
            if (!itemStack2.isEmpty()) {
                if (itemStack2.getItem() instanceof CustomHelmetItem) {
                    if (!itemStack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }

                    itemStack = itemStack2.copy();
                } else {
                    if (!(itemStack2.getItem() instanceof HoodHelmetItem)) {
                        return ItemStack.EMPTY;
                    }
                    hood = itemStack2;
                }
            }
        }

        if (!itemStack.isEmpty()) {
            return HoodDataComponent.setHood(itemStack, true, ModHoods.BASE_HOOD);
        } else {
            return ItemStack.EMPTY;
        }
    }

    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.CUSTOM_ARMOR_CAPE;
    }
}

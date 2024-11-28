package net.jukoz.me.item.items.armor;

import net.jukoz.me.MiddleEarth;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class CustomAnimalArmorItem extends ArmorItem {
    private final Identifier entityTexture;
    @Nullable
    private final Identifier overlayTexture;
    private final Type type;

    public CustomAnimalArmorItem(RegistryEntry<ArmorMaterial> material, String suffix, Type type, boolean hasOverlay, Item.Settings settings) {
        super(material, ArmorItem.Type.BODY, settings);
        this.type = type;
        Identifier identifier = Identifier.of(MiddleEarth.MOD_ID, type.textureIdFunction.apply(material.getKey().orElseThrow().getValue()).getPath());
        identifier = suffix != null ? identifier.withSuffixedPath(suffix) : identifier;
        this.entityTexture = identifier.withSuffixedPath(".png");
        this.overlayTexture = hasOverlay ? identifier.withSuffixedPath("_overlay.png") : null;
    }

    public Identifier getEntityTexture() {
        return this.entityTexture;
    }

    @Nullable
    public Identifier getOverlayTexture() {
        return this.overlayTexture;
    }

    public Type getArmorType() {
        return this.type;
    }

    @Override
    public SoundEvent getBreakSound() {
        return this.type.breakSound;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    public static enum Type {
        WARG((id) -> {
            return id.withPath((path) -> {
                return "textures/entities/warg/feature/warg_armor_" + path;
            });
        }, SoundEvents.ENTITY_ITEM_BREAK),
        BROADHOOF_GOAT((id) -> {
            return id.withPath((path) -> {
                return "textures/entities/broadhoof_goat/feature/broadhoof_goat_armor_" + path;
            });
        }, SoundEvents.ENTITY_ITEM_BREAK);
        final Function<Identifier, Identifier> textureIdFunction;
        final SoundEvent breakSound;

        private Type(Function<Identifier, Identifier> textureIdFunction, SoundEvent breakSound) {
            this.textureIdFunction = textureIdFunction;
            this.breakSound = breakSound;
        }
    }
}

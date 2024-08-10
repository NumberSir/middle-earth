package net.jukoz.me.item.utils;

import net.jukoz.me.item.ModResourceItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final ExtendedArmorMaterial STRAW_T1 = registerArmor(Tiers.BASIC, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, ModResourceItems.STRAW);

    public static final ExtendedArmorMaterial LEATHER_T0 = registerArmor(Tiers.CLOTHING, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.LEATHER);
    public static final ExtendedArmorMaterial LEATHER_T1 = registerArmor(Tiers.BASIC, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.LEATHER);
    public static final ExtendedArmorMaterial LEATHER_T2 = registerArmor(Tiers.LIGHT, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.LEATHER);
    public static final ExtendedArmorMaterial LEATHER_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.LEATHER);

    public static final ExtendedArmorMaterial IRON_T2 = registerArmor(Tiers.LIGHT, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, Items.IRON_INGOT);
    public static final ExtendedArmorMaterial IRON_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, Items.IRON_INGOT);

    public static final ExtendedArmorMaterial BRONZE_T2 = registerArmor(Tiers.LIGHT, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.BRONZE_INGOT);
    public static final ExtendedArmorMaterial BRONZE_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.BRONZE_INGOT);
    public static final ExtendedArmorMaterial BRONZE_T4 = registerArmor(Tiers.STURDY, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModResourceItems.BRONZE_INGOT);

    public static final ExtendedArmorMaterial SLAG_T2 = registerArmor(Tiers.LIGHT, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.SLAG_INGOT);
    public static final ExtendedArmorMaterial SLAG_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.SLAG_INGOT);
    public static final ExtendedArmorMaterial SLAG_T4 = registerArmor(Tiers.STURDY, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModResourceItems.SLAG_INGOT);

    public static final ExtendedArmorMaterial STEEL_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.STEEL_INGOT);
    public static final ExtendedArmorMaterial STEEL_T4 = registerArmor(Tiers.STURDY, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModResourceItems.STEEL_INGOT);
    public static final ExtendedArmorMaterial STEEL_T5 = registerArmor(Tiers.HEAVY, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, ModResourceItems.STEEL_INGOT);

    public static final ExtendedArmorMaterial DWARVEN_STEEL_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.DWARVEN_STEEL_INGOT);
    public static final ExtendedArmorMaterial DWARVEN_STEEL_T4 = registerArmor(Tiers.STURDY, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModResourceItems.DWARVEN_STEEL_INGOT);
    public static final ExtendedArmorMaterial DWARVEN_STEEL_T5 = registerArmor(Tiers.HEAVY, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, ModResourceItems.DWARVEN_STEEL_INGOT);

    public static final ExtendedArmorMaterial ELVEN_STEEL_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.ELVEN_STEEL_INGOT);
    public static final ExtendedArmorMaterial ELVEN_STEEL_T4 = registerArmor(Tiers.STURDY, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModResourceItems.ELVEN_STEEL_INGOT);
    public static final ExtendedArmorMaterial ELVEN_STEEL_T5 = registerArmor(Tiers.HEAVY, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, ModResourceItems.ELVEN_STEEL_INGOT);

    public static final ExtendedArmorMaterial URUK_STEEL_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.URUK_STEEL_INGOT);
    public static final ExtendedArmorMaterial URUK_STEEL_T4 = registerArmor(Tiers.STURDY, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModResourceItems.URUK_STEEL_INGOT);
    public static final ExtendedArmorMaterial URUK_STEEL_T5 = registerArmor(Tiers.HEAVY, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, ModResourceItems.URUK_STEEL_INGOT);


    public static final ExtendedArmorMaterial MORGUL_STEEL_T3 = registerArmor(Tiers.MEDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ModResourceItems.MORGUL_STEEL_INGOT);

    private static ExtendedArmorMaterial registerArmor(Tiers tier, RegistryEntry<SoundEvent> equipSound, Item repairIngredient) {
        EnumMap<ArmorItem.Type, Integer> map = new EnumMap<>(ArmorItem.Type.class);
        float toughness;
        float knockbackResistance;
        int enchantability;
        int durabilityMultiplier;
        switch (tier) {
            case CLOTHING -> {
                map.put(ArmorItem.Type.BOOTS, 0);
                map.put(ArmorItem.Type.LEGGINGS, 0);
                map.put(ArmorItem.Type.CHESTPLATE, 0);
                map.put(ArmorItem.Type.HELMET, 0);
                map.put(ArmorItem.Type.BODY, 0);
                durabilityMultiplier = 5;
                toughness = 0.0f;
                knockbackResistance = 0.0f;
                enchantability = 10;
            }
            case BASIC -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 4);
                durabilityMultiplier = 7;
                toughness = 0.0f;
                knockbackResistance = 0.0f;
                enchantability = 10;
            }
            case LIGHT -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 5);
                durabilityMultiplier = 11;
                toughness = 0.0f;
                knockbackResistance = 0.0f;
                enchantability = 10;
            }
            case MEDIUM -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 6);
                durabilityMultiplier = 15;
                toughness = 0.5f;
                knockbackResistance = 0.0f;
                enchantability = 10;
            }
            case STURDY -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 8);
                durabilityMultiplier = 25;
                toughness = 1.0f;
                knockbackResistance = 0.1f;
                enchantability = 10;

            }
            case HEAVY -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 10);
                durabilityMultiplier = 35;
                toughness = 2.0f;
                knockbackResistance = 0.1f;
                enchantability = 10;
            }
            default -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
                durabilityMultiplier = 5;
                toughness = 0.0f;
                knockbackResistance = 0.0f;
                enchantability = 1;
            }
        }
        return register(map, durabilityMultiplier, enchantability, equipSound, toughness, knockbackResistance, () -> Ingredient.ofItems(repairIngredient), tier);
    }

    private static ExtendedArmorMaterial register(EnumMap<ArmorItem.Type, Integer> defense,
                                                  int durabilityMultiplier, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance,
                                                  Supplier<Ingredient> repairIngredient, Tiers tier) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }
        ArmorMaterial material =  new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, null, toughness, knockbackResistance);
        return new ExtendedArmorMaterial(Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(""), material), durabilityMultiplier, tier);
    }

    public enum Tiers {
        CLOTHING,
        BASIC,
        LIGHT,
        MEDIUM,
        STURDY,
        HEAVY,
        ;
    }
}

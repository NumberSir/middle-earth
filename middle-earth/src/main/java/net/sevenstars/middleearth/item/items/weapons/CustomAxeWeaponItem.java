package net.sevenstars.middleearth.item.items.weapons;

import net.minecraft.item.Item;
import net.sevenstars.middleearth.MiddleEarth;
import net.sevenstars.middleearth.item.utils.MEEquipmentTooltip;
import net.sevenstars.middleearth.item.utils.ModWeaponTypes;
import net.sevenstars.middleearth.utils.ModFactions;
import net.sevenstars.middleearth.utils.ModSubFactions;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CustomAxeWeaponItem extends AxeItem implements MEEquipmentTooltip {
    private final ModFactions faction;
    private final ModSubFactions subFaction;

    private final ModWeaponTypes type;

    public CustomAxeWeaponItem(Settings settings, ToolMaterial toolMaterial) {
        super(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed, settings.attributeModifiers(createAttributeModifiersAxe(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed)));
        this.faction = ModFactions.NONE;
        this.subFaction = null;
        this.type = ModWeaponTypes.AXE;
    }

    public CustomAxeWeaponItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed, settings.attributeModifiers(createAttributeModifiersAxe(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed)));
        this.faction = ModFactions.NONE;
        this.subFaction = null;
        this.type = ModWeaponTypes.AXE;
    }

    public CustomAxeWeaponItem(ToolMaterial toolMaterial, ModFactions faction, Item.Settings settings) {
        super(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed, settings.attributeModifiers(createAttributeModifiersAxe(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed)));
        this.faction = faction;
        this.subFaction = null;
        this.type = ModWeaponTypes.AXE;
    }

    public CustomAxeWeaponItem(ToolMaterial toolMaterial, ModSubFactions subFaction, Item.Settings settings) {
        super(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed, settings.attributeModifiers(createAttributeModifiersAxe(toolMaterial, ModWeaponTypes.AXE.attack, ModWeaponTypes.AXE.attackSpeed)));
        this.faction = subFaction.getParent();
        this.subFaction = subFaction;
        this.type = ModWeaponTypes.AXE;
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public static AttributeModifiersComponent createAttributeModifiersAxe(ToolMaterial material, float baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID,
                        baseAttackDamage + material.attackDamageBonus(), EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID,
                        attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .build();
    }

    @Override
    public List<Text> getAdditionalShiftLines(ItemStack stack) {
        List<Text> list = new ArrayList<>(List.of());

        list.add(Text.translatable("tooltip." + MiddleEarth.MOD_ID + ".weapon_type").append(Text.translatable("tooltip." + MiddleEarth.MOD_ID + "." + this.type.name)));

        return list;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        appendBaseTooltip(tooltip, stack, this.faction, this.subFaction);
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public Text getName(ItemStack stack) {
        if(Registries.ITEM.getId(this).getPath().contains("_noble")
                || Registries.ITEM.getId(this).getPath().contains("_elite")
                || Registries.ITEM.getId(this).getPath().contains("uruk_hai")
                || Registries.ITEM.getId(this).getPath().contains("heyday")
                || Registries.ITEM.getId(this).getPath().contains("numenorean")){
            return Text.translatable(this.getTranslationKey()).formatted(Formatting.GOLD);
        }
        return super.getName(stack);
    }
}

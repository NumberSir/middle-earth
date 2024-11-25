package net.jukoz.me.item.items.weapons.ranged;

import net.jukoz.me.item.utils.MEEquipmentTooltip;
import net.jukoz.me.utils.ModFactions;
import net.jukoz.me.utils.ModSubFactions;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Predicate;

public class CustomBowWeaponItem extends BowItem implements MEEquipmentTooltip {
    private final ModFactions faction;
    private final ModSubFactions subFaction;

    public CustomBowWeaponItem(Settings settings) {
        super(settings);
        this.faction = null;
        this.subFaction = null;
    }

    public CustomBowWeaponItem(ModFactions faction, Settings settings) {
        super(settings);
        this.faction = faction;
        this.subFaction = null;
    }

    public CustomBowWeaponItem(ModSubFactions subFaction, Settings settings) {
        super(settings);
        this.faction = subFaction.getParent();
        this.subFaction = subFaction;
    }

    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        appendBaseTooltip(tooltip, stack, this.faction, this.subFaction);
        super.appendTooltip(stack, context, tooltip, type);
    }
}

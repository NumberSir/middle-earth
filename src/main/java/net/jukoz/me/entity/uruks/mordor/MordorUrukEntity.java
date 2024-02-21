package net.jukoz.me.entity.uruks.mordor;

import net.jukoz.me.entity.dwarves.durin.DurinDwarfEntity;
import net.jukoz.me.entity.elves.galadhrim.GaladhrimElfEntity;
import net.jukoz.me.entity.hobbits.shire.ShireHobbitEntity;
import net.jukoz.me.entity.humans.bandit.BanditHumanEntity;
import net.jukoz.me.entity.humans.gondor.GondorHumanEntity;
import net.jukoz.me.entity.humans.rohan.RohanHumanEntity;
import net.jukoz.me.entity.orcs.mordor.MordorOrcEntity;
import net.jukoz.me.item.ModEquipmentItems;
import net.jukoz.me.item.ModToolItems;
import net.jukoz.me.item.ModWeaponItems;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MordorUrukEntity extends HostileEntity {
    public MordorUrukEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        entityData = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        Random random = world.getRandom();
        this.initEquipment(random, difficulty);
        return entityData;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }

    @Override
    protected void initGoals() {
        int i = 0;
        this.goalSelector.add(++i, new SwimGoal(this));
        this.goalSelector.add(++i, new MeleeAttackGoal(this, 1.2f, false));
        this.goalSelector.add(++i, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(++i, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(++i, new LookAroundGoal(this));
        i = 0;
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(++i, new ActiveTargetGoal<>(this, GondorHumanEntity.class, true));
        this.targetSelector.add(++i, new ActiveTargetGoal<>(this, RohanHumanEntity.class, true));
        this.targetSelector.add(++i, new ActiveTargetGoal<>(this, GaladhrimElfEntity.class, true));
        this.targetSelector.add(++i, new ActiveTargetGoal<>(this, DurinDwarfEntity.class, true));
        this.targetSelector.add(++i, new ActiveTargetGoal<>(this, ShireHobbitEntity.class, true));
        this.targetSelector.add(++i, new ActiveTargetGoal<>(this, BanditHumanEntity.class, true));
    }

    public static enum State {
        NEUTRAL,
        ATTACKING,
    }

    public MordorUrukEntity.State getState() {
        if (this.isAttacking()) {
            return MordorUrukEntity.State.ATTACKING;
        }
        return MordorUrukEntity.State.NEUTRAL;
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        float randomVal = random.nextFloat();
        if(randomVal < 0.67f) {
            equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModWeaponItems.MORDOR_ORC_SWORD));
            equipStack(EquipmentSlot.OFFHAND, new ItemStack(ModEquipmentItems.MORDOR_SHIELD));
        } else {
            equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModToolItems.ORC_STEEL_AXE));
        }

        randomVal = random.nextFloat();
        if (randomVal > 0.35) {
            equipStack(EquipmentSlot.HEAD, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_SCALE_HELMET));
            equipStack(EquipmentSlot.CHEST, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_SCALE_CHESTPLATE));
            equipStack(EquipmentSlot.LEGS, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_SCALE_LEGGINGS));
            equipStack(EquipmentSlot.FEET, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_SCALE_BOOTS));
        } else {
            equipStack(EquipmentSlot.HEAD, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_PLATE_HELMET));
            equipStack(EquipmentSlot.CHEST, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_PLATE_CHESTPLATE));
            equipStack(EquipmentSlot.LEGS, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_PLATE_LEGGINGS));
            equipStack(EquipmentSlot.FEET, new ItemStack(ModEquipmentItems.MORDOR_BLACK_URUK_PLATE_BOOTS));
        }
    }

    public MordorUrukVariant getVariant() {
        return MordorUrukVariant.byId(this.getId());
    }
}

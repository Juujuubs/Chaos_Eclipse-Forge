package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class CustomZombieEntity extends Zombie {
    private final Player owner;
    private int lifeTicks = 0;
    private static final List<Class<? extends LivingEntity>> NON_ATTACKABLE = Arrays.asList(CustomZombieEntity.class, Player.class);

    public CustomZombieEntity(EntityType<? extends Zombie> entityType, Level world, Player owner) {
        super(entityType, world);
        this.owner = owner;
        this.setCanPickUpLoot(true); // Eles podem equipar itens
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, true) {
            @Override
            public boolean canUse() {
                LivingEntity target = CustomZombieEntity.this.getTarget();
                if (target == null || NON_ATTACKABLE.contains(target.getClass()) || target instanceof CustomZombieEntity) {
                    return false;
                }
                return super.canUse();
            }
        });
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Slime.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Phantom.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, entity -> entity != CustomZombieEntity.this.owner));
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        // Eles não dropam o equipamento
    }

    @Override
    protected void dropAllDeathLoot(DamageSource source) {
        // Eles não dropam o loot
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            this.lifeTicks++;
            if (this.lifeTicks >= 600) {
                this.remove(RemovalReason.KILLED);
            }
        }
    }



    @Override
    public boolean hurt(DamageSource source, float amount) {
        // Eles não dropam xp
        return false;
    }

    @Override
    protected boolean isSunSensitive() {
        // Eles não queimam no sol
        return false;
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        if (target instanceof CustomZombieEntity) {
            return false;
        }
        return super.doHurtTarget(target);
    }

    @Override
    public boolean canAttack(@Nullable LivingEntity target) {
        if (target instanceof CustomZombieEntity) {
            return false;
        }
        return super.canAttack(target);
    }
}

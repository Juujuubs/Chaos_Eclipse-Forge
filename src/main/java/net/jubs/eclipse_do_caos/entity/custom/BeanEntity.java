package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class BeanEntity extends Snowball {
    private final float explosionPower;

    public BeanEntity(EntityType<? extends Snowball> entityType, Level world) {
        super(entityType, world);
        this.explosionPower = 2.2F;
    }

    public BeanEntity(Level world, LivingEntity owner, float explosionPower) {
        super(EntityType.SNOWBALL, world);
        this.explosionPower = explosionPower;
        this.setOwner(owner);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), this.explosionPower, false, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity hitEntity = result.getEntity();
        Entity owner = this.getOwner();
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), this.explosionPower, false, Level.ExplosionInteraction.NONE);
            this.discard();
        }
        LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity) owner : null;
        float damage = 1.0F;
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingEntity), damage);
    }
}

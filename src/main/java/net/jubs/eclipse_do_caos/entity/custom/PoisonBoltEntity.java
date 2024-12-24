package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class PoisonBoltEntity extends Snowball {

    public PoisonBoltEntity(EntityType<? extends PoisonBoltEntity> entityType, Level world, ItemStack poisonBoltItem) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public PoisonBoltEntity(Level world, LivingEntity owner, ItemStack poisonBoltItem) {
        super(EntityType.SNOWBALL, world);
        this.setOwner(owner);
        this.setNoGravity(true);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            BlockPos pos;
            if (result.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) result;
                pos = entityHitResult.getEntity().blockPosition().above();
            } else if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) result;
                pos = blockHitResult.getBlockPos().above();
            } else {
                return;
            }

            AreaEffectCloud cloud = new AreaEffectCloud(this.level(), pos.getX(), pos.getY(), pos.getZ());
            cloud.setRadius(4.0F);
            cloud.setDuration(300);
            cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 300, 1));
            cloud.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
            cloud.setParticle(ParticleTypes.COMPOSTER);
            this.level().addFreshEntity(cloud);

            this.discard();
        }
    }
}

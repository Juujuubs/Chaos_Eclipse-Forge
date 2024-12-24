package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class LightningStrikeEntity extends Snowball {
    private final ItemStack lightningStrikeItem;

    public LightningStrikeEntity(EntityType<? extends LightningStrikeEntity> entityType, Level world, ItemStack lightningStrikeItem) {
        super(entityType, world);
        this.setNoGravity(true);
        this.lightningStrikeItem = lightningStrikeItem;
    }

    public LightningStrikeEntity(Level world, LivingEntity owner, ItemStack lightningStrikeItem) {
        super(EntityType.SNOWBALL, world);
        this.setOwner(owner);
        this.setNoGravity(true);
        this.lightningStrikeItem = lightningStrikeItem;
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            BlockPos pos;
            if (result.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) result;
                pos = entityHitResult.getEntity().blockPosition();
            } else if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) result;
                pos = blockHitResult.getBlockPos();
            } else {
                return;
            }

            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(this.level());
            if (lightningBolt != null) {
                lightningBolt.moveTo(pos.getX(), pos.getY(), pos.getZ());
                this.level().addFreshEntity(lightningBolt);
            }
            this.discard();
        }
    }
}

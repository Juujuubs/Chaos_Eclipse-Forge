package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class FireballEntity extends Snowball {

    public FireballEntity(EntityType<? extends FireballEntity> entityType, Level world, ItemStack fireBallItem) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public FireballEntity(Level world, LivingEntity owner, ItemStack fireBallItem) {
        super(EntityType.SNOWBALL, world);
        this.setOwner(owner);
        this.setNoGravity(true);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity hitEntity = result.getEntity();
        if (!(hitEntity instanceof Player player && player.isCreative())) {
            hitEntity.hurt(this.damageSources().thrown(this, this.getOwner()), 8.0F);
            hitEntity.setSecondsOnFire(6);
        }
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
                BlockPos firePos = pos.above();

                if (this.level().isEmptyBlock(firePos)) {
                    this.level().setBlockAndUpdate(firePos, net.minecraft.world.level.block.Blocks.FIRE.defaultBlockState());
                }
            } else {
                return;
            }

            this.discard();
        }
    }
}

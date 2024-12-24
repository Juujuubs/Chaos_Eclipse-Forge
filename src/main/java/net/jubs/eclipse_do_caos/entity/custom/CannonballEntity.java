package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class CannonballEntity extends Snowball {

    public CannonballEntity(EntityType<? extends CannonballEntity> entityType, Level world) {
        super(entityType, world);
        this.setNoGravity(false);
    }

    public CannonballEntity(Level world, LivingEntity owner) {
        super(EntityType.SNOWBALL, world);
        this.setOwner(owner);
        this.setNoGravity(false);
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            if (result.getType() == HitResult.Type.ENTITY) {
                onHitEntity((EntityHitResult) result);
            } else if (result.getType() == HitResult.Type.BLOCK) {
                onHitBlock((BlockHitResult) result);
            }
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity hitEntity = result.getEntity();
        if (hitEntity instanceof Player player && player.isCreative()) {
            return; // Não causa dano a jogadores no modo criativo
        }
        hitEntity.hurt(this.damageSources().thrown(this, this.getOwner()), 12.0F);
    }


    @Override
    protected void onHitBlock(BlockHitResult result) {
        BlockPos blockPos = result.getBlockPos();
        BlockState blockState = this.level().getBlockState(blockPos);
        if (blockState.is(Blocks.GLASS) || blockState.is(Blocks.GLASS_PANE) || blockState.is(Blocks.ICE) || blockState.is(Blocks.TINTED_GLASS) ||
                blockState.is(Tags.Blocks.STAINED_GLASS) || blockState.is(Tags.Blocks.STAINED_GLASS_PANES) || blockState.is(Blocks.LANTERN) || blockState.is(Blocks.REDSTONE_LAMP) ||
                blockState.is(Blocks.DECORATED_POT) || blockState.is(Blocks.SEA_LANTERN) || blockState.is(Blocks.GLOWSTONE) || blockState.is(Blocks.POINTED_DRIPSTONE)) {
            this.level().destroyBlock(blockPos, true);
        }
    }
}

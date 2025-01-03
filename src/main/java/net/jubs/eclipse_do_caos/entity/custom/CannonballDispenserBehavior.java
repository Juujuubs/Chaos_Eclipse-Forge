package net.jubs.eclipse_do_caos.entity.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;

public class CannonballDispenserBehavior extends DefaultDispenseItemBehavior {

    @Override
    protected ItemStack execute(BlockSource source, ItemStack stack) {
        Level level = source.getLevel();
        if (!level.isClientSide()) {
            Vec3 position = source.getPos().offset(source.getBlockState().getValue(DispenserBlock.FACING).getStepX(), source.getBlockState().getValue(DispenserBlock.FACING).getStepY(), source.getBlockState().getValue(DispenserBlock.FACING).getStepZ()).getCenter();
            CannonballEntity cannonballEntity = new CannonballEntity(level, position.x, position.y, position.z);
            cannonballEntity.setItem(stack);

            Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
            double velocityMultiplier = 2.0;
            cannonballEntity.shoot(direction.getStepX() * velocityMultiplier, direction.getStepY() * velocityMultiplier, direction.getStepZ() * velocityMultiplier, 2.0F, 0.0F);

            level.addFreshEntity(cannonballEntity);
            level.playSound(null, position.x, position.y, position.z, ModSounds.CANNONBALL_BLAST.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            stack.shrink(1);
        }
        return stack;
    }
}

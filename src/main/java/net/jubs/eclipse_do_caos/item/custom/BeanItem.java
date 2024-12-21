package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class BeanItem extends ItemNameBlockItem {


    public BeanItem(RegistryObject<Block> pBlock, Properties pProperties) {
        super(ModBlocks.BEAN_CROP.get(), pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());

        if (state.getBlock() == Blocks.FARMLAND) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = context.getLevel().getBlockState(abovePos);
            if (aboveState.isAir()) {
            if (!context.getLevel().isClientSide) {
                context.getLevel().setBlock(context.getClickedPos().above(), ModBlocks.BEAN_CROP.get().defaultBlockState(), 3);
                context.getItemInHand().shrink(1);
                context.getLevel().playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.useOn(context);
        }
    } else {
            return super.useOn(context);
        }
    }
}


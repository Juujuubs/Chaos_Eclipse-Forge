package net.jubs.eclipse_do_caos.block.custom;

import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    private final Supplier<Block> strippedBlock;

    public ModFlammableRotatedPillarBlock(Properties properties, Supplier<Block> strippedBlock) {
        super(properties);
        this.strippedBlock = strippedBlock;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (ToolActions.AXE_STRIP.equals(toolAction)) {
            if (state.is(ModBlocks.EDEN_LOG.get())) {
                return ModBlocks.STRIPPED_EDEN_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if (state.is(ModBlocks.EDEN_WOOD.get())) {
                return ModBlocks.STRIPPED_EDEN_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

}

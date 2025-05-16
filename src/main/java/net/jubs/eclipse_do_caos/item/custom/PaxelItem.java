package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Optional;

public class PaxelItem extends DiggerItem implements Vanishable {
    public PaxelItem( Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.PAXEL_MINEABLE, pProperties);
    }
    // Com a ajuda de PaxelsForDummies
    // Dentro da MIT License: https://github.com/GamingEinstein/PaxelsForDummies/blob/mc1.20.1-forge/LICENSE
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = !optional.isPresent() && !optional1.isPresent() ? Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_WAX_OFF, false)) : Optional.empty();
        ItemStack itemstack = pContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        } else if (optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }
        if (optional3.isPresent()) {
            if (player instanceof ServerPlayer)
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);

            level.setBlock(blockpos, (BlockState)optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)optional3.get()));
            if (player != null)
                itemstack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(pContext.getHand()));

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (pContext.getClickedFace() == Direction.DOWN)
            return InteractionResult.PASS;
        else {
            BlockState blockstate1 = blockstate.getToolModifiedState(pContext, ToolActions.SHOVEL_FLATTEN, false);
            BlockState blockstate2 = null;
            if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && (Boolean) blockstate.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide())
                    level.levelEvent((Player) null, 1009, blockpos, 0);

                CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
                blockstate2 = (BlockState) blockstate.setValue(CampfireBlock.LIT, false);
            }

            if (blockstate2 != null) {
                if (!level.isClientSide) {
                    level.setBlock(blockpos, blockstate2, 11);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
                    if (player != null)
                        pContext.getItemInHand().hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(pContext.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else
                return InteractionResult.PASS;
        }
    }

    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.ESSENCE_PAXEL.get());
    }
}

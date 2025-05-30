package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DelsItem extends Item {
    public DelsItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isEssenceBlock(state)) {
                    outputEssenceCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    pContext.getLevel().playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                            ModSounds.DELS_FOUND_ESSENCE.get(), SoundSource.BLOCKS, 1f, 1f, 0);

                    break;
                }
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.translatable("message.eclipse_do_caos.dels.message"));
            }


        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputEssenceCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));
    }

    private boolean isEssenceBlock(BlockState state) {
        return state.is(ModTags.Blocks.DELS_UNKNOWN_BLOCKS);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.DELS.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.dels.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.dels2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.dels3.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

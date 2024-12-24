package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZoraBowItem extends BowItem {
    public ZoraBowItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            boolean hasAmmo = !player.getProjectile(stack).isEmpty();
            int chargeDuration = getUseDuration(stack) - timeLeft;

            if (hasAmmo && chargeDuration >= 18) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 180, 0));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 0));
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.ZORA_BOW_FIRE.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
            }
        }
        super.releaseUsing(stack, world, entity, timeLeft);
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.zora_bow.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.zora_bowline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.zora_bow2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.zora_boweffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.zora_boweffect2.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class CatalystItem extends HoneyBottleItem {
    private static final int MAX_USE_TIME = 40;
    public CatalystItem(Properties pProperties) {
        super(pProperties);
    }

    public static int getMaxUseTime() {
        return MAX_USE_TIME;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (!world.isClientSide) {
            // Lista de efeitos possíveis
            MobEffect[] possibleEffects = new MobEffect[]{
                    MobEffects.WITHER,
                    MobEffects.REGENERATION,
                    MobEffects.DAMAGE_BOOST,
                    MobEffects.WEAKNESS,
                    MobEffects.MOVEMENT_SPEED,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    MobEffects.SATURATION,
                    MobEffects.HUNGER,
                    MobEffects.LUCK,
                    MobEffects.UNLUCK,
                    MobEffects.SLOW_FALLING,
                    MobEffects.LEVITATION,
                    MobEffects.DIG_SPEED,
                    MobEffects.DIG_SLOWDOWN,
                    MobEffects.ABSORPTION,
                    MobEffects.WATER_BREATHING,
                    MobEffects.POISON,
                    MobEffects.BLINDNESS
            };

            // Seleciona um efeito aleatório da lista
            MobEffect randomEffect = possibleEffects[new Random().nextInt(possibleEffects.length)];


            user.addEffect(new MobEffectInstance(randomEffect, 1200, 3));

            ServerLevel serverWorld = (ServerLevel) world;
            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                serverWorld.sendParticles(ParticleTypes.CRIMSON_SPORE,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            if (user instanceof Player player && !player.isCreative()) {
                stack.shrink(1);
                ItemStack catalystEmpty = new ItemStack(ModItems.CATALYST_EMPTY.get());
                if (stack.isEmpty()) {
                    return catalystEmpty;
                } else {
                    if (!player.getInventory().add(catalystEmpty)) {
                        player.drop(catalystEmpty, false);
                    }
                }
            }
        }

        return stack.isEmpty() ? new ItemStack(ModItems.CATALYST_EMPTY.get()) : stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return MAX_USE_TIME;
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.CATALYST.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalyst.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalystline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalyst2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalysteffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalyst3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalysteffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalysteffect22.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalysteffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.catalysteffect33.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

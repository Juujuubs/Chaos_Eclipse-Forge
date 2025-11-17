package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReusWalkingCaneItem extends SwordItem {
    public ReusWalkingCaneItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
        attacker.level().playSound(null, target, ModSounds.WALKING_CANE_HIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

        boolean effectApplied = false;

        if (new java.util.Random().nextFloat() < 0.4f) {
            target.setSecondsOnFire(2);
            effectApplied = true;
        }

        // Se aplicar o efeito aleatório, toca esse som
        if (effectApplied) {
            world.playSound(null, target.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.HOSTILE, 1.0F, 1.0F);
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Adiciona partículas na área de efeito
        if (!world.isClientSide()) {
            ServerLevel serverWorld = (ServerLevel) world;
            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                serverWorld.sendParticles(ParticleTypes.SOUL_FIRE_FLAME,
                        player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.FLAMES.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 2));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 400, 1));
            player.getCooldowns().addCooldown(this, 600);

        }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.REUS_WALKING_CANE.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_cane.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_caneline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_cane2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_caneeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_caneeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_cane3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_caneentities.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.reus_walking_caneeffect3.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

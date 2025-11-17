package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AkiraKatanaItem extends SwordItem {
    public AkiraKatanaItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
            target.setSecondsOnFire(6);
                world.playSound(null, target, ModSounds.AKIRA_HIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

        return super.hurtEnemy(stack, target, attacker);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
            BlockPos pos = player.blockPosition();
            int radius = 6;
            AABB area = new AABB(pos).inflate(radius);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);
            for (LivingEntity entity : entities) {
                if (entity != player && entity != player.getVehicle()) {
                    entity.setSecondsOnFire(20);
                }
            }

            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 150; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    serverWorld.sendParticles(ParticleTypes.DRIPPING_DRIPSTONE_LAVA,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.TORMENT.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1));
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 400, 4));
                player.getCooldowns().addCooldown(this, 650);

            }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.AKIRA_KATANA.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katana.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katana2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katanaeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katanaeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katanaeffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katanaeffect6.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katana3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katanaeffect4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katana4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.akira_katanaeffect5.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

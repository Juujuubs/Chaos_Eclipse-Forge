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

public class AgathaBonesawItem extends SwordItem {
    public AgathaBonesawItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 0), attacker);
        attacker.level().playSound(null, target, ModSounds.BONESAW_HIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockPos pos = player.blockPosition();
        int radius = 8;
        AABB area = new AABB(pos).inflate(radius);
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);
        for (LivingEntity entity : entities) {
            if (entity != player && entity != player.getVehicle()) {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 400, 0));
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 1));
            }
        }

        // Adiciona partículas na área de efeito
        if (!world.isClientSide()) {
            ServerLevel serverWorld = (ServerLevel) world;
            for (int i = 0; i < 300; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                serverWorld.sendParticles(ParticleTypes.FISHING,
                        player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.DEEP_SEA.get(), SoundSource.PLAYERS, 6.0F, 1.0F);
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 0));
            player.getCooldowns().addCooldown(this, 1600);

        }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.AGATHA_BONESAW.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaw.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaw2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaw3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesawentities.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaw4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect5.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect8.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect6.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect7.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

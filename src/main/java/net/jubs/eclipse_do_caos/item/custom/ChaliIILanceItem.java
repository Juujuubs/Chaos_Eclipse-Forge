package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
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
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChaliIILanceItem extends SwordItem {
    public ChaliIILanceItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
                world.playSound(null, target, ModSounds.CHALI_II_LANCE_HIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

        return super.hurtEnemy(stack, target, attacker);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide()) {
            double dashDistance = 12.0;
            double directionX = -Math.sin(Math.toRadians(player.getYRot())) * dashDistance;
            double directionZ = Math.cos(Math.toRadians(player.getYRot())) * dashDistance;
            double airResistance = 0.15;
            LivingEntity mover = player;

            if (player.getVehicle() instanceof LivingEntity mount) {
                mover = mount;
            }

            if (mover.onGround()) {
                mover.setDeltaMovement(directionX, mover.getDeltaMovement().y, directionZ);
            } else {
                mover.setDeltaMovement(directionX * airResistance, mover.getDeltaMovement().y, directionZ * airResistance);
            }
            mover.hurtMarked = true;

            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 50; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    serverWorld.sendParticles(ParticleTypes.CRIMSON_SPORE,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SPIDER_DASH.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 0));
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 2));
                player.getCooldowns().addCooldown(this, 400);

                Vec3 startPos = player.position();
                Vec3 endPos = startPos.add(player.getLookAngle().scale(8));
                AABB box = new AABB(startPos, endPos).inflate(1.0, 1.0, 1.0);
                List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, box,
                        entity -> entity != player && entity != player.getVehicle());

                for (LivingEntity entity : entities) {
                    if (entity.getBoundingBox().intersects(box)) {
                        entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
                    }
                }
            }

        }
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.CHALI_II_LANCE.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lance.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lanceline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lance2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lancemount.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect1.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lance3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect5.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

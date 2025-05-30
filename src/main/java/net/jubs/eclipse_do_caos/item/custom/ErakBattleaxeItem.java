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
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ErakBattleaxeItem extends AxeItem {

    public ErakBattleaxeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
                world.playSound(null, target, ModSounds.ERAK_BATTLEAXE_HIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

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
            if (entity != player) {
                boolean isHostile = entity instanceof Monster || entity instanceof Shulker;

                if (isHostile) {
                    entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 1));
                    if (entity.getMobType() == MobType.UNDEAD) {
                        entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 20, 0));
                    } else {
                        entity.addEffect(new MobEffectInstance(MobEffects.HARM, 20, 0));
                    }
                } else {
                    //mobs pacíficos
                    entity.addEffect(new MobEffectInstance(MobEffects.HARM, 20, 0));
                    entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 1));
                }
            }
        }

            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 150; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    serverWorld.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.TREMOR.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0));
                player.getCooldowns().addCooldown(this, 600);

            }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.ERAK_BATTLEAXE.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxe.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxeline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxeline3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxe2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxeeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxe3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxeeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.erak_battleaxeeffect3.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

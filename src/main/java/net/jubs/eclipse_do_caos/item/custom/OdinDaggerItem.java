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

public class OdinDaggerItem extends SwordItem {
    public OdinDaggerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
            attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 0), attacker);
                world.playSound(null, target, ModSounds.ODIN_DAGGER_HIT.get(), SoundSource.PLAYERS, 2.0F, 1.0F);

        return super.hurtEnemy(stack, target, attacker);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
            BlockPos pos = player.blockPosition();
            int radius = 12;
            AABB area = new AABB(pos).inflate(radius);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);
            for (LivingEntity entity : entities) {
                if (entity != player) {
                    entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0));
                }
            }

            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 150; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    serverWorld.sendParticles(ParticleTypes.DRIPPING_OBSIDIAN_TEAR,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.ODIN_VISION.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
                player.getCooldowns().addCooldown(this, 400);

            }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.ODIN_DAGGER.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_dagger.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_daggerline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_dagger2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_daggereffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_dagger3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_daggereffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_dagger4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_daggereffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.odin_daggereffect4.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

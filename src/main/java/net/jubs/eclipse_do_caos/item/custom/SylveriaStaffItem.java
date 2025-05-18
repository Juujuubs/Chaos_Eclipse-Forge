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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SylveriaStaffItem extends Item {

    public SylveriaStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
            BlockPos pos = player.blockPosition();
            int radius = 8;
            AABB area = new AABB(pos).inflate(radius);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);

            MobEffect effect1;
            MobEffect effect2;
            MobEffect effect3;

            if (RandomUtils.nextBoolean()) {

                    effect1 = MobEffects.HEAL;
                    effect2 = MobEffects.MOVEMENT_SPEED;
                    effect3 = MobEffects.DAMAGE_BOOST;

            } else {

                    effect1 = MobEffects.HARM;
                    effect2 = MobEffects.MOVEMENT_SLOWDOWN;
                    effect3 = MobEffects.WEAKNESS;

                }
        if (!world.isClientSide()) {
            for (LivingEntity entity : entities) {

                entity.addEffect(new MobEffectInstance(effect1, 60, 2));
                entity.addEffect(new MobEffectInstance(effect2, 400, 1));
                entity.addEffect(new MobEffectInstance(effect3, 400, 1));

            }

        }


            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 300; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    serverWorld.sendParticles(ParticleTypes.CRIMSON_SPORE,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                player.addEffect(new MobEffectInstance(effect1, 60, 2));
                player.addEffect(new MobEffectInstance(effect2, 400, 1));
                player.addEffect(new MobEffectInstance(effect3, 400, 1));
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.POSSESSED_CHAOS.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                player.getCooldowns().addCooldown(this, 550);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

            }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.SYLVERIA_STAFF.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staff.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staff2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staff3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffgood.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffbad.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect5.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect6.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect7.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }

}

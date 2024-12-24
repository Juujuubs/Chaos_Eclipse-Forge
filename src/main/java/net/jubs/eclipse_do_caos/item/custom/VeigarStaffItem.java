package net.jubs.eclipse_do_caos.item.custom;

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
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VeigarStaffItem extends Item {
    public VeigarStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
            BlockPos pos = player.blockPosition();
            int radius = 6;
            AABB area = new AABB(pos).inflate(radius);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);
            for (LivingEntity entity : entities) {
                if (entity != player) {
                    boolean isHostile = entity instanceof Monster;

                    if (entity instanceof Player || !isHostile) {
                    entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 0));
                    entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0));
                    }
                }
            }

            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 300; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    serverWorld.sendParticles(ParticleTypes.DRIPPING_DRIPSTONE_WATER,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.FLOW.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 400, 0));
                player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 1));
                player.getCooldowns().addCooldown(this, 650);

            }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staff.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staffline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staff2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staffeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staffeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staff3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staffentity.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staffeffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.veigar_staffeffect4.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

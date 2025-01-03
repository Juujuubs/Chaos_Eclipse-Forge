package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.entity.custom.LightningStrikeEntity;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AsgoreGrimoireItem extends Item {

    public AsgoreGrimoireItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide()) {
            ItemStack lightningStrikeItem = new ItemStack(ModItems.LIGHTNING_STRIKE.get());
            LightningStrikeEntity lightningStrikeEntity = new LightningStrikeEntity(world, player, lightningStrikeItem);
            lightningStrikeEntity.setItem(lightningStrikeItem);
            lightningStrikeEntity.setPos(player.getX(), player.getEyeY(), player.getZ());

            double speed = 2.0;
            double vx = -Math.sin(Math.toRadians(player.getYRot())) * Math.cos(Math.toRadians(player.getXRot())) * speed;
            double vy = -Math.sin(Math.toRadians(player.getXRot())) * speed;
            double vz = Math.cos(Math.toRadians(player.getYRot())) * Math.cos(Math.toRadians(player.getXRot())) * speed;
            lightningStrikeEntity.setDeltaMovement(vx, vy, vz);
            world.addFreshEntity(lightningStrikeEntity);

            ServerLevel serverWorld = (ServerLevel) world;
            for (int i = 0; i < 30; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                serverWorld.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                        player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LIGHTNING_STRIKE.get(), SoundSource.PLAYERS, 3F, 1.0F);
            player.getCooldowns().addCooldown(this, 85);

            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

            return InteractionResultHolder.consume(stack);
        }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.asgore_grimoire.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.asgore_grimoireline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.asgore_grimoire2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.asgore_grimoireeffect.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }
}

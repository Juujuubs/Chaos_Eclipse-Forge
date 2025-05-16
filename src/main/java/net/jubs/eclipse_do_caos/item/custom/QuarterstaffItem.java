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
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class QuarterstaffItem extends SwordItem {
    public QuarterstaffItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.level().playSound(null, target, ModSounds.QUARTERSTAFF_HIT.get(), SoundSource.PLAYERS, 2.0F, 1.0F);

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
                serverWorld.sendParticles(ParticleTypes.CLOUD,
                        player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.GUST.get(), SoundSource.PLAYERS, 9F, 1.0F);
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 1));
            player.getCooldowns().addCooldown(this, 650);

        }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.quarterstaff.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.quarterstaffline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.quarterstaff2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.quarterstaffffect1.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.quarterstaffffect2.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (this == ModItems.QUARTERSTAFF.get())
            return 6400;
        return 0;
    }
}

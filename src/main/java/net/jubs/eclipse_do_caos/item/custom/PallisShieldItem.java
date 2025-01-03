package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PallisShieldItem extends ShieldItem {

    private int useCooldown = 0;
    private int tickCounter = 0;

    public PallisShieldItem(Properties pProperties) {
        super(pProperties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        if (!world.isClientSide()) {
            if (useCooldown == 0) {
                ItemStack stack = player.getItemInHand(hand);
                BlockPos pos = player.blockPosition();
                int radius = 6;
                AABB area = new AABB(pos).inflate(radius);
                List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);

                for (LivingEntity entity : entities) {
                    if (entity != player) {
                        boolean isHostile = entity instanceof Monster || entity instanceof Shulker;
                        if (!isHostile) {
                            entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1));
                            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1));
                        }
                    }
                }

                // Adiciona partículas na área de efeito
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 180; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    serverWorld.sendParticles(ParticleTypes.TOTEM_OF_UNDYING,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.DEFENSE.get(), SoundSource.PLAYERS, 3.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1));
                useCooldown = 70;
                return InteractionResultHolder.pass(stack);
            } else {
                player.displayClientMessage(Component.literal("Cooldown remaining: " + useCooldown / 2 + " seconds"), true);
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            }
        }

        return super.use(world, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (entity instanceof Player) {
            if (useCooldown > 0) {
                tickCounter++;
                if (tickCounter >= 20) {
                    useCooldown--;
                    tickCounter = 0;
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shield.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shield2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shield3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shieldentity.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect4.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }
}

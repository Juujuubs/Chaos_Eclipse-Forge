package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BelaiosWandItem extends Item {
    public BelaiosWandItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide()) {

            Vec3 lookVector = player.getLookAngle();
            Vec3 newPosition = player.position().add(lookVector.scale(8));

            boolean foundEmptySpace = false;
            for (int i = -8; i <= 8; i++) {
                for (int j = -8; j <= 8; j++) {
                    for (int k = -8; k <= 8; k++) {
                        BlockPos blockPos = new BlockPos((int) (newPosition.x + i), (int) (newPosition.y + j), (int) (newPosition.z + k));

                        if (world.isEmptyBlock(blockPos)) {
                            BlockPos nearestEmptyPos = world.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, new BlockPos((int) newPosition.x, (int) newPosition.y, (int) newPosition.z));

                            if (!nearestEmptyPos.equals(player.blockPosition())) {
                                player.teleportTo(nearestEmptyPos.getX() + 0.5, nearestEmptyPos.getY(), nearestEmptyPos.getZ() + 0.5);
                                foundEmptySpace = true;
                                break;
                            }
                        }
                    }
                    if (foundEmptySpace) {
                        break;
                    }
                }
                if (foundEmptySpace) {
                    break;
                }
            }

            if (foundEmptySpace) {
                for (int i = 0; i < 15; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    ((ServerLevel) world).sendParticles(ParticleTypes.SOUL_FIRE_FLAME,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.CROSSING_SPELL.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                player.getCooldowns().addCooldown(this, 300);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

            } else {
                player.getCooldowns().addCooldown(this, 40);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BEACON_DEACTIVATE, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.belaios_wand.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.belaios_wandline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.belaios_wand2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.belaios_wand3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.belaios_wandeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.belaios_wandeffect.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (this == ModItems.BELAIOS_WAND.get())
            return 1600;
        return 0;
    }
}

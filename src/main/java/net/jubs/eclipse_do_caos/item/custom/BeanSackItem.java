package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.entity.custom.BeanEntity;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BeanSackItem extends Item {
    private final RegistryObject<Item> beanItem;

    public BeanSackItem(Properties pProperties, RegistryObject<Item> beanItem) {
        super(pProperties);
        this.beanItem = beanItem;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ItemStack beanStack = findBean(player);

        if (!world.isClientSide()) {
            if (beanStack.isEmpty()) {

                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 15; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    serverWorld.sendParticles(ParticleTypes.NAUTILUS,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.EMPTY_BEAN_SACK.get(), SoundSource.PLAYERS, 1F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 0));
                player.getCooldowns().addCooldown(this, 650);

                return InteractionResultHolder.fail(stack);
            } else {
                // Lança o feijão
                BeanEntity beanEntity = new BeanEntity(world, player, 2.2F);
                beanEntity.setItem(new ItemStack(beanStack.getItem()));
                beanEntity.setPos(player.getX(), player.getEyeY(), player.getZ());
                beanEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                world.addFreshEntity(beanEntity);

                if (!player.isCreative()) {
                    beanStack.shrink(1);
                }

                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 50; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    serverWorld.sendParticles(ParticleTypes.SPORE_BLOSSOM_AIR,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.BEANS.get(), SoundSource.PLAYERS, 1F, 1.0F);
                player.getCooldowns().addCooldown(this, 45);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

            }
        }

        return InteractionResultHolder.consume(stack);
    }

    private ItemStack findBean(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() == beanItem.get()) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.beans_sack.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.beans_sackline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.beans_sack2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.beans_sack3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.beans_sackclick.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.beans_sackeffect.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }

}

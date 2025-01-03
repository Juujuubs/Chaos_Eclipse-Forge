package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.entity.custom.CannonballEntity;
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

public class CarsonCannonItem extends Item {
    private final RegistryObject<Item> cannonItem;

    public CarsonCannonItem(Properties pProperties, RegistryObject<Item> cannonItem) {
        super(pProperties);
        this.cannonItem = cannonItem;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ItemStack cannonballStack = findCannonball(player);

        if (!world.isClientSide()) {
            if (cannonballStack.isEmpty()) {

                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 15; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    serverWorld.sendParticles(ParticleTypes.NOTE,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.EMPTY_CANNON.get(), SoundSource.PLAYERS, 1F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.LUCK, 350, 0));
                player.getCooldowns().addCooldown(this, 550);

                return InteractionResultHolder.fail(stack);
            } else {
                // Lança a cannonball
                CannonballEntity cannonballEntity = new CannonballEntity(world, player);
                cannonballEntity.setItem(new ItemStack(cannonballStack.getItem()));
                cannonballEntity.setPos(player.getX(), player.getEyeY(), player.getZ());
                cannonballEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 1.0F);
                world.addFreshEntity(cannonballEntity);

                if (!player.isCreative()) {
                    cannonballStack.shrink(1);
                }

                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 80; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    serverWorld.sendParticles(ParticleTypes.ASH,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.CANNONBALL_BLAST.get(), SoundSource.PLAYERS, 1F, 1.0F);
                player.getCooldowns().addCooldown(this, 45);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                return InteractionResultHolder.pass(stack);
            }
        }

        return InteractionResultHolder.pass(stack);
    }

    private ItemStack findCannonball(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() == cannonItem.get()) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.carson_cannon.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.carson_cannonline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.carson_cannon2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.carson_cannon3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.carson_cannonclick.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.carson_cannoneffect.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }

}

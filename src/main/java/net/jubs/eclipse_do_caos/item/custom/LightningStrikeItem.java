package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.entity.custom.LightningStrikeEntity;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;

public class LightningStrikeItem extends SnowballItem {
    public LightningStrikeItem(Properties pProperties) {
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

            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LIGHTNING_STRIKE.get(), SoundSource.PLAYERS, 3F, 1.0F);


        }
        player.getCooldowns().addCooldown(this, 45);
        if (!player.isCreative()) {
            stack.shrink(1);
        }
        return InteractionResultHolder.consume(stack);
        }

}

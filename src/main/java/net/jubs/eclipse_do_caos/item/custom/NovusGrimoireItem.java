package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.entity.custom.CustomZombieEntity;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NovusGrimoireItem extends Item {

    public NovusGrimoireItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!world.isClientSide()) {
            for (int i = 0; i < 4; i++) {
                double offset = i * Math.PI / 2.0; // Cria uma distância para cada zumbi
                double x = player.getX() + Math.cos(offset);
                double z = player.getZ() + Math.sin(offset);

                BlockPos originalPos = new BlockPos((int)Math.round(x), (int)Math.round(player.getY()), (int)Math.round(z));
                BlockPos spawnPos = findNearestAirBlock(world, originalPos);

                CustomZombieEntity zombie = new CustomZombieEntity(EntityType.ZOMBIE, world, player);
                zombie.moveTo(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);

                if (world.noCollision(zombie) && !world.containsAnyLiquid(zombie.getBoundingBox())) {
                    world.addFreshEntity(zombie);
                }
            }

            for (int i = 0; i < 120; i++) {
                double offsetX = Math.random() * 4.0 - 3.0;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 4.0 - 3.0;
                ((ServerLevel) world).sendParticles(ParticleTypes.SCULK_SOUL,
                        player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 800, 2));
            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SOUL_ALTERATION.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, 1200);

            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

        }
        return super.use(world, player, hand);
    }

    private BlockPos findNearestAirBlock(Level world, BlockPos pos) {
        for (int dx = -2; dx <= 2; dx++) {
            for (int dy = -2; dy <= 2; dy++) {
                for (int dz = -2; dz <= 2; dz++) {
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    if (world.getBlockState(checkPos).isAir()) {
                        return checkPos;
                    }
                }
            }
        }
        return pos; // Retorna a posição original se não encontrar um bloco vazio
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoire.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoire2.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoireeffect.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoireeffect2.tooltip"));
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }
}

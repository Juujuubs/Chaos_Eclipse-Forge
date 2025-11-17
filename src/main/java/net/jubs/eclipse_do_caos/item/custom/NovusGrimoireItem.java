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
            BlockPos center = player.blockPosition();
            BlockPos[] around = new BlockPos[] {
                    center.north(),
                    center.south(),
                    center.east(),
                    center.west()
            };

            for (BlockPos spawnPos : around) {
                if (world.getBlockState(spawnPos).isAir() && world.getBlockState(spawnPos.above()).isAir()) {
                    CustomZombieEntity zombie = new CustomZombieEntity(EntityType.ZOMBIE, world, player);
                    zombie.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, 0, 0);

                    if (world.noCollision(zombie)) {
                        world.addFreshEntity(zombie);
                    }
                }
            }

            double[][] offsets = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
            };

            for (double[] offset : offsets) {
                double baseX = player.getX() + offset[0];
                double baseZ = player.getZ() + offset[1];

                for (int i = 0; i < 30; i++) {
                    double offsetX = Math.random() * 0.6 - 0.3;
                    double offsetY = Math.random() * 2.0;
                    double offsetZ = Math.random() * 0.6 - 0.3;

                    ((ServerLevel) world).sendParticles(
                            ParticleTypes.SCULK_SOUL,
                            baseX + offsetX,
                            player.getY() + offsetY,
                            baseZ + offsetZ,
                            1, 0, 0, 0, 0.05
                    );
                }
            }

            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 800, 2));
            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SOUL_ALTERATION.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, 1200);

            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

        }
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFireResistant() {
        return (this == ModItems.NOVUS_GRIMOIRE.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoire.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoire2.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoirepeaceful.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoireeffect.tooltip"));
        tooltip.add(Component.translatable("tooltip.eclipse_do_caos.novus_grimoireeffect2.tooltip"));
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }
}

package net.jubs.eclipse_do_caos.item.custom;

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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class QrazStaffItem extends Item {

    public QrazStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockPos pos = player.blockPosition();
        int radius = 6;
        AABB area = new AABB(pos).inflate(radius);
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, area);

        BlockState leaves = Blocks.OAK_LEAVES.defaultBlockState();

        for (LivingEntity entity : entities) {
            if (entity != player && !entity.isSpectator() && !(entity instanceof Player && ((Player)entity).isCreative())) {
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 2));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 1));

                // Coloca blocos de folhas
                BlockPos entityPos = entity.blockPosition();
                for (BlockPos blockPos : BlockPos.betweenClosed(entityPos.offset(-1, -1, -1), entityPos.offset(1, 1, 1))) {
                    if (world.isEmptyBlock(blockPos)) {
                        world.setBlock(blockPos, leaves, 3);
                    }
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
                    serverWorld.sendParticles(ParticleTypes.ITEM_SLIME,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.VINE_TRAP.get(), SoundSource.PLAYERS, 4.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 0));
                player.getCooldowns().addCooldown(this, 850);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

            }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staff.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staff2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffeffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staff3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffentity.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_stafftrap.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffeffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.qraz_staffeffect3.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ESSENCE.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (this == ModItems.QRAZ_STAFF.get())
            return 6400;
        return 0;
    }

}

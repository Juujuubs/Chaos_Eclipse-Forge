package net.jubs.eclipse_do_caos.item.custom;

import com.google.common.collect.ImmutableMap;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SawEaterItem extends SwordItem {
    public SawEaterItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    protected static final Map<Block, Block> STRIPPABLES = new ImmutableMap.Builder<Block, Block>()
            .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
            .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
            .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
            .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
            .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
            .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
            .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
            .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
            .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
            .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
            .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK)
            .put(ModBlocks.EDEN_LOG.get(), ModBlocks.STRIPPED_EDEN_LOG.get()).put(ModBlocks.EDEN_WOOD.get(), ModBlocks.STRIPPED_EDEN_WOOD.get())
            .build();
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
            attacker.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 0), attacker);
                world.playSound(null, target, ModSounds.SAW_EATER_HIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

                if (new java.util.Random().nextFloat() < 0.5) {
                    target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1), attacker);
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1), attacker);
                }

        return super.hurtEnemy(stack, target, attacker);

    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = this.getStripped(blockstate);
        Optional<BlockState> optional1 = this.getDecreasedOxidationState(blockstate);
        Optional<BlockState> optional2 = this.getWaxedToUnwaxedState(blockstate);
        ItemStack itemstack = pContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        } else if (optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent()) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }

            level.setBlock(blockpos, (BlockState)optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)optional3.get()));
            if (player != null) {
                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(pContext.getHand());
                });
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

            // Adiciona partículas na área de efeito
            if (!world.isClientSide()) {
                ServerLevel serverWorld = (ServerLevel) world;
                for (int i = 0; i < 80; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    serverWorld.sendParticles(ParticleTypes.ENCHANTED_HIT,
                            player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SAW_EATER_SLASHER.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0));
                player.getCooldowns().addCooldown(this, 550);

            }

        return InteractionResultHolder.pass(stack);
    }

    private Optional<BlockState> getStripped(BlockState pUnstrippedState) {
        return Optional.ofNullable((Block)STRIPPABLES.get(pUnstrippedState.getBlock())).map((p_150689_) -> {
            return (BlockState)p_150689_.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)pUnstrippedState.getValue(RotatedPillarBlock.AXIS));
        });
        }

    private Optional<BlockState> getDecreasedOxidationState(BlockState blockState) { Block newBlock = null;
        if (blockState.getBlock() == Blocks.OXIDIZED_COPPER) { newBlock = Blocks.WEATHERED_COPPER; }
        else if (blockState.getBlock() == Blocks.WEATHERED_COPPER) { newBlock = Blocks.EXPOSED_COPPER; }
        else if (blockState.getBlock() == Blocks.EXPOSED_COPPER) { newBlock = Blocks.COPPER_BLOCK; }

        else if (blockState.getBlock() == Blocks.OXIDIZED_CUT_COPPER) { newBlock = Blocks.WEATHERED_CUT_COPPER; }
        else if (blockState.getBlock() == Blocks.WEATHERED_CUT_COPPER) { newBlock = Blocks.EXPOSED_CUT_COPPER; }
        else if (blockState.getBlock() == Blocks.EXPOSED_CUT_COPPER) { newBlock = Blocks.CUT_COPPER; }

        else if (blockState.getBlock() == Blocks.OXIDIZED_CUT_COPPER_STAIRS) { newBlock = Blocks.WEATHERED_CUT_COPPER_STAIRS; }
        else if (blockState.getBlock() == Blocks.WEATHERED_CUT_COPPER_STAIRS) { newBlock = Blocks.EXPOSED_CUT_COPPER_STAIRS; }
        else if (blockState.getBlock() == Blocks.EXPOSED_CUT_COPPER_STAIRS) { newBlock = Blocks.CUT_COPPER_STAIRS; }

        else if (blockState.getBlock() == Blocks.OXIDIZED_CUT_COPPER_SLAB) { newBlock = Blocks.WEATHERED_CUT_COPPER_SLAB; }
        else if (blockState.getBlock() == Blocks.WEATHERED_CUT_COPPER_SLAB) { newBlock = Blocks.EXPOSED_CUT_COPPER_SLAB; }
        else if (blockState.getBlock() == Blocks.EXPOSED_CUT_COPPER_SLAB) { newBlock = Blocks.CUT_COPPER_SLAB; }

        return newBlock != null ? Optional.of(newBlock.defaultBlockState()) : Optional.empty();
    }
    private Optional<BlockState> getWaxedToUnwaxedState(BlockState blockState) { Block newBlock = null;

        if (blockState.getBlock() == Blocks.WAXED_OXIDIZED_COPPER) { newBlock = Blocks.OXIDIZED_COPPER; }
        else if (blockState.getBlock() == Blocks.WAXED_WEATHERED_COPPER) { newBlock = Blocks.WEATHERED_COPPER; }
        else if (blockState.getBlock() == Blocks.WAXED_EXPOSED_COPPER) { newBlock = Blocks.EXPOSED_COPPER; }
        else if (blockState.getBlock() == Blocks.WAXED_COPPER_BLOCK) { newBlock = Blocks.COPPER_BLOCK; }

        else if (blockState.getBlock() == Blocks.WAXED_OXIDIZED_CUT_COPPER) { newBlock = Blocks.OXIDIZED_CUT_COPPER; }
        else if (blockState.getBlock() == Blocks.WAXED_WEATHERED_CUT_COPPER) { newBlock = Blocks.WEATHERED_CUT_COPPER; }
        else if (blockState.getBlock() == Blocks.WAXED_EXPOSED_CUT_COPPER) { newBlock = Blocks.EXPOSED_CUT_COPPER; }
        else if (blockState.getBlock() == Blocks.WAXED_CUT_COPPER) { newBlock = Blocks.CUT_COPPER; }

        else if (blockState.getBlock() == Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS) { newBlock = Blocks.OXIDIZED_CUT_COPPER_STAIRS; }
        else if (blockState.getBlock() == Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS) { newBlock = Blocks.WEATHERED_CUT_COPPER_STAIRS; }
        else if (blockState.getBlock() == Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS) { newBlock = Blocks.EXPOSED_CUT_COPPER_STAIRS; }
        else if (blockState.getBlock() == Blocks.WAXED_CUT_COPPER_STAIRS) { newBlock = Blocks.CUT_COPPER_STAIRS; }

        else if (blockState.getBlock() == Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB) { newBlock = Blocks.OXIDIZED_CUT_COPPER_SLAB; }
        else if (blockState.getBlock() == Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB) { newBlock = Blocks.WEATHERED_CUT_COPPER_SLAB; }
        else if (blockState.getBlock() == Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB) { newBlock = Blocks.EXPOSED_CUT_COPPER_SLAB; }
        else if (blockState.getBlock() == Blocks.WAXED_CUT_COPPER_SLAB) { newBlock = Blocks.CUT_COPPER_SLAB; }

        return newBlock != null ? Optional.of(newBlock.defaultBlockState()) : Optional.empty();
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eater.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eaterline2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eater2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eatereffect.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eatereffect2.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eater3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eaterself.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eatereffect3.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eaterentities.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eatereffect4.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.eclipse_do_caos.saw_eatereffect5.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

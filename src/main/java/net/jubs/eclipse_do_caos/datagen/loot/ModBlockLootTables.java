package net.jubs.eclipse_do_caos.datagen.loot;

import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ESSENCE_BLOCK.get());
        this.dropSelf(ModBlocks.TEETH_BLOCK.get());
        this.dropSelf(ModBlocks.MEAT_BLOCK.get());
        this.dropSelf(ModBlocks.EYE_BLOCK.get());
        this.dropSelf(ModBlocks.BROMELIAD.get());
        this.dropSelf(ModBlocks.EDEN_LOG.get());
        this.dropSelf(ModBlocks.EDEN_WOOD.get());
        this.dropSelf(ModBlocks.EDEN_PLANKS.get());
        this.dropSelf(ModBlocks.EDEN_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_EDEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EDEN_LOG.get());
        this.add(ModBlocks.POTTED_BROMELIAD.get(),
                createPotFlowerItemTable(ModBlocks.POTTED_BROMELIAD.get()));

        this.add(ModBlocks.ESSENCE_ORE_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ESSENCE_ORE_BLOCK.get(), ModItems.ESSENCE.get()));

        this.add(ModBlocks.EDEN_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EDEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.EDEN_LEAVES.get(), item ->
                createLeavesDrops(item, Block.byItem(ModItems.EDEN_APPLE.get()), 0.036f));
        this.add(ModBlocks.EDEN_LEAVES.get(), block ->
                createLeavesDrops(block, Block.byItem(ModItems.EDEN_TREE_APPLE.get()), 0.02f));
        this.add(ModBlocks.EDEN_LEAVES.get(), block ->
                createLeavesDrops(block, Block.byItem(Items.STICK), 0.12f));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    }


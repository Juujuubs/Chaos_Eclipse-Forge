package net.jubs.eclipse_do_caos.datagen.loot;

import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.block.custom.BeanCropBlock;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
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
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import static net.jubs.eclipse_do_caos.item.ModItems.EDEN_APPLE;

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
        this.dropSelf(ModBlocks.EDEN_STAIRS.get());
        this.dropSelf(ModBlocks.EDEN_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.EDEN_BUTTON.get());
        this.dropSelf(ModBlocks.EDEN_FENCE_GATE.get());
        this.dropSelf(ModBlocks.EDEN_FENCE.get());
        this.dropSelf(ModBlocks.EDEN_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SAMARA_PLUSHIE.get());
        this.dropSelf(ModBlocks.RADIO_ANNOUNCER.get());

        this.add(ModBlocks.EDEN_DOOR.get(),
                block -> createDoorTable(ModBlocks.EDEN_DOOR.get()));

        this.add(ModBlocks.EDEN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.EDEN_SLAB.get()));

        this.add(ModBlocks.POTTED_BROMELIAD.get(),
                createPotFlowerItemTable(ModBlocks.POTTED_BROMELIAD.get()));

        this.add(ModBlocks.ESSENCE_ORE_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ESSENCE_ORE_BLOCK.get(), ModItems.ESSENCE.get()));

        this.add(ModBlocks.EDEN_LEAVES.get(), block ->
                createEdenLeavesDrops(block, ModBlocks.EDEN_SAPLING.get(), EDEN_APPLE.get(), ModItems.EDEN_TREE_APPLE.get(), Items.STICK));


        this.add(ModBlocks.EDEN_SIGN.get(), block ->
                createSingleItemTable(ModItems.EDEN_SIGN.get()));
        this.add(ModBlocks.EDEN_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.EDEN_SIGN.get()));

        this.add(ModBlocks.EDEN_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.EDEN_HANGING_SIGN.get()));
        this.add(ModBlocks.EDEN_HANGING_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.EDEN_HANGING_SIGN.get()));


        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeanCropBlock.AGE, 5));
        this.add(ModBlocks.BEAN_CROP.get(), this.createCropDrops(ModBlocks.BEAN_CROP.get(),
                ModItems.BEAN.get(), ModItems.BEAN.get(), lootitemcondition$builder1));
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

    protected LootTable.Builder createEdenLeavesDrops(Block leavesBlock, Block sapling, Item apple, Item treeApple, Item stick) {
        LootPool.Builder silkTouchPool = LootPool.lootPool()
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))
                .add(LootItem.lootTableItem(leavesBlock))
                .apply(ApplyExplosionDecay.explosionDecay());

        LootPool.Builder shearsPool = LootPool.lootPool()
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))
                .add(LootItem.lootTableItem(leavesBlock))
                .apply(ApplyExplosionDecay.explosionDecay());

        LootPool.Builder saplingPool = LootPool.lootPool()
                .add(LootItem.lootTableItem(sapling))
                .when(LootItemRandomChanceCondition.randomChance(0.12f));

        LootPool.Builder applePool = LootPool.lootPool()
                .add(LootItem.lootTableItem(apple))
                .when(LootItemRandomChanceCondition.randomChance(0.027f));

        LootPool.Builder treeApplePool = LootPool.lootPool()
                .add(LootItem.lootTableItem(treeApple))
                .when(LootItemRandomChanceCondition.randomChance(0.015f));

        LootPool.Builder stickPool = LootPool.lootPool()
                .add(LootItem.lootTableItem(stick))
                .when(LootItemRandomChanceCondition.randomChance(0.09f));

        return LootTable.lootTable()
                .withPool(silkTouchPool)
                .withPool(shearsPool)
                .withPool(saplingPool)
                .withPool(applePool)
                .withPool(treeApplePool)
                .withPool(stickPool);
    }

}


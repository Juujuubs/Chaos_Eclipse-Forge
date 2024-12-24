package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ESSENCE_SMELTABLES = List.of(ModBlocks.ESSENCE_ORE_BLOCK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.ESSENCE.get(), 0.7f, 100, "essence");
        oreSmelting(pWriter, ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.ESSENCE.get(), 0.7f, 200, "essence");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ESSENCE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.ESSENCE.get())
                .unlockedBy(getHasName(ModItems.ESSENCE.get()), has(ModItems.ESSENCE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ESSENCE.get(), 9)
                .requires(ModBlocks.ESSENCE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ESSENCE_BLOCK.get()), has(ModBlocks.ESSENCE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DELS.get(), 1)
                .pattern("#A#")
                .pattern("ECE")
                .pattern("#A#")
                .define('#', ModItems.ESSENCE.get())
                .define('A', Items.AMETHYST_SHARD)
                .define('E', Items.ECHO_SHARD)
                .define('C', Items.COMPASS)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .unlockedBy(getHasName(Items.COMPASS), has(Items.COMPASS))
                .unlockedBy(getHasName(ModItems.ESSENCE.get()), has(ModItems.ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RADIO_ANNOUNCER.get(), 1)
                .pattern("###")
                .pattern("#J#")
                .pattern("###")
                .define('#', ModItems.ESSENCE.get())
                .define('J', Items.JUKEBOX)
                .unlockedBy(getHasName(Items.JUKEBOX), has(Items.JUKEBOX))
                .unlockedBy(getHasName(ModItems.ESSENCE.get()), has(ModItems.ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAMARA_PLUSHIE.get(), 1)
                .pattern("EHE")
                .pattern("LBG")
                .pattern("EDE")
                .define('E', ModItems.ESSENCE.get())
                .define('H', ModItems.HUMAN_TOOTH.get())
                .define('G', ModItems.GOBLIN_EYE.get())
                .define('D', ModItems.DEVIL_HORN.get())
                .define('L', ModItems.ELF_EAR.get())
                .define('B', Items.BEEF)
                .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                .unlockedBy(getHasName(ModItems.ESSENCE.get()), has(ModItems.ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CATALYST_INFUSER.get(), 1)
                .pattern("G#C")
                .pattern("BJP")
                .pattern("SLS")
                .define('#', ModItems.CATALYST_EMPTY.get())
                .define('C', Items.CAULDRON)
                .define('J', ModItems.ESSENCE.get())
                .define('P', ItemTags.PLANKS)
                .define('L', ItemTags.WOODEN_SLABS)
                .define('S', Items.STICK)
                .define('B', Items.CHEST)
                .define('G', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(ModItems.ESSENCE.get()), has(ModItems.ESSENCE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(ModBlocks.BROMELIAD.get())
                .unlockedBy(getHasName(ModBlocks.BROMELIAD.get()), has(ModBlocks.BROMELIAD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL)
                .requires(ModItems.HUMAN_TOOTH.get())
                .unlockedBy(getHasName(ModItems.HUMAN_TOOTH.get()), has(ModItems.HUMAN_TOOTH.get()))
                .save(pWriter, "bone_meal_from_human_tooth");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 2)
                .requires(ModItems.DEVIL_HORN.get())
                .unlockedBy(getHasName(ModItems.DEVIL_HORN.get()), has(ModItems.DEVIL_HORN.get()))
                .save(pWriter, "bone_meal_from_devil_horn");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_PLANKS.get(), 4)
                .requires(ModBlocks.EDEN_LOG.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_LOG.get()), has(ModBlocks.EDEN_LOG.get()))
                .save(pWriter, "eden_planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_PLANKS.get(), 4)
                .requires(ModBlocks.EDEN_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_WOOD.get()), has(ModBlocks.EDEN_WOOD.get()))
                .save(pWriter, "eden_planks_from_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_EDEN_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_EDEN_LOG.get()), has(ModBlocks.STRIPPED_EDEN_LOG.get()))
                .save(pWriter, "eden_planks_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_EDEN_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_EDEN_WOOD.get()), has(ModBlocks.STRIPPED_EDEN_WOOD.get()))
                .save(pWriter, "eden_planks_from_stripped_wood");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_WOOD.get(), 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.EDEN_LOG.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_LOG.get()), has(ModBlocks.EDEN_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_EDEN_WOOD.get(), 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.STRIPPED_EDEN_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_EDEN_LOG.get()), has(ModBlocks.STRIPPED_EDEN_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.EDEN_CHEST_BOAT.get(), 1)
                .pattern("C")
                .pattern("#")
                .define('#', ModItems.EDEN_BOAT.get())
                .define('C', Items.CHEST)
                .unlockedBy(getHasName(ModItems.EDEN_BOAT.get()), has(ModItems.EDEN_BOAT.get()))
                .unlockedBy(getHasName(Items.CHEST), has(Items.CHEST))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.EDEN_BOAT.get(), 1)
                .pattern("# #")
                .pattern("###")
                .define('#', ModBlocks.EDEN_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.EDEN_SIGN.get(), 3)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .define('#', ModBlocks.EDEN_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.EDEN_HANGING_SIGN.get(), 6)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.EDEN_PLANKS.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(Items.CHAIN), has(Items.CHAIN))
                .save(pWriter);

        fenceBuilder(ModBlocks.EDEN_FENCE.get(), Ingredient.of(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        fenceGateBuilder(ModBlocks.EDEN_FENCE_GATE.get(), Ingredient.of(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        stairBuilder(ModBlocks.EDEN_STAIRS.get(), Ingredient.of(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        doorBuilder(ModBlocks.EDEN_DOOR.get(), Ingredient.of(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        trapdoorBuilder(ModBlocks.EDEN_TRAPDOOR.get(), Ingredient.of(ModBlocks.EDEN_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.EDEN_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_PRESSURE_PLATE.get(), 1)
                .pattern("##")
                .define('#', ModBlocks.EDEN_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_BUTTON.get())
                .requires(ModBlocks.EDEN_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EDEN_PLANKS.get()), has(ModBlocks.EDEN_PLANKS.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CATALYST_EMPTY.get(), 3)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .define('E', ModItems.ESSENCE.get())
                .define('#', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                .unlockedBy(getHasName(ModItems.ESSENCE.get()), has(ModItems.ESSENCE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GLASS_BOTTLE, 7)
                .requires(ModItems.CATALYST_EMPTY.get())
                .unlockedBy(getHasName(ModItems.CATALYST_EMPTY.get()), has(ModItems.CATALYST_EMPTY.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SUSHI_TILAPIA.get(), 4)
                .requires(ModItems.TILAPIA.get())
                .requires(Items.DRIED_KELP)
                .unlockedBy(getHasName(ModItems.TILAPIA.get()), has(ModItems.TILAPIA.get()))
                .unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.CANNONBALL.get(), 4)
                .requires(Items.IRON_INGOT)
                .requires(Items.IRON_INGOT)
                .requires(Items.COAL)
                .requires(Items.GUNPOWDER)
                .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.ESSENCE_PAXEL.get(), 1)
                .requires(Items.NETHERITE_PICKAXE)
                .requires(Items.NETHERITE_AXE)
                .requires(Items.NETHERITE_SHOVEL)
                .requires(ModBlocks.ESSENCE_BLOCK.get())
                .unlockedBy(getHasName(Items.NETHERITE_PICKAXE), has(Items.NETHERITE_PICKAXE))
                .unlockedBy(getHasName(Items.NETHERITE_AXE), has(Items.NETHERITE_AXE))
                .unlockedBy(getHasName(Items.NETHERITE_SHOVEL), has(Items.NETHERITE_SHOVEL))
                .unlockedBy(getHasName(ModBlocks.ESSENCE_BLOCK.get()), has(ModBlocks.ESSENCE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_NUGGET, 4)
                .requires(ModItems.CANNONBALL.get())
                .unlockedBy(getHasName(ModItems.CANNONBALL.get()), has(ModItems.CANNONBALL.get()))
                .save(pWriter, "iron_nugget_from_cannonball");

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TEETH_BLOCK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.HUMAN_TOOTH.get())
                .unlockedBy(getHasName(ModItems.HUMAN_TOOTH.get()), has(ModItems.HUMAN_TOOTH.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HUMAN_TOOTH.get(), 9)
                .requires(ModBlocks.TEETH_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TEETH_BLOCK.get()), has(ModBlocks.TEETH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.EYE_BLOCK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.GOBLIN_EYE.get())
                .unlockedBy(getHasName(ModItems.GOBLIN_EYE.get()), has(ModItems.GOBLIN_EYE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOBLIN_EYE.get(), 9)
                .requires(ModBlocks.EYE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.EYE_BLOCK.get()), has(ModBlocks.EYE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MEAT_BLOCK.get(), 1)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .define('#', Items.ROTTEN_FLESH)
                .define('E', ModItems.ELF_EAR.get())
                .unlockedBy(getHasName(ModItems.ELF_EAR.get()), has(ModItems.ELF_EAR.get()))
                .unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ELF_EAR.get(), 1)
                .requires(ModBlocks.MEAT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MEAT_BLOCK.get()), has(ModBlocks.MEAT_BLOCK.get()))
                .save(pWriter);
    }







    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  EclipseDoCaos.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

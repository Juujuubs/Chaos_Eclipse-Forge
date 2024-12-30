package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EclipseDoCaos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.DELS_UNKNOWN_BLOCKS)
                .add(ModBlocks.ESSENCE_BLOCK.get(),
                ModBlocks.ESSENCE_ORE_BLOCK.get(),
                ModBlocks.BROMELIAD.get(),
                ModBlocks.POTTED_BROMELIAD.get(),
                ModBlocks.EDEN_WOOD.get(),
                ModBlocks.STRIPPED_EDEN_LOG.get(),
                ModBlocks.STRIPPED_EDEN_WOOD.get(),
                ModBlocks.EDEN_SAPLING.get(),
                ModBlocks.SAMARA_PLUSHIE.get(),
                ModBlocks.RADIO_ANNOUNCER.get(),
                ModBlocks.CATALYST_INFUSER.get(),
                ModBlocks.POTTED_EDEN_SAPLING.get(),
                ModBlocks.EDEN_LOG.get()

                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ESSENCE_BLOCK.get(),
                ModBlocks.CATALYST_INFUSER.get(),
                ModBlocks.RADIO_ANNOUNCER.get()

                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ESSENCE_ORE_BLOCK.get()

                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ESSENCE_BLOCK.get(),
                ModBlocks.ESSENCE_ORE_BLOCK.get(),
                ModBlocks.RADIO_ANNOUNCER.get(),
                ModBlocks.TEETH_BLOCK.get()

                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.EYE_BLOCK.get(),
                ModBlocks.CATALYST_INFUSER.get(),
                ModBlocks.SAMARA_PLUSHIE.get()

                );

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(ModTags.Blocks.SAW_EATER_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.FLOWERS)
                .add(ModBlocks.BROMELIAD.get()
                );
        this.tag(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.BROMELIAD.get()
                );

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EDEN_LOG.get(),
                ModBlocks.EDEN_WOOD.get(),
                ModBlocks.STRIPPED_EDEN_LOG.get(),
                ModBlocks.STRIPPED_EDEN_WOOD.get()
                );
        this.tag(BlockTags.LOGS)
                .add(ModBlocks.EDEN_LOG.get(),
                        ModBlocks.EDEN_WOOD.get(),
                        ModBlocks.STRIPPED_EDEN_LOG.get(),
                        ModBlocks.STRIPPED_EDEN_WOOD.get()
                );
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.EDEN_PLANKS.get()
                );
        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.EDEN_STAIRS.get()
                );
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EDEN_STAIRS.get()
                );
        this.tag(BlockTags.SLABS)
                .add(ModBlocks.EDEN_SLAB.get()
                );
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EDEN_SLAB.get()
                );
        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.EDEN_BUTTON.get()
                );
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.EDEN_BUTTON.get()
                );
        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.EDEN_PRESSURE_PLATE.get()
                );
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EDEN_PRESSURE_PLATE.get()
                );
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.EDEN_FENCE.get()
                );
        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EDEN_FENCE.get()
                );
        this.tag(BlockTags.DOORS)
                .add(ModBlocks.EDEN_DOOR.get()
                );
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EDEN_DOOR.get()
                );
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.EDEN_TRAPDOOR.get()
                );
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EDEN_TRAPDOOR.get()
                );
        this.tag(BlockTags.CROPS)
                .add(ModBlocks.BEAN_CROP.get()
                );
        this.tag(BlockTags.MAINTAINS_FARMLAND)
                .add(ModBlocks.BEAN_CROP.get()
                );
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.EDEN_FENCE_GATE.get()
                );
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.EDEN_LEAVES.get()
                );
        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.EDEN_SAPLING.get()
                );
        this.tag(BlockTags.SIGNS)
                .add(ModBlocks.EDEN_SIGN.get(),
                ModBlocks.EDEN_WALL_SIGN.get(),
                ModBlocks.EDEN_HANGING_SIGN.get(),
                ModBlocks.EDEN_HANGING_WALL_SIGN.get()
                );
        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.EDEN_SIGN.get()
                );
        this.tag(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.EDEN_SIGN.get()
                );
        this.tag(BlockTags.ALL_SIGNS)
                .add(ModBlocks.EDEN_SIGN.get(),
                        ModBlocks.EDEN_WALL_SIGN.get(),
                        ModBlocks.EDEN_HANGING_SIGN.get(),
                        ModBlocks.EDEN_HANGING_WALL_SIGN.get()
                );
        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.EDEN_WALL_SIGN.get(),
                        ModBlocks.EDEN_HANGING_WALL_SIGN.get()
                );
        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.EDEN_HANGING_WALL_SIGN.get()
                );
        this.tag(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.EDEN_HANGING_SIGN.get(),
                        ModBlocks.EDEN_HANGING_WALL_SIGN.get()
                );
        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.EDEN_HANGING_SIGN.get(),
                        ModBlocks.EDEN_HANGING_WALL_SIGN.get()
                );
    }
}

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
                ModBlocks.POTTED_BROMELIAD.get()

                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ESSENCE_BLOCK.get()

                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ESSENCE_ORE_BLOCK.get()

                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ESSENCE_BLOCK.get(),
                ModBlocks.ESSENCE_ORE_BLOCK.get(),
                ModBlocks.TEETH_BLOCK.get()

                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.EYE_BLOCK.get()

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
    }
}

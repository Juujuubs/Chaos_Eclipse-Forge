package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EclipseDoCaos.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ESSENCE_BLOCK);
        blockWithItem(ModBlocks.ESSENCE_ORE_BLOCK);
        blockWithItem(ModBlocks.MEAT_BLOCK);

        simpleBlock(ModBlocks.BROMELIAD.get(),
                models().cross(blockTexture(ModBlocks.BROMELIAD.get()).getPath(), blockTexture(ModBlocks.BROMELIAD.get())).renderType("cutout"));


        logBlock(((RotatedPillarBlock) ModBlocks.EDEN_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EDEN_WOOD.get()), blockTexture(ModBlocks.EDEN_LOG.get()), blockTexture(ModBlocks.EDEN_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EDEN_LOG.get(), new ResourceLocation(EclipseDoCaos.MOD_ID, "block/stripped_eden_log"),
                new ResourceLocation(EclipseDoCaos.MOD_ID, "block/stripped_eden_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EDEN_WOOD.get(), new ResourceLocation(EclipseDoCaos.MOD_ID, "block/stripped_eden_log"),
                new ResourceLocation(EclipseDoCaos.MOD_ID, "block/stripped_eden_log"));

        blockItem(ModBlocks.EDEN_LOG);
        blockItem(ModBlocks.EDEN_WOOD);
        blockItem(ModBlocks.STRIPPED_EDEN_LOG);
        blockItem(ModBlocks.STRIPPED_EDEN_WOOD);

        blockWithItem(ModBlocks.EDEN_PLANKS);
        leavesBlock(ModBlocks.EDEN_LEAVES);

        saplingBlock(ModBlocks.EDEN_SAPLING);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("eclipse_do_caos:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("eclipse_do_caos:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}

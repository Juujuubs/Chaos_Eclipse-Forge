package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
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

        signBlock(((StandingSignBlock) ModBlocks.EDEN_SIGN.get()), ((WallSignBlock) ModBlocks.EDEN_WALL_SIGN.get()),
                blockTexture(ModBlocks.EDEN_PLANKS.get()));

        hangingSignBlock(ModBlocks.EDEN_HANGING_SIGN.get(), ModBlocks.EDEN_HANGING_WALL_SIGN.get(),
                blockTexture(ModBlocks.STRIPPED_EDEN_LOG.get()));


        stairsBlock(((StairBlock) ModBlocks.EDEN_STAIRS.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.EDEN_SLAB.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()));

        blockItem(ModBlocks.EDEN_STAIRS);
        blockItem(ModBlocks.EDEN_SLAB);

        buttonBlock(((ButtonBlock) ModBlocks.EDEN_BUTTON.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.EDEN_PRESSURE_PLATE.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()));

        blockItem(ModBlocks.EDEN_PRESSURE_PLATE);

        fenceBlock(((FenceBlock) ModBlocks.EDEN_FENCE.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.EDEN_FENCE_GATE.get()), blockTexture(ModBlocks.EDEN_PLANKS.get()));

        blockItem(ModBlocks.EDEN_FENCE_GATE);

        doorBlockWithRenderType((DoorBlock)ModBlocks.EDEN_DOOR.get(), modLoc("block/eden_door_bottom"), modLoc("block/eden_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.EDEN_TRAPDOOR.get(), modLoc("block/eden_trapdoor"), true, "cutout");

        blockItem(ModBlocks.EDEN_TRAPDOOR, "_bottom");

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
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private String name(Block block) {
        return key(block).getPath();
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}

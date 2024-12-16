package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

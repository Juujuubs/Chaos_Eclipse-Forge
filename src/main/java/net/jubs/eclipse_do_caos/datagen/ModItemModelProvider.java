package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EclipseDoCaos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CONTRACT);
        simpleItem(ModItems.ESSENCE);
        simpleItem(ModItems.TILAPIA);
        simpleItem(ModItems.SYMBOL);
        simpleItem(ModItems.VOX);
        simpleItem(ModItems.BEAN);
        simpleItem(ModItems.FRIED_TILAPIA);
        simpleItem(ModItems.SUSHI_TILAPIA);
        simpleItem(ModItems.DEVIL_HORN);
        simpleItem(ModItems.GOBLIN_EYE);
        simpleItem(ModItems.ELF_EAR);
        simpleItem(ModItems.HUMAN_TOOTH);
        simpleItem(ModItems.TICKET_ARCANUMRAILS);
        simpleItem(ModItems.TICKET_DELUXE_ARCANUMRAILS);
        simpleItem(ModItems.COOKED_BEAN);
        simpleItem(ModItems.CANNONBALL);
        simpleItem(ModItems.ECLIPSE_BEGINS_MUSIC_DISC);
        handheldItem(ModItems.ESSENCE_PAXEL);

        simpleBlockItem(ModBlocks.BROMELIAD);

        saplingItem(ModBlocks.EDEN_SAPLING);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EclipseDoCaos.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EclipseDoCaos.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EclipseDoCaos.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EclipseDoCaos.MOD_ID,"block/" + item.getId().getPath()));
    }

}

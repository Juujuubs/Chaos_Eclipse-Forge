package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
        simpleItem(ModItems.DELS);
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
        simpleItem(ModItems.EDEN_APPLE);
        simpleItem(ModItems.EDEN_TREE_APPLE);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EclipseDoCaos.MOD_ID, "item/" + item.getId().getPath()));
    }
}

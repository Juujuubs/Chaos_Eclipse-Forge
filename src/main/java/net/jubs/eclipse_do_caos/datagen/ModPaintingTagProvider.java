package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagProvider extends PaintingVariantTagsProvider {
    public ModPaintingTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, EclipseDoCaos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "the_first_kin"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "godwelling"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "godwelling_now"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "belaios"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "juno"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "qraz"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "raven"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "veigar"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "vex"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "reus"))
                .addOptional(new ResourceLocation(EclipseDoCaos.MOD_ID, "beloria_bonissimo"));
    }
}

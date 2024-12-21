package net.jubs.eclipse_do_caos.entity.layers;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

    public static final ModelLayerLocation EDEN_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(EclipseDoCaos.MOD_ID, "boat/eden"), "main");
    public static final ModelLayerLocation EDEN_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(EclipseDoCaos.MOD_ID, "chest_boat/eden"), "main");
}

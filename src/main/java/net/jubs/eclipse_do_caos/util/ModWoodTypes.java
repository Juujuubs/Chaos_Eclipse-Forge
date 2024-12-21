package net.jubs.eclipse_do_caos.util;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType EDEN = WoodType.register(new WoodType(EclipseDoCaos.MOD_ID + ":eden", BlockSetType.OAK));
}

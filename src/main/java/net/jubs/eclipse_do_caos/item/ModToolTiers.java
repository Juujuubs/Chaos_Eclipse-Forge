package net.jubs.eclipse_do_caos.item;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ESSENCE = TierSortingRegistry.registerTier(
            new ForgeTier(5,3000,12f, 5f, 30, ModTags.Blocks.NEEDS_ESSENCE_TOOL,
                    () -> Ingredient.of(ModItems.ESSENCE.get())),
            new ResourceLocation(EclipseDoCaos.MOD_ID, "essence"), List.of(Tiers.NETHERITE), List.of());

}

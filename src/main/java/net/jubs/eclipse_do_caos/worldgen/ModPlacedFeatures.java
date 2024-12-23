package net.jubs.eclipse_do_caos.worldgen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> EDEN_PLACED_KEY = registerKey("eden_placed");
    public static final ResourceKey<PlacedFeature> ESSENCE_ORE_BLOCK_PLACED_KEY = registerKey("essence_ore_block_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ESSENCE_ORE_BLOCK_PLACED_KEY = registerKey("nether_essence_ore_block_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, EDEN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EDEN_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                        ModBlocks.EDEN_SAPLING.get()));


        register(context, ESSENCE_ORE_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ESSENCE_ORE_BLOCK_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, NETHER_ESSENCE_ORE_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ESSENCE_ORE_BLOCK_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(EclipseDoCaos.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

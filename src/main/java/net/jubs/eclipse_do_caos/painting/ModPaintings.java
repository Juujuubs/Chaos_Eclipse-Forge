package net.jubs.eclipse_do_caos.painting;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, EclipseDoCaos.MOD_ID);

    public static final RegistryObject<PaintingVariant> THE_FIRST_KIN = PAINTING_VARIANTS.register("the_first_kin",
            () -> new PaintingVariant(128, 64));
    public static final RegistryObject<PaintingVariant> GODWELLING = PAINTING_VARIANTS.register("godwelling",
            () -> new PaintingVariant(64, 32));
    public static final RegistryObject<PaintingVariant> GODWELLING_NOW = PAINTING_VARIANTS.register("godwelling_now",
            () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> BELAIOS = PAINTING_VARIANTS.register("belaios",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> JUNO = PAINTING_VARIANTS.register("juno",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> QRAZ = PAINTING_VARIANTS.register("qraz",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> RAVEN = PAINTING_VARIANTS.register("raven",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> VEIGAR = PAINTING_VARIANTS.register("veigar",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> VEX = PAINTING_VARIANTS.register("vex",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> BELORIA_BONISSIMO = PAINTING_VARIANTS.register("beloria_bonissimo",
            () -> new PaintingVariant(16, 32));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}

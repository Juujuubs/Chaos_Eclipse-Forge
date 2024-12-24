package net.jubs.eclipse_do_caos.block.entity;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EclipseDoCaos.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mod_sign_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.EDEN_SIGN.get(), ModBlocks.EDEN_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mod_hanging_sign_entity", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.EDEN_HANGING_SIGN.get(), ModBlocks.EDEN_HANGING_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<CatalystInfuserBlockEntity>> CATALYST_INFUSER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("catalyst_infuser_be", () ->
                    BlockEntityType.Builder.of(CatalystInfuserBlockEntity::new,
                            ModBlocks.CATALYST_INFUSER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}

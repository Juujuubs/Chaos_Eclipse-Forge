package net.jubs.eclipse_do_caos.loot;

import com.mojang.serialization.Codec;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EclipseDoCaos.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEMS =
            LOOT_MODIFIER_SERIALIZERS.register("add_items", AddItemsModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> REPLACE_ITEMS =
            LOOT_MODIFIER_SERIALIZERS.register("replace_items", ReplaceItemsModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}

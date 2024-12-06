package net.jubs.eclipse_do_caos.item;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.item.custom.DelsItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EclipseDoCaos.MOD_ID);

public static final RegistryObject<Item> CONTRACT = ITEMS.register("contract",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DELS = ITEMS.register("dels",
            () -> new DelsItem(new Item.Properties().durability(512)));

    public static void register(IEventBus eventBus){
ITEMS.register(eventBus);

    }
}

package net.jubs.eclipse_do_caos.item;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.item.custom.DelsItem;
import net.jubs.eclipse_do_caos.item.custom.PaxelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EclipseDoCaos.MOD_ID);

    public static final RegistryObject<Item> CONTRACT = ITEMS.register("contract",
        () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SYMBOL = ITEMS.register("symbol",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VOX = ITEMS.register("vox",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEVIL_HORN = ITEMS.register("devil_horn",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HUMAN_TOOTH = ITEMS.register("human_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TICKET_ARCANUMRAILS = ITEMS.register("ticket_arcanumrails",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TICKET_DELUXE_ARCANUMRAILS = ITEMS.register("ticket_deluxe_arcanumrails",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CANNONBALL = ITEMS.register("cannonball",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DELS = ITEMS.register("dels",
            () -> new DelsItem(new Item.Properties().durability(512)));

    public static final RegistryObject<Item> TILAPIA = ITEMS.register("tilapia",
            () -> new Item(new Item.Properties().food(ModFoods.TILAPIA)));
    public static final RegistryObject<Item> FRIED_TILAPIA = ITEMS.register("fried_tilapia",
            () -> new Item(new Item.Properties().food(ModFoods.FRIED_TILAPIA)));
    public static final RegistryObject<Item> SUSHI_TILAPIA = ITEMS.register("sushi_tilapia",
            () -> new Item(new Item.Properties().food(ModFoods.SUSHI_TILAPIA)));

    public static final RegistryObject<Item> BEAN = ITEMS.register("bean",
            () -> new Item(new Item.Properties().food(ModFoods.BEAN)));
    public static final RegistryObject<Item> COOKED_BEAN = ITEMS.register("cooked_bean",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_BEAN)));

    public static final RegistryObject<Item> GOBLIN_EYE = ITEMS.register("goblin_eye",
            () -> new Item(new Item.Properties().food(ModFoods.GOBLIN_EYE)));
    public static final RegistryObject<Item> ELF_EAR = ITEMS.register("elf_ear",
            () -> new Item(new Item.Properties().food(ModFoods.ELF_EAR)));

    public static final RegistryObject<Item> EDEN_TREE_APPLE = ITEMS.register("eden_tree_apple",
            () -> new Item(new Item.Properties().food(ModFoods.EDEN_TREE_APPLE)));
    public static final RegistryObject<Item> EDEN_APPLE = ITEMS.register("eden_apple",
            () -> new Item(new Item.Properties().food(ModFoods.EDEN_APPLE)));

    public static final RegistryObject<Item> ESSENCE_PAXEL = ITEMS.register("essence_paxel",
            () -> new PaxelItem(ModToolTiers.ESSENCE, 1.5f, -2.9f, new Item.Properties()));






    public static void register(IEventBus eventBus){
ITEMS.register(eventBus);

    }
}

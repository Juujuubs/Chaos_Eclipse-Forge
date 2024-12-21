package net.jubs.eclipse_do_caos.item;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.entity.custom.ModBoatEntity;
import net.jubs.eclipse_do_caos.item.custom.DelsItem;
import net.jubs.eclipse_do_caos.item.custom.ModBoatItem;
import net.jubs.eclipse_do_caos.item.custom.PaxelItem;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> ZORA_BOW = ITEMS.register("zora_bow",
            () -> new BowItem(new Item.Properties().durability(3000)));

    public static final RegistryObject<Item> PALLIS_SHIELD = ITEMS.register("pallis_shield",
            () -> new ShieldItem(new Item.Properties().durability(3000)));

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

    public static final RegistryObject<Item> ECLIPSE_BEGINS_MUSIC_DISC = ITEMS.register("eclipse_begins_music_disc",
            () -> new RecordItem(7, ModSounds.ECLIPSE_BEGINS, new Item.Properties().stacksTo(1), 4220));

    public static final RegistryObject<Item> ESSENCE_PAXEL = ITEMS.register("essence_paxel",
            () -> new PaxelItem(ModToolTiers.ESSENCE, 1.5f, -2.9f, new Item.Properties()));

    public static final RegistryObject<Item> GAUNTLET = ITEMS.register("gauntlet",
            () -> new SwordItem(ModToolTiers.ESSENCE, 2, -1.5f, new Item.Properties()));

    public static final RegistryObject<Item> QUARTERSTAFF = ITEMS.register("quarterstaff",
            () -> new SwordItem(ModToolTiers.ESSENCE, 6, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> LADON_DRAGON_GLAIVE = ITEMS.register("ladon_dragon_glaive",
            () -> new SwordItem(ModToolTiers.ESSENCE, 7, -3.2f, new Item.Properties()));

    public static final RegistryObject<Item> HELENA_BASEBALL_BAT = ITEMS.register("helena_baseball_bat",
            () -> new SwordItem(ModToolTiers.ESSENCE, 4, -2.6f, new Item.Properties()));

    public static final RegistryObject<Item> CHALI_II_LANCE = ITEMS.register("chali_ii_lance",
            () -> new SwordItem(ModToolTiers.ESSENCE, 5, -2.75f, new Item.Properties()));

    public static final RegistryObject<Item> SAW_EATER = ITEMS.register("saw_eater",
            () -> new AxeItem(ModToolTiers.ESSENCE, 10, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> ARTORIAS_DESPAIR = ITEMS.register("artorias_despair",
            () -> new AxeItem(ModToolTiers.ESSENCE, 12, -3.75f, new Item.Properties()));

    public static final RegistryObject<Item> ERAK_BATTLEAXE = ITEMS.register("erak_battleaxe",
            () -> new AxeItem(ModToolTiers.ESSENCE, 16, -3.85f, new Item.Properties()));

    public static final RegistryObject<Item> NORR_FORR_HAMMER = ITEMS.register("norr_forr_hammer",
            () -> new AxeItem(ModToolTiers.ESSENCE, 11, -3.65f, new Item.Properties()));

    public static final RegistryObject<Item> CLAWS = ITEMS.register("claws",
            () -> new SwordItem(ModToolTiers.ESSENCE, -3, 2f, new Item.Properties()));

    public static final RegistryObject<Item> AKIRA_KATANA = ITEMS.register("akira_katana",
            () -> new SwordItem(ModToolTiers.ESSENCE, 8, -2.2f, new Item.Properties()));

    public static final RegistryObject<Item> ODIN_DAGGER = ITEMS.register("odin_dagger",
            () -> new SwordItem(ModToolTiers.ESSENCE, -1, 1f, new Item.Properties()));

    public static final RegistryObject<Item> HILDA_SCYTHE = ITEMS.register("hilda_scythe",
            () -> new SwordItem(ModToolTiers.ESSENCE, 0, 0.5f, new Item.Properties()));

    public static final RegistryObject<Item> SAI = ITEMS.register("sai",
            () -> new SwordItem(ModToolTiers.ESSENCE, -2, 1.5f, new Item.Properties()));

    public static final RegistryObject<Item> DIEGO_RAPIER = ITEMS.register("diego_rapier",
            () -> new SwordItem(ModToolTiers.ESSENCE, 1, -1f, new Item.Properties()));

    public static final RegistryObject<Item> GRIMOIRE = ITEMS.register("grimoire",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BELAIOS_WAND = ITEMS.register("belaios_wand",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> OLD_GRIMOIRE = ITEMS.register("old_grimoire",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ASGORE_GRIMOIRE = ITEMS.register("asgore_grimoire",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NOVUS_GRIMOIRE = ITEMS.register("novus_grimoire",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BEANS_SACK = ITEMS.register("beans_sack",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> FROG = ITEMS.register("frog",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VEIGAR_STAFF = ITEMS.register("veigar_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> QRAZ_STAFF = ITEMS.register("qraz_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SYLVERIA_STAFF = ITEMS.register("sylveria_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CATALYST = ITEMS.register("catalyst",
            () -> new Item(new Item.Properties().stacksTo(3)));
    public static final RegistryObject<Item> CATALYST_EMPTY = ITEMS.register("catalyst_empty",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CARSON_CANNON = ITEMS.register("carson_cannon",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ECLIPSE = ITEMS.register("eclipse",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> EDEN_SIGN = ITEMS.register("eden_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.EDEN_SIGN.get(), ModBlocks.EDEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> EDEN_HANGING_SIGN = ITEMS.register("eden_hanging_sign",
            () -> new HangingSignItem(ModBlocks.EDEN_HANGING_SIGN.get(), ModBlocks.EDEN_HANGING_WALL_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> EDEN_BOAT = ITEMS.register("eden_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.EDEN, new Item.Properties()));
    public static final RegistryObject<Item> EDEN_CHEST_BOAT = ITEMS.register("eden_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.EDEN, new Item.Properties()));



    public static void register(IEventBus eventBus){
ITEMS.register(eventBus);

    }
}

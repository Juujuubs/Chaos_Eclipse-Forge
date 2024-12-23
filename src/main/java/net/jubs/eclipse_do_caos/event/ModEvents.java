package net.jubs.eclipse_do_caos.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = EclipseDoCaos.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ModEvents {


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FISHERMAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //Compra
            ItemStack stack = new ItemStack(ModItems.TILAPIA.get(), 4);
            int villagerLevel = 1;

            //Item que Paga
            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), stack, 7, 4, 0.10f
            ));

            //Fisherman Nível 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    //Compra abaixo
                    new ItemStack(ModItems.FRIED_TILAPIA.get(), 8),
                    6, 4, 0.2f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FRIED_TILAPIA.get(), 2),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 3),
                    6, 4, 0.2f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16),
                    //Compra abaixo
                    new ItemStack(ModItems.SUSHI_TILAPIA.get(), 4),
                    3, 6, 0.8f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SUSHI_TILAPIA.get(), 6),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 14),
                    4, 4, 0.4f
            ));
        }

        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BEAN.get(), 6);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), stack, 8, 2, 0.15f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BEAN.get(), 28),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 1),
                    6, 3, 0.3f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    //Compra abaixo
                    new ItemStack(ModItems.COOKED_BEAN.get(), 3),
                    4, 3, 0.35f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.COOKED_BEAN.get(), 14),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 4),
                    4, 3, 0.4f
            ));

        }
        if (event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.CANNONBALL.get(), 8);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20), stack, 4, 3, 0.55f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.CANNONBALL.get(), 8),
                    new ItemStack(Items.IRON_INGOT, 4),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 16),
                    3, 5, 0.8f
            ));
        }
        if (event.getType() == VillagerProfession.CARTOGRAPHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.VOX.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.COPPER_INGOT, 3), stack, 5, 2, 0.10f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_NUGGET, 2),
                    new ItemStack(Items.IRON_NUGGET, 40),
                    //Compra abaixo
                    new ItemStack(ModItems.TICKET_ARCANUMRAILS.get(), 1),
                    6, 2, 0.40f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.TICKET_ARCANUMRAILS.get(), 12),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 25),
                    4, 4, 0.80f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 25),
                    //Compra abaixo
                    new ItemStack(Items.NETHERITE_SCRAP, 4),
                    2, 5, 0.90f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_NUGGET, 6),
                    new ItemStack(Items.IRON_NUGGET, 50),
                    //Compra abaixo
                    new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 1),
                    4, 4, 0.80f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.TICKET_ARCANUMRAILS.get(), 30),
                    new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 20),
                    //Compra abaixo
                    new ItemStack(Items.NETHERITE_INGOT, 2),
                    2, 6, 1.0f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.TICKET_ARCANUMRAILS.get(), 35),
                    new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 30),
                    //Compra abaixo
                    new ItemStack(ModItems.ESSENCE.get(), 25),
                    2, 7, 1.10f
            ));
        }
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.CATALYST_EMPTY.get(), 4);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 30), stack, 3, 5, 0.20f
            ));
        }
        if (event.getType() == VillagerProfession.BUTCHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.ELF_EAR.get(), 6);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(ModItems.ESSENCE.get(), 4),
                    stack, 3, 7, 0.5f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 30),
                    new ItemStack(ModItems.ESSENCE.get(), 6),
                    //Compra abaixo
                    new ItemStack(ModItems.DEVIL_HORN.get(), 8),
                    2, 7, 0.7f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16),
                    new ItemStack(ModItems.ESSENCE.get(), 3),
                    //Compra abaixo
                    new ItemStack(ModItems.GOBLIN_EYE.get(), 5),
                    5, 3, 0.4f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 14),
                    new ItemStack(ModItems.ESSENCE.get(), 2),
                    //Compra abaixo
                    new ItemStack(ModItems.HUMAN_TOOTH.get(), 5),
                    4, 4, 0.5f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 27),
                    //Compra abaixo
                    new ItemStack(ModBlocks.MEAT_BLOCK.get(), 4),
                    4, 3, 0.7f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 13),
                    //Compra abaixo
                    new ItemStack(ModBlocks.EYE_BLOCK.get(), 6),
                    4, 3, 0.5f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 14),
                    //Compra abaixo
                    new ItemStack(ModBlocks.TEETH_BLOCK.get(), 3),
                    5, 4, 0.65f
            ));
            //TROCAS INVERTIDAS
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.ELF_EAR.get(), 2),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 6),
                    3, 7, 0.5f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.DEVIL_HORN.get(), 3),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 12),
                    2, 7, 0.7f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GOBLIN_EYE.get(), 12),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 2),
                    5, 3, 0.4f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.HUMAN_TOOTH.get(), 10),
                    //Compra abaixo
                    new ItemStack(Items.EMERALD, 5),
                    4, 4, 0.5f
            ));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
        ItemStack stack = new ItemStack(ModItems.VOX.get(), 2);

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 8), stack, 6, 2, 0.1f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.ESSENCE.get(), 2),
                new ItemStack(Items.EMERALD, 64), 2, 8, 0.8f
        ));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                //Compra
                new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 1),
                //Paga
                new ItemStack(Items.GOLD_NUGGET, 5),
                new ItemStack(Items.IRON_NUGGET, 60),
                3, 3, 1.2f
        ));
    }

}

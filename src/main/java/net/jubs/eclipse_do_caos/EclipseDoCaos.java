package net.jubs.eclipse_do_caos;

import com.mojang.logging.LogUtils;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModCreativeModeTabs;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EclipseDoCaos.MOD_ID)
public class EclipseDoCaos
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "eclipse_do_caos";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public EclipseDoCaos(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);



        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.DELS);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SYMBOL);
            event.accept(ModItems.CONTRACT);
            event.accept(ModItems.VOX);
            event.accept(ModItems.TICKET_ARCANUMRAILS);
            event.accept(ModItems.TICKET_DELUXE_ARCANUMRAILS);
            event.accept(ModItems.ESSENCE);
            event.accept(ModItems.DEVIL_HORN);
            event.accept(ModItems.GOBLIN_EYE);
            event.accept(ModItems.ELF_EAR);
            event.accept(ModItems.HUMAN_TOOTH);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.BEAN);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.CANNONBALL);
            // Adicionar as Armas aqui
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.TILAPIA);
            event.accept(ModItems.FRIED_TILAPIA);
            event.accept(ModItems.SUSHI_TILAPIA);
            event.accept(ModItems.BEAN);
            event.accept(ModItems.COOKED_BEAN);
            event.accept(ModItems.EDEN_APPLE);
            event.accept(ModItems.EDEN_TREE_APPLE);
            event.accept(ModItems.GOBLIN_EYE);
            event.accept(ModItems.ELF_EAR);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}

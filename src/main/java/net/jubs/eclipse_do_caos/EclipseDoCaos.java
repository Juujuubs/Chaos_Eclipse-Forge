package net.jubs.eclipse_do_caos;

import com.mojang.logging.LogUtils;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.block.entity.ModBlockEntities;
import net.jubs.eclipse_do_caos.entity.ModEntities;
import net.jubs.eclipse_do_caos.entity.client.ModBoatRenderer;
import net.jubs.eclipse_do_caos.item.ModCreativeModeTabs;
import net.jubs.eclipse_do_caos.item.ModItemProperties;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.loot.ModLootModifiers;
import net.jubs.eclipse_do_caos.painting.ModPaintings;
import net.jubs.eclipse_do_caos.screen.CatalystInfuserScreen;
import net.jubs.eclipse_do_caos.screen.ModMenuTypes;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.jubs.eclipse_do_caos.util.ModWoodTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
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

        ModSounds.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);



        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.EDEN_APPLE.get(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(ModItems.EDEN_TREE_APPLE.get(), 0.8f);
            ComposterBlock.COMPOSTABLES.put(ModItems.BEAN.get(), 0.2f);
            ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_BEAN.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BROMELIAD.get().asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.EDEN_LEAVES.get().asItem(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.EDEN_SAPLING.get().asItem(), 0.45f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BROMELIAD.getId(), ModBlocks.POTTED_BROMELIAD);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.EDEN_CHEST_BOAT);
            event.accept(ModItems.EDEN_BOAT);
            event.accept(ModItems.ECLIPSE_BEGINS_MUSIC_DISC);
            event.accept(ModItems.DELS);
            event.accept(ModItems.ESSENCE_PAXEL);
            event.accept(ModItems.SAW_EATER);
            event.accept(ModItems.ARTORIAS_DESPAIR);
            event.accept(ModItems.NORR_FORR_HAMMER);
            event.accept(ModItems.ERAK_BATTLEAXE);
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
            event.accept(ModItems.QUARTERSTAFF);
            event.accept(ModItems.OLD_GRIMOIRE);
            event.accept(ModItems.GRIMOIRE);
            event.accept(ModItems.FROG);
            event.accept(ModItems.CATALYST);
            event.accept(ModItems.CLAWS);
            event.accept(ModItems.PALLIS_SHIELD);
            event.accept(ModItems.ASGORE_GRIMOIRE);
            event.accept(ModItems.ARTORIAS_DESPAIR);
            event.accept(ModItems.HELENA_BASEBALL_BAT);
            event.accept(ModItems.HILDA_SCYTHE);
            event.accept(ModItems.DIEGO_RAPIER);
            event.accept(ModItems.AKIRA_KATANA);
            event.accept(ModItems.ODIN_DAGGER);
            event.accept(ModItems.SAI);
            event.accept(ModItems.VEIGAR_STAFF);
            event.accept(ModItems.QRAZ_STAFF);
            event.accept(ModItems.SYLVERIA_STAFF);
            event.accept(ModItems.NOVUS_GRIMOIRE);
            event.accept(ModItems.CARSON_CANNON);
            event.accept(ModItems.ZORA_BOW);
            event.accept(ModItems.CANNONBALL);
            event.accept(ModItems.SAW_EATER);
            event.accept(ModItems.LADON_DRAGON_GLAIVE);
            event.accept(ModItems.ERAK_BATTLEAXE);
            event.accept(ModItems.BELAIOS_WAND);
            event.accept(ModItems.GAUNTLET);
            event.accept(ModItems.NORR_FORR_HAMMER);
            event.accept(ModItems.CHALI_II_LANCE);
            event.accept(ModItems.ESSENCE_PAXEL);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.CATALYST);
            event.accept(ModItems.CATALYST_EMPTY);
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
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.EDEN_SIGN);
            event.accept(ModItems.EDEN_HANGING_SIGN);
            event.accept(ModBlocks.CATALYST_INFUSER);
            event.accept(ModBlocks.RADIO_ANNOUNCER);
            event.accept(ModBlocks.SAMARA_PLUSHIE);
        }
        if(event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(ModItems.ECLIPSE);
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
            event.enqueueWork(() -> {
                Sheets.addWoodType(ModWoodTypes.EDEN);

                ModItemProperties.addCustomItemProperties();

                EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));


                MenuScreens.register(ModMenuTypes.CATALYST_INFUSER_MENU.get(), CatalystInfuserScreen::new);
            });
        }
    }
}

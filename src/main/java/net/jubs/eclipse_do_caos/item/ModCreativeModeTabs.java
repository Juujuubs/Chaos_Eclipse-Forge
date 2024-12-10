package net.jubs.eclipse_do_caos.item;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
           DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EclipseDoCaos.MOD_ID);

public static final RegistryObject<CreativeModeTab> ECLIPSE_TAB = CREATIVE_MODE_TABS.register("eclipse_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ESSENCE.get()))
                .title(Component.translatable("creativetab.eclipse_tab"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.SYMBOL.get());
                    pOutput.accept(ModItems.CONTRACT.get());
                    pOutput.accept(ModItems.VOX.get());
                    pOutput.accept(ModItems.TICKET_ARCANUMRAILS.get());
                    pOutput.accept(ModItems.TICKET_DELUXE_ARCANUMRAILS.get());
                    pOutput.accept(ModItems.DEVIL_HORN.get());
                    pOutput.accept(ModItems.GOBLIN_EYE.get());
                    pOutput.accept(ModItems.ELF_EAR.get());
                    pOutput.accept(ModItems.HUMAN_TOOTH.get());

                    pOutput.accept(ModItems.TILAPIA.get());
                    pOutput.accept(ModItems.FRIED_TILAPIA.get());
                    pOutput.accept(ModItems.SUSHI_TILAPIA.get());
                    pOutput.accept(ModItems.BEAN.get());
                    pOutput.accept(ModItems.COOKED_BEAN.get());
                    pOutput.accept(ModItems.EDEN_TREE_APPLE.get());
                    pOutput.accept(ModItems.EDEN_APPLE.get());

                    pOutput.accept(ModBlocks.ESSENCE_ORE_BLOCK.get());
                    pOutput.accept(ModBlocks.ESSENCE_BLOCK.get());

                    pOutput.accept(ModItems.ESSENCE.get());

                    pOutput.accept(ModBlocks.EYE_BLOCK.get());
                    pOutput.accept(ModBlocks.MEAT_BLOCK.get());
                    pOutput.accept(ModBlocks.TEETH_BLOCK.get());

                    pOutput.accept(ModItems.DELS.get());
                    pOutput.accept(ModItems.ESSENCE_PAXEL.get());

                    pOutput.accept(ModItems.CANNONBALL.get());
                })
                .build());
// Alterar depois para a Lua

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

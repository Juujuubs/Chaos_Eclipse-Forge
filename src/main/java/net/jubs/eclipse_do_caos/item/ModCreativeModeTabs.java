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
                    pOutput.accept(ModItems.CONTRACT.get());
                    pOutput.accept(ModItems.ESSENCE.get());
                    pOutput.accept(ModItems.DELS.get());

                    pOutput.accept(ModBlocks.ESSENCE_BLOCK.get());
                    pOutput.accept(ModBlocks.ESSENCE_ORE_BLOCK.get());
                    pOutput.accept(ModBlocks.MEAT_BLOCK.get());
                })
                .build());
// Alterar depois para a Lua

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

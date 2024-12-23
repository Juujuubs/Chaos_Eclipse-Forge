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
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECLIPSE.get()))
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

                    pOutput.accept(ModBlocks.BROMELIAD.get());
                    pOutput.accept(ModItems.ECLIPSE.get());
                    pOutput.accept(ModBlocks.ESSENCE_ORE_BLOCK.get());
                    pOutput.accept(ModBlocks.ESSENCE_BLOCK.get());

                    pOutput.accept(ModItems.ESSENCE.get());

                    pOutput.accept(ModBlocks.RADIO_ANNOUNCER.get());
                    pOutput.accept(ModBlocks.SAMARA_PLUSHIE.get());

                    pOutput.accept(ModBlocks.EYE_BLOCK.get());
                    pOutput.accept(ModBlocks.MEAT_BLOCK.get());
                    pOutput.accept(ModBlocks.TEETH_BLOCK.get());

                    pOutput.accept(ModBlocks.EDEN_LOG.get());
                    pOutput.accept(ModBlocks.EDEN_WOOD.get());
                    pOutput.accept(ModBlocks.STRIPPED_EDEN_LOG.get());
                    pOutput.accept(ModBlocks.STRIPPED_EDEN_WOOD.get());
                    pOutput.accept(ModBlocks.EDEN_PLANKS.get());
                    pOutput.accept(ModBlocks.EDEN_DOOR.get());
                    pOutput.accept(ModBlocks.EDEN_STAIRS.get());
                    pOutput.accept(ModBlocks.EDEN_FENCE.get());
                    pOutput.accept(ModBlocks.EDEN_FENCE_GATE.get());
                    pOutput.accept(ModBlocks.EDEN_HANGING_SIGN.get());
                    pOutput.accept(ModBlocks.EDEN_SIGN.get());
                    pOutput.accept(ModItems.EDEN_CHEST_BOAT.get());
                    pOutput.accept(ModItems.EDEN_BOAT.get());
                    pOutput.accept(ModBlocks.EDEN_SLAB.get());
                    pOutput.accept(ModBlocks.EDEN_TRAPDOOR.get());
                    pOutput.accept(ModBlocks.EDEN_PRESSURE_PLATE.get());
                    pOutput.accept(ModBlocks.EDEN_BUTTON.get());
                    pOutput.accept(ModBlocks.EDEN_LEAVES.get());
                    pOutput.accept(ModBlocks.EDEN_SAPLING.get());

                    pOutput.accept(ModItems.ECLIPSE_BEGINS_MUSIC_DISC.get());

                    pOutput.accept(ModItems.DELS.get());
                    pOutput.accept(ModItems.ESSENCE_PAXEL.get());

                    pOutput.accept(ModItems.QUARTERSTAFF.get());
                    pOutput.accept(ModItems.HELENA_BASEBALL_BAT.get());
                    pOutput.accept(ModItems.QRAZ_STAFF.get());
                    pOutput.accept(ModItems.SYLVERIA_STAFF.get());
                    pOutput.accept(ModItems.VEIGAR_STAFF.get());
                    pOutput.accept(ModItems.LADON_DRAGON_GLAIVE.get());
                    pOutput.accept(ModItems.NORR_FORR_HAMMER.get());
                    pOutput.accept(ModItems.ERAK_BATTLEAXE.get());
                    pOutput.accept(ModItems.ARTORIAS_DESPAIR.get());
                    pOutput.accept(ModItems.SAW_EATER.get());
                    pOutput.accept(ModItems.CHALI_II_LANCE.get());
                    pOutput.accept(ModItems.AKIRA_KATANA.get());
                    pOutput.accept(ModItems.DIEGO_RAPIER.get());
                    pOutput.accept(ModItems.CLAWS.get());
                    pOutput.accept(ModItems.SAI.get());
                    pOutput.accept(ModItems.HILDA_SCYTHE.get());
                    pOutput.accept(ModItems.ODIN_DAGGER.get());
                    pOutput.accept(ModItems.GAUNTLET.get());
                    pOutput.accept(ModItems.BEANS_SACK.get());
                    pOutput.accept(ModItems.FROG.get());
                    pOutput.accept(ModItems.BELAIOS_WAND.get());
                    pOutput.accept(ModItems.GRIMOIRE.get());
                    pOutput.accept(ModItems.OLD_GRIMOIRE.get());
                    pOutput.accept(ModItems.ASGORE_GRIMOIRE.get());
                    pOutput.accept(ModItems.NOVUS_GRIMOIRE.get());
                    pOutput.accept(ModItems.ZORA_BOW.get());
                    pOutput.accept(ModItems.CARSON_CANNON.get());
                    pOutput.accept(ModItems.PALLIS_SHIELD.get());
                    pOutput.accept(ModItems.CATALYST.get());
                    pOutput.accept(ModItems.CATALYST_EMPTY.get());
                    pOutput.accept(ModItems.CANNONBALL.get());
                    pOutput.accept(ModItems.POISON_BOLT.get());
                    pOutput.accept(ModItems.LIGHTNING_STRIKE.get());
                })
                .build());
// Alterar depois para a Lua

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, EclipseDoCaos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
    this.tag(ItemTags.MUSIC_DISCS)
            .add(ModItems.ECLIPSE_BEGINS_MUSIC_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.ECLIPSE_BEGINS_MUSIC_DISC.get());

        this.tag(ItemTags.SWORDS)
                .add(ModItems.QUARTERSTAFF.get())
                .add(ModItems.HELENA_BASEBALL_BAT.get())
                .add(ModItems.CLAWS.get())
                .add(ModItems.HILDA_SICKLE.get())
                .add(ModItems.DIEGO_RAPIER.get())
                .add(ModItems.AKIRA_KATANA.get())
                .add(ModItems.ODIN_DAGGER.get())
                .add(ModItems.SAW_EATER.get())
                .add(ModItems.LADON_DRAGON_GLAIVE.get())
                .add(ModItems.CHALI_II_LANCE.get())
                .add(ModItems.AGATHA_BONESAW.get())
                .add(ModItems.SAI.get());

        this.tag(ItemTags.FISHES)
                .add(ModItems.TILAPIA.get());

        this.tag(ModTags.Items.GRIMOIRES)
                .add(ModItems.GRIMOIRE.get())
                .add(ModItems.ASGORE_GRIMOIRE.get())
                .add(ModItems.OLD_GRIMOIRE.get())
                .add(ModItems.NOVUS_GRIMOIRE.get());

        this.tag(ModTags.Items.STAFFS)
                .add(ModItems.VEIGAR_STAFF.get())
                .add(ModItems.QRAZ_STAFF.get())
                .add(ModItems.SYLVERIA_STAFF.get())
                .add(ModItems.QUARTERSTAFF.get());

        this.tag(ModTags.Items.WANDS)
                .add(ModItems.BELAIOS_WAND.get());

        this.tag(ItemTags.AXES)
                .add(ModItems.ESSENCE_PAXEL.get())
                .add(ModItems.ARTORIAS_DESPAIR.get())
                .add(ModItems.SAW_EATER.get())
                .add(ModItems.NORR_FORR_HAMMER.get())
                .add(ModItems.ERAK_BATTLEAXE.get());

        this.tag(ItemTags.PICKAXES)
                .add(ModItems.ESSENCE_PAXEL.get());

        this.tag(ItemTags.SHOVELS)
                .add(ModItems.ESSENCE_PAXEL.get());

        this.tag(ItemTags.TOOLS)
                .add(ModItems.ESSENCE_PAXEL.get())
                .add(ModItems.DELS.get())
                .add(ModItems.ARTORIAS_DESPAIR.get())
                .add(ModItems.SAW_EATER.get())
                .add(ModItems.NORR_FORR_HAMMER.get())
                .add(ModItems.ERAK_BATTLEAXE.get());

        this.tag(ModTags.Items.SHIELDS)
                .add(ModItems.PALLIS_SHIELD.get());
        this.tag(ModTags.Items.BOWS)
                .add(ModItems.ZORA_BOW.get());
        this.tag(ModTags.Items.GUNS)
                .add(ModItems.CARSON_CANNON.get());

        this.tag(ItemTags.FLOWERS)
                .add(ModBlocks.BROMELIAD.get().asItem());
        this.tag(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.BROMELIAD.get().asItem());

        this.tag(ModTags.Items.LOST_WEAPONS)
                .add(ModItems.QUARTERSTAFF.get())
                .add(ModItems.OLD_GRIMOIRE.get())
                .add(ModItems.GRIMOIRE.get())
                .add(ModItems.FROG.get())
                .add(ModItems.CATALYST.get())
                .add(ModItems.CLAWS.get())
                .add(ModItems.PALLIS_SHIELD.get())
                .add(ModItems.ASGORE_GRIMOIRE.get())
                .add(ModItems.BEANS_SACK.get())
                .add(ModItems.ARTORIAS_DESPAIR.get())
                .add(ModItems.HELENA_BASEBALL_BAT.get())
                .add(ModItems.HILDA_SICKLE.get())
                .add(ModItems.DIEGO_RAPIER.get())
                .add(ModItems.AKIRA_KATANA.get())
                .add(ModItems.ODIN_DAGGER.get())
                .add(ModItems.SAI.get())
                .add(ModItems.VEIGAR_STAFF.get())
                .add(ModItems.QRAZ_STAFF.get())
                .add(ModItems.SYLVERIA_STAFF.get())
                .add(ModItems.NOVUS_GRIMOIRE.get())
                .add(ModItems.CARSON_CANNON.get())
                .add(ModItems.SAW_EATER.get())
                .add(ModItems.LADON_DRAGON_GLAIVE.get())
                .add(ModItems.ERAK_BATTLEAXE.get())
                .add(ModItems.BELAIOS_WAND.get())
                .add(ModItems.GAUNTLET.get())
                .add(ModItems.NORR_FORR_HAMMER.get())
                .add(ModItems.CHALI_II_LANCE.get())
                .add(ModItems.AGATHA_BONESAW.get())
                .add(ModItems.ZORA_BOW.get());

        this.tag(ModTags.Items.NOT_FROM_THIS_WORLD)
                .add(ModItems.ASGORE_GRIMOIRE.get())
                .add(ModItems.ARTORIAS_DESPAIR.get())
                .add(ModItems.HELENA_BASEBALL_BAT.get())
                .add(ModItems.HILDA_SICKLE.get())
                .add(ModItems.DIEGO_RAPIER.get())
                .add(ModItems.ODIN_DAGGER.get())
                .add(ModItems.CARSON_CANNON.get())
                .add(ModItems.SAW_EATER.get())
                .add(ModItems.LADON_DRAGON_GLAIVE.get())
                .add(ModItems.ERAK_BATTLEAXE.get())
                .add(ModItems.CHALI_II_LANCE.get())
                .add(ModItems.ZORA_BOW.get());

        this.tag(ModTags.Items.RANGED_WEAPONS)
                .add(ModItems.ASGORE_GRIMOIRE.get())
                .add(ModItems.BEANS_SACK.get())
                .add(ModItems.CARSON_CANNON.get())
                .add(ModItems.GRIMOIRE.get())
                .add(ModItems.NOVUS_GRIMOIRE.get())
                .add(ModItems.OLD_GRIMOIRE.get())
                .add(ModItems.QRAZ_STAFF.get())
                .add(ModItems.SYLVERIA_STAFF.get())
                .add(ModItems.VEIGAR_STAFF.get())
                .add(ModItems.ZORA_BOW.get())
                .add(ModItems.BELAIOS_WAND.get())
                .add(ModItems.FROG.get());

        this.tag(ModTags.Items.BOSS_WEAPONS)
                .add(ModItems.DIEGO_RAPIER.get())
                .add(ModItems.CHALI_II_LANCE.get())
                .add(ModItems.AGATHA_BONESAW.get())
                .add(ModItems.AKIRA_KATANA.get());

        this.tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.ASGORE_GRIMOIRE.get())
                .add(ModItems.ODIN_DAGGER.get())
                .add(ModItems.CARSON_CANNON.get())
                .add(ModItems.GRIMOIRE.get())
                .add(ModItems.OLD_GRIMOIRE.get());

        this.tag(ItemTags.BOOKSHELF_BOOKS)
                .add(ModItems.NOVUS_GRIMOIRE.get())
                .add(ModItems.ASGORE_GRIMOIRE.get())
                .add(ModItems.GRIMOIRE.get())
                .add(ModItems.VOX.get())
                .add(ModItems.OLD_GRIMOIRE.get());

        this.tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.ESSENCE.get());

        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.BEAN.get());

        this.tag(ItemTags.LOGS)
                .add(ModBlocks.EDEN_LOG.get().asItem())
                .add(ModBlocks.EDEN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EDEN_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EDEN_WOOD.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EDEN_LOG.get().asItem())
                .add(ModBlocks.EDEN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EDEN_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EDEN_WOOD.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.EDEN_PLANKS.get().asItem());
        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.EDEN_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.EDEN_STAIRS.get().asItem());
        this.tag(ItemTags.SLABS)
                .add(ModBlocks.EDEN_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.EDEN_SLAB.get().asItem());
        this.tag(ItemTags.BUTTONS)
                .add(ModBlocks.EDEN_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.EDEN_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EDEN_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.FENCES)
                .add(ModBlocks.EDEN_FENCE.get().asItem());
        this.tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.EDEN_FENCE.get().asItem());
        this.tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.EDEN_FENCE_GATE.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.EDEN_DOOR.get().asItem());
        this.tag(ItemTags.DOORS)
                .add(ModBlocks.EDEN_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EDEN_TRAPDOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.EDEN_TRAPDOOR.get().asItem());
        this.tag(ItemTags.LEAVES)
                .add(ModBlocks.EDEN_LEAVES.get().asItem());
        this.tag(ItemTags.SAPLINGS)
                .add(ModBlocks.EDEN_SAPLING.get().asItem());
        this.tag(ItemTags.SIGNS)
                .add(ModBlocks.EDEN_SIGN.get().asItem());
        this.tag(ItemTags.HANGING_SIGNS)
                .add(ModBlocks.EDEN_HANGING_SIGN.get().asItem());

        this.tag(ItemTags.BOATS)
                .add(ModItems.EDEN_BOAT.get())
                .add(ModItems.EDEN_CHEST_BOAT.get());
        this.tag(ItemTags.CHEST_BOATS)
                .add(ModItems.EDEN_CHEST_BOAT.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }

}

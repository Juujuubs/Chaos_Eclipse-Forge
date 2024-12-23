package net.jubs.eclipse_do_caos.datagen;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.ModBlocks;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.loot.AddItemsModifier;
import net.jubs.eclipse_do_caos.loot.AddItemsModifier.ItemEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.Arrays;
import java.util.List;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, EclipseDoCaos.MOD_ID);
    }

    @Override
    protected void start() {
        //STRUCTURES
        add("items_from_the_ancient_city", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ESSENCE.get(), 0.5f, 2),
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.5f, 1),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.5f, 1),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.5f, 1),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.5f, 1),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get(), 0.5f, 4),
                        new ItemEntry(ModItems.CANNONBALL.get(), 0.5f, 3)
                )));
        add("weapons_from_the_ancient_city", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.GRIMOIRE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.QUARTERSTAFF.get(), 0.08f, 1),
                        new ItemEntry(ModItems.CLAWS.get(), 0.08f, 1),
                        new ItemEntry(ModItems.ODIN_DAGGER.get(), 0.08f, 1),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.ARTORIAS_DESPAIR.get(), 0.08f, 1),
                        new ItemEntry(ModItems.SAW_EATER.get(), 0.08f, 1),
                        new ItemEntry(ModItems.ASGORE_GRIMOIRE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.NOVUS_GRIMOIRE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.PALLIS_SHIELD.get(), 0.08f, 1),
                        new ItemEntry(ModItems.SYLVERIA_STAFF.get(), 0.08f, 1),
                        new ItemEntry(ModItems.CARSON_CANNON.get(), 0.08f, 1),
                        new ItemEntry(ModItems.ZORA_BOW.get(), 0.08f, 1),
                        new ItemEntry(ModItems.EDEN_APPLE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.BELAIOS_WAND.get(), 0.08f, 1),
                        new ItemEntry(ModItems.GAUNTLET.get(), 0.08f, 1),
                        new ItemEntry(ModItems.NORR_FORR_HAMMER.get(), 0.08f, 1),
                        new ItemEntry(ModItems.CHALI_II_LANCE.get(), 0.08f, 1),
                        new ItemEntry(ModItems.DELS.get(), 0.12f, 1)
                )));
        add("extra_items_from_the_ancient_city", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ECLIPSE_BEGINS_MUSIC_DISC.get(), 0.3f, 1),
                        new ItemEntry(ModItems.VOX.get(), 0.3f, 1),
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 0.3f, 1)
                )));
        add("weapon_from_the_ancient_city_ice_box", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city_ice_box")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                List.of(
                        new ItemEntry(ModItems.CLAWS.get(), 0.10f, 1)
                )));
        add("items_from_the_abandoned_mineshaft", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.9f, 3),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.9f, 3),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.9f, 3),
                        new ItemEntry(ModItems.VOX.get(), 0.9f, 3),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get(), 0.9f, 3),
                        new ItemEntry(ModItems.TICKET_ARCANUMRAILS.get(), 0.9f, 3),
                        new ItemEntry(ModItems.CANNONBALL.get(), 0.9f, 3)
                )));
        add("weapons_from_the_abandoned_mineshaft", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.GRIMOIRE.get(), 0.01f, 1),
                        new ItemEntry(ModItems.BEANS_SACK.get(), 0.01f, 1),
                        new ItemEntry(ModItems.DIEGO_RAPIER.get(), 0.01f, 1),
                        new ItemEntry(ModItems.HILDA_SCYTHE.get(), 0.01f, 1),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get(), 0.01f, 1),
                        new ItemEntry(ModItems.HELENA_BASEBALL_BAT.get(), 0.01f, 1),
                        new ItemEntry(ModItems.CARSON_CANNON.get(), 0.01f, 1),
                        new ItemEntry(ModItems.ZORA_BOW.get(), 0.01f, 1),
                        new ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get(), 0.01f, 1),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get(), 0.01f, 1),
                        new ItemEntry(ModItems.BELAIOS_WAND.get(), 0.01f, 1),
                        new ItemEntry(ModItems.NORR_FORR_HAMMER.get(), 0.01f, 1),
                        new ItemEntry(ModItems.CHALI_II_LANCE.get(), 0.01f, 1),
                        new ItemEntry(ModItems.ESSENCE_PAXEL.get(), 0.01f, 1)

                )));

        //MOBS
        add("items_from_the_zombie", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.35f, 2),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.35f, 2),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.35f, 2)
                )));
        add("items_from_the_drowned", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/drowned")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.45f, 2),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.45f, 2)
                )));
        add("items_from_the_husk", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/husk")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.25f, 2)
                )));
        add("items_from_the_zombified_piglin", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombified_piglin")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.45f, 3),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.45f, 3),
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.45f, 3)
                )));
        add("items_from_the_piglin", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/piglin")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.45f, 2),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.45f, 2)
                )));
        add("items_from_the_piglin_brute", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/piglin_brute")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.55f, 2),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.55f, 2)
                )));
        add("items_from_the_skeleton", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.35f, 2)
                )));
        add("items_from_the_stray", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/stray")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.45f, 3)
                )));
        add("items_from_the_wither_skeleton", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/wither_skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.25f, 3)
                )));
        add("items_from_the_wither", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/wither")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.45f, 6),
                        new ItemEntry(ModItems.ESSENCE.get(), 0.45f, 6)
                )));
        add("items_from_the_enderman", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/enderman")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.5f, 2),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.5f, 2)
                )));
        add("items_from_the_ender_dragon", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/ender_dragon")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.7f, 8),
                        new ItemEntry(ModItems.ESSENCE.get(), 0.7f, 8)
                )));
        add("items_from_the_zombie_villager", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie_villager")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.45f, 2),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.45f, 2)
                )));
        add("items_from_the_villager", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/villager")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.25f, 1),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.25f, 1)
                )));
        add("items_from_the_pillager", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/pillager")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.25f, 1),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.25f, 1)
                )));
        add("items_from_the_evoker", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/evoker")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.35f, 2),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.35f, 2)
                )));
        add("items_from_the_vindicator", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/vindicator")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.45f, 2),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.45f, 2)
                )));
        add("items_from_the_witch", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/witch")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.65f, 3),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.65f, 3),
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.65f, 3),
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.65f, 3)
                )));
        add("items_from_the_ravager", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/ravager")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.5f, 4),
                        new ItemEntry(ModItems.ELF_EAR.get(), 0.5f, 4),
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.5f, 4)
                )));
        add("items_from_the_warden", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/warden")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.ESSENCE.get(), 0.55f, 7),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.55f, 7)
                )));
        add("items_from_the_frog", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/frog")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModItems.FROG.get(), 0.05f, 1)
                )));
        add("items_from_the_wandering_trader", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/wandering_trader")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get(), 0.15f, 2),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.15f, 2)
                )));

        //GAMEPLAY
        add("items_from_the_fish", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/fishing/fish")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModItems.TILAPIA.get(), 1f, 1)
                )));
        add("items_from_the_treasure", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/fishing/treasure")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.FROG.get(), 0.05f, 1),
                        new ItemEntry(ModItems.ESSENCE.get(), 0.05f, 1),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get(), 0.05f, 1),
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get(), 0.05f, 1)
                )));
        add("items_from_the_junk", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/fishing/junk")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get(), 0.15f, 1),
                        new ItemEntry(ModItems.DEVIL_HORN.get(), 0.15f, 1),
                        new ItemEntry(ModItems.VOX.get(), 0.15f, 1),
                        new ItemEntry(ModItems.TICKET_ARCANUMRAILS.get(), 0.15f, 1),
                        new ItemEntry(ModItems.BEAN.get(), 0.15f, 1)
                )));
        add("items_from_the_sniffer_digging", new AddItemsModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()},
                List.of(
                        new ItemEntry(ModBlocks.BROMELIAD.get().asItem(), 0.35f, 1)
                )));
    }
}

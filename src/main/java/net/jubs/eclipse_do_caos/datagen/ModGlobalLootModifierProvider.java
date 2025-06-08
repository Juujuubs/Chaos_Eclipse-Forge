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
        add("items_from_the_ancient_city", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.ESSENCE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.DEVIL_HORN.get()),
                        new AddItemsModifier.ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ELF_EAR.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CANNONBALL.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.7f // Chance dos Itens Aparecerem
        ));

        add("weapons_from_the_ancient_city", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.ESSENCE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.QUARTERSTAFF.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CLAWS.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ODIN_DAGGER.get()),
                        new AddItemsModifier.ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ARTORIAS_DESPAIR.get()),
                        new AddItemsModifier.ItemEntry(ModItems.SAW_EATER.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ASGORE_GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.NOVUS_GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.PALLIS_SHIELD.get()),
                        new AddItemsModifier.ItemEntry(ModItems.SYLVERIA_STAFF.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CARSON_CANNON.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ZORA_BOW.get()),
                        new AddItemsModifier.ItemEntry(ModItems.EDEN_APPLE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ERAK_BATTLEAXE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.BELAIOS_WAND.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GAUNTLET.get()),
                        new AddItemsModifier.ItemEntry(ModItems.NORR_FORR_HAMMER.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CHALI_II_LANCE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.DELS.get())
                ),
        1, // Máximo de Itens que podem Aparecer
                0.12f // Chance dos Itens Aparecerem
        ));
        add("weapon_from_the_ancient_city_ice_box", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city_ice_box")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.CLAWS.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.10f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_abandoned_mineshaft", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ELF_EAR.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new AddItemsModifier.ItemEntry(ModItems.VOX.get()),
                        new AddItemsModifier.ItemEntry(ModItems.TICKET_ARCANUMRAILS.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CANNONBALL.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.9f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_abandoned_mineshaft", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.BEANS_SACK.get()),
                        new AddItemsModifier.ItemEntry(ModItems.DIEGO_RAPIER.get()),
                        new AddItemsModifier.ItemEntry(ModItems.HILDA_SICKLE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.HELENA_BASEBALL_BAT.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CARSON_CANNON.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ZORA_BOW.get()),
                        new AddItemsModifier.ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ERAK_BATTLEAXE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.BELAIOS_WAND.get()),
                        new AddItemsModifier.ItemEntry(ModItems.NORR_FORR_HAMMER.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CHALI_II_LANCE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ESSENCE_PAXEL.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.01f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_bastion_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/bastion_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.DEVIL_HORN.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ELF_EAR.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new AddItemsModifier.ItemEntry(ModItems.TICKET_ARCANUMRAILS.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                1f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_bastion_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/bastion_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.AKIRA_KATANA.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.QUARTERSTAFF.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST.get()),
                        new AddItemsModifier.ItemEntry(ModItems.PALLIS_SHIELD.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.03f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_ruined_portal", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/ruined_portal")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.AKIRA_KATANA.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GRIMOIRE.get()),
                        new AddItemsModifier.ItemEntry(ModItems.QUARTERSTAFF.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST.get()),
                        new AddItemsModifier.ItemEntry(ModItems.PALLIS_SHIELD.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.01f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_desert_pyramid", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/desert_pyramid")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.DEVIL_HORN.get()),
                        new AddItemsModifier.ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new AddItemsModifier.ItemEntry(ModItems.ELF_EAR.get()),
                        new AddItemsModifier.ItemEntry(ModItems.BEAN.get()),
                        new AddItemsModifier.ItemEntry(ModItems.VOX.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new AddItemsModifier.ItemEntry(ModItems.TICKET_ARCANUMRAILS.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.8f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_desert_pyramid", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/desert_pyramid")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.BEANS_SACK.get()),
                        new AddItemsModifier.ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new AddItemsModifier.ItemEntry(ModItems.PALLIS_SHIELD.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CARSON_CANNON.get()),
                        new AddItemsModifier.ItemEntry(ModItems.BELAIOS_WAND.get()),
                        new AddItemsModifier.ItemEntry(ModItems.GAUNTLET.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.01f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_end_city_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new AddItemsModifier.ItemEntry(ModItems.DEVIL_HORN.get()),
                        new AddItemsModifier.ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CATALYST.get()),
                        new AddItemsModifier.ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get()),
                        new AddItemsModifier.ItemEntry(ModItems.CANNONBALL.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                1f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_end_city_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GRIMOIRE.get()),
                        new ItemEntry(ModItems.ASGORE_GRIMOIRE.get()),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new ItemEntry(ModItems.ODIN_DAGGER.get()),
                        new ItemEntry(ModItems.PALLIS_SHIELD.get()),
                        new ItemEntry(ModItems.QUARTERSTAFF.get()),
                        new ItemEntry(ModItems.HELENA_BASEBALL_BAT.get()),
                        new ItemEntry(ModItems.ARTORIAS_DESPAIR.get()),
                        new ItemEntry(ModItems.SAW_EATER.get()),
                        new ItemEntry(ModItems.AKIRA_KATANA.get()),
                        new ItemEntry(ModItems.BEANS_SACK.get()),
                        new ItemEntry(ModItems.DIEGO_RAPIER.get()),
                        new ItemEntry(ModItems.HILDA_SICKLE.get()),
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.CATALYST.get()),
                        new ItemEntry(ModItems.SAI.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.SYLVERIA_STAFF.get()),
                        new ItemEntry(ModItems.NOVUS_GRIMOIRE.get()),
                        new ItemEntry(ModItems.CARSON_CANNON.get()),
                        new ItemEntry(ModItems.ZORA_BOW.get()),
                        new ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get()),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get()),
                        new ItemEntry(ModItems.BELAIOS_WAND.get()),
                        new ItemEntry(ModItems.GAUNTLET.get()),
                        new ItemEntry(ModItems.NORR_FORR_HAMMER.get()),
                        new ItemEntry(ModItems.CHALI_II_LANCE.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.12f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_jungle_temple", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.BEAN.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                1f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_jungle_temple", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.BEANS_SACK.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.SYLVERIA_STAFF.get()),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new ItemEntry(ModItems.ZORA_BOW.get()),
                        new ItemEntry(ModItems.BELAIOS_WAND.get()),
                        new ItemEntry(ModItems.GAUNTLET.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.04f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_pillager_outpost", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/pillager_outpost")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.TICKET_ARCANUMRAILS.get()),
                        new ItemEntry(ModItems.VOX.get()),
                        new ItemEntry(ModItems.CANNONBALL.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.7f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_pillager_outpost", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/pillager_outpost")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ARTORIAS_DESPAIR.get()),
                        new ItemEntry(ModItems.SAW_EATER.get()),
                        new ItemEntry(ModItems.HELENA_BASEBALL_BAT.get()),
                        new ItemEntry(ModItems.AKIRA_KATANA.get()),
                        new ItemEntry(ModItems.DIEGO_RAPIER.get()),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new ItemEntry(ModItems.NOVUS_GRIMOIRE.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.PALLIS_SHIELD.get()),
                        new ItemEntry(ModItems.SYLVERIA_STAFF.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.SAI.get()),
                        new ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get()),
                        new ItemEntry(ModItems.GAUNTLET.get()),
                        new ItemEntry(ModItems.NORR_FORR_HAMMER.get()),
                        new ItemEntry(ModItems.CHALI_II_LANCE.get()),
                        new ItemEntry(ModItems.DELS.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.02f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_igloo_chest", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/igloo_chest")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get())
                ),
                4, // Máximo de Itens que podem Aparecer
                0.5f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_igloo_chest", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/igloo_chest")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.CLAWS.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.04f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_simple_dungeon", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/simple_dungeon")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.DEVIL_HORN.get())
                ),
                6, // Máximo de Itens que podem Aparecer
                0.75f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_simple_dungeon", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/simple_dungeon")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GRIMOIRE.get()),
                        new ItemEntry(ModItems.ASGORE_GRIMOIRE.get()),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new ItemEntry(ModItems.NOVUS_GRIMOIRE.get()),
                        new ItemEntry(ModItems.QUARTERSTAFF.get()),
                        new ItemEntry(ModItems.HILDA_SICKLE.get()),
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.SYLVERIA_STAFF.get()),
                        new ItemEntry(ModItems.ZORA_BOW.get()),
                        new ItemEntry(ModItems.BELAIOS_WAND.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.03f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_woodland_mansion", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/woodland_mansion")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.DEVIL_HORN.get()),
                        new ItemEntry(ModItems.TICKET_ARCANUMRAILS.get()),
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get()),
                        new ItemEntry(ModItems.CANNONBALL.get())
                ),
                6, // Máximo de Itens que podem Aparecer
                0.8f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_woodland_mansion", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/woodland_mansion")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ARTORIAS_DESPAIR.get()),
                        new ItemEntry(ModItems.SAW_EATER.get()),
                        new ItemEntry(ModItems.HELENA_BASEBALL_BAT.get()),
                        new ItemEntry(ModItems.AKIRA_KATANA.get()),
                        new ItemEntry(ModItems.DIEGO_RAPIER.get()),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new ItemEntry(ModItems.SYLVERIA_STAFF.get()),
                        new ItemEntry(ModItems.NOVUS_GRIMOIRE.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.PALLIS_SHIELD.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.NORR_FORR_HAMMER.get()),
                        new ItemEntry(ModItems.CHALI_II_LANCE.get()),
                        new ItemEntry(ModItems.DELS.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.04f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_stronghold_library", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_library")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.DEVIL_HORN.get()),
                        new ItemEntry(ModItems.TICKET_ARCANUMRAILS.get()),
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get())
                ),
                7, // Máximo de Itens que podem Aparecer
                0.9f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_stronghold_library", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_library")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ODIN_DAGGER.get()),
                        new ItemEntry(ModItems.PALLIS_SHIELD.get()),
                        new ItemEntry(ModItems.QUARTERSTAFF.get()),
                        new ItemEntry(ModItems.HELENA_BASEBALL_BAT.get()),
                        new ItemEntry(ModItems.ARTORIAS_DESPAIR.get()),
                        new ItemEntry(ModItems.SAW_EATER.get()),
                        new ItemEntry(ModItems.AKIRA_KATANA.get()),
                        new ItemEntry(ModItems.DIEGO_RAPIER.get()),
                        new ItemEntry(ModItems.HILDA_SICKLE.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.GRIMOIRE.get()),
                        new ItemEntry(ModItems.ASGORE_GRIMOIRE.get()),
                        new ItemEntry(ModItems.NOVUS_GRIMOIRE.get()),
                        new ItemEntry(ModItems.OLD_GRIMOIRE.get()),
                        new ItemEntry(ModItems.LADON_DRAGON_GLAIVE.get()),
                        new ItemEntry(ModItems.CHALI_II_LANCE.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.05f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_underwater_ruin_big", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_big")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.BEAN.get()),
                        new ItemEntry(ModItems.CANNONBALL.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.75f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_underwater_ruin_big", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_big")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.BEANS_SACK.get()),
                        new ItemEntry(ModItems.SAI.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.04f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_underwater_ruin_small", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_small")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.BEAN.get()),
                        new ItemEntry(ModItems.CANNONBALL.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.65f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_underwater_ruin_small", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_small")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.BEANS_SACK.get()),
                        new ItemEntry(ModItems.SAI.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.03f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_shipwreck_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get()),
                        new ItemEntry(ModItems.EDEN_APPLE.get()),
                        new ItemEntry(ModItems.BEAN.get()),
                        new ItemEntry(ModItems.CATALYST_EMPTY.get()),
                        new ItemEntry(ModItems.CANNONBALL.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.50f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_shipwreck_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.BEANS_SACK.get()),
                        new ItemEntry(ModItems.SAI.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.05f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_buried_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/buried_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.TICKET_DELUXE_ARCANUMRAILS.get()),
                        new ItemEntry(ModItems.EDEN_TREE_APPLE.get()),
                        new ItemEntry(ModItems.CANNONBALL.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.35f // Chance dos Itens Aparecerem
        ));
        add("weapons_from_the_buried_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/buried_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.FROG.get()),
                        new ItemEntry(ModItems.BEANS_SACK.get()),
                        new ItemEntry(ModItems.SAI.get()),
                        new ItemEntry(ModItems.VEIGAR_STAFF.get()),
                        new ItemEntry(ModItems.QRAZ_STAFF.get()),
                        new ItemEntry(ModItems.CLAWS.get()),
                        new ItemEntry(ModItems.ERAK_BATTLEAXE.get()),
                        new ItemEntry(ModItems.BELAIOS_WAND.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.06f // Chance dos Itens Aparecerem
        ));
        add("extra_item_from_the_buried_treasure", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("chests/buried_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModBlocks.SAMARA_PLUSHIE.get().asItem())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.03f // Chance dos Itens Aparecerem
        ));

        //MOBS
        add("items_from_the_zombie", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.35f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_drowned", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/drowned")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_husk", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/husk")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.25f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_zombified_piglin", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/zombified_piglin")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.DEVIL_HORN.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_piglin", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/piglin")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_piglin_brute", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/piglin_brute")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.55f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_skeleton", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.35f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_stray", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/stray")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_wither_skeleton", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/wither_skeleton")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.DEVIL_HORN.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.25f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_wither", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/wither")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.DEVIL_HORN.get()),
                        new ItemEntry(ModItems.ESSENCE.get())
                ),
                6, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_enderman", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/enderman")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.DEVIL_HORN.get()),
                        new ItemEntry(ModItems.ELF_EAR.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.5f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_ender_dragon", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/ender_dragon")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.DEVIL_HORN.get()),
                        new ItemEntry(ModItems.ESSENCE.get())
                ),
                8, // Máximo de Itens que podem Aparecer
                0.7f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_zombie_villager", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/zombie_villager")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_villager", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/villager")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.25f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_pillager", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/pillager")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.25f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_evoker", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/evoker")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.35f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_vindicator", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/vindicator")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.45f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_witch", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/witch")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.DEVIL_HORN.get())
                ),
                3, // Máximo de Itens que podem Aparecer
                0.65f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_ravager", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/ravager")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.HUMAN_TOOTH.get()),
                        new ItemEntry(ModItems.ELF_EAR.get()),
                        new ItemEntry(ModItems.DEVIL_HORN.get())
                ),
                4, // Máximo de Itens que podem Aparecer
                0.5f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_warden", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/warden")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.ESSENCE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get())
                ),
                7, // Máximo de Itens que podem Aparecer
                0.55f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_frog", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/frog")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.FROG.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.05f // Chance dos Itens Aparecerem
        ));
        add("items_from_the_wandering_trader", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("entities/wandering_trader")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                Arrays.asList(
                        new ItemEntry(ModItems.GOBLIN_EYE.get()),
                        new ItemEntry(ModItems.HUMAN_TOOTH.get())
                ),
                2, // Máximo de Itens que podem Aparecer
                0.15f // Chance dos Itens Aparecerem
        ));

        //GAMEPLAY
        add("items_from_the_sniffer_digging", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModBlocks.BROMELIAD.get().asItem())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.35f // Chance dos Itens Aparecerem
        ));

        add("tilapia_from_fishing", new AddItemsModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(new ResourceLocation("gameplay/fishing/fish")).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build()
                },
                List.of(
                        new ItemEntry(ModItems.TILAPIA.get())
                ),
                1, // Máximo de Itens que podem Aparecer
                0.35f // Chance dos Itens Aparecerem
        ));
    }

}

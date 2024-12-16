package net.jubs.eclipse_do_caos.sound;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EclipseDoCaos.MOD_ID);

    public static final RegistryObject<SoundEvent> RADIO_SOUNDS = registerSoundEvents("radio_sounds");
    public static final RegistryObject<SoundEvent> SAMARA_SOUNDS = registerSoundEvents("samara_sounds");

    public static final RegistryObject<SoundEvent> DELS_FOUND_ESSENCE = registerSoundEvents("dels_found_essence");
    public static final RegistryObject<SoundEvent> FROG_USE = registerSoundEvents("frog_use");
    public static final RegistryObject<SoundEvent> GUST = registerSoundEvents("gust");
    public static final RegistryObject<SoundEvent> FIREBALL = registerSoundEvents("fireball");
    public static final RegistryObject<SoundEvent> INVISIBLE = registerSoundEvents("invisible");
    public static final RegistryObject<SoundEvent> DEFENSE = registerSoundEvents("defense");
    public static final RegistryObject<SoundEvent> POISON_BOLT = registerSoundEvents("poison_bolt");
    public static final RegistryObject<SoundEvent> LIGHTNING_STRIKE = registerSoundEvents("lightning_strike");
    public static final RegistryObject<SoundEvent> BEANS = registerSoundEvents("beans");
    public static final RegistryObject<SoundEvent> RAGE = registerSoundEvents("rage");
    public static final RegistryObject<SoundEvent> ARTORIAS_HIT = registerSoundEvents("artorias_hit");
    public static final RegistryObject<SoundEvent> CLAWS_HIT = registerSoundEvents("claws_hit");
    public static final RegistryObject<SoundEvent> QUARTERSTAFF_HIT = registerSoundEvents("quarterstaff_hit");
    public static final RegistryObject<SoundEvent> HELENA_HIT = registerSoundEvents("helena_hit");
    public static final RegistryObject<SoundEvent> SCARLET_RAMPAGE = registerSoundEvents("scarlet_rampage");
    public static final RegistryObject<SoundEvent> HILDA_HIT = registerSoundEvents("hilda_hit");
    public static final RegistryObject<SoundEvent> EPICARP = registerSoundEvents("epicarp");
    public static final RegistryObject<SoundEvent> DIEGO_HIT = registerSoundEvents("diego_hit");
    public static final RegistryObject<SoundEvent> ADELANTE = registerSoundEvents("adelante");
    public static final RegistryObject<SoundEvent> AKIRA_HIT = registerSoundEvents("akira_hit");
    public static final RegistryObject<SoundEvent> TORMENT = registerSoundEvents("torment");
    public static final RegistryObject<SoundEvent> ODIN_DAGGER_HIT = registerSoundEvents("odin_dagger_hit");
    public static final RegistryObject<SoundEvent> ODIN_VISION = registerSoundEvents("odion_vision");
    public static final RegistryObject<SoundEvent> SAI_HIT = registerSoundEvents("sai_hit");
    public static final RegistryObject<SoundEvent> MISHAP = registerSoundEvents("mishap");
    public static final RegistryObject<SoundEvent> FLOW = registerSoundEvents("flow");
    public static final RegistryObject<SoundEvent> VINE_TRAP = registerSoundEvents("vine_trap");
    public static final RegistryObject<SoundEvent> POSSESSED_CHAOS = registerSoundEvents("possessed_chaos");
    public static final RegistryObject<SoundEvent> SOUL_ALTERATION = registerSoundEvents("soul_alteration");
    public static final RegistryObject<SoundEvent> CANNONBALL_BLAST = registerSoundEvents("cannonball_blast");
    public static final RegistryObject<SoundEvent> EMPTY_CANNON = registerSoundEvents("empty_cannon");
    public static final RegistryObject<SoundEvent> EMPTY_BEAN_SACK = registerSoundEvents("empty_bean_sack");
    public static final RegistryObject<SoundEvent> ZORA_BOW_FIRE = registerSoundEvents("zora_bow_fire");
    public static final RegistryObject<SoundEvent> SAW_EATER_HIT = registerSoundEvents("saw_eater_hit");
    public static final RegistryObject<SoundEvent> SAW_EATER_SLASHER = registerSoundEvents("saw_eater_slasher");
    public static final RegistryObject<SoundEvent> INFUSER_POT = registerSoundEvents("infuser_pot");
    public static final RegistryObject<SoundEvent> LADON_DRAGON_GLAIVE_HIT = registerSoundEvents("ladon_dragon_glaive_hit");
    public static final RegistryObject<SoundEvent> LEVITATE = registerSoundEvents("levitate");
    public static final RegistryObject<SoundEvent> ERAK_BATTLEAXE_HIT = registerSoundEvents("erak_battleaxe_hit");
    public static final RegistryObject<SoundEvent> TREMOR = registerSoundEvents("tremor");
    public static final RegistryObject<SoundEvent> CROSSING_SPELL = registerSoundEvents("crossing_spell");
    public static final RegistryObject<SoundEvent> GAUNTLET_HIT = registerSoundEvents("gauntlet_hit");
    public static final RegistryObject<SoundEvent> GAUNTLET_POWER = registerSoundEvents("gauntlet_power");
    public static final RegistryObject<SoundEvent> NORR_FORR_HAMMER_HIT = registerSoundEvents("norr_forr_hammer_hit");
    public static final RegistryObject<SoundEvent> ACCURSE = registerSoundEvents("accurse");
    public static final RegistryObject<SoundEvent> CHALI_II_LANCE_HIT = registerSoundEvents("chali_ii_lance_hit");
    public static final RegistryObject<SoundEvent> SPIDER_DASH = registerSoundEvents("spider_dash");


    public static final RegistryObject<SoundEvent> ECLIPSE_BEGINS = registerSoundEvents("eclipse_begins");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(EclipseDoCaos.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

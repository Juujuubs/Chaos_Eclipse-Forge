package net.jubs.eclipse_do_caos.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TILAPIA = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(() ->
                    new MobEffectInstance(MobEffects.POISON, 200), 0.15f).build();
    public static final FoodProperties FRIED_TILAPIA = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.9f).effect(() ->
                    new MobEffectInstance(MobEffects.LUCK, 300), 0.35f).build();
    public static final FoodProperties SUSHI_TILAPIA = new FoodProperties.Builder().nutrition(4)
            .saturationMod(1.5f).fast().effect(() ->
                    new MobEffectInstance(MobEffects.SATURATION, 300), 0.20f).build();

    public static final FoodProperties BEAN = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.1f).fast().effect(() ->
                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 300), 0.01f).build();
    public static final FoodProperties COOKED_BEAN = new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.6f).fast().build();

    public static final FoodProperties EDEN_TREE_APPLE = new FoodProperties.Builder().nutrition(12)
            .saturationMod(8.0f).effect(() ->
                    new MobEffectInstance(MobEffects.REGENERATION, 300, 5), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 5), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 5), 0.3f)
            .build();

    public static final FoodProperties EDEN_APPLE = new FoodProperties.Builder().nutrition(20)
            .saturationMod(12.0f).alwaysEat()
            // Efeitos Positivos
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 300, 10), 1.0f)
            // Efeitos Neutros
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 300, 10), 1.0f)
            // Efeitos Negativos
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 300, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 300, 10), 1.0f)
            .build();

    public static final FoodProperties GOBLIN_EYE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.4f).fast().effect(() ->
                    new MobEffectInstance(MobEffects.CONFUSION, 200), 0.25f).build();

    public static final FoodProperties ELF_EAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.5f).fast().effect(() ->
                    new MobEffectInstance(MobEffects.CONFUSION, 200), 0.35f).build();

}

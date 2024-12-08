package net.jubs.eclipse_do_caos.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TILAPIA = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(() ->
                    new MobEffectInstance(MobEffects.POISON, 200), 0.15f).build();

}

package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModFoods;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import java.util.Random;

public class CookedBeanItem extends Item {
    private static final Random RANDOM = new Random();

    public CookedBeanItem(Properties pProperties) {
        super(pProperties.food(ModFoods.COOKED_BEAN));
    }



    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity player) {
        super.finishUsingItem(stack, world, player);

        if (!world.isClientSide()) {
            if (RANDOM.nextFloat() < 0.10F) {
                world.explode(player, player.getX(), player.getY(0.5), player.getZ(), 4.0F, Level.ExplosionInteraction.NONE);
                player.addEffect(new MobEffectInstance(MobEffects.HARM, 60, 10));
            }
        }

        return stack;
    }

}

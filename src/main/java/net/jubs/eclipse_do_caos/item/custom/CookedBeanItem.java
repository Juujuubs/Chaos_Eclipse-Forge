package net.jubs.eclipse_do_caos.item.custom;

import net.jubs.eclipse_do_caos.item.ModFoods;
import net.minecraft.world.item.Item;

public class CookedBeanItem extends Item {
    public CookedBeanItem(Properties pProperties) {
        super(pProperties.food(ModFoods.COOKED_BEAN));
    }

}

package com.github.kabi0210.animalworldx.common.item;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import net.minecraft.item.Item;

/**
 * @author KSGFK create in 2019/10/31
 */
public class AWBaseItem extends Item {
    public AWBaseItem(String name) {
        setRegistryName(AnimalWorldX.MOD_ID, name);
        setTranslationKey(AnimalWorldX.MOD_ID + "." + name);
        setCreativeTab(AnimalWorldX.getInstance().mainTab);
    }
}

package com.github.kabi0210.animalworldx.common.init;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.item.AWBaseItem;
import com.github.ksgfk.dawnfoundation.api.annotations.Registry;
import net.minecraft.item.Item;

/**
 * @author KSGFK create in 2019/10/31
 */
@Registry(modId = AnimalWorldX.MOD_ID)
public class AWItems {
    public static final Item LegendGoldIngot = new AWBaseItem("legend_gold_ingot");
}

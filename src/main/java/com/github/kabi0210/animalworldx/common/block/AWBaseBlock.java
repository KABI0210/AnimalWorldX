package com.github.kabi0210.animalworldx.common.block;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author KSGFK create in 2019/10/31
 */
public class AWBaseBlock extends Block {
    public AWBaseBlock(String name, Material material) {
        super(material);
        setRegistryName(AnimalWorldX.MOD_ID, name);
        setTranslationKey(AnimalWorldX.MOD_ID + "." + name);
        setCreativeTab(AnimalWorldX.getInstance().mainTab);
    }
}

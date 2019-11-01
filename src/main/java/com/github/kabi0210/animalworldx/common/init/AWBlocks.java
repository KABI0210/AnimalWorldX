package com.github.kabi0210.animalworldx.common.init;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.block.AWBaseBlock;
import com.github.ksgfk.dawnfoundation.api.annotations.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author KSGFK create in 2019/10/31
 */
@Registry(modId = AnimalWorldX.MOD_ID)
public class AWBlocks {
    public static final Block NatureBlock = new AWBaseBlock("nature_block", Material.ROCK);
}

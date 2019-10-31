package com.github.kabi0210.animalworldx.common.init;

import com.github.kabi0210.animalworldx.annotations.Registry;
import com.github.kabi0210.animalworldx.common.block.AWBaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author KSGFK create in 2019/10/31
 */
@Registry
public class AWBlocks {
    public static final Block test = new AWBaseBlock("nature_block", Material.ROCK);
}

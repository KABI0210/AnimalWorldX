package com.github.kabi0210.animalworldx.common.block;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.ksgfk.dawnfoundation.api.annotations.IDomainName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

/**
 * @author KSGFK create in 2019/10/31
 */
public class AWBaseBlock extends Block implements IDomainName {
    private String name;

    public AWBaseBlock(String name, Material material) {
        super(material);
        this.name = name;
        setTranslationKey(AnimalWorldX.MOD_ID + "." + name);
        setCreativeTab(AnimalWorldX.getInstance().mainTab);
    }

    @Nonnull
    @Override
    public ResourceLocation getDomainName() {
        return new ResourceLocation(AnimalWorldX.MOD_ID, name);
    }
}

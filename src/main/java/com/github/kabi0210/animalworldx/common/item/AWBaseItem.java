package com.github.kabi0210.animalworldx.common.item;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.ksgfk.dawnfoundation.api.annotations.IDomainName;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

/**
 * @author KSGFK create in 2019/10/31
 */
public class AWBaseItem extends Item implements IDomainName {
    private String name;

    public AWBaseItem(String name) {
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

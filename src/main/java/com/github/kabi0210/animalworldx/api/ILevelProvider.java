package com.github.kabi0210.animalworldx.api;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/3
 */
public interface ILevelProvider {
    void registerLevel(@Nonnull String levelName);

    @Nullable
    String getLevel(@Nonnull ItemStack stack);

    void setLevel(@Nonnull ItemStack stack, @Nonnull String level);
}

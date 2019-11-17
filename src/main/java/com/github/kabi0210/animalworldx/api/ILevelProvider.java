package com.github.kabi0210.animalworldx.api;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/3
 */
public interface ILevelProvider {
    void registerLevel(@Nonnull String levelName, @Nullable LevelData data);

    @Nullable
    LevelData getLevelData(@Nonnull String levelName);

    @Nullable
    LevelData getLevel();

}

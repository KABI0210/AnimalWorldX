package com.github.kabi0210.animalworldx.api.event;

import com.github.kabi0210.animalworldx.api.LevelData;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001_lv2;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/15
 */
public class RegisterPetBoxLevelEvent extends RegisterLevelEvent {
    public void registerLevel(@Nonnull String levelName, @Nullable LevelData data) {
        EntityPetBox001.getLevelMap().put(levelName, (EntityPetBox001.Level) data);
    }
}

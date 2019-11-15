package com.github.kabi0210.animalworldx.api.event;

import com.github.kabi0210.animalworldx.api.LevelData;
import net.minecraftforge.fml.common.eventhandler.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/15
 */
public abstract class RegisterLevelEvent extends Event {
    public abstract void registerLevel(@Nonnull String levelName, @Nullable LevelData data);
}

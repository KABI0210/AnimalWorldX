package com.github.kabi0210.animalworldx.api.event;

import com.github.kabi0210.animalworldx.api.ILevelProvider;
import com.github.kabi0210.animalworldx.api.LevelData;
import net.minecraftforge.fml.common.eventhandler.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/3
 */
public class RegisterMagicBookLevelEvent extends RegisterLevelEvent {
    private final ILevelProvider provider;

    public RegisterMagicBookLevelEvent(ILevelProvider book) {
        provider = book;
    }

    public ILevelProvider getBook() {
        return provider;
    }

    @Override
    public void registerLevel(@Nonnull String levelName, @Nullable LevelData data) {
        provider.registerLevel(levelName, data);
    }
}

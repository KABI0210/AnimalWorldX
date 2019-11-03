package com.github.kabi0210.animalworldx.api.event;

import com.github.kabi0210.animalworldx.api.ILevelProvider;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * @author KSGFK create in 2019/11/3
 */
public class RegisterMagicBookLevelEvent extends Event {
    private final ILevelProvider provider;

    public RegisterMagicBookLevelEvent(ILevelProvider book) {
        provider = book;
    }

    public ILevelProvider getBook() {
        return provider;
    }
}

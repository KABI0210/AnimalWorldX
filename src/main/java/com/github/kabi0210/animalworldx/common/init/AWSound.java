package com.github.kabi0210.animalworldx.common.init;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.sound.AWBaseSound;
import com.github.ksgfk.dawnfoundation.api.annotations.Registry;
import net.minecraft.util.SoundEvent;

@Registry(modId = AnimalWorldX.MOD_ID)
public class AWSound {
    public static final SoundEvent BOX01_DEATH_SOUND = new AWBaseSound("entity_box01_death");
}

package com.github.kabi0210.animalworldx.common.sound;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * @author KSGFK create in 2019/11/8
 */
public class AWBaseSound extends SoundEvent {
    public AWBaseSound(String path) {
        this(new ResourceLocation(AnimalWorldX.MOD_ID, path));
    }

    public AWBaseSound(ResourceLocation soundName) {
        super(soundName);
        setRegistryName(soundName);
    }
}

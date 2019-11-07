package com.github.kabi0210.animalworldx.common;


import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventLoader {
    public static final RegistryNamespaced<ResourceLocation, SoundEvent> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(SoundEvent.class);

    private final ResourceLocation soundName;
    private static int soundEventId;

    public EventLoader(ResourceLocation soundName) {
        this.soundName = soundName;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getSoundName()
    {
        return this.soundName;
    }

    public static void registerSounds()
    {
        registerSound("entity.petbox01.death");
    }

    private static void registerSound(String soundNameIn)
    {
        ResourceLocation resourcelocation = new ResourceLocation(soundNameIn);
        REGISTRY.register(soundEventId++, resourcelocation, new SoundEvent(resourcelocation));
    }
}

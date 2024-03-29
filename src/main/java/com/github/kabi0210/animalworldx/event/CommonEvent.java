package com.github.kabi0210.animalworldx.event;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.api.event.RegisterMagicBookLevelEvent;
import com.github.kabi0210.animalworldx.api.event.RegisterPetBoxLevelEvent;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001_lv2;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author KSGFK create in 2019/11/3
 */
@Mod.EventBusSubscriber(modid = AnimalWorldX.MOD_ID)
public class CommonEvent {
    @SubscribeEvent
    public static void registerMagicBookLevel(RegisterMagicBookLevelEvent event) {
        event.registerLevel("lv1", null);
        event.registerLevel("lv2", null);
        event.registerLevel("lv3", null);
        event.registerLevel("lv4", null);
        event.registerLevel("lv5", null);
        event.registerLevel("lv6", null);
    }

    @SubscribeEvent
    public static void registerPetBoxLevel(RegisterPetBoxLevelEvent event) {
        event.registerLevel("lv1", EntityPetBox001.Level.create()
                .setAttackVolume(0.2F)
                .setWidth(0.8F)
                .setHeight(0.8F)
                .setHealth(15)
                .setSpeed(0.45D)
                .setResistance(0.3D)
                .setRange(8.0D)
                .build());
       /* event.registerLevel("lv4", EntityPetBox001_lv2.Level.create()
                .setAttackVolume(0.2F)
                .setWidth(1.1F)
                .setHeight(1.1F)
                .setHealth(35)
                .setSpeed(0.45D)
                .setResistance(0.6D)
                .setRange(32.0D)
                .build());*/
    }

}

package com.github.kabi0210.animalworldx.event;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.api.event.RegisterMagicBookLevelEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author KSGFK create in 2019/11/3
 */
@Mod.EventBusSubscriber(modid = AnimalWorldX.MOD_ID)
public class CommonEvent {
    @SubscribeEvent
    public static void registerMagicBookLevel(RegisterMagicBookLevelEvent event) {
        event.getBook().registerLevel("lv1");
        event.getBook().registerLevel("lv2");
        event.getBook().registerLevel("lv3");
        event.getBook().registerLevel("lv4");
        event.getBook().registerLevel("lv5");
        event.getBook().registerLevel("lv6");
    }
}

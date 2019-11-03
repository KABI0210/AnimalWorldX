package com.github.kabi0210.animalworldx.event;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.api.event.RegisterMagicBookLevelEvent;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KSGFK create in 2019/11/3
 */
@Mod.EventBusSubscriber(modid = AnimalWorldX.MOD_ID)
public class CommonEvent {
    private static final Map<String, String> magicBookNameColor = new HashMap<String, String>() {
        {
            put("lv1", "§7");
            put("lv2", "§a");
        }
    };

    @SubscribeEvent
    public static void registerMagicBookLevel(RegisterMagicBookLevelEvent event) {
        event.getBook().registerLevel("lv1");
        event.getBook().registerLevel("lv2");
    }

    @SubscribeEvent
    public static void showMagicBookOfPortalTips(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() != AWItems.MagicBookOfPortal) {
            return;
        }
        String lv = AWItems.MagicBookOfPortal.getLevel(event.getItemStack());
        if (lv == null) {
            return;
        }
        event.getItemStack().setStackDisplayName(magicBookNameColor.get(lv) + event.getItemStack().getDisplayName());
    }
}

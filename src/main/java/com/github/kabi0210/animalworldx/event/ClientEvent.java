package com.github.kabi0210.animalworldx.event;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KSGFK create in 2019/11/3
 */
@Mod.EventBusSubscriber(modid = AnimalWorldX.MOD_ID)
public class ClientEvent {
    @SideOnly(Side.CLIENT)
    private static final Map<String, String> magicBookNameColor = new HashMap<String, String>() {
        {
            put("lv1", "§7");
            put("lv2", "§a");
            put("lv3", "§1");
            put("lv4", "§5");
            put("lv5", "§6");
        }
    };

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void showMagicBookOfPortalTips(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() != AWItems.MagicBookOfPortal) {
            return;
        }
        String lv = AWItems.MagicBookOfPortal.getLevel(event.getItemStack());
        if (lv == null) {
            return;
        }
        if (lv.equals("lv6")) {
            String str = event.getItemStack().getDisplayName();
            int count = str.length();
            int len = count / 4;
            if (len <= 0) {
                return;
            }
            char[] ch = str.toCharArray();
            StringBuilder b = new StringBuilder();
            for (int a = 0, pos = 0, c = 0; a < 4; a++, pos += len, c++) {
                switch (c) {
                    case 0:
                        b.append("§c");
                        break;
                    case 1:
                        b.append("§e");
                        break;
                    case 2:
                        b.append("§a");
                        break;
                    case 3:
                        b.append("§1");
                        break;
                    default:
                        break;
                }
                b.append(Arrays.copyOfRange(ch, pos, pos + len));
            }
            event.getItemStack().setStackDisplayName(b.toString());
        } else {
            event.getItemStack().setStackDisplayName(magicBookNameColor.get(lv) + event.getItemStack().getDisplayName());
        }
    }
}

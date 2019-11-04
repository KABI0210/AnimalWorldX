package com.github.kabi0210.animalworldx.common.container;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.client.gui.GuiMagicBookPortal;
import com.github.ksgfk.dawnfoundation.api.annotations.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/4
 */
public class AWGuiHandler implements IGuiHandler {
    public static final int MagicBook = 0;

    @GuiHandler(modId = AnimalWorldX.MOD_ID)
    private static AWGuiHandler instance = new AWGuiHandler();

    private AWGuiHandler() {
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case MagicBook:
                return new MagicBookPortalContainer();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case MagicBook:
                return new GuiMagicBookPortal(new MagicBookPortalContainer());
            default:
                return null;
        }
    }

    public static AWGuiHandler getInstance() {
        return instance;
    }
}

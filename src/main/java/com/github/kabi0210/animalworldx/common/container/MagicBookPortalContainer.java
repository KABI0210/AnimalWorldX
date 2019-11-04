package com.github.kabi0210.animalworldx.common.container;

import com.github.kabi0210.animalworldx.common.init.AWItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.EnumHand;

import javax.annotation.Nonnull;

/**
 * @author KSGFK create in 2019/11/4
 */
public class MagicBookPortalContainer extends Container {

    @Override
    public boolean canInteractWith(@Nonnull EntityPlayer playerIn) {
        return playerIn.getHeldItemMainhand().getItem() == AWItems.MagicBookOfPortal || playerIn.getHeldItem(EnumHand.OFF_HAND).getItem() == AWItems.MagicBookOfPortal;
    }
}

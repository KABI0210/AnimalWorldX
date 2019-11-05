package com.github.kabi0210.animalworldx.client.gui;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author KSGFK create in 2019/11/4
 */
@SideOnly(Side.CLIENT)
public class GuiMagicBookPortal extends GuiContainer {
    private static final ResourceLocation Background = new ResourceLocation(AnimalWorldX.MOD_ID, "textures/gui/magic_book_portal.png");

    private final int bgSizeX = 256;
    private final int bgSizeY = 180;

    public GuiMagicBookPortal(Container inventorySlotsIn) {
        super(inventorySlotsIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        drawWorldBackground(0);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(Background);
        int offsetX = (width - bgSizeX) / 2;
        int offsetY = (height - bgSizeY) / 2;
        drawTexturedModalRect(offsetX, offsetY, 0, 0, bgSizeX, bgSizeY);
        GlStateManager.popMatrix();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }
}

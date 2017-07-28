package com.kjmaster.mb.guis;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.containers.ContainerWoodCutRune;
import com.kjmaster.mb.tileentities.TileEntityWoodCutRune;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public class GuiWoodCutRune extends GuiContainer {

    private TileEntityWoodCutRune te;
    private IInventory playerInv;
    public GuiWoodCutRune(IInventory playerInv, TileEntityWoodCutRune te) {
        super(new ContainerWoodCutRune(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;

        this.te = te;
        this.playerInv = playerInv;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = I18n.format("container.woodcutrune_block"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=Block Breaker" to the language file (without quotes) and then delete this note
        this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
        this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Ref.MODID, "textures/gui/container/woodcutrune_block.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}

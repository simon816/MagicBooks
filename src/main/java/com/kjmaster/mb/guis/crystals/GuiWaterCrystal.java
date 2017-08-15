package com.kjmaster.mb.guis.crystals;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.containers.ContainerWaterCrystal;
import com.kjmaster.mb.guis.ProgressBar;
import com.kjmaster.mb.tileentities.crystals.TileEntityWaterCrystal;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 06/08/2017.
 */
public class GuiWaterCrystal extends GuiContainer {

    private final ResourceLocation TEXTURE = new ResourceLocation(Ref.MODID, "textures/gui/container/water_crystal.png");

    private final TileEntityWaterCrystal te;
    private ProgressBar progressBar;
    private IInventory playerInv;
    private World world;
    public GuiWaterCrystal(IInventory playerInv, TileEntityWaterCrystal te, World world) {
        super(new ContainerWaterCrystal(playerInv, te));
        this.xSize = 176;
        this.ySize = 166;
        this.te = te;
        this.playerInv = playerInv;
        this.world = world;

        this.progressBar = new ProgressBar(TEXTURE, ProgressBar.ProgressBarDirection.DOWN_TO_UP, 55, 49, this.guiLeft + 60, this.guiTop + 18, 176, 18);
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = I18n.format("container.water_crystal"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=BlockEarthCrystal Breaker" to the language file (without quotes) and then delete this note
        this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
        this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
        int mana = this.te.getField(0);
        this.progressBar.setMin(mana).setMax(10000);
        this.progressBar.draw(this.mc);
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        int mana = this.te.getField(0);
        this.progressBar.setMin(mana).setMax(1000);
        this.progressBar.draw(this.mc);
    }
}

package com.kjmaster.mb.guis;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.containers.ContainerManaInfuser;
import com.kjmaster.mb.tileentities.TileEntityManaInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 18/08/2017.
 */
public class GuiManaInfuser extends GuiContainer {

    private final ResourceLocation TEXTURE = new ResourceLocation(Ref.MODID, "textures/gui/container/mana_infuser.png");

    private final TileEntityManaInfuser te;
    private ProgressBar earthProgressBar;
    private ProgressBar airProgressBar;
    private ProgressBar fireProgressBar;
    private ProgressBar waterProgressBar;
    private IInventory playerInv;
    private World world;

    public GuiManaInfuser(IInventory playerInv, TileEntityManaInfuser te, World world) {
        super(new ContainerManaInfuser(playerInv, te));
        this.xSize = 176;
        this.ySize = 166;
        this.te = te;
        this.playerInv = playerInv;
        this.world = world;

        this.earthProgressBar = new ProgressBar(TEXTURE, ProgressBar.ProgressBarDirection.DOWN_TO_UP, 9, 38, this.guiLeft + 14, this.guiTop + 24, 190, 0);
        this.airProgressBar = new ProgressBar(TEXTURE, ProgressBar.ProgressBarDirection.DOWN_TO_UP, 9, 38, this.guiLeft + 29, this.guiTop + 24, 176, 0);
        this.fireProgressBar = new ProgressBar(TEXTURE, ProgressBar.ProgressBarDirection.DOWN_TO_UP, 9, 38, this.guiLeft + 44, this.guiTop + 24, 218, 0);
        this.waterProgressBar = new ProgressBar(TEXTURE, ProgressBar.ProgressBarDirection.DOWN_TO_UP, 9, 38, this.guiLeft + 59, this.guiTop + 24, 204, 0);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = I18n.format("container.mana_infuser"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=BlockEarthCrystal Breaker" to the language file (without quotes) and then delete this note
        this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
        this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name

        int earthMana = this.te.getField(0);
        this.earthProgressBar.setMin(earthMana).setMax(10000);
        this.earthProgressBar.draw(this.mc);

        int airMana = this.te.getField(1);
        this.airProgressBar.setMin(airMana).setMax(10000);
        this.airProgressBar.draw(this.mc);

        int fireMana = this.te.getField(2);
        this.fireProgressBar.setMin(fireMana).setMax(10000);
        this.fireProgressBar.draw(this.mc);

        int waterMana = this.te.getField(3);
        this.waterProgressBar.setMin(waterMana).setMax(10000);
        this.waterProgressBar.draw(this.mc);

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

        int earthMana = this.te.getField(0);
        this.earthProgressBar.setMin(earthMana).setMax(10000);
        this.earthProgressBar.draw(this.mc);

        int airMana = this.te.getField(1);
        this.airProgressBar.setMin(airMana).setMax(10000);
        this.airProgressBar.draw(this.mc);

        int fireMana = this.te.getField(2);
        this.fireProgressBar.setMin(fireMana).setMax(10000);
        this.fireProgressBar.draw(this.mc);

        int waterMana = this.te.getField(3);
        this.waterProgressBar.setMin(waterMana).setMax(10000);
        this.waterProgressBar.draw(this.mc);
    }
}

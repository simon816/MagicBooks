package com.kjmaster.mb.guis.spellunlock;

import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

import java.io.IOException;

/**
 * Created by pbill_000 on 18/06/2017.
 */
public class GuiWaterSpells extends GuiScreen {
    public GuiButton a = new GuiButton(0, 145, 10, 190, 20, TextFormatting.BLUE + "Unlock water wolf spell (16 points)");
    public GuiButton b = new GuiButton(1, 145, 210, 190, 20,  TextFormatting.BLUE + "Close");
    public static float waterpoints;
    @Override
    public void setGuiSize(int w, int h) {

        super.setGuiSize(256, 256);
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(18));
        this.drawString(mc.fontRenderer,"You currently have " + waterpoints, 5, 10, 255);
        this.drawString(mc.fontRenderer, "water skill points", 5, 19, 255);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
    @Override
    public void initGui() {
        this.buttonList.add(a);
        this.buttonList.add(b);
    }
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == a) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(9));


        }

        if (button == b) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
    }
}

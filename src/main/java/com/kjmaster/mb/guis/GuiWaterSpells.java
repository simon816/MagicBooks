package com.kjmaster.mb.guis;

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
    public static int width = 256;
    public static int height = 256;
    public static GuiButton a = new GuiButton(0, 150, 10, 175, 20, TextFormatting.BLUE + "Unlock water wolf spell (16 points)");
    public static  GuiButton b = new GuiButton(1, 150, 210, 175, 20,  TextFormatting.BLUE + "Close");

    @Override
    public void setGuiSize(int w, int h) {
        super.setGuiSize(w, h);
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
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

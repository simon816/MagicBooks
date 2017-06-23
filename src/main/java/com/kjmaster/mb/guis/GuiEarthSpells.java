package com.kjmaster.mb.guis;

import com.kjmaster.mb.network.PointsPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.util.text.TextFormatting;

/**
 * Created by pbill_000 on 07/06/2017.
 */

public class GuiEarthSpells extends GuiScreen {
    public static int width = 256;
    public static int height = 256;
    public static  GuiButton a = new GuiButton(0, 150, 10, 175, 20, TextFormatting.GREEN + "Unlock bonemeal spell (4 points)");
    public static  GuiButton b = new GuiButton(1, 175, 235, 100, 20,  TextFormatting.GREEN + "Close");
    public static  GuiButton c = new GuiButton(2, 50, 235, 100, 20,  TextFormatting.WHITE + "Open air spells");
    public static GuiButton d = new GuiButton(3, 150, 50, 175, 20, TextFormatting.GREEN + "Unlock walling rune spell (16 points)");
    public static GuiButton e = new GuiButton(4, 150, 90, 175, 20, TextFormatting.GREEN + "Unlock clear wall spell (1 point)");


    @Override
    public void setGuiSize(int w, int h) {

        super.setGuiSize(width, height);
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
        this.buttonList.add(c);
        this.buttonList.add(d);
        this.buttonList.add(e);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == a) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(1));



        }

        if (button == b) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
        if (button == c) {
            this.mc.displayGuiScreen(new GuiAirSpells());
        }
        if(button == d) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(11));
        }
        if(button == e) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(13));
        }

    }
}


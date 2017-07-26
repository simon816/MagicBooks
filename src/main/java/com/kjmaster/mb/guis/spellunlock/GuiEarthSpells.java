package com.kjmaster.mb.guis.spellunlock;

import com.kjmaster.mb.guis.spellunlock.GuiAirSpells;
import com.kjmaster.mb.network.PointsPacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.util.text.TextFormatting;

/**
 * Created by pbill_000 on 07/06/2017.
 */

public class GuiEarthSpells extends GuiScreen {
    public GuiButton a = new GuiButton(0, 145, 10, 190, 20, TextFormatting.GREEN + "Unlock Bonemeal spell (4 points)");
    public static  GuiButton b = new GuiButton(1, 145, 210, 190, 20,  TextFormatting.GREEN + "Close");
    public static  GuiButton c = new GuiButton(2, 50, 235, 100, 20,  TextFormatting.WHITE + "Open air spells");
    public GuiButton e = new GuiButton(4, 145, 50, 190, 20, TextFormatting.GREEN + "Unlock clear wall spell (1 point)");
    public static float earthpoints;

    @Override
    public void setGuiSize(int w, int h) {

        super.setGuiSize(256, 256);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(16));
        this.drawString(mc.fontRenderer,"You currently have " + earthpoints, 5, 10, 65280);
        this.drawString(mc.fontRenderer, "earth skill points", 5, 19, 65280);
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
        if(button == e) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(13));
        }

    }
}


package com.kjmaster.mb.guis;

import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import java.io.IOException;

/**
 * Created by pbill_000 on 09/06/2017.
 */
public class GuiAirSpells extends GuiScreen {
    public GuiButton a = new GuiButton(0, 145, 10, 190, 20, TextFormatting.WHITE + "Unlock invisibility spell (8 points)");
    public GuiButton b = new GuiButton(1, 145, 210, 190, 20,  TextFormatting.WHITE + "Close");
    public GuiButton c = new GuiButton(2, 145, 50, 190, 20, TextFormatting.WHITE + "Unlock lightning spell (16 points");
    public static  GuiButton d = new GuiButton(3, 50, 235, 100, 20,  TextFormatting.RED + "Open fire spells");
    public static float airpoints = 0;
    @Override
    public void setGuiSize(int w, int h) {

        super.setGuiSize(256, 256);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(15));
        this.drawString(mc.fontRenderer,"You currently have " + airpoints, 5, 10, 16777215);
        this.drawString(mc.fontRenderer, "air skill points", 5, 19, 16777215);
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
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == a) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(3));



        }

        if (button == b) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
        if (button == c) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(5));
        }
        if(button == d) {
            this.mc.displayGuiScreen(new GuiFireSpells());
        }

    }
}

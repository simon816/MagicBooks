package com.kjmaster.mb.guis.magicbook;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import java.io.IOException;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class GuiMagicBook2 extends GuiScreen {
    public GuiButton a = new GuiButton(0, 145, 10, 190, 20, TextFormatting.LIGHT_PURPLE + "Set spell 2 as Bonemeal");
    public static  GuiButton b = new GuiButton(1, 145, 235, 190, 10,  TextFormatting.LIGHT_PURPLE + "Close");
    public GuiButton c = new GuiButton(2, 145, 50, 190, 20, TextFormatting.LIGHT_PURPLE + "Set spell 2 as clear wall spell");
    public GuiButton d = new GuiButton(3, 145, 90, 190, 20, TextFormatting.LIGHT_PURPLE + "Set spell 2 as invisibility spell ");
    public GuiButton e = new GuiButton(4, 145, 130, 190, 20, TextFormatting.LIGHT_PURPLE + "Set spell 2 as lightning spell ");
    public GuiButton f = new GuiButton(5, 145, 170, 190, 20, TextFormatting.LIGHT_PURPLE + "Set spell 2 as fireblast spell ");
    public GuiButton g = new GuiButton(6, 145, 210, 190, 20, TextFormatting.LIGHT_PURPLE + "Set spell 2 as spawn waterwolf spell ");
    public GuiButton h = new GuiButton(7, 20, 235, 100, 10, TextFormatting.LIGHT_PURPLE + "Open spell 3");
    @Override
    public void setGuiSize(int w, int h) {
        super.setGuiSize(256, 256);
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
        this.buttonList.add(f);
        this.buttonList.add(g);
        this.buttonList.add(h);
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button == a) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(26));
        }
        if(button == b) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
        if(button == c) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(27));
        }
        if(button == d) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(28));
        }
        if(button == e) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(29));
        }
        if(button == f) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(30));
        }
        if(button == g) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(31));
        }
        if(button == h) {
            this.mc.displayGuiScreen(new GuiMagicBook3());
        }
    }
}

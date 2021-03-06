package com.kjmaster.mb.guis.spellunlock;

import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

/**
 * Created by pbill_000 on 12/06/2017.
 */
@SideOnly(Side.CLIENT)
public class GuiFireSpells extends GuiScreen {
    public GuiButton a = new GuiButton(0, 145, 10, 190, 20, TextFormatting.RED + "Unlock fire blast spell (16 points)");
    public GuiButton b = new GuiButton(1, 145, 210, 190, 20,  TextFormatting.RED + "Close");
    public static  GuiButton c = new GuiButton(2, 50, 235, 100, 20,  TextFormatting.BLUE + "Open water spells");
    @Override
    public void setGuiSize(int w, int h) {

        super.setGuiSize(256, 256);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        EntityPlayer player = Minecraft.getMinecraft().player;
        mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(72));
        IFireSkillPoints fireCap = player.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
        float firepoints = fireCap.getFireSkillPoints();
        this.drawString(mc.fontRenderer,"You currently have " + firepoints, 5, 10, 16711680);
        this.drawString(mc.fontRenderer, "fire skill points", 5, 19, 16711680);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {
        this.buttonList.add(a);
        this.buttonList.add(b);
        this.buttonList.add(c);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == a) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(7));



        }

        if (button == b) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
        if (button == c) {
            this.mc.displayGuiScreen(new GuiWaterSpells());
        }
    }
}

package com.kjmaster.mb.client;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.guis.spellunlock.GuiEarthSpells;
import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;

/**
 * Created by pbill_000 on 07/06/2017.
 */
@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Ref.MODID)
public class KeyHandler {
    private static final String SECTION_NAME = Ref.NAME;
    private static final KeyBinding SPELLGUI_KEY = new KeyBinding("SpellGui", Keyboard.KEY_M, SECTION_NAME);
    private static final KeyBinding CHANGEBOOK_KEY = new KeyBinding("Change Spell", Keyboard.KEY_U, SECTION_NAME);
    static {
        ClientRegistry.registerKeyBinding(SPELLGUI_KEY);
        ClientRegistry.registerKeyBinding(CHANGEBOOK_KEY);
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(receiveCanceled = false)
    public static void onKeyboard(@Nonnull InputEvent.KeyInputEvent event) {
        if(SPELLGUI_KEY.isPressed() && Minecraft.getMinecraft().currentScreen == null) {
            final GuiEarthSpells gui = new GuiEarthSpells();
            Minecraft.getMinecraft().displayGuiScreen(gui);
        }
        if(CHANGEBOOK_KEY.isPressed()) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(19));
        }
    }
}

package com.kjmaster.mb.client;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.guis.GuiEarthSpells;
import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;

/**
 * Created by pbill_000 on 07/06/2017.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Ref.MODID)
public class KeyHandler {
    private static final String SECTION_NAME = Ref.NAME;
    private static final KeyBinding SPELLGUI_KEY = new KeyBinding("SpellGui", Keyboard.KEY_M, SECTION_NAME);
    private static final KeyBinding BONEMEAL_KEY = new KeyBinding("Bonemeal Spell", Keyboard.KEY_B, SECTION_NAME);
    private static final KeyBinding INVIS_KEY = new KeyBinding("Invisiblity Spell", Keyboard.KEY_I, SECTION_NAME);
    private static final KeyBinding LIGHTNING_KEY = new KeyBinding("Lightning Spell", Keyboard.KEY_L, SECTION_NAME);
    private static final KeyBinding FIREBLAST_KEY = new KeyBinding("Fire Blast Spell", Keyboard.KEY_F, SECTION_NAME);
    static {
        ClientRegistry.registerKeyBinding(SPELLGUI_KEY);
        ClientRegistry.registerKeyBinding(BONEMEAL_KEY);
        ClientRegistry.registerKeyBinding(INVIS_KEY);
        ClientRegistry.registerKeyBinding(LIGHTNING_KEY);
        ClientRegistry.registerKeyBinding(FIREBLAST_KEY);
    }

    @SubscribeEvent(receiveCanceled = false)
    public static void onKeyboard(@Nonnull InputEvent.KeyInputEvent event) {
        if(SPELLGUI_KEY.isPressed() && Minecraft.getMinecraft().currentScreen == null) {
            final GuiEarthSpells gui = new GuiEarthSpells();
            Minecraft.getMinecraft().displayGuiScreen(gui);
        }

        if(BONEMEAL_KEY.isPressed()){
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(2));
        }
        if(INVIS_KEY.isPressed()) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(4));
        }
        if(LIGHTNING_KEY.isPressed()) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(6));
        }
        if(FIREBLAST_KEY.isPressed()) {
            mbPacketHandler.INSTANCE.sendToServer(new PointsPacket(8));
        }
    }
}

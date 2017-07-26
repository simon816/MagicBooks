package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.spellmanager.air.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class Invisibility {
    public static void castInvisibility(World world, EntityPlayer player) {
        if(ConfigHandler.isInvisibilityEnabled) {
            if (!(player.world.isRemote)) {
                IInvisibilityManager INVIS_UNLOCKED = player.getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
                float Invis = INVIS_UNLOCKED.getInvisibility();
                if (Invis == 1) {
                    if (player.isInvisible()) {
                        player.setInvisible(false);
                    } else {
                        player.setInvisible(true);
                    }

                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has not been unlocked!"));
                }
            }
        } else {
            player.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has been disabled!"));
        }
    }
}

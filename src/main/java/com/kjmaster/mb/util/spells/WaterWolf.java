package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManagerProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import static com.kjmaster.mb.client.ConfigHandler.maxWaterWolves;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class WaterWolf {
    public static void castWaterWolf(World world, EntityPlayer player) {
        if(ConfigHandler.isWaterWolfEnabled) {
            if (!(player.world.isRemote)) {
                IWaterWolfManager WATERWOLF_UNLOCKED1 = player.getCapability(WaterWolfManagerProvider.WATERWOLF_MANAGER_CAP, null);
                float WaterWolf = WATERWOLF_UNLOCKED1.getWaterWolf();
                if (WaterWolf < (maxWaterWolves + 1) && WaterWolf >= 1) {
                    com.kjmaster.mb.entities.WaterWolf waterWolf = new com.kjmaster.mb.entities.WaterWolf(world, player);
                    waterWolf.setLocationAndAngles(player.posX, player.posY, player.posZ, 0F, 0F);
                    world.spawnEntity(waterWolf);
                    WATERWOLF_UNLOCKED1.addWaterWolf(1);

                } else if (WaterWolf > 0) {
                    player.sendMessage(new TextComponentString(TextFormatting.BLUE + "You can only spawn 10 water wolves per world, make sure you breed them for more!"));
                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.BLUE + "This spell has not been unlocked!"));
                }
            }
        } else {
            player.sendMessage(new TextComponentString(TextFormatting.BLUE + "This spell has been disabled!"));
        }
    }
}

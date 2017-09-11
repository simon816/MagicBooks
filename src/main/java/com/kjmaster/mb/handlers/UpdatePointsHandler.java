package com.kjmaster.mb.handlers;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.network.UpdatePointsPacket;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import com.kjmaster.mb.skillpoints.water.IWaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by pbill_000 on 07/09/2017.
 */
public class UpdatePointsHandler implements IMessageHandler<UpdatePointsPacket, IMessage> {

    @Override
    public IMessage onMessage(UpdatePointsPacket message, MessageContext ctx) {
        MagicBooks.proxy.getThreadFromContext(ctx).addScheduledTask(new Runnable() {
            @Override
            public void run() {
                processMessage(message, ctx);
            }
        });
        return null;
    }

    private void processMessage(UpdatePointsPacket message, MessageContext ctx) {
        String type = message.type;
        float points = message.points;
        EntityPlayer player = MagicBooks.proxy.getPlayerEntity(ctx);
        switch (type) {
            case "Earth":
                IEarthSkillPoints earthCap = player.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
                earthCap.setEarth(points);
                break;
            case "Air":
                IAirSkillPoints airCap = player.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
                airCap.setAir(points);
                break;
            case "Fire":
                IFireSkillPoints fireCap = player.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
                fireCap.setFire(points);
                break;
            case "Water":
                IWaterSkillPoints waterCap = player.getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
                waterCap.setWater(points);
                break;
            default:
                break;
        }
    }
}


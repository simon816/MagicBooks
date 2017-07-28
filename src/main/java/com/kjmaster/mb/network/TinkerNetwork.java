package com.kjmaster.mb.network;

import com.kjmaster.mb.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public class TinkerNetwork extends SimpleNetworkWrapper {
    public static TinkerNetwork instance = new TinkerNetwork();
    public TinkerNetwork() {
        super(Ref.MODID);
    }

    public static void sendPacket(Entity player, Packet<?> packet) {
        if(player instanceof EntityPlayerMP && ((EntityPlayerMP) player).connection != null) {
            ((EntityPlayerMP) player).connection.sendPacket(packet);
        }
    }
}

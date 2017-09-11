package com.kjmaster.mb.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
 * Created by pbill_000 on 07/09/2017.
 */
public class UpdatePointsPacket implements IMessage {

    public String type;
    public float points;

    public UpdatePointsPacket() {}

    public UpdatePointsPacket(String type, float points ) {
        this.points = points;
        this.type = type;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        type = ByteBufUtils.readUTF8String(buf);
        points = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, type);
        buf.writeFloat(points);
    }
}

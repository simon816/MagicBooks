package com.kjmaster.mb.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class PointsPacket implements IMessage {
    public PointsPacket(){}
    public float toSend;
    public PointsPacket(float toSend) {
        this.toSend = toSend;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        toSend = buf.readFloat();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(toSend);

    }
}

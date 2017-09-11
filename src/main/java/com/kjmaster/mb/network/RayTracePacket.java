package com.kjmaster.mb.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
 * Created by pbill_000 on 10/09/2017.
 */
public class RayTracePacket implements IMessage {

    public int x;
    public int y;
    public int z;
    public String spell;
    public ItemStack itemStack;

    public RayTracePacket() {}

    public RayTracePacket(int x, int y, int z, String spell, ItemStack itemStack) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.spell = spell;
        this.itemStack = itemStack;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        spell = ByteBufUtils.readUTF8String(buf);
        itemStack = ByteBufUtils.readItemStack(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        ByteBufUtils.writeUTF8String(buf, spell);
        ByteBufUtils.writeItemStack(buf, itemStack);
    }
}

package com.kjmaster.mb.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
 * Created by pbill_000 on 10/09/2017.
 */
public class UpdateChosenSpellsPacket implements IMessage {

    public String chosenspell;
    public String chosenspell2;
    public String chosenspell3;
    public String chosenspell4;
    public String chosenspell5;
    public String chosenspell6;
    public String chosenspell7;
    public String chosenspell8;

    public UpdateChosenSpellsPacket() {}

    public UpdateChosenSpellsPacket(String chosenspell, String chosenspell2, String chosenspell3,
                              String chosenspell4, String chosenspell5, String chosenspell6,
                              String chosenspell7, String chosenspell8) {
        this.chosenspell = chosenspell;
        this.chosenspell2 = chosenspell2;
        this.chosenspell3 = chosenspell3;
        this.chosenspell4 = chosenspell4;
        this.chosenspell5 = chosenspell5;
        this.chosenspell6 = chosenspell6;
        this.chosenspell7 = chosenspell7;
        this.chosenspell8 = chosenspell8;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        chosenspell = ByteBufUtils.readUTF8String(buf);
        chosenspell2 = ByteBufUtils.readUTF8String(buf);
        chosenspell3 = ByteBufUtils.readUTF8String(buf);
        chosenspell4 = ByteBufUtils.readUTF8String(buf);
        chosenspell5 = ByteBufUtils.readUTF8String(buf);
        chosenspell6 = ByteBufUtils.readUTF8String(buf);
        chosenspell7 = ByteBufUtils.readUTF8String(buf);
        chosenspell8 = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, chosenspell);
        ByteBufUtils.writeUTF8String(buf, chosenspell2);
        ByteBufUtils.writeUTF8String(buf, chosenspell3);
        ByteBufUtils.writeUTF8String(buf, chosenspell4);
        ByteBufUtils.writeUTF8String(buf, chosenspell5);
        ByteBufUtils.writeUTF8String(buf, chosenspell6);
        ByteBufUtils.writeUTF8String(buf, chosenspell7);
        ByteBufUtils.writeUTF8String(buf, chosenspell8);
    }
}

package com.kjmaster.mb.handlers;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpellProvider;
import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2Provider;
import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3Provider;
import com.kjmaster.mb.chosenspells.chosenspell3.IChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4Provider;
import com.kjmaster.mb.chosenspells.chosenspell4.IChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5Provider;
import com.kjmaster.mb.chosenspells.chosenspell5.IChosenSpell5;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6Provider;
import com.kjmaster.mb.chosenspells.chosenspell6.IChosenSpell6;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7Provider;
import com.kjmaster.mb.chosenspells.chosenspell7.IChosenSpell7;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8Provider;
import com.kjmaster.mb.chosenspells.chosenspell8.IChosenSpell8;
import com.kjmaster.mb.network.UpdateChosenSpellsPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by pbill_000 on 10/09/2017.
 */
public class UpdateChosenSpellsHandler implements IMessageHandler<UpdateChosenSpellsPacket, IMessage> {
    @Override
    public IMessage onMessage(UpdateChosenSpellsPacket message, MessageContext ctx) {
        MagicBooks.proxy.getThreadFromContext(ctx).addScheduledTask(new Runnable() {
            @Override
            public void run() {
                processMessage(message, ctx);
            }
        });
        return null;
    }

    private void processMessage(UpdateChosenSpellsPacket message, MessageContext ctx) {
        EntityPlayer player = MagicBooks.proxy.getPlayerEntity(ctx);
        String chosenspell = message.chosenspell;
        String chosenspell2 = message.chosenspell2;
        String chosenspell3 = message.chosenspell3;
        String chosenspell4 = message.chosenspell4;
        String chosenspell5 = message.chosenspell5;
        String chosenspell6 = message.chosenspell6;
        String chosenspell7 = message.chosenspell7;
        String chosenspell8 = message.chosenspell8;
        IChosenSpell chosenSpellCap = player.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
        chosenSpellCap.setChosenSpell(chosenspell);
        IChosenSpell2 chosenSpellCap2 = player.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
        chosenSpellCap2.setChosenSpell2(chosenspell2);
        IChosenSpell3 chosenSpellCap3 = player.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
        chosenSpellCap3.setChosenSpell3(chosenspell3);
        IChosenSpell4 chosenSpellCap4 = player.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
        chosenSpellCap4.setChosenSpell4(chosenspell4);
        IChosenSpell5 chosenSpellCap5 = player.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
        chosenSpellCap5.setChosenSpell5(chosenspell5);
        IChosenSpell6 chosenSpellCap6 = player.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
        chosenSpellCap6.setChosenSpell6(chosenspell6);
        IChosenSpell7 chosenSpellCap7 = player.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
        chosenSpellCap7.setChosenSpell7(chosenspell7);
        IChosenSpell8 chosenSpellCap8 = player.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
        chosenSpellCap8.setChosenSpell8(chosenspell8);
    }
}

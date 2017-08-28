package com.kjmaster.mb.events;

import com.kjmaster.mb.util.LightningCooldown;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
/**
 * Created by pbill_000 on 12/06/2017.
 */
public class Tick {
    @SubscribeEvent
    public final void onTick(TickEvent.ServerTickEvent event) {
        LightningCooldown.LightningCooldown = LightningCooldown.LightningCooldown -1;
    }
}

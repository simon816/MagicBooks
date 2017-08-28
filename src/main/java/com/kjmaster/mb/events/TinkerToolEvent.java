package com.kjmaster.mb.events;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public abstract class TinkerToolEvent extends Event {


    public TinkerToolEvent() {

    }

    @Cancelable
    public static class ExtraBlockBreak extends TinkerToolEvent {

        public final EntityPlayer player;
        public final IBlockState state;

        public int width;
        public int height;
        public int depth;
        public int distance;

        public ExtraBlockBreak(EntityPlayer player, IBlockState state) {
            this.player = player;
            this.state = state;
        }

        public static ExtraBlockBreak fireEvent(EntityPlayer player, IBlockState state, int width, int height, int depth, int distance) {
            ExtraBlockBreak event = new ExtraBlockBreak(player, state);
            event.width = width;
            event.height = height;
            event.depth = depth;
            event.distance = distance;

            MinecraftForge.EVENT_BUS.post(event);
            return event;
        }
    }
}


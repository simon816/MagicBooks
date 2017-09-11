package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.network.RayTracePacket;
import com.kjmaster.mb.network.mbPacketHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


/**
 * Created by pbill_000 on 25/07/2017.
 */

public class Bonemeal {
    public static void castBonemeal(World world, EntityPlayer player, ItemStack itemStack) {
        RayTraceResult lastPosition = player.rayTrace(100, 1.0F);
        BlockPos pos = lastPosition.getBlockPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        mbPacketHandler.INSTANCE.sendToServer(new RayTracePacket(x, y, z, "Bonemeal", itemStack));
    }
}


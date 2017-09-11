package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.blocks.BlockWalling;
import com.kjmaster.mb.blocks.BlockWallingRune;
import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import com.kjmaster.mb.network.RayTracePacket;
import com.kjmaster.mb.network.mbPacketHandler;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManagerProvider;
import com.kjmaster.mb.spellmanager.earth.clearwall.IClearWallManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 25/07/2017.
 */

public class ClearWall {
    public static void castClearWall(World world, EntityPlayer player, ItemStack itemStack) {
        RayTraceResult lastPosition = player.rayTrace(100, 1.0F);
        BlockPos pos = lastPosition.getBlockPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        mbPacketHandler.INSTANCE.sendToServer(new RayTracePacket(x, y, z, "ClearWall", itemStack));
    }
}

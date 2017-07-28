package com.kjmaster.mb.util;

import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.network.TinkerNetwork;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public class ToolHelper {
    private ToolHelper() {

    }

    public static void breakExtraBlock(World world, EntityPlayer player, BlockPos pos, BlockPos refPos) {
        // prevent calling that stuff for air blocks, could lead to unexpected behaviour since it fires events
        if(world.isAirBlock(pos)) {
            return;
        }

        //if(!(player instanceof EntityPlayerMP)) {
        //return;
        //}

        // check if the block can be broken, since extra block breaks shouldn't instantly break stuff like obsidian
        // or precious ores you can't harvest while mining stone
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        IBlockState refState = world.getBlockState(refPos);
        float refStrength = ForgeHooks.blockStrength(refState, player, world, refPos);
        float strength = ForgeHooks.blockStrength(state, player, world, pos);

        // only harvestable blocks that aren't impossibly slow to harvest
        if(!ForgeHooks.canHarvestBlock(block, player, world, pos) || refStrength / strength > 10f) {
            return;
        }

        // From this point on it's clear that the player CAN break the block

        if(player.capabilities.isCreativeMode) {
            block.onBlockHarvested(world, pos, state, player);
            if(block.removedByPlayer(state, world, pos, player, false)) {
                block.onBlockDestroyedByPlayer(world, pos, state);
            }

            // send update to client
            return;
        }

        // callback to the tool the player uses. Called on both sides. This damages the tool n stuff.

        // server sided handling
        if(!world.isRemote) {
            // send the blockbreak event
            int xp = ForgeHooks.onBlockBreakEvent(world, ((EntityPlayerMP) player).interactionManager.getGameType(), (EntityPlayerMP) player, pos);
            if(xp == -1) {
                return;
            }

            // serverside we reproduce ItemInWorldManager.tryHarvestBlock

            TileEntity tileEntity = world.getTileEntity(pos);
            // ItemInWorldManager.removeBlock
            if(block.removedByPlayer(state, world, pos, player, true)) // boolean is if block can be harvested, checked above
            {
                block.onBlockDestroyedByPlayer(world, pos, state);
                block.harvestBlock(world, player, pos, state, tileEntity, new ItemStack(ModBlocks.woodCutRuneBlock));
                block.dropXpOnBlockBreak(world, pos, xp);
            }

            // always send block update to client
        }
        // client sided handling
        else {
            // clientside we do a "this clock has been clicked on long enough to be broken" call. This should not send any new packets
            // the code above, executed on the server, sends a block-updates that give us the correct state of the block we destroy.

            // following code can be found in PlayerControllerMP.onPlayerDestroyBlock
            world.playBroadcastSound(2001, pos, Block.getStateId(state));
            if(block.removedByPlayer(state, world, pos, player, true)) {
                block.onBlockDestroyedByPlayer(world, pos, state);
            }

            }

            // send an update to the server, so we get an update back
            //if(PHConstruct.extraBlockUpdates)
            NetHandlerPlayClient netHandlerPlayClient = Minecraft.getMinecraft().getConnection();
            assert netHandlerPlayClient != null;
            netHandlerPlayClient.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos, Minecraft
                    .getMinecraft().objectMouseOver.sideHit));
    }
}

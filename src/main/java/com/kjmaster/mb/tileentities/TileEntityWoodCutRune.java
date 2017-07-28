package com.kjmaster.mb.tileentities;

import com.google.common.collect.Lists;
import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.blocks.BlockWoodCutRune;
import com.kjmaster.mb.containers.ContainerWoodCutRune;
import com.kjmaster.mb.events.TinkerToolEvent;
import com.kjmaster.mb.util.ToolHelper;
import gnu.trove.set.hash.THashSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import static com.kjmaster.mb.blocks.BlockWoodCutRune.*;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public class TileEntityWoodCutRune extends TileEntity implements ITickable, ICapabilityProvider {

    private ItemStackHandler handler;
    private int cooldown;

    public TileEntityWoodCutRune() {
        this.cooldown = 0;
        handler = new ItemStackHandler(1);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.cooldown = compound.getInteger("Cooldown");
        handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("Cooldown", this.cooldown);
        compound.setTag("ItemStackHandler", handler.serializeNBT() );
        return super.writeToNBT(compound);
    }

    @Override
    public void update() {
        if(this.world != null) {
                TileEntityWoodCutRune te = (TileEntityWoodCutRune) world.getTileEntity(pos);
                IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
                ItemStack itemStack = handler.getStackInSlot(0);
                Item item = itemStack.getItem();
                 if(item instanceof ItemAxe && !this.world.isRemote) {
                     this.cooldown++;
                     this.cooldown %= 500;
                     MagicBooks.LOGGER.info(Ref.MODID + ":Rune Of Lumber Cooldown: " + this.cooldown);
                     if(cooldown == 0) {
                         BlockPos BlockPosNorth = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
                         BlockPos BlockPosSouth = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
                         BlockPos BlockPosEast = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
                         BlockPos BlockPosWest = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
                         EntityPlayer player = this.world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 100000D, false);
                         Block BlockNorth = world.getBlockState(BlockPosNorth).getBlock();
                         Block BlockSouth = world.getBlockState(BlockPosSouth).getBlock();
                         Block BlockEast = world.getBlockState(BlockPosEast).getBlock();
                         Block BlockWest = world.getBlockState(BlockPosWest).getBlock();
                         if(BlockNorth instanceof BlockLog) {
                             if(detectTree(world, BlockPosNorth)) {
                                 fellTree(BlockPosNorth, player);
                             }
                         }
                         if(BlockSouth instanceof BlockLog) {
                             if(detectTree(world, BlockPosSouth)) {
                                 fellTree(BlockPosSouth, player);
                             }
                         }
                         if(BlockEast instanceof BlockLog) {
                             if(detectTree(world, BlockPosEast)) {
                                 fellTree(BlockPosEast, player);
                             }
                         }
                         if(BlockWest instanceof BlockLog) {
                             if(detectTree(world, BlockPosWest)) {
                                 fellTree(BlockPosWest, player);
                             }
                         }
                     }
                 }
        }
    }
    public static boolean fellTree(BlockPos start, EntityPlayer player) {
        if (player.getEntityWorld().isRemote) {
            return true;
        }
        TinkerToolEvent.ExtraBlockBreak event = TinkerToolEvent.ExtraBlockBreak.fireEvent(player, player.getEntityWorld().getBlockState(start), 3, 3, 3, -1);
        int speed = Math.round((event.width * event.height * event.depth) / 27f);
        if (event.distance > 0) {
            speed = event.distance + 1;
        }

        MinecraftForge.EVENT_BUS.register(new TreeChopTask(start, player, speed));
        return true;
    }

    public static boolean detectTree(World world, BlockPos origin) {
        BlockPos pos = null;
        Stack<BlockPos> candidates = new Stack<>();
        candidates.add(origin);

        while (!candidates.isEmpty()) {
            BlockPos candidate = candidates.pop();
            if ((pos == null || candidate.getY() > pos.getY()) && isLog(world, candidate)) {
                pos = candidate.up();
                // go up
                while (isLog(world, pos)) {
                    pos = pos.up();
                }
                // check if we still have a way diagonally up
                candidates.add(pos.north());
                candidates.add(pos.east());
                candidates.add(pos.south());
                candidates.add(pos.west());
            }
        }

        // not even one match, so there were no logs.
        if (pos == null) {
            return false;
        }

        // check if there were enough leaves around the last position
        // pos now contains the block above the topmost log
        // we want at least 5 leaves in the surrounding 26 blocks
        int d = 3;
        int o = -1; // -(d-1)/2
        int leaves = 0;
        for (int x = 0; x < d; x++) {
            for (int y = 0; y < d; y++) {
                for (int z = 0; z < d; z++) {
                    BlockPos leaf = pos.add(o + x, o + y, o + z);
                    IBlockState state = world.getBlockState(leaf);
                    if (state.getBlock().isLeaves(state, world, leaf)) {
                        if (++leaves >= 5) {
                            return true;
                        }
                    }
                }
            }
        }

        // not enough leaves. sorreh
        return false;
    }

    private static boolean isLog(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().isWood(world, pos);
    }

    public static class TreeChopTask {

        public final World world;
        public final EntityPlayer player;
        public final int blocksPerTick;

        public Queue<BlockPos> blocks = Lists.newLinkedList();
        public Set<BlockPos> visited = new THashSet<>();

        public TreeChopTask(BlockPos start, EntityPlayer player, int blocksPerTick) {
            this.world = player.getEntityWorld();
            this.player = player;
            this.blocksPerTick = blocksPerTick;

            this.blocks.add(start);
        }

        @SubscribeEvent
        public void chopChop(TickEvent.WorldTickEvent event) {
            if (event.side.isClient()) {
                finish();
                return;
            }
            // only if same dimension
            if (event.world.provider.getDimension() != world.provider.getDimension()) {
                return;
            }

            // setup
            int left = blocksPerTick;

            // continue running
            BlockPos pos;
            while (left > 0) {
                // completely done or can't do our job anymore?!
                if (blocks.isEmpty()) {
                    finish();
                    return;
                }

                pos = blocks.remove();
                if (!visited.add(pos)) {
                    continue;
                }

                // can we harvest the block and is effective?
                if (!isLog(world, pos)) {
                    continue;
                }

                // save its neighbours
                for (EnumFacing facing : new EnumFacing[]{EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST}) {
                    BlockPos pos2 = pos.offset(facing);
                    if (!visited.contains(pos2)) {
                        blocks.add(pos2);
                    }
                }

                // also add the layer above.. stupid acacia trees
                for (int x = 0; x < 3; x++) {
                    for (int z = 0; z < 3; z++) {
                        BlockPos pos2 = pos.add(-1 + x, 1, -1 + z);
                        if (!visited.contains(pos2)) {
                            blocks.add(pos2);
                        }
                    }
                }

                // break it, wooo!
                ToolHelper.breakExtraBlock(world, player, pos, pos);
                left--;
            }
        }

        private void finish() {
            // goodbye cruel world
            MinecraftForge.EVENT_BUS.unregister(this);
        }
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        int metadata = getBlockMetadata();
        return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound getTileData() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) handler;
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return true;
        return super.hasCapability(capability, facing);
    }
}

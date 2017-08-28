package com.kjmaster.mb.tileentities;

import com.google.common.collect.Lists;
import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.events.TinkerToolEvent;
import com.kjmaster.mb.mana.ManaStorage;
import com.kjmaster.mb.util.InventoryUtils;
import com.mojang.authlib.GameProfile;
import gnu.trove.set.hash.THashSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
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
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public class TileEntityWoodCutRune extends TileEntity implements ITickable, ICapabilityProvider {
    public static int MANA_USE = 400;
    private ItemStackHandler handler;
    public static int cooldown;
    private static int blocksbroken = 0;
    public final ManaStorage storage = new ManaStorage(10000, 10000, 10000);

    public TileEntityWoodCutRune() {
        this.cooldown = 0;
        handler = new ItemStackHandler(1);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.cooldown = compound.getInteger("Cooldown");
        handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
        this.storage.readFromNBT(compound);
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("Cooldown", this.cooldown);
        compound.setTag("ItemStackHandler", handler.serializeNBT() );
        this.storage.writeToNBT(compound);
        return super.writeToNBT(compound);
    }

    @Override
    public void update() {
        if (this.world != null) {
            EntityPlayer player = new EntityPlayer(world, new GameProfile(null, "RuneOfLumber")) {
                @Override
                public boolean isSpectator() {
                    return true;
                }

                @Override
                public boolean isCreative() {
                    return false;
                }
            };
            TileEntityWoodCutRune te = (TileEntityWoodCutRune) world.getTileEntity(pos);
            IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            ItemStack itemStack = handler.getStackInSlot(0);
            Item item = itemStack.getItem();
            if (item.getDamage(itemStack) >= item.getMaxDamage(itemStack) && item instanceof ItemAxe) {
                itemStack.shrink(1);
            }
            if (item instanceof ItemAxe && !this.world.isRemote) {
                te.cooldown++;
                te.cooldown %= 150;
                if (te.cooldown == 0) {
                    coolDownDone(pos, world, te, player, handler);
                }
            }
            te.setField(0, this.storage.getManaStored());
        }
    }

    public static void coolDownDone(BlockPos pos, World world, TileEntityWoodCutRune te, EntityPlayer player, IItemHandler handler) {
        BlockPos BlockPosNorth = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        BlockPos BlockPosSouth = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
        BlockPos BlockPosEast = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        BlockPos BlockPosWest = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        Block BlockNorth = world.getBlockState(BlockPosNorth).getBlock();
        Block BlockSouth = world.getBlockState(BlockPosSouth).getBlock();
        Block BlockEast = world.getBlockState(BlockPosEast).getBlock();
        Block BlockWest = world.getBlockState(BlockPosWest).getBlock();
        if(BlockNorth instanceof BlockLog && te.storage.getManaStored() >= MANA_USE) {
            if(detectTree(world, BlockPosNorth)) {
                fellTree(BlockPosNorth, player, handler, pos, te);
            }
        }
        if(BlockSouth instanceof BlockLog && te.storage.getManaStored() >= MANA_USE) {
            if(detectTree(world, BlockPosSouth)) {
                fellTree(BlockPosSouth, player, handler, pos, te);
            }
        }
        if(BlockEast instanceof BlockLog  && te.storage.getManaStored() >= MANA_USE) {
            if(detectTree(world, BlockPosEast)) {
                fellTree(BlockPosEast, player, handler, pos, te);
            }
        }
        if(BlockWest instanceof BlockLog  && te.storage.getManaStored() >= MANA_USE) {
            if(detectTree(world, BlockPosWest)) {
                fellTree(BlockPosWest, player, handler, pos, te);
            }
        }
    }


    public static boolean fellTree(BlockPos start, EntityPlayer player, IItemHandler handler1, BlockPos runePos, TileEntityWoodCutRune te) {
        if (player.getEntityWorld().isRemote) {
            return true;
        }
        TinkerToolEvent.ExtraBlockBreak event = TinkerToolEvent.ExtraBlockBreak.fireEvent(player, player.getEntityWorld().getBlockState(start), 3, 3, 3, -1);
        int speed = Math.round((event.width * event.height * event.depth) / 27f);
        if (event.distance > 0) {
            speed = event.distance + 1;
        }

        MinecraftForge.EVENT_BUS.register(new TreeChopTask(start, player, speed, handler1, runePos, te));
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

        return true;
    }

    private static boolean isLog(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().isWood(world, pos) || world.getBlockState(pos).getBlock().isLeaves(world.getBlockState(pos), world, pos);
    }

    public static class TreeChopTask {

        public final World world;
        public final EntityPlayer player;
        public final int blocksPerTick;
        public IItemHandler handler;
        public BlockPos runePos;
        public Queue<BlockPos> blocks = Lists.newLinkedList();
        public Set<BlockPos> visited = new THashSet<>();
        public TileEntityWoodCutRune te;

        public TreeChopTask(BlockPos start, EntityPlayer player, int blocksPerTick, IItemHandler handler, BlockPos runePos, TileEntityWoodCutRune te) {
            this.world = player.getEntityWorld();
            this.player = player;
            this.blocksPerTick = blocksPerTick;
            this.handler = handler;
            this.runePos = runePos;
            this.te = te;
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
                BlockPos blockPosUp = new BlockPos(runePos.getX(), runePos.getY() + 1, runePos.getZ());
                IItemHandler handlerUp = InventoryUtils.tryGetHandler(world, blockPosUp, null);
                BlockPos blockPosDown = new BlockPos(runePos.getX(), runePos.getY() - 1, runePos.getZ());
                IItemHandler handlerDown = InventoryUtils.tryGetHandler(world, blockPosDown, null);
                BlockPos blockPosNorth = new BlockPos(runePos.getX(), runePos.getY() + 1, runePos.getZ() - 1);
                IItemHandler handlerNorth = InventoryUtils.tryGetHandler(world, blockPosNorth, null);
                BlockPos blockPosSouth = new BlockPos(runePos.getX(), runePos.getY() + 1, runePos.getZ() + 1);
                IItemHandler handlerSouth = InventoryUtils.tryGetHandler(world, blockPosSouth, null);
                BlockPos blockPosEast = new BlockPos(runePos.getX() + 1, runePos.getY() + 1, runePos.getZ());
                IItemHandler handlerEast = InventoryUtils.tryGetHandler(world, blockPosEast, null);
                BlockPos blockPosWest = new BlockPos(runePos.getX() - 1, runePos.getY() + 1, runePos.getZ());
                IItemHandler handlerWest = InventoryUtils.tryGetHandler(world, blockPosWest, null);
                List <ItemStack> drops = world.getBlockState(pos).getBlock().getDrops(world, pos, world.getBlockState(pos), 0);
                for(ItemStack drop: drops) {
                    if (handlerUp != null) {
                        if (InventoryUtils.canInsertStack(handlerUp, drop)) {
                            ItemHandlerHelper.insertItemStacked(handlerUp, drop, false);
                        }
                    }
                    else if (handlerDown != null) {
                        if (InventoryUtils.canInsertStack(handlerDown, drop)) {
                            ItemHandlerHelper.insertItemStacked(handlerDown, drop, false);
                        }
                    }
                    else if (handlerNorth != null) {
                        if (InventoryUtils.canInsertStack(handlerNorth, drop)) {
                            ItemHandlerHelper.insertItemStacked(handlerNorth, drop, false);
                        }
                    }
                    else if (handlerSouth != null) {
                        if (InventoryUtils.canInsertStack(handlerSouth, drop)) {
                            ItemHandlerHelper.insertItemStacked(handlerSouth, drop, false);
                        }
                    }
                    else if (handlerEast != null) {
                        if (InventoryUtils.canInsertStack(handlerEast, drop)) {
                            ItemHandlerHelper.insertItemStacked(handlerEast, drop, false);
                        }
                    }
                    else if (handlerWest != null) {
                        if (InventoryUtils.canInsertStack(handlerWest, drop)) {
                            ItemHandlerHelper.insertItemStacked(handlerWest, drop, false);
                        }
                    }
                    else {
                        InventoryHelper.spawnItemStack(world, blockPosUp.getX(), blockPosUp.getY(), blockPosUp.getZ(), drop);
                    }
                }
                world.destroyBlock(pos, false);
                blocksbroken = blocksbroken + 1;
                left--;
            }
        }

        private void finish() {
            MinecraftForge.EVENT_BUS.unregister(this);
            int damage = handler.getStackInSlot(0).getItemDamage();
            handler.getStackInSlot(0).setItemDamage(damage + blocksbroken);
            if(!world.isRemote) {
                te.storage.extractMana(MANA_USE, false);
            }
            blocksbroken = 0;
            // goodbye cruel world
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
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) handler;
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return true;
        return super.hasCapability(capability, facing);
    }

    public void recieveMana(int mana) {
        this.storage.recieveMana(mana, false);
    }

    public void extractMana(int mana) {
        this.storage.extractMana(mana, false);
    }

    public boolean getCanReceive() {
        return this.storage.canReceive();
    }

    public int getManaStored() {
        return this.storage.getManaStored();
    }

    public int getField(int id) {
        switch (id)
        {
            case 0:
                return this.storage.getManaStored();
            default:
                return 0;
        }
    }

    public void setField(int id, int value) {
        switch (id)
        {
            case 0:
                this.storage.setMana(value);
        }
    }

    public int getFieldCount() { return 1; }

}

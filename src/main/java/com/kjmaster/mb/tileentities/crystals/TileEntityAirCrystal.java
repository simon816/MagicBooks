package com.kjmaster.mb.tileentities.crystals;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.mana.ManaStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

/**
 * Created by pbill_000 on 06/08/2017.
 */
public class TileEntityAirCrystal extends TileEntity implements ITickable, ICapabilityProvider {
    public static final int MANA_USE = 400;
    public final ManaStorage storage = new ManaStorage(10000, 10000, MANA_USE);
    private boolean hasConnection;
    private BlockPos connectedToPos;

    public TileEntityAirCrystal() {
        this.hasConnection = false;
        this.connectedToPos = new BlockPos(0, 0, 0);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.storage.readFromNBT(compound);
        setHasConnection(compound.getBoolean("HasConnection"));
        setConnectedToPos(compound.getInteger("X"), compound.getInteger("Y"), compound.getInteger("Z"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        this.storage.writeToNBT(compound);
        compound.setBoolean("HasConnection", getHasConnection());
        compound.setInteger("X", getConnectedToPos().getX());
        compound.setInteger("Y", getConnectedToPos().getY());
        compound.setInteger("Z", getConnectedToPos().getZ());
        return super.writeToNBT(compound);
    }

    @Override
    public void update() {
        if(this.world != null) {
            TileEntityAirCrystal te = (TileEntityAirCrystal) world.getTileEntity(pos);
            if(!this.world.isRemote) {
                if(getHasConnection()) {
                    if(world.getBlockState(pos).getBlock().equals(ModBlocks.greaterAirCrystalBlock)) {
                        this.storage.recieveMana(10000, false);
                    }
                    BlockPos posToSendMana = getConnectedToPos();
                    TileEntity entity = world.getTileEntity(posToSendMana);
                    if(entity instanceof TileEntityAirCrystal) {
                        MagicBooks.LOGGER.info("Test1");
                        TileEntityAirCrystal airCrystal = (TileEntityAirCrystal) entity;
                        if(airCrystal.getCanRecieve() && this.storage.canExtract() && !airCrystal.storage.isFull() && this.storage.getManaStored() >= MANA_USE) {
                            MagicBooks.LOGGER.info("Test2");
                            airCrystal.receiveMana(MANA_USE);
                            this.storage.extractMana(MANA_USE, false);
                        }
                    }
                }
                int mana = this.storage.getManaStored();
                MagicBooks.LOGGER.info("air crystal mana: " + mana);
            }
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

    public boolean getHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(Boolean connection) {
        this.hasConnection = connection;
    }

    public void setConnectedToPos(BlockPos connectedToPos) {
        this.connectedToPos = connectedToPos;
    }

    public BlockPos getConnectedToPos() {
        return connectedToPos;
    }

    public void setConnectedToPos(int X, int Y, int Z) {
        BlockPos pos = new BlockPos(X, Y, Z);
        this.setConnectedToPos(pos);
    }

    public ManaStorage getManaStorage () {
        return this.storage;
    }

    public void receiveMana(int mana) {
        this.storage.recieveMana(mana, false);
    }

    public boolean getCanRecieve() {
        return this.storage.canReceive();
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

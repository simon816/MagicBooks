package com.kjmaster.mb.tileentities.greatercrystals;

import com.kjmaster.mb.mana.ManaStorage;
import com.kjmaster.mb.tileentities.crystals.TileEntityAirCrystal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pbill_000 on 13/08/2017.
 */
public class TileEntityGreaterAirCrystal extends TileEntity implements ITickable {
    public static final int MANA_USE = 5000;
    public final ManaStorage storage = new ManaStorage(5000, 5000, 5000);
    public int connections;
    private List<BlockPos> connectedToPos;

    public TileEntityGreaterAirCrystal() {
        this.connections = 0;
        this.connectedToPos = new ArrayList<>(100);
    }

    @Override
    public void update() {
        if(this.world != null) {
            TileEntityGreaterAirCrystal te = (TileEntityGreaterAirCrystal) world.getTileEntity(pos);
            if(!this.world.isRemote) {
                if(te.getConnections() > 0) {
                    te.storage.recieveMana(500, false);
                    List<BlockPos> posToSendManaTo = te.getConnectedToPos();
                    for(int i = 0; i < posToSendManaTo.size(); i++) {
                        TileEntity entity = world.getTileEntity(posToSendManaTo.get(i));
                        if(entity instanceof TileEntityAirCrystal) {
                            TileEntityAirCrystal airCrystal = (TileEntityAirCrystal) entity;
                            if(airCrystal.getCanRecieve() && this.storage.canExtract() && !airCrystal.storage.isFull() && this.storage.getManaStored() >= (MANA_USE / posToSendManaTo.size())) {
                                airCrystal.receiveMana(MANA_USE / posToSendManaTo.size());
                                this.storage.extractMana(MANA_USE / posToSendManaTo.size(), false);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.storage.readFromNBT(compound);
        setConnections(compound.getInteger("Connections"));
        NBTTagList tagList = compound.getTagList("PosList", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            int X = tagCompound.getInteger("PosX" + i);
            int Y = tagCompound.getInteger("PosY" + i);
            int Z = tagCompound.getInteger("PosZ" + i);
            addConnectedToPos(X, Y, Z);

        }
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        this.storage.writeToNBT(compound);
        compound.setInteger("Connections", getConnections());
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < connectedToPos.size(); i++) {
            BlockPos pos = connectedToPos.get(i);
            if(pos != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setInteger("PosX" + i, pos.getX());
                tagCompound.setInteger("PosY" + i, pos.getY());
                tagCompound.setInteger("PosZ" + i, pos.getZ());
                tagList.appendTag(tagCompound);
            }

        }
        compound.setTag("PosList", tagList);
        return super.writeToNBT(compound);
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


    public void setConnectedToPos(List<BlockPos> connectedToPos) {
        this.connectedToPos = connectedToPos;
    }

    public List<BlockPos> getConnectedToPos() {
        return connectedToPos;
    }

    public void addConnectedToPos(int X, int Y, int Z) {
        BlockPos pos = new BlockPos(X, Y, Z);
        this.connectedToPos.add(pos);
    }

    public int getConnections() {return connections;}

    public void setConnections(int connections) {this.connections = connections;}
}

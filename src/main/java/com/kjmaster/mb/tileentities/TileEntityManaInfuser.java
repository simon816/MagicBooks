package com.kjmaster.mb.tileentities;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import com.kjmaster.mb.mana.MultipleManaStorage;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 18/08/2017.
 */
public class TileEntityManaInfuser extends TileEntity implements ITickable, ICapabilityProvider {

    public final MultipleManaStorage storage = new MultipleManaStorage(10000, 10000, 10000);
    private ItemStackHandler handler;
    public TileEntityManaInfuser() {
        handler = new ItemStackHandler(1);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
        this.storage.readFromNBT(compound);
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("ItemStackHandler", handler.serializeNBT() );
        this.storage.writeToNBT(compound);
        return super.writeToNBT(compound);
    }

    @Override
    public void update() {
        if(this.world != null) {
            if(!this.world.isRemote) {
                TileEntityManaInfuser te = (TileEntityManaInfuser) world.getTileEntity(pos);
                IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
                ItemStack itemStack = handler.getStackInSlot(0);
                Item item = itemStack.getItem();

                if(item.equals(ModItems.MagicBook)) {
                    ItemMagicBook magicBook = (ItemMagicBook) item;

                    if(te.storage.getAirManaStored() > 0 && magicBook.getAirManaStored(itemStack) < 10000) {
                        int manaInInfuser = te.storage.getAirManaStored();
                        magicBook.receiveAirMana(itemStack, manaInInfuser, false);
                        te.storage.extractAirMana(manaInInfuser, false);
                    }

                    if(te.storage.getEarthManaStored() > 0 && magicBook.getEarthManaStored(itemStack) < 10000) {
                        int manaInInfuser = te.storage.getEarthManaStored();
                        magicBook.receiveEarthMana(itemStack, manaInInfuser, false);
                        te.storage.extractEarthMana(manaInInfuser, false);
                    }

                    if(te.storage.getFireManaStored() > 0 && magicBook.getFireManaStored(itemStack) < 10000) {
                        int manaInInfuser = te.storage.getFireManaStored();
                        magicBook.receiveFireMana(itemStack, manaInInfuser, false);
                        te.storage.extractFireMana(manaInInfuser, false);
                    }

                    if(te.storage.getWaterManaStored() > 0 && magicBook.getWaterManaStored(itemStack) < 10000) {
                        int manaInInfuser = te.storage.getWaterManaStored();
                        magicBook.receiveWaterMana(itemStack, manaInInfuser, false);
                        te.storage.extractWaterMana(manaInInfuser, false);
                    }
                }
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

    public int getField(int id) {
        switch (id)
        {
            case 0:
                return this.storage.getEarthManaStored();
            case 1:
                return this.storage.getAirManaStored();
            case 2:
                return this.storage.getFireManaStored();
            case 3:
                return this.storage.getWaterManaStored();
            default:
                return 0;
        }
    }

    public void setField(int id, int value) {
        switch (id)
        {
            case 0:
                this.storage.setEarthMana(value);
                break;
            case 1:
                this.storage.setAirMana(value);
                break;
            case 2:
                this.storage.setFireMana(value);
                break;
            case 3:
                this.storage.setWaterMana(value);
        }
    }

    public int getFieldCount() { return 4; }
}

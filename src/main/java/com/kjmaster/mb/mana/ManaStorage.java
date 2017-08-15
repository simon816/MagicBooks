package com.kjmaster.mb.mana;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by pbill_000 on 03/08/2017.
 */
public class ManaStorage implements IManaStorage {

    protected int mana;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public ManaStorage(int capacity) {
        this(capacity, capacity, capacity, 0);
    }
    public ManaStorage(int capacity, int maxTransfer)
    {
        this(capacity, maxTransfer, maxTransfer, 0);
    }

    public ManaStorage(int capacity, int maxReceive, int maxExtract)
    {
        this(capacity, maxReceive, maxExtract, 0);
    }

    public ManaStorage(int capacity, int maxReceive, int maxExtract, int mana)
    {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.mana = Math.max(0 , Math.min(capacity, mana));
    }

    @Override
    public int recieveMana(int maxReceive, boolean simulate) {
        if (!canReceive())
            return 0;

        int manaReceived = Math.min(capacity - mana, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            mana += manaReceived;
        return manaReceived;
    }

    @Override
    public int extractMana(int maxExtract, boolean simulate) {
        if (!canExtract())
            return 0;

        int manaExtracted = Math.min(mana, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            mana -= manaExtracted;
        return manaExtracted;
    }

    @Override
    public int getManaStored() {
        return mana;
    }

    @Override
    public int getMaxManaStored() {
        return capacity;
    }

    @Override
    public boolean canExtract()
    {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive()
    {
        return this.maxReceive > 0;
    }

    @Override
    public boolean isFull() {
        return this.mana == capacity;
    }

    public void readFromNBT(NBTTagCompound compound) {
        this.setMana(compound.getInteger("Mana"));
    }

    public void writeToNBT(NBTTagCompound compound) {
        compound.setInteger("Mana", this.getManaStored());
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}

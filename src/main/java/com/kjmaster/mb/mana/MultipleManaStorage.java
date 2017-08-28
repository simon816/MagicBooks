package com.kjmaster.mb.mana;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by pbill_000 on 18/08/2017.
 */
public class MultipleManaStorage implements IMultipleManaStorage {
    protected int earthMana;
    protected int airMana;
    protected int fireMana;
    protected int waterMana;

    protected int capacity;

    protected int maxReceive;
    protected int maxExtract;

    public MultipleManaStorage(int capacity) {
        this(capacity, capacity, capacity, 0, 0, 0, 0);
    }
    public MultipleManaStorage(int capacity, int maxTransfer)
    {
        this(capacity, maxTransfer, maxTransfer, 0, 0, 0, 0);
    }

    public MultipleManaStorage(int capacity, int maxReceive, int maxExtract) { this(capacity, maxReceive, maxExtract, 0, 0, 0, 0);}

    public MultipleManaStorage(int capacity, int maxReceive, int maxExtract, int earthMana, int airMana, int fireMana, int waterMana)
    {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.earthMana = Math.max(0 , Math.min(capacity, earthMana));
        this.airMana = Math.max(0 , Math.min(capacity, airMana));
        this.fireMana = Math.max(0 , Math.min(capacity, fireMana));
        this.waterMana = Math.max(0 , Math.min(capacity, waterMana));

    }
    //Earth Mana
    @Override
    public int receiveEarthMana(int maxReceive, boolean simulate) {
        if (!canEarthReceive())
            return 0;

        int manaReceived = Math.min(capacity - earthMana, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            earthMana += manaReceived;
        return manaReceived;
    }

    @Override
    public int extractEarthMana(int maxExtract, boolean simulate) {
        if (!canEarthExtract())
            return 0;

        int manaExtracted = Math.min(earthMana, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            earthMana -= manaExtracted;
        return manaExtracted;
    }

    @Override
    public int getEarthManaStored() {
        return earthMana;
    }

    @Override
    public int getMaxEarthManaStored() {
        return capacity;
    }

    @Override
    public boolean canEarthExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canEarthReceive() {
        return this.maxReceive > 0;
    }

    @Override
    public boolean isEarthFull() {
        return this.earthMana == capacity;
    }

    //Air Mana


    @Override
    public int receiveAirMana(int maxReceive, boolean simulate) {
        if (!canAirReceive())
            return 0;

        int manaReceived = Math.min(capacity - airMana, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            airMana += manaReceived;
        return manaReceived;
    }

    @Override
    public int extractAirMana(int maxExtract, boolean simulate) {
        if (!canAirExtract())
            return 0;

        int manaExtracted = Math.min(airMana, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            airMana -= manaExtracted;
        return manaExtracted;
    }

    @Override
    public int getAirManaStored() {
        return airMana;
    }

    @Override
    public int getMaxAirManaStored() {
        return capacity;
    }

    @Override
    public boolean canAirExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canAirReceive() {
        return this.maxReceive > 0;
    }

    @Override
    public boolean isAirFull() {
        return this.airMana == capacity;
    }

    //Fire Mana


    @Override
    public int receiveFireMana(int maxReceive, boolean simulate) {
        if (!canFireReceive())
            return 0;

        int manaReceived = Math.min(capacity - fireMana, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            fireMana += manaReceived;
        return manaReceived;
    }

    @Override
    public int extractFireMana(int maxExtract, boolean simulate) {
        if (!canFireExtract())
            return 0;

        int manaExtracted = Math.min(fireMana, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            fireMana -= manaExtracted;
        return manaExtracted;
    }

    @Override
    public int getFireManaStored() {
        return fireMana;
    }

    @Override
    public int getMaxFireManaStored() {
        return capacity;
    }

    @Override
    public boolean canFireExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canFireReceive() {
        return this.maxReceive > 0;
    }

    @Override
    public boolean isFireFull() {
        return this.fireMana == capacity;
    }

    //Water Mana


    @Override
    public int receiveWaterMana(int maxReceive, boolean simulate) {
        if (!canWaterReceive())
            return 0;

        int manaReceived = Math.min(capacity - waterMana, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            waterMana += manaReceived;
        return manaReceived;
    }

    @Override
    public int extractWaterMana(int maxExtract, boolean simulate) {
        if (!canWaterExtract())
            return 0;

        int manaExtracted = Math.min(waterMana, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            waterMana -= manaExtracted;
        return manaExtracted;
    }

    @Override
    public int getWaterManaStored() {
        return waterMana;
    }

    @Override
    public int getMaxWaterManaStored() {
        return capacity;
    }

    @Override
    public boolean canWaterExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canWaterReceive() {
        return this.maxReceive > 0;
    }

    @Override
    public boolean isWaterFull() {
        return this.waterMana == capacity;
    }

    public void readFromNBT(NBTTagCompound compound) {
        this.setEarthMana(compound.getInteger("EarthMana"));
        this.setAirMana(compound.getInteger("AirMana"));
        this.setFireMana(compound.getInteger("FireMana"));
        this.setWaterMana(compound.getInteger("WaterMana"));
    }

    public void writeToNBT(NBTTagCompound compound) {
        compound.setInteger("EarthMana", this.getEarthManaStored());
        compound.setInteger("AirMana", this.getAirManaStored());
        compound.setInteger("FireMana", this.getFireManaStored());
        compound.setInteger("WaterMana", this.getWaterManaStored());
    }

    public void setEarthMana(int mana) {
        this.earthMana = mana;
    }
    public void setAirMana(int mana) {
        this.airMana = mana;
    }
    public void setFireMana(int mana) {
        this.fireMana = mana;
    }
    public void setWaterMana(int mana) {
        this.waterMana = mana;
    }

}

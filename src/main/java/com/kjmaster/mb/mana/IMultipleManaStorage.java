package com.kjmaster.mb.mana;

/**
 * Created by pbill_000 on 18/08/2017.
 */
public interface IMultipleManaStorage {

    int receiveEarthMana(int maxReceive, boolean simulate);
    int extractEarthMana(int maxExtract, boolean simulate);
    int getEarthManaStored();
    int getMaxEarthManaStored();
    boolean canEarthExtract();
    boolean canEarthReceive();
    boolean isEarthFull();

    int receiveAirMana(int maxReceive, boolean simulate);
    int extractAirMana(int maxExtract, boolean simulate);
    int getAirManaStored();
    int getMaxAirManaStored();
    boolean canAirExtract();
    boolean canAirReceive();
    boolean isAirFull();

    int receiveFireMana(int maxReceive, boolean simulate);
    int extractFireMana(int maxExtract, boolean simulate);
    int getFireManaStored();
    int getMaxFireManaStored();
    boolean canFireExtract();
    boolean canFireReceive();
    boolean isFireFull();

    int receiveWaterMana(int maxReceive, boolean simulate);
    int extractWaterMana(int maxExtract, boolean simulate);
    int getWaterManaStored();
    int getMaxWaterManaStored();
    boolean canWaterExtract();
    boolean canWaterReceive();
    boolean isWaterFull();

}

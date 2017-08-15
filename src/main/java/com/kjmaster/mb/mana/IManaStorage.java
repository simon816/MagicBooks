package com.kjmaster.mb.mana;

/**
 * Created by pbill_000 on 03/08/2017.
 */
public interface IManaStorage {

    int recieveMana(int maxReceive, boolean simulate);

    int extractMana(int maxExtract, boolean simulate);

    int getManaStored();

    int getMaxManaStored();

    boolean canExtract();

    boolean canReceive();

    boolean isFull();
}

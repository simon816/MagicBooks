package com.kjmaster.mb.mana;

import net.minecraft.item.ItemStack;

/**
 * Created by pbill_000 on 16/08/2017.
 */
public interface IManaContainerItem {
    int receiveEarthMana(ItemStack container, int maxRecieve, boolean simulate);

    int extractEarthMana(ItemStack container, int maxExtract, boolean simulate);

    int getEarthManaStored(ItemStack container);

    int getMaxEarthManaStored(ItemStack container);

    int receiveAirMana(ItemStack container, int maxRecieve, boolean simulate);

    int extractAirMana(ItemStack container, int maxExtract, boolean simulate);

    int getAirManaStored(ItemStack container);

    int getMaxAirManaStored(ItemStack container);

    int receiveFireMana(ItemStack container, int maxRecieve, boolean simulate);

    int extractFireMana(ItemStack container, int maxExtract, boolean simulate);

    int getFireManaStored(ItemStack container);

    int getMaxFireManaStored(ItemStack container);

    int receiveWaterMana(ItemStack container, int maxRecieve, boolean simulate);

    int extractWaterMana(ItemStack container, int maxExtract, boolean simulate);

    int getWaterManaStored(ItemStack container);

    int getMaxWaterManaStored(ItemStack container);

}

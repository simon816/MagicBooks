package com.kjmaster.mb.util;

import com.kjmaster.mb.MagicBooks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by pbill_000 on 16/08/2017.
 */
public class NBTHelper {
    public static NBTTagCompound getTag(ItemStack stack) {
        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
        return stack.getTagCompound();
    }

    public static boolean hasTag(ItemStack stack) {
        return stack.hasTagCompound();
    }

    public static void setInt(ItemStack stack, String key, int val) {
        getTag(stack).setInteger(key, val);
    }

    public static int getInt(ItemStack stack, String key) {
        return hasTag(stack) ? getTag(stack).getInteger(key) : 0;
    }

    //Earth mana

    public static int receiveEarthMana(ItemStack container, int earthMana, int maxEarthMana, boolean simulate) {
        int stored = getEarthManaStored(container);
        int accepted = Math.min(earthMana, maxEarthMana - stored);
        if (!simulate) {
            stored += accepted;
            NBTHelper.setInt(container, "EarthMana", stored);
        }
        MagicBooks.LOGGER.info("Accepted: " + accepted);
        return accepted;
    }

    public static int extractEarthMana(ItemStack container, int earthMana, boolean simulate) {
        int stored = getEarthManaStored(container);
        int extracted = Math.min(earthMana, stored);
        if (!simulate) {
            stored -= extracted;
            NBTHelper.setInt(container, "EarthMana", stored);
        }
        MagicBooks.LOGGER.info("Extracted: " + extracted);
        return extracted;
    }

    public static int getEarthManaStored(ItemStack container) {
        return getInt(container, "EarthMana");
    }

    //Air Mana

    public static int receiveAirMana(ItemStack container, int airMana, int maxAirMana, boolean simulate) {
        int stored = getAirManaStored(container);
        int accepted = Math.min(airMana, maxAirMana - stored);
        if (!simulate) {
            stored += accepted;
            NBTHelper.setInt(container, "AirMana", stored);
        }
        MagicBooks.LOGGER.info("Accepted: " + accepted);
        return accepted;
    }

    public static int extractAirMana(ItemStack container, int airMana, boolean simulate) {
        int stored = getAirManaStored(container);
        int extracted = Math.min(airMana, stored);
        if (!simulate) {
            stored -= extracted;
            NBTHelper.setInt(container, "AirMana", stored);
        }
        MagicBooks.LOGGER.info("Extracted: " + extracted);
        return extracted;
    }

    public static int getAirManaStored(ItemStack container) {
        return getInt(container, "AirMana");
    }

    //Fire Mana

    public static int receiveFireMana(ItemStack container, int fireMana, int maxFireMana, boolean simulate) {
        int stored = getFireManaStored(container);
        int accepted = Math.min(fireMana, maxFireMana - stored);
        if (!simulate) {
            stored += accepted;
            NBTHelper.setInt(container, "FireMana", stored);
        }
        MagicBooks.LOGGER.info("Accepted: " + accepted);
        return accepted;
    }

    public static int extractFireMana(ItemStack container, int fireMana, boolean simulate) {
        int stored = getFireManaStored(container);
        int extracted = Math.min(fireMana, stored);
        if (!simulate) {
            stored -= extracted;
            NBTHelper.setInt(container, "FireMana", stored);
        }
        MagicBooks.LOGGER.info("Extracted: " + extracted);
        return extracted;
    }

    public static int getFireManaStored(ItemStack container) {
        return getInt(container, "FireMana");
    }

    //Water Mana

    public static int receiveWaterMana(ItemStack container, int waterMana, int maxWaterMana, boolean simulate) {
        int stored = getWaterManaStored(container);
        int accepted = Math.min(waterMana, maxWaterMana - stored);
        if (!simulate) {
            stored += accepted;
            NBTHelper.setInt(container, "WaterMana", stored);
        }
        MagicBooks.LOGGER.info("Accepted: " + accepted);
        return accepted;
    }

    public static int extractWaterMana(ItemStack container, int waterMana, boolean simulate) {
        int stored = getWaterManaStored(container);
        int extracted = Math.min(waterMana, stored);
        if (!simulate) {
            stored -= extracted;
            NBTHelper.setInt(container, "WaterMana", stored);
        }
        MagicBooks.LOGGER.info("Extracted: " + extracted);
        return extracted;
    }

    public static int getWaterManaStored(ItemStack container) {
        return getInt(container, "WaterMana");
    }

}

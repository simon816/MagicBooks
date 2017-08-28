package com.kjmaster.mb.util;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by pbill_000 on 27/08/2017.
 */
public class TagUtil {

    public static NBTTagCompound getTagSafe(NBTTagCompound tag, String key) {
        if(tag == null || !tag.hasKey(key)) {
            return new NBTTagCompound();
        }

        return tag.getCompoundTag(key);
    }
}

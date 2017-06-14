package com.kjmaster.mb.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class ItemBase extends Item {
    public ItemBase(String name, CreativeTabs tab) {
        this(name, tab, 64);
    }

    public ItemBase(String name, CreativeTabs tab, int maxSize) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setMaxStackSize(maxSize);
    }
}

package com.kjmaster.mb.creative;

import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class ModCreativeTab {
    public static final CreativeTabs tabMagicBooks = new CreativeTabs("MagicBooks") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.FireBook);
        }
    };
}

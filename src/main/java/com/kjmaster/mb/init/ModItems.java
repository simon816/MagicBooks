package com.kjmaster.mb.init;

import com.kjmaster.mb.creative.ModCreativeTab;
import com.kjmaster.mb.items.ItemAirBook;
import com.kjmaster.mb.items.ItemEarthBook;
import com.kjmaster.mb.items.ItemFireBook;
import com.kjmaster.mb.items.ItemWaterBook;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class ModItems {
    public static final Item EarthBook = new ItemEarthBook("earth_book", CreativeTabs.MISC, 64 );
    public static final Item AirBook = new ItemAirBook("air_book", CreativeTabs.MISC, 64 );
    public static final Item FireBook = new ItemFireBook("fire_book", CreativeTabs.MISC, 64 );
    public static final Item WaterBook = new ItemWaterBook("water_book", CreativeTabs.MISC, 64 );
}

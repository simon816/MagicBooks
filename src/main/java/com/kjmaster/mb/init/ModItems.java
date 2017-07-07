package com.kjmaster.mb.init;

import com.kjmaster.mb.creative.ModCreativeTab;
import com.kjmaster.mb.items.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class ModItems {
    public static final Item EarthBook = new ItemEarthBook("earth_book", ModCreativeTab.tabMagicBooks, 64 );
    public static final Item AirBook = new ItemAirBook("air_book", ModCreativeTab.tabMagicBooks, 64 );
    public static final Item FireBook = new ItemFireBook("fire_book", ModCreativeTab.tabMagicBooks, 64 );
    public static final Item WaterBook = new ItemWaterBook("water_book", ModCreativeTab.tabMagicBooks, 64 );
    public static final Item AirShard = new ItemAirShard("air_shard", ModCreativeTab.tabMagicBooks, 64);
    public static final Item EarthShard = new ItemEarthShard("earth_shard", ModCreativeTab.tabMagicBooks, 64);
    public static final Item FireShard = new ItemEarthShard("fire_shard", ModCreativeTab.tabMagicBooks, 64);
    public static final Item WaterShard = new ItemEarthShard("water_shard", ModCreativeTab.tabMagicBooks, 64);

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            final Item[] items = {
                            EarthBook,
                            AirBook,
                            FireBook,
                            WaterBook,
                            AirShard,
                            EarthShard,
                            FireShard,
                            WaterShard,

            };
            final IForgeRegistry<Item> registry = event.getRegistry();
            for(final Item item : items) {
                registry.register(item);
                ITEMS.add(item);
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }
}

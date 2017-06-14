package com.kjmaster.mb.handlers;

import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.util.LootUtils;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Created by pbill_000 on 06/06/2017.
 */
@Mod.EventBusSubscriber
public class LootHandler {
    @SubscribeEvent
    public static void lootTableLoad(LootTableLoadEvent event) {
        LootCondition[] chance;
        LootCondition[] lootingEnchant;
        LootCondition[] count;
        LootEntryItem[] item;
        LootPool newPool;
        if(event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) {
            LootTable loot = event.getTable();
            LootUtils.addItemToTable(loot, ModItems.EarthBook,0,0,1,1,10,1,4,0,0, ModItems.EarthBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.AirBook,0,0,1,1,10,1,4,0,0, ModItems.AirBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.FireBook,0,0,1,1,10,1,4,0,0, ModItems.FireBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.WaterBook,0,0,1,1,10,1,4,0,0, ModItems.WaterBook.getUnlocalizedName() );

        }
        if(event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
            LootTable loot = event.getTable();
            LootUtils.addItemToTable(loot, ModItems.EarthBook,0,0,1,1,10,1,4,0,0, ModItems.EarthBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.AirBook,0,0,1,1,10,1,4,0,0, ModItems.AirBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.FireBook,0,0,1,1,10,1,4,0,0, ModItems.FireBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.WaterBook,0,0,1,1,10,1,4,0,0, ModItems.WaterBook.getUnlocalizedName() );

        }
        if(event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
            LootTable loot = event.getTable();
            LootUtils.addItemToTable(loot, ModItems.EarthBook,0,0,1,1,10,1,4,0,0, ModItems.EarthBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.AirBook,0,0,1,1,10,1,4,0,0, ModItems.AirBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.FireBook,0,0,1,1,10,1,4,0,0, ModItems.FireBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.WaterBook,0,0,1,1,10,1,4,0,0, ModItems.WaterBook.getUnlocalizedName() );

        }
        if(event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
            LootTable loot = event.getTable();
            LootUtils.addItemToTable(loot, ModItems.EarthBook,0,0,1,1,10,1,4,0,0, ModItems.EarthBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.AirBook,0,0,1,1,10,1,4,0,0, ModItems.AirBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.FireBook,0,0,1,1,10,1,4,0,0, ModItems.FireBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.WaterBook,0,0,1,1,10,1,4,0,0, ModItems.WaterBook.getUnlocalizedName() );
        }
        if(event.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
            LootTable loot = event.getTable();
            LootUtils.addItemToTable(loot, ModItems.EarthBook,0,0,1,1,10,1,4,0,0, ModItems.EarthBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.AirBook,0,0,1,1,10,1,4,0,0, ModItems.AirBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.FireBook,0,0,1,1,10,1,4,0,0, ModItems.FireBook.getUnlocalizedName() );
            LootUtils.addItemToTable(loot, ModItems.WaterBook,0,0,1,1,10,1,4,0,0, ModItems.WaterBook.getUnlocalizedName() );

        }

    }
}

package com.kjmaster.mb.util;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class RegisterUtil {
    public static void registerAll(FMLPreInitializationEvent event) {
        registerItems(event, ModItems.EarthBook);
        registerItems(event, ModItems.AirBook);
        registerItems(event, ModItems.FireBook);
        registerItems(event, ModItems.WaterBook);
        registerBlocks(event, ModBlocks.wallingRuneBlock);
        registerBlocks(event, ModBlocks.wallingBlock);
    }

    private static void registerBlocks(FMLPreInitializationEvent event, Block...blocks) {
        MagicBooks.LOGGER.info("Registering blocks: ");
        for(Block block: blocks) {
            MagicBooks.LOGGER.info("\tRegistering " + block.getUnlocalizedName().substring(5));
            final ItemBlock itemblock = new ItemBlock(block);
            if(event.getSide() == Side.CLIENT) {
                GameRegistry.register(block);
                GameRegistry.register(itemblock, block.getRegistryName());
                MagicBooks.LOGGER.info("\t\tRegistered!");
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                        0,
                        new ModelResourceLocation(
                                block.getRegistryName(),
                                "inventory"));
                MagicBooks.LOGGER.info("\t\tModel Registered!");

            }
        }
    }

    private  static void registerItems(FMLPreInitializationEvent event, Item...items) {
        MagicBooks.LOGGER.info("Registering items: ");
        for(Item item : items) {
            MagicBooks.LOGGER.info("\tRegistering " + item.getUnlocalizedName().substring(5));
            if(event.getSide() == Side.CLIENT) {
                GameRegistry.register(item);
                MagicBooks.LOGGER.info("\t\tRegistered!");
                ModelLoader.setCustomModelResourceLocation(item,
                        0,
                        new ModelResourceLocation(
                                item.getRegistryName(),
                                "inventory"));
                MagicBooks.LOGGER.info("\t\tModel Registered!");

            }
        }

    }

}

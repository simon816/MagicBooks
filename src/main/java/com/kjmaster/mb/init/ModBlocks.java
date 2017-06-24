package com.kjmaster.mb.init;

import com.kjmaster.mb.blocks.BlockWalling;
import com.kjmaster.mb.blocks.BlockWallingRune;
import com.kjmaster.mb.creative.ModCreativeTab;
import jline.internal.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
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
public class ModBlocks {
    public static final Block wallingRuneBlock = new BlockWallingRune(
            "wallingrune_block",
            net.minecraft.block.material.Material.CARPET,
            ModCreativeTab.tabMagicBooks,
            1F,
            1F,
            "shears",
            1);
    public static final Block wallingBlock = new BlockWalling(
            "walling_block",
            net.minecraft.block.material.Material.CARPET,
            ModCreativeTab.tabMagicBooks,
            0.01F,
            0.0001F,
            "shears",
            1);
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();
            final Block[] blocks = {
                            wallingRuneBlock,
                            wallingBlock,
            };
            registry.registerAll(blocks);
            for(final Block block: blocks) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }

        }
        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                    new ItemBlock(wallingRuneBlock),
                    new ItemBlock(wallingBlock),
            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for(final ItemBlock item : items) {
                final Block block = item.getBlock();
                final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName());
                registry.register(item.setRegistryName(registryName));
                ITEM_BLOCKS.add(item);
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

            }
        }
    }
}

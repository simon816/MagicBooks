package com.kjmaster.mb.init;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.blocks.*;
import com.kjmaster.mb.creative.ModCreativeTab;
import jline.internal.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class ModBlocks {
    public static final Block wallingRuneBlock = new BlockWallingRune(
            "wallingrune_block",
            Material.CLOTH,
            ModCreativeTab.tabMagicBooks,
            1F,
            1F,
            "shears",
            1);
    public static final Block wallingBlock = new BlockWalling(
            "walling_block",
            Material.CLOTH,
            ModCreativeTab.tabMagicBooks,
            0.01F,
            0.0001F,
            "shears",
            1);
    public static final Block drowningRuneBlock = new BlockDrowningRune(
            "drowningrune_block",
            Material.CLOTH,
            ModCreativeTab.tabMagicBooks,
            1F,
            1F,
            "shears",
            1);
    public static final Block airShardOre = new BlockAirShardOre(
            "air_shard_ore",
            Material.ROCK,
            ModCreativeTab.tabMagicBooksOres,
            5.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block earthShardOre = new BlockEarthShardOre(
            "earth_shard_ore",
            Material.ROCK,
            ModCreativeTab.tabMagicBooksOres,
            5.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block fireShardOre = new BlockFireShardOre(
            "fire_shard_ore",
            Material.ROCK,
            ModCreativeTab.tabMagicBooksOres,
            5.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block waterShardOre = new BlockWaterShardOre(
            "water_shard_ore",
            Material.ROCK,
            ModCreativeTab.tabMagicBooksOres,
            5.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block woodCutRuneBlock = new BlockWoodCutRune(
            "woodcutrune_block",
            Material.CLOTH,
            ModCreativeTab.tabMagicBooks,
            1F,
            1F,
            "shears",
            1);
    public static final Block earthCrystalBlock = new BlockEarthCrystal(
            "earth_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block airCrystalBlock = new BlockAirCrystal(
            "air_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block fireCrystalBlock = new BlockFireCrystal(
            "fire_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block waterCrystalBlock = new BlockWaterCrystal(
            "water_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block greaterEarthCrystalBlock = new BlockGreaterEarthCrystal(
            "greater_earth_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block greaterAirCrystalBlock = new BlockGreaterAirCrystal(
            "greater_air_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block greaterFireCrystalBlock = new BlockGreaterFireCrystal(
            "greater_fire_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    public static final Block greaterWaterCrystalBlock = new BlockGreaterWaterCrystal(
            "greater_water_crystal",
            Material.ROCK,
            ModCreativeTab.tabMagicBooks,
            3.0F,
            10.0F,
            "pickaxe",
            2);
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();
            final Block[] blocks = {
                    wallingRuneBlock,
                    drowningRuneBlock,
                    woodCutRuneBlock,
                    wallingBlock,
                    airShardOre,
                    earthShardOre,
                    fireShardOre,
                    waterShardOre,
                    earthCrystalBlock,
                    airCrystalBlock,
                    fireCrystalBlock,
                    waterCrystalBlock,
                    greaterEarthCrystalBlock,
                    greaterAirCrystalBlock,
                    greaterFireCrystalBlock,
                    greaterWaterCrystalBlock,
            };
            registry.registerAll(blocks);
            for (final Block block : blocks) {
            }

        }

        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                    new ItemBlock(wallingRuneBlock),
                    new ItemBlock(drowningRuneBlock),
                    new ItemBlock(woodCutRuneBlock),
                    new ItemBlock(wallingBlock),
                    new ItemBlock(airShardOre),
                    new ItemBlock(earthShardOre),
                    new ItemBlock(fireShardOre),
                    new ItemBlock(waterShardOre),
                    new ItemBlock(earthCrystalBlock),
                    new ItemBlock(airCrystalBlock),
                    new ItemBlock(fireCrystalBlock),
                    new ItemBlock(waterCrystalBlock),
                    new ItemBlock(greaterEarthCrystalBlock),
                    new ItemBlock(greaterAirCrystalBlock),
                    new ItemBlock(greaterFireCrystalBlock),
                    new ItemBlock(greaterWaterCrystalBlock),
            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final ItemBlock item : items) {
                final Block block = item.getBlock();
                final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName());
                registry.register(item.setRegistryName(registryName));
                ITEM_BLOCKS.add(item);
            }
        }
    }
    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        final Block[] blocks = {
                wallingRuneBlock,
                drowningRuneBlock,
                woodCutRuneBlock,
                wallingBlock,
                airShardOre,
                earthShardOre,
                fireShardOre,
                waterShardOre,
                earthCrystalBlock,
                airCrystalBlock,
                fireCrystalBlock,
                waterCrystalBlock,
                greaterEarthCrystalBlock,
                greaterAirCrystalBlock,
                greaterFireCrystalBlock,
                greaterWaterCrystalBlock,
        };
        for(final Block block: blocks) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Ref.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));;
        }
        final ItemBlock[] items = {
                new ItemBlock(wallingRuneBlock),
                new ItemBlock(drowningRuneBlock),
                new ItemBlock(woodCutRuneBlock),
                new ItemBlock(wallingBlock),
                new ItemBlock(airShardOre),
                new ItemBlock(earthShardOre),
                new ItemBlock(fireShardOre),
                new ItemBlock(waterShardOre),
                new ItemBlock(earthCrystalBlock),
                new ItemBlock(airCrystalBlock),
                new ItemBlock(fireCrystalBlock),
                new ItemBlock(waterCrystalBlock),
                new ItemBlock(greaterEarthCrystalBlock),
                new ItemBlock(greaterAirCrystalBlock),
                new ItemBlock(greaterFireCrystalBlock),
                new ItemBlock(greaterWaterCrystalBlock),
        };
        for(final ItemBlock item : items) {
            final Block block = item.getBlock();
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Ref.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
        }
    }
}

package com.kjmaster.mb.init;

import com.kjmaster.mb.blocks.BlockWalling;
import com.kjmaster.mb.blocks.BlockWallingRune;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by pbill_000 on 05/06/2017.
 */
public class ModBlocks {
    public static final Block wallingRuneBlock = new BlockWallingRune(
            "wallingrune_block",
            net.minecraft.block.material.Material.CARPET,
            CreativeTabs.MISC,
            1F,
            1F,
            "shears",
            1);
    public static final Block wallingBlock = new BlockWalling(
            "walling_block",
            net.minecraft.block.material.Material.CARPET,
            CreativeTabs.MISC,
            0.01F,
            0.0001F,
            "shears",
            1);
}

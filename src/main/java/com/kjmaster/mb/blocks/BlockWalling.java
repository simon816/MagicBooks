package com.kjmaster.mb.blocks;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by pbill_000 on 21/06/2017.
 */
public class BlockWalling extends BlockBase {
    public BlockWalling(String name,
                        Material mat,
                        CreativeTabs tab,
                        float hardness,
                        float resistance,
                        String tool,
                        int harvest) {
        super(name, mat, tab, hardness, resistance, tool, harvest);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null;
    }
}
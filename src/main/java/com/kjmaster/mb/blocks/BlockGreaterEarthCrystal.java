package com.kjmaster.mb.blocks;

import com.kjmaster.mb.tileentities.crystals.TileEntityEarthCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterEarthCrystal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by pbill_000 on 06/08/2017.
 */
public class BlockGreaterEarthCrystal extends BlockBase implements ITileEntityProvider {
    public BlockGreaterEarthCrystal(String name,
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

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGreaterEarthCrystal();
    }
}

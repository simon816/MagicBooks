package com.kjmaster.mb.blocks;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.network.ModGuiHandler;
import com.kjmaster.mb.tileentities.crystals.TileEntityAirCrystal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by pbill_000 on 06/08/2017.
 */
public class BlockAirCrystal extends BlockBase implements ITileEntityProvider {
    public BlockAirCrystal(String name,
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
        return Item.getItemFromBlock(ModBlocks.airCrystalBlock);
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
        return new TileEntityAirCrystal();
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityAirCrystal();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote && !playerIn.isSneaking()) {
            playerIn.openGui(MagicBooks.instance, ModGuiHandler.AirCrystal, worldIn, pos.getX(), pos.getY(), pos.getZ() );
        }
        return true;
    }
}

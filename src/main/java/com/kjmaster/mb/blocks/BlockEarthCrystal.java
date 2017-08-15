package com.kjmaster.mb.blocks;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.network.ModGuiHandler;
import com.kjmaster.mb.tileentities.crystals.TileEntityEarthCrystal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by pbill_000 on 29/07/2017.
 */
public class BlockEarthCrystal extends BlockBase implements ITileEntityProvider{
    public BlockEarthCrystal(String name,
                             Material mat,
                             CreativeTabs tab,
                             float hardness,
                             float resistance,
                             String tool,
                             int harvest) {
        super(name, mat, tab, hardness, resistance, tool, harvest);
    }

    @SideOnly(Side.CLIENT)
    public static void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.earthCrystalBlock), 0, new ModelResourceLocation(ModBlocks.earthCrystalBlock.getRegistryName(), "inventory"));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.earthCrystalBlock);
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
        return new TileEntityEarthCrystal();
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityEarthCrystal();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote && !playerIn.isSneaking()) {
            playerIn.openGui(MagicBooks.instance, ModGuiHandler.EarthCrystal, worldIn, pos.getX(), pos.getY(), pos.getZ() );
        }
        return true;
    }
}

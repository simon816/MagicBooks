package com.kjmaster.mb.blocks;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by pbill_000 on 20/06/2017.
 */
public class BlockWallingRune extends BlockBase {
    public BlockWallingRune(String name,
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
        return Item.getItemFromBlock(ModBlocks.wallingRuneBlock);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if(!(worldIn.isRemote)) {
            //Hit block on the side to spawn blocks wall on x axis
            if (facing.getAxis().isHorizontal()) {
                int j = 0;
                for(int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 1;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 2;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 3;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 4;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 5;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 6;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 7;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 8;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 9;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 10;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 11;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 12;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 13;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 14;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x - i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x + i, y + j, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                }
                for(int i = 1; i < 15; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + i, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + i, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                }
            }
            //Hit block on top to spawn wall on z axis
            if (facing.getAxis().isVertical()) {
                int j = 0;
                for(int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y, z-i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y, z+ i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 1;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 2;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 3;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 4;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 5;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 6;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 7;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 8;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 9;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 10;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 11;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 12;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 13;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    j = 14;
                }
                for (int i = 1; i < 16; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z - i), ModBlocks.wallingBlock.getDefaultState());
                    }
                    block1 = worldIn.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + j, z + i), ModBlocks.wallingBlock.getDefaultState());
                    }
                }
                for(int i = 1; i < 15; i++) {
                    Block block1 = worldIn.getBlockState(new BlockPos(x, y + i, z)).getBlock();
                    if(block1 instanceof BlockAir) {
                        worldIn.setBlockState(new BlockPos(x, y + i, z), ModBlocks.wallingBlock.getDefaultState());
                    }
                }
            }
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}

package com.kjmaster.mb.worldgen.structures;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by pbill_000 on 07/08/2017.
 */
public class EarthCircle extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();
        IBlockState mossyBricks = Blocks.STONEBRICK.getStateFromMeta(1);
        IBlockState mossyStone = Blocks.MOSSY_COBBLESTONE.getDefaultState();
        IBlockState cobbleWall = Blocks.COBBLESTONE_WALL.getStateFromMeta(0);
        IBlockState mossyWall = Blocks.COBBLESTONE_WALL.getStateFromMeta(1);
        IBlockState cobble = Blocks.COBBLESTONE.getDefaultState();
        IBlockState cobbleSlab = Blocks.STONE_SLAB.getStateFromMeta(3);
        IBlockState cobbleStairs = Blocks.STONE_STAIRS.getDefaultState();
        IBlockState darkOakLeaves = Blocks.LEAVES.getStateFromMeta(1);
        //Front row
        world.setBlockState(new BlockPos(x + 3, y, z + 1), mossyStone);
        world.setBlockState(new BlockPos(x + 4, y, z + 1), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 1), mossyStone);
        world.setBlockState(new BlockPos(x + 6, y, z + 1), mossyBricks);
        world.setBlockState(new BlockPos(x + 7, y, z + 1), mossyStone);
        //Second row
        world.setBlockState(new BlockPos(x + 2, y, z + 2), mossyStone);
        world.setBlockState(new BlockPos(x + 3, y, z + 2), cobble);
        world.setBlockState(new BlockPos(x + 4, y, z + 2), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 2), mossyStone);
        world.setBlockState(new BlockPos(x + 6, y, z + 2), mossyStone);
        world.setBlockState(new BlockPos(x + 7, y, z + 2), mossyStone);
        world.setBlockState(new BlockPos(x + 8, y, z + 2), mossyBricks);
        //Third row
        world.setBlockState(new BlockPos(x + 1, y, z + 3), mossyStone);
        world.setBlockState(new BlockPos(x + 2, y, z + 3), cobble);
        world.setBlockState(new BlockPos(x + 3, y, z + 3), cobbleSlab);
        world.setBlockState(new BlockPos(x + 4, y, z + 3), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 3), cobble);
        world.setBlockState(new BlockPos(x + 6, y, z + 3), mossyBricks);
        world.setBlockState(new BlockPos(x + 7, y, z + 3), mossyStone);
        world.setBlockState(new BlockPos(x + 8, y, z + 3), cobble);
        world.setBlockState(new BlockPos(x + 9, y, z + 3), mossyStone);
        //Fourth row
        world.setBlockState(new BlockPos(x + 1, y, z + 4), mossyStone);
        world.setBlockState(new BlockPos(x + 2, y, z + 4), mossyBricks);
        world.setBlockState(new BlockPos(x + 3, y, z + 4), mossyStone);
        world.setBlockState(new BlockPos(x + 4, y, z + 4), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 4), cobble);
        world.setBlockState(new BlockPos(x + 6, y, z + 4), mossyStone);
        world.setBlockState(new BlockPos(x + 7, y, z + 4), cobbleStairs);
        world.setBlockState(new BlockPos(x + 8, y, z + 4), mossyStone);
        world.setBlockState(new BlockPos(x + 9, y, z + 4), mossyStone);
        //Fifth row
        world.setBlockState(new BlockPos(x + 1, y, z + 5), mossyStone);
        world.setBlockState(new BlockPos(x + 2, y, z + 5), mossyStone);
        world.setBlockState(new BlockPos(x + 3, y, z + 5), cobble);
        world.setBlockState(new BlockPos(x + 4, y, z + 5), cobble);
        world.setBlockState(new BlockPos(x + 5, y, z + 5), cobble);
        world.setBlockState(new BlockPos(x + 6, y, z + 5), mossyStone);
        world.setBlockState(new BlockPos(x + 7, y, z + 5), mossyStone);
        world.setBlockState(new BlockPos(x + 8, y, z + 5), mossyStone);
        world.setBlockState(new BlockPos(x + 9, y, z + 5), cobble);
        //Sixth row
        world.setBlockState(new BlockPos(x + 1, y, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 2, y, z + 6), mossyStone);
        world.setBlockState(new BlockPos(x + 3, y, z + 6), mossyStone);
        world.setBlockState(new BlockPos(x + 4, y, z + 6), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 6, y, z + 6), mossyStone);
        world.setBlockState(new BlockPos(x + 7, y, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 8, y, z + 6), mossyStone);
        world.setBlockState(new BlockPos(x + 9, y, z + 6), mossyStone);
        //Seventh row
        world.setBlockState(new BlockPos(x + 1, y, z + 7), mossyStone);
        world.setBlockState(new BlockPos(x + 2, y, z + 7), cobbleStairs);
        world.setBlockState(new BlockPos(x + 3, y, z + 7), cobble);
        world.setBlockState(new BlockPos(x + 4, y, z + 7), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 7), cobble);
        world.setBlockState(new BlockPos(x + 6, y, z + 7), cobbleSlab);
        world.setBlockState(new BlockPos(x + 7, y, z + 7), mossyStone);
        world.setBlockState(new BlockPos(x + 8, y, z + 7), mossyStone);
        world.setBlockState(new BlockPos(x + 9, y, z + 7), mossyStone);
        //Eighth row
        world.setBlockState(new BlockPos(x + 2, y, z + 8), mossyStone);
        world.setBlockState(new BlockPos(x + 3, y, z + 8), mossyBricks);
        world.setBlockState(new BlockPos(x + 4, y, z + 8), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y, z + 8), mossyStone);
        world.setBlockState(new BlockPos(x + 6, y, z + 8), mossyStone);
        world.setBlockState(new BlockPos(x + 7, y, z + 8), mossyStone);
        world.setBlockState(new BlockPos(x + 8, y, z + 8), mossyBricks);
        //Ninth row
        world.setBlockState(new BlockPos(x + 3, y, z + 9), mossyStone);
        world.setBlockState(new BlockPos(x + 4, y, z + 9), cobble);
        world.setBlockState(new BlockPos(x + 5, y, z + 9), mossyStone);
        world.setBlockState(new BlockPos(x + 6, y, z + 9), mossyStone);
        world.setBlockState(new BlockPos(x + 7, y, z + 9), mossyStone);
        //Pillar 1
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), cobble);
        world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), cobble);
        world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), cobble);
        world.setBlockState(new BlockPos(x + 2, y + 4, z + 2), mossyWall);
        //Pillar 2
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 1), mossyWall);
        world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), cobbleWall);
        //Pillar 3
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 1), cobbleSlab);
        //Pillar 4
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 1), mossyStone);
        world.setBlockState(new BlockPos(x + 6, y + 2, z + 1), cobble);
        world.setBlockState(new BlockPos(x + 6, y + 3, z + 1), cobble);
        world.setBlockState(new BlockPos(x + 6, y + 4, z + 1), cobble);
        world.setBlockState(new BlockPos(x + 6, y + 5, z + 1), darkOakLeaves);
        //Pillar 5
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 3), cobbleWall);
        //Pillar 6
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 4), cobble);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 4), cobble);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 4), cobble);
        world.setBlockState(new BlockPos(x + 9, y + 4, z + 4), cobble);
        world.setBlockState(new BlockPos(x + 9, y + 5, z + 4), mossyWall);
        //Pillar 7
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 6), mossyWall);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 6), cobbleWall);
        //Pillar 8
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 7), mossyStone);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 7), mossyStone);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 7), cobble);
        world.setBlockState(new BlockPos(x + 9, y + 4, z + 7), darkOakLeaves);
        //Pillar 9
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), mossyWall);
        world.setBlockState(new BlockPos(x + 7, y + 2, z + 9), cobbleWall);
        //Pillar 10
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), cobbleSlab);
        //Pillar 11
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), mossyStone);
        world.setBlockState(new BlockPos(x + 5, y + 2, z + 9), cobble);
        world.setBlockState(new BlockPos(x + 5, y + 3, z + 9), cobble);
        world.setBlockState(new BlockPos(x + 5, y + 4, z + 9), cobble);
        world.setBlockState(new BlockPos(x + 5, y + 5, z + 9), mossyWall);
        //Pillar 12
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 9), cobbleWall);
        world.setBlockState(new BlockPos(x + 3, y + 2, z + 9), cobbleWall);
        world.setBlockState(new BlockPos(x + 3, y + 3, z + 9), cobbleWall);
        //Pillar 13
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 8), cobbleSlab);
        //Pillar 14
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 7), cobbleWall);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 7), mossyWall);
        //Pillar 15
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), mossyStone);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 1, y + 4, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 1, y + 5, z + 6), cobble);
        world.setBlockState(new BlockPos(x + 1, y + 6, z + 6), darkOakLeaves);
        //Pillar 16
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 4), cobbleWall);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 4), cobbleWall);
        //Pillar 17
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 3), cobbleSlab);
        //Centre
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), cobbleStairs);
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), cobbleStairs);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), mossyBricks);
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), cobbleSlab);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), cobbleStairs);
        world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), ModBlocks.greaterEarthCrystalBlock.getDefaultState());

        return true;
    }
}

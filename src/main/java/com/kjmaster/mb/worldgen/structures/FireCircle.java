package com.kjmaster.mb.worldgen.structures;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by pbill_000 on 07/08/2017.
 */
public class FireCircle extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();
        IBlockState netherrack = Blocks.NETHERRACK.getDefaultState();
        IBlockState netherbrick = Blocks.NETHER_BRICK.getDefaultState();
        IBlockState netherbrickRed = Blocks.RED_NETHER_BRICK.getDefaultState();
        IBlockState magma = Blocks.MAGMA.getDefaultState();
        IBlockState lantern = Blocks.LIT_PUMPKIN.getDefaultState();
        IBlockState quartzOre = Blocks.QUARTZ_ORE.getDefaultState();
        IBlockState soulSand = Blocks.SOUL_SAND.getDefaultState();
        IBlockState netherbrickFence = Blocks.NETHER_BRICK_FENCE.getDefaultState();
        IBlockState netherbrickStairs = Blocks.NETHER_BRICK_STAIRS.getDefaultState();
        IBlockState netherbrickSlab = Blocks.STONE_SLAB.getStateFromMeta(6);

        //Front row
        world.setBlockState(new BlockPos(x + 3, y, z + 1), netherbrick);
        world.setBlockState(new BlockPos(x + 4, y, z + 1), netherbrick);
        world.setBlockState(new BlockPos(x + 5, y, z + 1), netherbrick);
        world.setBlockState(new BlockPos(x + 6, y, z + 1), netherbrick);
        world.setBlockState(new BlockPos(x + 7, y, z + 1), netherbrick);
        //Second row
        world.setBlockState(new BlockPos(x + 2, y, z + 2), netherbrick);
        world.setBlockState(new BlockPos(x + 3, y, z + 2), magma);
        world.setBlockState(new BlockPos(x + 4, y, z + 2), netherrack);
        world.setBlockState(new BlockPos(x + 5, y, z + 2), netherrack);
        world.setBlockState(new BlockPos(x + 6, y, z + 2), netherrack);
        world.setBlockState(new BlockPos(x + 7, y, z + 2), netherrack);
        world.setBlockState(new BlockPos(x + 8, y, z + 2), netherbrick);
        //Third row
        world.setBlockState(new BlockPos(x + 1, y, z + 3), netherbrick);
        world.setBlockState(new BlockPos(x + 2, y, z + 3), netherrack);
        world.setBlockState(new BlockPos(x + 3, y, z + 3), netherrack);
        world.setBlockState(new BlockPos(x + 4, y, z + 3), netherrack);
        world.setBlockState(new BlockPos(x + 5, y, z + 3), netherrack);
        world.setBlockState(new BlockPos(x + 6, y, z + 3), quartzOre);
        world.setBlockState(new BlockPos(x + 7, y, z + 3), netherrack);
        world.setBlockState(new BlockPos(x + 8, y, z + 3), netherrack);
        world.setBlockState(new BlockPos(x + 9, y, z + 3), netherbrick);
        //Fourth row
        world.setBlockState(new BlockPos(x + 1, y, z + 4), netherbrick);
        world.setBlockState(new BlockPos(x + 2, y, z + 4), netherrack);
        world.setBlockState(new BlockPos(x + 3, y, z + 4), quartzOre);
        world.setBlockState(new BlockPos(x + 4, y, z + 4), soulSand);
        world.setBlockState(new BlockPos(x + 5, y, z + 4), magma);
        world.setBlockState(new BlockPos(x + 6, y, z + 4), soulSand);
        world.setBlockState(new BlockPos(x + 7, y, z + 4), netherrack);
        world.setBlockState(new BlockPos(x + 8, y, z + 4), quartzOre);
        world.setBlockState(new BlockPos(x + 9, y, z + 4), netherbrick);
        //Fifth row
        world.setBlockState(new BlockPos(x + 1, y, z + 5), netherbrick);
        world.setBlockState(new BlockPos(x + 2, y, z + 5), magma);
        world.setBlockState(new BlockPos(x + 3, y, z + 5), netherrack);
        world.setBlockState(new BlockPos(x + 4, y, z + 5), netherrack);
        world.setBlockState(new BlockPos(x + 5, y, z + 5), netherrack);
        world.setBlockState(new BlockPos(x + 6, y, z + 5), netherrack);
        world.setBlockState(new BlockPos(x + 7, y, z + 5), netherrack);
        world.setBlockState(new BlockPos(x + 8, y, z + 5), netherrack);
        world.setBlockState(new BlockPos(x + 9, y, z + 5), netherbrick);
        //Sixth row
        world.setBlockState(new BlockPos(x + 1, y, z + 6), netherrack);
        world.setBlockState(new BlockPos(x + 2, y, z + 6), netherrack);
        world.setBlockState(new BlockPos(x + 3, y, z + 6), netherrack);
        world.setBlockState(new BlockPos(x + 4, y, z + 6), quartzOre);
        world.setBlockState(new BlockPos(x + 5, y, z + 6), netherrack);
        world.setBlockState(new BlockPos(x + 6, y, z + 6), soulSand);
        world.setBlockState(new BlockPos(x + 7, y, z + 6), magma);
        world.setBlockState(new BlockPos(x + 8, y, z + 6), netherrack);
        world.setBlockState(new BlockPos(x + 9, y, z + 6), netherbrick);
        //Seventh row
        world.setBlockState(new BlockPos(x + 1, y, z + 7), netherbrick);
        world.setBlockState(new BlockPos(x + 2, y, z + 7), netherrack);
        world.setBlockState(new BlockPos(x + 3, y, z + 7), netherrack);
        world.setBlockState(new BlockPos(x + 4, y, z + 7), magma);
        world.setBlockState(new BlockPos(x + 5, y, z + 7), netherrack);
        world.setBlockState(new BlockPos(x + 6, y, z + 7), netherrack);
        world.setBlockState(new BlockPos(x + 7, y, z + 7), quartzOre);
        world.setBlockState(new BlockPos(x + 8, y, z + 7), netherrack);
        world.setBlockState(new BlockPos(x + 9, y, z + 7), netherbrick);
        //Eighth row
        world.setBlockState(new BlockPos(x + 2, y, z + 8), netherrack);
        world.setBlockState(new BlockPos(x + 3, y, z + 8), netherrack);
        world.setBlockState(new BlockPos(x + 4, y, z + 8), netherrack);
        world.setBlockState(new BlockPos(x + 5, y, z + 8), quartzOre);
        world.setBlockState(new BlockPos(x + 6, y, z + 8), netherrack);
        world.setBlockState(new BlockPos(x + 7, y, z + 8), netherrack);
        world.setBlockState(new BlockPos(x + 8, y, z + 8), netherrack);
        //Ninth row
        world.setBlockState(new BlockPos(x + 3, y, z + 9), netherbrick);
        world.setBlockState(new BlockPos(x + 4, y, z + 9), netherbrick);
        world.setBlockState(new BlockPos(x + 5, y, z + 9), netherbrick);
        world.setBlockState(new BlockPos(x + 6, y, z + 9), netherbrick);
        world.setBlockState(new BlockPos(x + 7, y, z + 9), netherbrick);

        //Pillar 1
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), netherbrickFence);
        //Pillar 2
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 1), netherbrickRed);
        world.setBlockState(new BlockPos(x + 3, y + 2, z + 1), netherbrickFence);
        //Pillar 3
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 1), netherbrickRed);
        world.setBlockState(new BlockPos(x + 7, y + 2, z + 1), netherbrickRed);
        world.setBlockState(new BlockPos(x + 7, y + 3, z + 1), netherbrickRed);
        world.setBlockState(new BlockPos(x + 7, y + 4, z + 1), lantern.withRotation(Rotation.CLOCKWISE_180));
        //Pillar 4
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 2), netherbrickFence);
        world.setBlockState(new BlockPos(x + 8, y + 2, z + 2), netherbrickFence);
        //Pillar 5
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 3), netherbrickRed);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 3), netherbrickRed);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 3), netherbrickRed);
        //Pillar 6
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 4), netherbrickFence);
        //Pillar 7
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 5), netherbrickFence);
        //Pillar 8
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 7), netherbrickFence);
        //Pillar 9
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 8), netherbrickRed);
        world.setBlockState(new BlockPos(x + 8, y + 2, z + 8), netherbrickFence);
        world.setBlockState(new BlockPos(x + 8, y + 3, z + 8), netherbrickFence);
        //Pillar 10
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), netherbrickFence);
        //Pillar 11
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), netherbrickRed);
        world.setBlockState(new BlockPos(x + 6, y + 2, z + 9), netherbrickRed);
        world.setBlockState(new BlockPos(x + 6, y + 3, z + 9), netherbrickRed);
        world.setBlockState(new BlockPos(x + 6, y + 4, z + 9), lantern);
        //Pillar 12
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), netherbrickFence);
        //Pillar 13
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 9), netherbrickFence);
        //Pillar 14
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 8), netherbrickRed);
        world.setBlockState(new BlockPos(x + 2, y + 2, z + 8), netherbrickRed);
        world.setBlockState(new BlockPos(x + 2, y + 3, z + 8), netherbrickFence);
        world.setBlockState(new BlockPos(x + 2, y + 4, z + 8), netherbrickFence);
        //Pillar 15
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 7), netherbrickFence);
        //Pillar 16
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), netherbrickRed);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), netherbrickRed);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), netherbrickRed);
        world.setBlockState(new BlockPos(x + 1, y + 4, z + 6), netherbrickFence);
        //Pillar 17
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 5), netherbrickFence);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 5), netherbrickFence);
        //Pillar 18
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 4), netherbrickFence);
        //Pillar 19
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 3), netherbrickRed);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 3), lantern.withRotation(Rotation.CLOCKWISE_90));

        //Centre
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), netherbrick);
        world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), ModBlocks.greaterFireCrystalBlock.getDefaultState());
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), netherbrickStairs.withRotation(Rotation.CLOCKWISE_90));
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), netherbrickSlab);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), netherbrickSlab);
        return true;
    }
}

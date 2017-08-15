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
 * Created by pbill_000 on 13/08/2017.
 */
public class AirCircle extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {

        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();
        IBlockState quartz = Blocks.QUARTZ_BLOCK.getDefaultState();
        IBlockState quartzSlab = Blocks.STONE_SLAB.getStateFromMeta(7);
        IBlockState quartzChiseled = Blocks.QUARTZ_BLOCK.getStateFromMeta(1);
        IBlockState quartzPillar = Blocks.QUARTZ_BLOCK.getStateFromMeta(2);
        IBlockState quartzStairs = Blocks.QUARTZ_STAIRS.getDefaultState();
        IBlockState snowLayer1 = Blocks.SNOW_LAYER.getDefaultState();
        IBlockState snow = Blocks.SNOW.getDefaultState();
        IBlockState whiteGlass = Blocks.STAINED_GLASS.getStateFromMeta(0);
        IBlockState whitePane = Blocks.STAINED_GLASS_PANE.getStateFromMeta(0);
        IBlockState lightGrayGlass = Blocks.STAINED_GLASS.getStateFromMeta(7);
        IBlockState lightGrayGlassPane = Blocks.STAINED_GLASS_PANE.getStateFromMeta(8);
        IBlockState glowstone = Blocks.GLOWSTONE.getDefaultState();
        //Front row
        world.setBlockState(new BlockPos(x + 3, y, z + 1), snow);
        world.setBlockState(new BlockPos(x + 4, y, z + 1), quartz);
        world.setBlockState(new BlockPos(x + 5, y, z + 1), snow);
        world.setBlockState(new BlockPos(x + 6, y, z + 1), quartz);
        world.setBlockState(new BlockPos(x + 7, y, z + 1), quartz);
        //Second row
        world.setBlockState(new BlockPos(x + 2, y, z + 2), quartz);
        world.setBlockState(new BlockPos(x + 3, y, z + 2), quartz);
        world.setBlockState(new BlockPos(x + 4, y, z + 2), whiteGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 2), whiteGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 2), whiteGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 2), quartzPillar);
        world.setBlockState(new BlockPos(x + 8, y, z + 2), snow);
        //Third row
        world.setBlockState(new BlockPos(x + 1, y, z + 3), quartz);
        world.setBlockState(new BlockPos(x + 2, y, z + 3), quartzPillar);
        world.setBlockState(new BlockPos(x + 3, y, z + 3), quartzChiseled);
        world.setBlockState(new BlockPos(x + 4, y, z + 3), quartzSlab);
        world.setBlockState(new BlockPos(x + 5, y, z + 3), quartz);
        world.setBlockState(new BlockPos(x + 6, y, z + 3), quartzSlab);
        world.setBlockState(new BlockPos(x + 7, y, z + 3), quartzChiseled);
        world.setBlockState(new BlockPos(x + 8, y, z + 3), quartzPillar);
        world.setBlockState(new BlockPos(x + 9, y, z + 3), quartz);
        //Fourth row
        world.setBlockState(new BlockPos(x + 1, y, z + 4), quartz);
        world.setBlockState(new BlockPos(x + 2, y, z + 4), whiteGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 4), quartzSlab);
        world.setBlockState(new BlockPos(x + 4, y, z + 4), quartzSlab);
        world.setBlockState(new BlockPos(x + 5, y, z + 4), glowstone);
        world.setBlockState(new BlockPos(x + 6, y, z + 4), quartzSlab);
        world.setBlockState(new BlockPos(x + 7, y, z + 4), quartzSlab);
        world.setBlockState(new BlockPos(x + 8, y, z + 4), whiteGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 4), quartz);
        //Fifth row
        world.setBlockState(new BlockPos(x + 1, y, z + 5), snow);
        world.setBlockState(new BlockPos(x + 2, y, z + 5), whiteGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 5), quartz);
        world.setBlockState(new BlockPos(x + 4, y, z + 5), Blocks.QUARTZ_STAIRS.withRotation(Blocks.QUARTZ_STAIRS.getDefaultState(), Rotation.CLOCKWISE_90));
        world.setBlockState(new BlockPos(x + 5, y, z + 5), glowstone);
        world.setBlockState(new BlockPos(x + 6, y, z + 5), Blocks.QUARTZ_STAIRS.withRotation(Blocks.QUARTZ_STAIRS.getDefaultState(), Rotation.COUNTERCLOCKWISE_90));
        world.setBlockState(new BlockPos(x + 7, y, z + 5), quartz);
        world.setBlockState(new BlockPos(x + 8, y, z + 5), whiteGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 5), quartz);
        //Sixth row
        world.setBlockState(new BlockPos(x + 1, y, z + 6), quartz);
        world.setBlockState(new BlockPos(x + 2, y, z + 6), whiteGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 6), quartzSlab);
        world.setBlockState(new BlockPos(x + 4, y, z + 6), quartzSlab);
        world.setBlockState(new BlockPos(x + 5, y, z + 6), glowstone);
        world.setBlockState(new BlockPos(x + 6, y, z + 6), quartzSlab);
        world.setBlockState(new BlockPos(x + 7, y, z + 6), quartzSlab);
        world.setBlockState(new BlockPos(x + 8, y, z + 6), whiteGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 6), quartz);
        //Seventh row
        world.setBlockState(new BlockPos(x + 1, y, z + 7), quartz);
        world.setBlockState(new BlockPos(x + 2, y, z + 7), quartzPillar);
        world.setBlockState(new BlockPos(x + 3, y, z + 7), quartzChiseled);
        world.setBlockState(new BlockPos(x + 4, y, z + 7), quartzSlab);
        world.setBlockState(new BlockPos(x + 5, y, z + 7), quartz);
        world.setBlockState(new BlockPos(x + 6, y, z + 7), quartzSlab);
        world.setBlockState(new BlockPos(x + 7, y, z + 7), quartzChiseled);
        world.setBlockState(new BlockPos(x + 8, y, z + 7), quartzPillar);
        world.setBlockState(new BlockPos(x + 9, y, z + 7), snow);
        //Eighth row
        world.setBlockState(new BlockPos(x + 2, y, z + 8), snow);
        world.setBlockState(new BlockPos(x + 3, y, z + 8), quartzPillar);
        world.setBlockState(new BlockPos(x + 4, y, z + 8), whiteGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 8), whiteGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 8), whiteGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 8), quartzPillar);
        world.setBlockState(new BlockPos(x + 8, y, z + 8), quartz);
        //Ninth row
        world.setBlockState(new BlockPos(x + 3, y, z + 9), quartz);
        world.setBlockState(new BlockPos(x + 4, y, z + 9), snow);
        world.setBlockState(new BlockPos(x + 5, y, z + 9), quartz);
        world.setBlockState(new BlockPos(x + 6, y, z + 9), quartz);
        world.setBlockState(new BlockPos(x + 7, y, z + 9), quartz);
        //Pillar 1
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), whiteGlass);
        world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), whitePane);
        world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), whitePane);
        //Pillar 2
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 1), lightGrayGlass);
        world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), lightGrayGlassPane);
        world.setBlockState(new BlockPos(x + 4, y + 3, z + 1), whitePane);
        world.setBlockState(new BlockPos(x + 4, y + 4, z + 1), lightGrayGlassPane);
        //Pillar 3
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 1), whitePane);
        //Pillar 4
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 1), lightGrayGlass);
        world.setBlockState(new BlockPos(x + 7, y + 2, z + 1), whiteGlass);
        world.setBlockState(new BlockPos(x + 7, y + 3, z + 1), whitePane);
        world.setBlockState(new BlockPos(x + 7, y + 4, z + 1), lightGrayGlassPane);
        //Pillar 5
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 2), lightGrayGlassPane);
        //Pillar 6
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 3), whiteGlass);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 3), whitePane);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 3), lightGrayGlassPane);
        //Pillar 7
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 4), snowLayer1);
        //Pillar 8
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 5), lightGrayGlass);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 5), whiteGlass);
        world.setBlockState(new BlockPos(x + 9, y + 3, z + 5), whiteGlass);
        world.setBlockState(new BlockPos(x + 9, y + 4, z + 5), lightGrayGlassPane);
        //Pillar 9
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 7), whitePane);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 7), whitePane);
        //Pillar 10
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 8), whiteGlass);
        world.setBlockState(new BlockPos(x + 8, y + 2, z + 8), whitePane);
        //Pillar 11
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), whiteGlass);
        world.setBlockState(new BlockPos(x + 6, y + 2, z + 9), whitePane);
        //Pillar 12
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), lightGrayGlass);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), whiteGlass);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), whiteGlass);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), lightGrayGlassPane);
        //Pillar 13
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 9), whitePane);
        //Pillar 14
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 9), snowLayer1);
        //Pillar 15
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 8), whiteGlass);
        world.setBlockState(new BlockPos(x + 2, y + 2, z + 8), whitePane);
        //Pillar 16
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), whiteGlass);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), whitePane);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), whitePane);
        //Pillar 17
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 5), whitePane);
        //Pillar 18
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 3), lightGrayGlass);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 3), whiteGlass);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 3), whiteGlass);
        world.setBlockState(new BlockPos(x + 1, y + 4, z + 3), lightGrayGlassPane);
        //Snows
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 2), snowLayer1);
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 2), snowLayer1);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 2), snowLayer1);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 2), snowLayer1);

        world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), snowLayer1);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 3), snowLayer1);

        world.setBlockState(new BlockPos(x + 1, y + 1, z + 4), snowLayer1);
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 4), snowLayer1);
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 4), snowLayer1);
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 4), snowLayer1);

        world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), snowLayer1);

        world.setBlockState(new BlockPos(x + 8, y + 1, z + 6), snowLayer1);

        world.setBlockState(new BlockPos(x + 8, y + 1, z + 7), snowLayer1);

        world.setBlockState(new BlockPos(x + 3, y + 1, z + 8), snowLayer1);
        world.setBlockState(new BlockPos(x + 4, y + 1, z + 8), snowLayer1);

        world.setBlockState(new BlockPos(x + 3, y + 1, z + 9), snowLayer1);

        //Centre

        world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), ModBlocks.greaterAirCrystalBlock.getDefaultState());
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), lightGrayGlass);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), quartzSlab);
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), quartzSlab);

        return true;
    }
}

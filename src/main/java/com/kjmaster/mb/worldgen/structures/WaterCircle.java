package com.kjmaster.mb.worldgen.structures;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockSeaLantern;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pbill_000 on 10/08/2017.
 */
public class WaterCircle extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();
        IBlockState prismarine = Blocks.PRISMARINE.getStateFromMeta(0);
        IBlockState darkPrismarine = Blocks.PRISMARINE.getStateFromMeta(2);
        IBlockState bricksPrismarine = Blocks.PRISMARINE.getStateFromMeta(1);
        IBlockState seaLantern = Blocks.SEA_LANTERN.getDefaultState();
        IBlockState packedIce = Blocks.PACKED_ICE.getDefaultState();
        IBlockState ice = Blocks.ICE.getDefaultState();
        IBlockState darkBlueGlass = Blocks.STAINED_GLASS.getStateFromMeta(11);
        IBlockState lightBlueGlass = Blocks.STAINED_GLASS.getStateFromMeta(3);
        //Front row
        world.setBlockState(new BlockPos(x + 3, y, z + 1), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 4, y, z + 1), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 5, y, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 6, y, z + 1), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 7, y, z + 1), bricksPrismarine);
        //Second row
        world.setBlockState(new BlockPos(x + 2, y, z + 2), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 3, y, z + 2), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 4, y, z + 2), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 2), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 2), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 2), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 8, y, z + 2), bricksPrismarine);
        //Third row
        world.setBlockState(new BlockPos(x + 1, y, z + 3), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 2, y, z + 3), ice);
        world.setBlockState(new BlockPos(x + 3, y, z + 3), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 4, y, z + 3), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 3), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 3), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 3), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 8, y, z + 3), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 3), bricksPrismarine);
        //Fourth row
        world.setBlockState(new BlockPos(x + 1, y, z + 4), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 2, y, z + 4), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 4), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 4, y, z + 4), ice);
        world.setBlockState(new BlockPos(x + 5, y, z + 4), packedIce);
        world.setBlockState(new BlockPos(x + 6, y, z + 4), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 4), ice);
        world.setBlockState(new BlockPos(x + 8, y, z + 4), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 4), prismarine);
        //Fifth row
        world.setBlockState(new BlockPos(x + 1, y, z + 5), prismarine);
        world.setBlockState(new BlockPos(x + 2, y, z + 5), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 5), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 4, y, z + 5), packedIce);
        world.setBlockState(new BlockPos(x + 5, y, z + 5), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 5), packedIce);
        world.setBlockState(new BlockPos(x + 7, y, z + 5), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 8, y, z + 5), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 5), bricksPrismarine);
        //Sixth row
        world.setBlockState(new BlockPos(x + 1, y, z + 6), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 2, y, z + 6), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 6), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 4, y, z + 6), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 6), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 6), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 6), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 8, y, z + 6), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 6), prismarine);
        //Seventh row
        world.setBlockState(new BlockPos(x + 1, y, z + 7), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 2, y, z + 7), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 3, y, z + 7), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 4, y, z + 7), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 7), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 7), ice);
        world.setBlockState(new BlockPos(x + 7, y, z + 7), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 8, y, z + 7), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 9, y, z + 7), bricksPrismarine);
        //Eighth row
        world.setBlockState(new BlockPos(x + 2, y, z + 8), prismarine);
        world.setBlockState(new BlockPos(x + 3, y, z + 8), ice);
        world.setBlockState(new BlockPos(x + 4, y, z + 8), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 5, y, z + 8), darkBlueGlass);
        world.setBlockState(new BlockPos(x + 6, y, z + 8), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 7, y, z + 8), lightBlueGlass);
        world.setBlockState(new BlockPos(x + 8, y, z + 8), bricksPrismarine);
        //Ninth row
        world.setBlockState(new BlockPos(x + 3, y, z + 9), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 4, y, z + 9), prismarine);
        world.setBlockState(new BlockPos(x + 5, y, z + 9), bricksPrismarine);
        world.setBlockState(new BlockPos(x + 6, y, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y, z + 9), bricksPrismarine);
        //Pillar 1
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 3, y + 2, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 3, y + 3, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 3, y + 4, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 3, y + 5, z + 1), seaLantern);
        //Pillar 2
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 2, z + 1), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 3, z + 1), darkPrismarine);
        //Pillar 3
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 2), prismarine);
        world.setBlockState(new BlockPos(x + 8, y + 2, z + 2), seaLantern);
        //Pillar 4
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 3), darkPrismarine);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 3), darkPrismarine);
        //Pillar 5
        world.setBlockState(new BlockPos(x + 9, y + 1, z + 7), darkPrismarine);
        world.setBlockState(new BlockPos(x + 9, y + 2, z + 7), darkPrismarine);
        //Pillar 6
        world.setBlockState(new BlockPos(x + 8, y + 1, z + 8), prismarine);
        //Pillar 7
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 2, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 3, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 4, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 5, z + 9), seaLantern);
        //Pillar 8
        world.setBlockState(new BlockPos(x + 3, y + 1, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 3, y + 2, z + 9), darkPrismarine);
        world.setBlockState(new BlockPos(x + 3, y + 3, z + 9), darkPrismarine);
        //Pillar 9
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 7), darkPrismarine);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 7), darkPrismarine);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 7), seaLantern);
        //Pillar 10
        world.setBlockState(new BlockPos(x + 1, y + 1, z + 3), darkPrismarine);
        world.setBlockState(new BlockPos(x + 1, y + 2, z + 3), darkPrismarine);
        world.setBlockState(new BlockPos(x + 1, y + 3, z + 3), darkPrismarine);
        //Pillar 11
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), prismarine);
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), darkPrismarine);
        //Random Blocks
        world.setBlockState(new BlockPos(x + 6, y + 1, z + 3), darkPrismarine);
        world.setBlockState(new BlockPos(x + 2, y + 1, z + 6), darkPrismarine);
        world.setBlockState(new BlockPos(x + 7, y + 1, z + 6), darkPrismarine);
        //Centre
        world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), packedIce);
        world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), ModBlocks.greaterWaterCrystalBlock.getDefaultState());
        return true;
    }

}

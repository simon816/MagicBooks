package com.kjmaster.mb.worldgen.structures;

import com.kjmaster.mb.MagicBooks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pbill_000 on 07/08/2017.
 */
public class StructureGenerator implements IWorldGenerator {

    FireCircle fireCircle = new FireCircle();
    EarthCircle earthCircle = new EarthCircle();
    AirCircle airCircle = new AirCircle();
    WaterCircle waterCircle = new WaterCircle();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0:
                this.runEarthCircleGenerator(world, random, chunkX, chunkZ);
                this.runAirCircleGenerator(world, random, chunkX, chunkZ);
                this.runWaterCircleGenerator(world, random, chunkX, chunkZ);
                this.runFireCircleGenerator(world, random, chunkX, chunkZ);
                break;
            case 1:
                break;
            case -1:
                break;
            default:
                break;
        }
    }

    public void runWaterCircleGenerator(World world, Random random, int chunkX, int chunkZ) {
        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);
        int xy = x >> 4;
        int zy = z >> 4;
        int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
        int y = height-1;
        if((random.nextInt(2000) + 1) <= 4) {
            if(isInWaterBiome(world, x, y, z))
                waterCircle.generate(world, random, new BlockPos(x, y, z));
        }
    }

    public void runFireCircleGenerator(World world, Random random, int chunkX, int chunkZ) {
        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);
        int xy = x >> 4;
        int zy = z >> 4;
        int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
        int y = height-1;
        if(isOnBlock(world, x, y, z) && hasFloor(world, x, y, z) && isInFireBiome(world, x, y, z)) {
            MagicBooks.LOGGER.info("Test 3");
            if((random.nextInt(50) + 1) <= 4) {
                MagicBooks.LOGGER.info("Test 4");
                boolean place = false;
                int m = 0;
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < 10; k++) {
                        for(int i = 0; i < 10; i++) {
                            if((world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock().equals(Blocks.AIR))
                                    || (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock().equals(Blocks.TALLGRASS))
                                    || (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() instanceof BlockFlower))  {
                                MagicBooks.LOGGER.info("Test 5");
                                m++;
                            }
                        }
                    }
                }
                MagicBooks.LOGGER.info("Blocks " + m);
                if(m > 499)
                    place = true;
                if(place) {
                    fireCircle.generate(world, random, new BlockPos(x, y, z));
                }
            }
        }
    }

    public void runEarthCircleGenerator(World world, Random random, int chunkX, int chunkZ) {
        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);
        int xy = x >> 4;
        int zy = z >> 4;
        int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
        int y = height-1;
        if(isOnBlock(world, x, y, z) && hasFloor(world, x, y, z) && isInEarthBiome(world, x, y, z)) {
            if((random.nextInt(50) + 1) <= 4) {
                boolean place = false;
                int m = 0;
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < 10; k++) {
                        for(int i = 0; i < 10; i++) {
                            if((world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock().equals(Blocks.AIR))
                                    || (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock().equals(Blocks.TALLGRASS))
                                    || (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() instanceof BlockFlower))  {
                                m++;
                            }
                        }
                    }
                }
                MagicBooks.LOGGER.info("Blocks " + m);
                if(m > 499)
                    place = true;
                if(place) {
                    earthCircle.generate(world, random, new BlockPos(x, y, z));
                }
            }
        }
    }


    public void runAirCircleGenerator(World world, Random random, int chunkX, int chunkZ) {
        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);
        int xy = x >> 4;
        int zy = z >> 4;
        int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
        int y = height-1;
        if(isOnBlock(world, x, y, z) && hasFloor(world, x, y, z) && isInAirBiome(world, x, y, z)) {
            if((random.nextInt(50) + 1) <= 4) {
                boolean place = false;
                int m = 0;
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < 10; k++) {
                        for(int i = 0; i < 10; i++) {
                            if((world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock().equals(Blocks.AIR))
                                    || (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock().equals(Blocks.TALLGRASS))
                                    || (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() instanceof BlockFlower))  {
                                m++;
                            }
                        }
                    }
                }
                MagicBooks.LOGGER.info("Blocks " + m);
                if(m > 499)
                    place = true;
                if(place) {
                    airCircle.generate(world, random, new BlockPos(x, y, z));
                }
            }
        }
    }

    public boolean isInEarthBiome(World world, int x, int y, int z) {
        Class biomeClass = world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass();
        if(biomeClass.equals(BiomePlains.class))
            return true;
        else if(biomeClass.equals(BiomeForest.class))
            return true;
        else if(biomeClass.equals(BiomeHills.class))
            return true;
        else if(biomeClass.equals(BiomeSavanna.class))
            return true;
        else
            return false;

    }

    public boolean isInAirBiome(World world, int x, int y, int z) {
        Class biomeClass = world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass();
        if(biomeClass.equals(BiomeSnow.class))
            return true;
        else
            return false;
    }

    public boolean isInFireBiome(World world, int x, int y, int z) {
        Class biomeClass = world.getBiomeForCoordsBody(new BlockPos(x, y, z)).getBiomeClass();
        if(biomeClass.equals(BiomeDesert.class))
            return true;
        else if (biomeClass.equals(BiomeSavanna.class))
            return true;
        else if (biomeClass.equals(BiomeHell.class))
            return true;
        else
            return false;
    }

    public boolean isInWaterBiome(World world, int x, int y, int z) {
        Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, y, z));
        if(biome instanceof BiomeOcean)
            return true;
        else
            return false;
    }

    public boolean isInWater(World world, int x, int y, int z) {
        List<IBlockState> validWater = new ArrayList<IBlockState>();
        for(int j = 0; j < 5; j++) {
            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 10; i++) {
                    validWater.add(world.getBlockState(new BlockPos(i + x, y + j + 1, k + z)));
                }
            }
        }
        for (int i = 0; i < validWater.size(); i++) {
            IBlockState state = validWater.get(i);
            if(!(state == Blocks.WATER.getDefaultState()) || !(state == Blocks.FLOWING_WATER.getDefaultState())) {
                return false;
            }
        }
        return true;
    }


    public boolean isOnBlock(World world, int x, int y, int z) {
        IBlockState blockState = world.getBlockState(new BlockPos(x, y, z));
        IBlockState grass = Blocks.GRASS.getDefaultState();
        IBlockState stone = Blocks.STONE.getDefaultState();
        IBlockState sand = Blocks.SAND.getStateFromMeta(0);
        IBlockState gravel = Blocks.GRAVEL.getDefaultState();
        IBlockState netherrack = Blocks.NETHERRACK.getDefaultState();
        if(blockState.equals(grass))
            return true;
        else if(blockState.equals(stone))
            return true;
        else if(blockState.equals(sand))
            return true;
        else if(blockState.equals(gravel))
            return true;
        else if(blockState.equals(netherrack))
            return true;
        else return false;
    }
    public boolean hasFloor(World world, int x, int y, int z) {
        int m = 0;
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++ ) {
                Block block = world.getBlockState(new BlockPos(x + i, y, z + k)).getBlock();
                if(block.equals(Blocks.AIR) || block.equals(Blocks.WATER) || block.equals(Blocks.FLOWING_WATER))
                    m++;
            }
        }
        MagicBooks.LOGGER.info("Floor Air Blocks: " + m);
        return m < 1;
    }


}

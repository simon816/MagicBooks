package com.kjmaster.mb.worldgen;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by pbill_000 on 24/07/2017.
 */
public class OreGen implements IWorldGenerator {
    //World generators
    private WorldGenerator airShardOre;
    private WorldGenerator earthShardOre;
    private WorldGenerator fireShardOre;
    private WorldGenerator waterShardOre;

    public OreGen() {
        airShardOre = new WorldGenMinable(ModBlocks.airShardOre.getDefaultState(), 4);
        earthShardOre = new WorldGenMinable(ModBlocks.earthShardOre.getDefaultState(), 4);
        fireShardOre = new WorldGenMinable(ModBlocks.fireShardOre.getDefaultState(), 4);
        waterShardOre = new WorldGenMinable(ModBlocks.waterShardOre.getDefaultState(), 4);
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()) {
            case 0: // Overworld
                this.runGenerator(airShardOre, world, random, chunkX, chunkZ, 5, 5, 18 );
                this.runGenerator(earthShardOre, world, random, chunkX, chunkZ, 5, 5, 18 );
                this.runGenerator(fireShardOre, world, random, chunkX, chunkZ, 5, 5, 18 );
                this.runGenerator(waterShardOre, world, random, chunkX, chunkZ, 5, 5, 18 );
        }
    }
}

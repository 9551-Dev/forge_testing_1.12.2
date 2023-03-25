package com.example.examplemod.world;

import com.example.examplemod.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class TestWorldGen implements IWorldGenerator {
    private final WorldGenMinable overworld;

    public TestWorldGen() {
        overworld = new WorldGenMinable(ModBlocks.TESTBLOCK.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.AIR));

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionType()) {
            case NETHER:
                break;
            case OVERWORLD:
                genStandard(overworld,world,random,chunkX,chunkZ,100,1,255);
                break;
            case THE_END:
                genStandard(overworld,world,random,chunkX,chunkZ,100,1,255);
                break;
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void genStandard(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int spawnTries, int minHeight, int maxHeight) {
        BlockPos chunkPosAsBlockPos = new BlockPos(chunkX << 4, 0, chunkZ << 4);
        int heightDiff = maxHeight - minHeight + 1;

        for (int i = 0; i < spawnTries; i++) {
            generator.generate(world, random,
                    chunkPosAsBlockPos.add(
                            random.nextInt(16),
                            minHeight + random.nextInt(heightDiff),
                            random.nextInt(16)
                    )
            );
        }
    }
}

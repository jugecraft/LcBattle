package com.lcbattle;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.Material;
import java.util.Random;

public class ChunkProviderGenerate extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);

        // Lógica personalizada de generación de chunk
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int highestBlock = world.getHighestBlockYAt(chunkX * 16 + x, chunkZ * 16 + z);
                chunkData.setBlock(x, highestBlock, z, Material.STONE); // Cambiar por lo que desees
            }
        }

        return chunkData;
    }
}

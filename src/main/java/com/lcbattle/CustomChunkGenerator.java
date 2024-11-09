package com.lcbattle;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);

        // Ejemplo de generación personalizada
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int highestY = world.getHighestBlockYAt(chunkX * 16 + x, chunkZ * 16 + z);
                chunkData.setBlock(x, highestY, z, Material.STONE); // Establece piedra en el nivel más alto
            }
        }

        return chunkData;
    }
}

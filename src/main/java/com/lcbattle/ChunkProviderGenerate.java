package com.lcbattle;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class ChunkProviderGenerate extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        // Crear una instancia de ChunkData
        ChunkData chunkData = createChunkData(world);

        // Puedes generar bloques en el chunk usando chunkData.setBlock(x, y, z, Material)
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 64; y++) { // Asumiendo una altura de 64
                    // Colocar bloques de piedra en el chunk
                    chunkData.setBlock(x, y, z, Material.STONE); // Cambia Material.STONE por el material que desees
                }
            }
        }

        // Devuelve el ChunkData con la generación personalizada
        return chunkData;
    }
}

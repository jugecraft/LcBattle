package com.lcbattle;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {

    @Override
    public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
        byte[] chunk = new byte[32768];  // Un chunk tiene 16x16x128 bloques (16x16 es el tamaño horizontal, 128 es la altura máxima)

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 64; y++) {  // Asumiendo una altura de 64
                    // Calculamos el índice en el arreglo (16x16x64)
                    int index = (x * 16 + z) * 128 + y;
                    // Asignamos el valor de un bloque (usando el id de material para STONE)
                    chunk[index] = (byte) Material.STONE.getId();  // Cambia Material.STONE por el material que desees
                }
            }
        }

        return chunk;
    }
}

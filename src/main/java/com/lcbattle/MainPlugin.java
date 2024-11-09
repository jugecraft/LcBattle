package com.lcbattle;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registrar el generador de chunks personalizado
        // En este caso, creamos un mundo con el generador personalizado

        WorldCreator worldCreator = new WorldCreator("myCustomWorld");
        worldCreator.generator(new com.lcbattle.ChunkProviderGenerate());  // Usamos nuestro generador personalizado

        World world = Bukkit.createWorld(worldCreator);
        // Ahora 'world' tiene el generador que has creado
        getLogger().info("Mundo personalizado creado con el generador CustomChunkGenerator");
    }
}

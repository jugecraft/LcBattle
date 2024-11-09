package com.lcbattle;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class LcBattlePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Crear un mundo con el generador personalizado
        WorldCreator creator = new WorldCreator("nombre_del_mundo");  // Nombre del mundo
        creator.generator(new ChunkProviderGenerate());  // Usamos el generador personalizado
        World world = creator.createWorld();  // Crea el mundo con ese generador

        getLogger().info("Mundo generado con generador personalizado.");
    }

    @Override
    public void onDisable() {
        // Lógica para limpiar recursos si es necesario
        getLogger().info("Plugin desactivado.");
    }
}

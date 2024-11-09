package com.lcbattle;

import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    private CommandManager commandManager;

    @Override
    public void onEnable() {
        // Configuración del plugin
        saveDefaultConfig();

        // Inicializar el manejador de comandos
        commandManager = new CommandManager(this);

        // Registrar comandos
        getCommand("lcbt").setExecutor(commandManager);

        getLogger().info("Plugin habilitado.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deshabilitado.");
    }
}

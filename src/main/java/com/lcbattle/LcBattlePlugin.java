package com.lcbattle;

import org.bukkit.plugin.java.JavaPlugin;

public class LcBattlePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registrar el Listener del Evento
        getServer().getPluginManager().registerEvents(new LcBattleListener(this), this);

        // Registrar el comando principal 'lcbt' pasando la instancia de LcBattlePlugin
        this.getCommand("lcbt").setExecutor(new LcBattleCommands(this));

        // Registrar el comando 'lobby' que teletransporta al jugador al lobby
        this.getCommand("lobby").setExecutor(new LobbyCommand());

        // Registrar el comando 'importworld' para importar un mundo
        this.getCommand("importworld").setExecutor(new ImportWorldCommand(this));

        // También puedes cargar tu configuración o inicializar valores aquí si lo necesitas
        saveDefaultConfig(); // Asegúrate de que el archivo config.yml se cargue si no existe
    }

    @Override
    public void onDisable() {
        // Código para apagar el plugin si es necesario
        // Por ejemplo, guardar configuraciones o realizar alguna limpieza
    }
}

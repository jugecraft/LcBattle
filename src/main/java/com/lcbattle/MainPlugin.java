package com.lcbattle;

import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Configurar comandos
        getCommand("lcbt").setExecutor(new LcBattleCommands(this));

        // Registra eventos, si es necesario
        getServer().getPluginManager().registerEvents(new LcBattleListener(), this);

        // Otras configuraciones iniciales
        getLogger().info("LcBattle Plugin habilitado!");
    }

    @Override
    public void onDisable() {
        // Código de limpieza cuando el plugin se desactive
        getLogger().info("LcBattle Plugin deshabilitado!");
    }
}

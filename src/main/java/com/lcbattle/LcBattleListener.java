package com.lcbattle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LcBattleListener implements Listener {

    private final LcBattlePlugin plugin;

    // Constructor para acceder a la instancia de LcBattlePlugin
    public LcBattleListener(LcBattlePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Cargar mensaje de bienvenida desde la configuración o usar un valor predeterminado
        String welcomeMessage = plugin.getConfig().getString("player-join-message", "¡Bienvenido al LcBattle!");

        // Reemplazar {{player}} con el nombre del jugador
        welcomeMessage = welcomeMessage.replace("{{player}}", event.getPlayer().getName());

        // Enviar mensaje al jugador que se une
        event.getPlayer().sendMessage(welcomeMessage);

        // También enviar un mensaje a todos los demás jugadores (opcional)
        event.setJoinMessage(welcomeMessage);
    }
}

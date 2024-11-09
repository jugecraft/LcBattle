package com.lcbattle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LcBattleListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Lógica para eventos de jugadores, como cuando un jugador se une al servidor
        event.getPlayer().sendMessage("¡Bienvenido al LcBattle!");
    }
}

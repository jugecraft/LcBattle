package com.lcbattle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Verificar si el mundo 'world' está cargado
            World world = Bukkit.getWorld("world");
            if (world == null) {
                player.sendMessage("El mundo 'world' no está cargado.");
                return false;
            }

            // Definir la ubicación del lobby (cambia las coordenadas según tu mapa)
            Location lobbyLocation = new Location(world, 100, 65, 100); // Cambiar las coordenadas

            // Teletransportar al jugador al lobby
            player.teleport(lobbyLocation);
            player.sendMessage("Te has teletransportado al lobby.");
            return true;
        } else {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
            return false;
        }
    }
}

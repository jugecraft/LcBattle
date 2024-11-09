package com.lcbattle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LcBattleCommands implements CommandExecutor {

    private final LcBattlePlugin plugin;

    // Constructor que recibe la instancia del plugin
    public LcBattleCommands(LcBattlePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
            return false;
        }

        Player player = (Player) sender;

        // Verificar permisos
        if (!player.hasPermission("lcbattle.admin")) {
            player.sendMessage("No tienes permiso para ejecutar este comando.");
            return false;
        }

        // Comandos y lógica
        if (args.length == 0) {
            player.sendMessage("Uso: /lcbt <comando>");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "top":
                // Mostrar los mejores jugadores (ejemplo, implementa la lógica que necesites)
                player.sendMessage("Comando /lcbt top ejecutado.");
                break;

            case "setlobby":
                // Guardar ubicación del lobby
                plugin.getConfig().set("lobby", player.getLocation());
                plugin.saveConfig();
                player.sendMessage("¡Lobby configurado correctamente!");
                break;

            case "setspawn":
                // Guardar ubicación del spawn
                plugin.getConfig().set("spawn", player.getLocation());
                plugin.saveConfig();
                player.sendMessage("¡Spawn configurado correctamente!");
                break;

            case "lobby":
                // Teletransportar al jugador al lobby
                Location lobbyLocation = (Location) plugin.getConfig().get("lobby");
                if (lobbyLocation != null) {
                    player.teleport(lobbyLocation);
                    player.sendMessage("¡Te has teletransportado al lobby!");
                } else {
                    player.sendMessage("El lobby no está configurado.");
                }
                break;

            case "import":
                // Importar un mundo
                if (args.length > 1) {
                    String worldNameToImport = args[1];
                    World world = Bukkit.getServer().getWorld(worldNameToImport);
                    if (world != null) {
                        player.teleport(world.getSpawnLocation());
                        player.sendMessage("¡Mundo " + worldNameToImport + " importado correctamente!");
                    } else {
                        player.sendMessage("El mundo no se pudo cargar.");
                    }
                } else {
                    player.sendMessage("Uso: /lcbt import <nombre_del_mundo>");
                }
                break;

            case "save":
                // Guardar mapa (puedes agregar la lógica específica para esto)
                player.sendMessage("¡Mapa guardado!");
                break;

            case "edit":
                // Editar mapa (puedes agregar la lógica específica para esto)
                player.sendMessage("¡Mapa editado!");
                break;

            case "reset":
                // Reiniciar el plugin (si es necesario, agrega la lógica de reinicio)
                player.sendMessage("¡Plugin reiniciado!");
                break;

            case "help":
                // Mostrar ayuda con los comandos disponibles
                player.sendMessage("Comandos disponibles:");
                player.sendMessage("/lcbt top - Mostrar los mejores jugadores");
                player.sendMessage("/lcbt setlobby - Configurar la ubicación del lobby");
                player.sendMessage("/lcbt setspawn - Configurar la ubicación del spawn");
                player.sendMessage("/lcbt lobby - Teletransportar al lobby");
                player.sendMessage("/lcbt import <nombre_del_mundo> - Importar un mundo");
                player.sendMessage("/lcbt save - Guardar el mapa");
                player.sendMessage("/lcbt edit - Editar el mapa");
                player.sendMessage("/lcbt reset - Reiniciar el plugin");
                break;

            default:
                player.sendMessage("Comando desconocido.");
                return false;
        }

        return true;
    }
}

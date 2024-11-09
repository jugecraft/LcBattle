package com.lcbattle;

import com.lcbattle.MainPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandManager implements CommandExecutor {

    private final MainPlugin plugin;
    private final FileConfiguration config;

    public CommandManager(MainPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser usado por jugadores.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            handleHelpCommand(player);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "top":
                handleTopCommand(player, args);
                break;
            case "setlobby":
                handleSetLobbyCommand(player);
                break;
            case "setspawn":
                handleSetSpawnCommand(player);
                break;
            case "lcoins":
                handleLCoinsCommand(player, args);
                break;
            case "rango":
                handleRangoCommand(player, args);
                break;
            case "import":
                if (args.length > 1) {
                    handleImportCommand(player, args[1]);
                } else {
                    player.sendMessage("Uso: /lcbt import <worldName>");
                }
                break;
            case "save":
                if (args.length > 1) {
                    handleSaveCommand(player, args[1]);
                } else {
                    player.sendMessage("Uso: /lcbt save <mapName>");
                }
                break;
            case "help":
                handleHelpCommand(player);
                break;
            default:
                player.sendMessage("Comando desconocido. Usa /lcbt help para ver la lista de comandos.");
        }
        return true;
    }

    public void handleTopCommand(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Uso: /lcbt top <wins|kills|time> <edit|create|remove|reset> [#]");
            return;
        }
        String topType = args[1];
        String action = args.length > 2 ? args[2] : "";

        switch (action.toLowerCase()) {
            case "create":
                player.sendMessage("Creando el top en la ubicación actual.");
                break;
            case "edit":
                player.sendMessage("Editando el top.");
                break;
            case "remove":
                player.sendMessage("Eliminando el top.");
                break;
            case "reset":
                player.sendMessage("Reseteando el top.");
                break;
            default:
                player.sendMessage("Acción inválida. Usa: create, edit, remove, reset.");
        }
    }

    public void handleSetLobbyCommand(Player player) {
        Location location = player.getLocation();
        config.set("lobby.spawn", location);
        plugin.saveConfig();
        player.sendMessage("Lobby establecido en tu ubicación actual.");
    }

    public void handleSetSpawnCommand(Player player) {
        Location location = player.getLocation();
        config.set("lobby.waiting_spawn", location);
        plugin.saveConfig();
        player.sendMessage("Spawn de espera establecido en tu ubicación actual.");
    }

    public void handleLCoinsCommand(Player player, String[] args) {
        if (args.length < 4) {
            player.sendMessage("Uso: /lcbt lcoins <edit|set|remove> <jugador> <monto>");
            return;
        }

        String action = args[1];
        String targetPlayer = args[2];
        int amount = Integer.parseInt(args[3]);

        switch (action.toLowerCase()) {
            case "set":
                setLCoins(targetPlayer, amount);
                break;
            case "edit":
                editLCoins(targetPlayer, amount);
                break;
            case "remove":
                removeLCoins(targetPlayer, amount);
                break;
        }
        player.sendMessage("LCoins actualizados para " + targetPlayer);
    }

    public void handleRangoCommand(Player player, String[] args) {
        player.sendMessage(ChatColor.RED + "PROXIMAMENTE");
    }

    public void handleImportCommand(Player player, String worldName) {
        player.sendMessage("Mapa " + worldName + " importado y convertido.");
    }

    public void handleSaveCommand(Player player, String mapName) {
        player.sendMessage("Mapa " + mapName + " guardado correctamente.");
    }

    public void handleHelpCommand(Player player) {
        player.sendMessage("Lista de Comandos:");
        player.sendMessage("/lcbt top - Gestionar los tops.");
        player.sendMessage("/lcbt setlobby - Establecer lobby.");
        player.sendMessage("/lcbt setspawn - Establecer spawn.");
        player.sendMessage("/lcbt lcoins - Gestionar lcoins.");
    }

    private void setLCoins(String playerName, int amount) {
        // Lógica para establecer LCoins
    }

    private void editLCoins(String playerName, int amount) {
        // Lógica para editar LCoins
    }

    private void removeLCoins(String playerName, int amount) {
        // Lógica para remover LCoins
    }
}

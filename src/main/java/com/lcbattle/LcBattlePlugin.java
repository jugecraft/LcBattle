package com.lcbattle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LcBattlePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("LcBattle Plugin activado!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LcBattle Plugin desactivado!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
            return false;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("lcbt")) {
            if (args.length == 0) {
                return false;
            }

            switch (args[0].toLowerCase()) {
                case "top":
                    return handleTopCommand(player, args);
                case "setlobby":
                    return handleSetLobbyCommand(player);
                case "setspawn":
                    return handleSetSpawnCommand(player);
                case "lcoins":
                    return handleLCoinsCommand(player, args);
                case "rango":
                    return handleRangoCommand(player);
                case "import":
                    return handleImportCommand(player, args);
                case "save":
                    return handleSaveCommand(player, args);
                case "edit":
                    return handleEditCommand(player, args);
                case "reset":
                    return handleResetCommand(player);
                case "help":
                    return handleHelpCommand(player);
                default:
                    return false;
            }
        }

        return false;
    }

    private boolean handleTopCommand(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Uso: /lcbt top <wins|kills|time> <edit|create|remove|reset>");
            return false;
        }

        String type = args[1].toLowerCase();
        switch (type) {
            case "edit":
                // Lógica para editar los tops
                break;
            case "create":
                // Lógica para crear los tops
                break;
            case "remove":
                // Lógica para remover los tops
                break;
            case "reset":
                // Lógica para reiniciar los tops
                break;
            default:
                player.sendMessage("Comando no reconocido.");
                return false;
        }
        return true;
    }

    private boolean handleSetLobbyCommand(Player player) {
        // Lógica para establecer el lobby
        player.sendMessage("Lobby establecido.");
        return true;
    }

    private boolean handleSetSpawnCommand(Player player) {
        // Lógica para establecer el spawn de espera
        player.sendMessage("Spawn de espera establecido.");
        return true;
    }

    private boolean handleLCoinsCommand(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Uso: /lcbt lcoins <edit|set|remove> <jugador> [monto]");
            return false;
        }

        String action = args[1].toLowerCase();
        String targetPlayer = args[2];
        int amount = args.length > 3 ? Integer.parseInt(args[3]) : 0;

        switch (action) {
            case "edit":
                // Lógica para editar Lcoins
                break;
            case "set":
                // Lógica para colocar Lcoins
                break;
            case "remove":
                // Lógica para quitar Lcoins
                break;
            default:
                player.sendMessage("Acción no reconocida.");
                return false;
        }

        return true;
    }

    private boolean handleRangoCommand(Player player) {
        player.sendMessage("PROXIMAMENTE");
        return true;
    }

    private boolean handleImportCommand(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Uso: /lcbt import <mundo>");
            return false;
        }

        String worldName = args[1];
        // Lógica para importar el mundo y convertirlo en un mapa
        return true;
    }

    private boolean handleSaveCommand(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Uso: /lcbt save <mapa>");
            return false;
        }

        String mapName = args[1];
        // Lógica para guardar el mapa
        return true;
    }

    private boolean handleEditCommand(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Uso: /lcbt edit <mapa> <tp|save|max_player|min_player|time> [numero]");
            return false;
        }

        String mapName = args[1];
        String action = args[2].toLowerCase();

        switch (action) {
            case "tp":
                // Lógica para teletransportarse al mapa
                break;
            case "save":
                // Lógica para guardar el mapa
                break;
            case "max_player":
            case "min_player":
            case "time":
                // Lógica para editar max_player, min_player, o time
                break;
            default:
                player.sendMessage("Acción no reconocida.");
                return false;
        }

        return true;
    }

    private boolean handleResetCommand(Player player) {
        // Lógica para reiniciar el plugin
        player.sendMessage("Plugin reiniciado.");
        return true;
    }

    private boolean handleHelpCommand(Player player) {
        player.sendMessage("Lista de comandos de LcBattle:");
        player.sendMessage("/lcbt top <wins|kills|time> <edit|create|remove|reset>");
        player.sendMessage("/lcbt setlobby");
        player.sendMessage("/lcbt setspawn");
        player.sendMessage("/lcbt lcoins <edit|set|remove> <jugador> [monto]");
        player.sendMessage("/lcbt rango");
        player.sendMessage("/lcbt import <mundo>");
        player.sendMessage("/lcbt save <mapa>");
        player.sendMessage("/lcbt edit <mapa> <tp|save|max_player|min_player|time>");
        player.sendMessage("/lcbt reset");
        return true;
    }
}

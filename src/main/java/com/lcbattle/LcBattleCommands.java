package com.lcbattle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LcBattleCommands implements CommandExecutor {

    private MainPlugin plugin;

    public LcBattleCommands(MainPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("lcbt")) {
                // Aquí agregas la lógica para los comandos específicos, como:
                if (args.length == 0) {
                    player.sendMessage("Comando inválido. Usa /lcbt help para obtener ayuda.");
                } else if (args[0].equalsIgnoreCase("top")) {
                    // Lógica para el comando /lcbt top
                    player.sendMessage("Comando /lcbt top");
                }
                // Añadir más condiciones para otros subcomandos
                return true;
            }
        }
        return false;
    }
}

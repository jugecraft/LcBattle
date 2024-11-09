package com.lcbattle;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ImportWorldCommand implements CommandExecutor {

    private final LcBattlePlugin plugin;

    // Constructor que recibe la instancia de LcBattlePlugin
    public ImportWorldCommand(LcBattlePlugin plugin) {
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

        if (args.length < 1) {
            player.sendMessage("Uso: /importworld <nombre_del_mundo>");
            return false;
        }

        String worldName = args[0];
        World world = Bukkit.getServer().getWorld(worldName);

        if (world == null) {
            try {
                world = Bukkit.getServer().createWorld(new WorldCreator(worldName));
                player.sendMessage("Mundo " + worldName + " importado exitosamente.");
            } catch (Exception e) {
                player.sendMessage("Hubo un error al crear el mundo.");
                e.printStackTrace();
            }
        } else {
            player.teleport(world.getSpawnLocation());
            player.sendMessage("El mundo ya está cargado, te has teletransportado a la ubicación de aparición.");
        }

        return true;
    }
}

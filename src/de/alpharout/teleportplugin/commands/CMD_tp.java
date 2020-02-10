package de.alpharout.teleportplugin.commands;

import de.alpharout.teleportplugin.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.xml.transform.stax.StAXResult;

public class CMD_tp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(strings.length == 1) {
                if(player.hasPermission("system.teleport.self")) {
                    try {
                        Player target = Bukkit.getPlayer(strings[0]);

                        Location goalLocation = target.getLocation();
                        player.teleport(goalLocation);

                        player.sendMessage(Data.getPrefix() + "§aDu hast dich zu " + target.getDisplayName() + " teleportiert!");
                    } catch (Exception e) {
                        player.sendMessage(Data.getPrefix() + "§cDu konntest dich leider nicht teleportieren...");
                    }
                } else {
                    player.sendMessage(Data.getPrefix() + "§cDazu hast du keine Berechtigung!");
                }

            } else if(strings.length == 2) {
                if(player.hasPermission("system.teleport.other")) {
                    try {
                        Player from = Bukkit.getPlayer(strings[0]);
                        Player to = Bukkit.getPlayer(strings[1]);

                        from.teleport(to.getLocation());

                        from.sendMessage(Data.getPrefix() + "§aDu wurdest zu " + to.getDisplayName() + " teleportiert!");

                        player.sendMessage(Data.getPrefix() + "§aDu hast " + from.getDisplayName() + " zu " + from.getDisplayName() + " teleportiert!");

                    } catch (Exception e) {
                        player.sendMessage(Data.getPrefix() + "§cDu konntest leider nicht teleportieren...");
                    }
                } else {
                    player.sendMessage(Data.getPrefix() + "§cDazu hast du keine Berechtigung!");
                }

            } else {
                player.sendMessage(Data.getPrefix() + "§cBitte benutze /tp <Spieler> oder /tp <Spieler> <Spieler>");
            }


        } else {
            Data.log("§cDu musst ein Spieler sein, um diesen Command ausführen zu können!");
        }
        return false;
    }
}

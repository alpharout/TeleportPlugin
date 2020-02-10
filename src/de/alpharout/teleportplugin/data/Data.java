package de.alpharout.teleportplugin.data;

import de.alpharout.teleportplugin.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Data {
    private static String prefix = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("prefix"));

    public static String getPrefix() {
        return prefix;
    }

    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }
}

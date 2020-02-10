package de.alpharout.teleportplugin.main;

import de.alpharout.teleportplugin.commands.CMD_tp;
import de.alpharout.teleportplugin.data.Data;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.getConfig().addDefault("prefix", "&8[&bTP&8] ");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        Data.log("§7Das Teleportplugin wurde aktiviert! Programmiert von §calphaR0ut");

        this.getCommand("tp").setExecutor(new CMD_tp());
    }

    @Override
    public void onDisable() {
        Data.log("§7Das Teleportplugin wurde deaktiviert! Programmiert von §calphaR0ut");
    }

    public static Main getInstance() {
        return INSTANCE;
    }
}

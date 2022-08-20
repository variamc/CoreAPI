package de.variamc.coreapi;

import de.variamc.coreapi.utils.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * Class created by Kaseax on 2022
 */
public class CoreAPI extends JavaPlugin {

    private static CoreAPI instance;
    private static String prefix = "§8» §eVaria§6MC §r";

    @Override
    public void onLoad() {
        instance = this;
        Config config = new Config("config.yml", getDataFolder());
        if(!config.getConfig().contains("mysql.host")) {
            config.getConfig().set("mysql.host", "localhost");
        }
        if(!config.getConfig().contains("mysql.port")) {
            config.getConfig().set("mysql.port", 3306);
        }
        if(!config.getConfig().contains("mysql.database")) {
            config.getConfig().set("mysql.database", "coreapi");
        }
        if(!config.getConfig().contains("mysql.user")) {
            config.getConfig().set("mysql.user", "root");
        }
        if(!config.getConfig().contains("mysql.password")) {
            config.getConfig().set("mysql.password", "");
        }
        try {
            config.getConfig().save(config.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static CoreAPI getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }
}

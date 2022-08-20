package de.variamc.coreapi;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class created by Kaseax on 2022
 */
public class CoreAPI extends JavaPlugin {

    private static CoreAPI instance;

    @Override
    public void onLoad() {
        instance = this;
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
}

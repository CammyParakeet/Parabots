package com.parakeetstudios.parabots.plugin;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.ParabotsAPI;
import com.parakeetstudios.parabots.core.VanillaBotManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ParabotsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(this.getName() + " has started!");

        ParabotsAPI.getInstance().initialize(new VanillaBotManager());

    }

    @Override
    public void onDisable() {
        getLogger().info(this.getName() + " is shutting down");
        ParabotsAPI.getInstance().shutdown();
    }

}

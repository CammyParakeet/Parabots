package com.parakeetstudios.parabots.plugin;

import com.parakeetstudios.parabots.api.ParabotsAPI;
import com.parakeetstudios.parabots.core.HumanSkinManager;
import com.parakeetstudios.parabots.core.VanillaBotManager;
import com.parakeetstudios.parabots.core.v1_20_R1.EntityProgramRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class ParabotsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(this.getName() + " has started!");
        ParabotsAPI.getInstance().initialize(new VanillaBotManager(), new HumanSkinManager());
        try {
            EntityProgramRegistry.registerBuilders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(this.getName() + " is shutting down");
        ParabotsAPI.getInstance().shutdown();
    }

}

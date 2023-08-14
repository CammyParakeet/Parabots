package com.parakeetstudios.parabots.plugin;

import com.parakeetstudios.parabots.api.ParabotsAPI;
import com.parakeetstudios.parabots.core.HumanSkinManager;
import com.parakeetstudios.parabots.core.VanillaBotManager;
import com.parakeetstudios.parabots.core.utils.Paralog;
import com.parakeetstudios.parabots.core.v1_20_R1.EntityProgramRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class ParabotsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Paralog.init(getLogger());
        Paralog.info(this.getName() + " Is initializing...");

        // Initialize API singleton
        ParabotsAPI.getInstance().initialize(new VanillaBotManager(), new HumanSkinManager());

        // Register entity programs
        try {
            EntityProgramRegistry.registerPrograms();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Paralog.info(this.getName() + " has been initialized");
    }

    @Override
    public void onDisable() {
        getLogger().info(this.getName() + " is shutting down");
        ParabotsAPI.getInstance().shutdown();
    }

}

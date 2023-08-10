package com.parakeetstudios.parabots.api;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/*
* Main Entry point to the Parabots Interface
*
*/
public final class ParabotsAPI {

    private BotManager botManager;

    private ParabotsAPI() {};

    private static final class InstanceHolder {
        private static final ParabotsAPI instance = new ParabotsAPI();
    }

    /**
     * Get the singleton instance of ParabotsAPI.
     * @return The ParabotsAPI instance.
     */
    public static ParabotsAPI getInstance() {
        return InstanceHolder.instance;
    }

    public BotManager getBotManager() {
        return botManager;
    }

    /**
     * Initializes the {@link ParabotsAPI} with a specific {@link BotManager} instance.
     * <p>
     * This method is intended to be called only once during the lifecycle of the API to set
     * its {@link BotManager}. Any subsequent invocations will result in an {@link IllegalStateException}.
     * </p>
     * <p>
     * It is recommended to invoke this method early in the startup sequence, ideally from
     * the main plugin class's onEnable method to ensure the API is properly initialized.
     * </p>
     *
     * @param manager The {@link BotManager} instance to be used by the API.
     * @throws IllegalStateException if the method is called more than once.
     */
    public synchronized void initialize(BotManager manager) {
        if (this.botManager == null) {
            this.botManager = manager;
        } else {
            throw new IllegalStateException("ParabotsAPI has already been initialized");
        }
    }

    public void shutdown() {
        if (botManager == null) return;
        botManager.cleanUp();
        botManager = null;
    }
}

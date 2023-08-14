package com.parakeetstudios.parabots.api;

import org.bukkit.Bukkit;

import java.util.Objects;

/*
* Main Entry point to the Parabots Interface
*
*/
public final class ParabotsAPI {

    private BotManager botManager;
    private SkinManager skinManager;

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

    public SkinManager getSkinManager() {
        return skinManager;
    }

    /**
     * Initializes the {@link ParabotsAPI} with a specific {@link BotManager} and {@link SkinManager} instance.
     * <p>
     * This method is intended to be called only once during the lifecycle of the API to set
     * its {@link BotManager} & {@link SkinManager}. Any subsequent invocations will result in an {@link IllegalStateException}.
     * </p>
     * <p>
     * It is recommended to invoke this method early in the startup sequence, ideally from
     * the main plugin class's onEnable method to ensure the API is properly initialized.
     * </p>
     *
     * @param botManager The {@link BotManager} instance to be used by the API.
     * @param skinManager The {@link SkinManager} instance to be used by the API.
     * @throws IllegalStateException if the method is called more than once.
     */
    public synchronized void initialize(BotManager botManager, SkinManager skinManager) {
        if (this.botManager == null && this.skinManager == null) {
            this.botManager = botManager;
            this.skinManager = skinManager;
            Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("Parabots")).getLogger().info("INITIALIZED!!");
        } else {
            throw new IllegalStateException("ParabotsAPI has already been initialized");
        }
    }

    /**
     * Safely shuts down the ParabotsAPI, ensuring that any associated resources
     * are released and cleaned up.
     * <p>
     * This method will:
     * <ul>
     *     <li>Invoke the cleanup process for both the bot manager and the skin manager, if they are initialized.</li>
     *     <li>Set the references to the bot manager and skin manager to {@code null} after cleanup.</li>
     * </ul>
     * </p>
     * <p>
     * Note: This method is synchronized to ensure thread-safety. If multiple threads attempt
     * to shut down simultaneously, only one will execute the method at a time.
     * </p>
     * <p>
     * After invoking this method, the ParabotsAPI instance will not be functional
     * until reinitialized.
     * </p>
     */
    public synchronized void shutdown() {
        if (this.botManager != null) {
            this.botManager.cleanUp();
            this.botManager = null;
        }
        if (this.skinManager != null) {
            this.skinManager.cleanUp();
            this.skinManager = null;
        }
    }
}

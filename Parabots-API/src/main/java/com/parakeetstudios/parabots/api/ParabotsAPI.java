package com.parakeetstudios.parabots.api;

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

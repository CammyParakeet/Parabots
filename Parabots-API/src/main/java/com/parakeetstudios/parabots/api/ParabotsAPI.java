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

    private final BotManager botManager;

    private ParabotsAPI(BotManager manager) {
        this.botManager = manager;
    };

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

    /**
     * Create a new bot.
     * @param type The type of bot.
     * @param name The name of the bot.
     * @param location The location to spawn the bot.
     * @return The created Parabot instance.
     */
    public Parabot createBot(EntityType type, String name, Location location) {
        return botManager.createBot(type, name, location);
    }

    /**
     * Retrieve a bot by its UUID.
     * @param botID The UUID of the bot.
     * @return The Parabot instance, or null if no bot with the given UUID exists.
     */
    public Parabot getBotByID(UUID botID) {
        return botManager.getBotByID(botID);
    }
}

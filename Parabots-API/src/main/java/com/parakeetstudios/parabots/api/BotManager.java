package com.parakeetstudios.parabots.api;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.List;
import java.util.UUID;

/**
 * Represents a manager responsible for handling the life cycle, creation, and management
 * of {@link Parabot} instances in the game environment.
 *
 * <p>This interface provides methods to create, retrieve, manage, and remove
 * Parabot instances, ensuring systematic handling of bot entities.</p>
 */
public interface BotManager {

    /**
     * Creates and registers a new {@link Parabot} of the specified entity type and name,
     * to be initialized at a given location in the game world.
     *
     * @param type The type of the bot's entity.
     * @param name The name of the bot.
     * @param location The initial location of the bot in the game world.
     * @return The newly created Parabot instance.
     */
    Parabot createBot(EntityType type, String name, Location location);

    /**
     * Creates and registers a new {@link Parabot} of the specified entity type and name,
     * to be initialized at a default location.
     *
     * @param type The type of the bot's entity.
     * @param name The name of the bot.
     * @return The newly created Parabot instance.
     */
    Parabot createBot(EntityType type, String name);

    /**
     * Retrieves a specific {@link Parabot} instance based on its unique ID.
     *
     * @param botID The unique ID of the bot to retrieve.
     * @return The Parabot instance if found; {@code null} otherwise.
     */
    Parabot getBotByID(UUID botID);

    /**
     * Retrieves a list of all currently registered {@link Parabot} instances managed by this manager.
     *
     * @return A list of all active Parabots.
     */
    List<Parabot> getAllParabots();

    /**
     * Removes and unregisters a specific {@link Parabot} based on its unique ID.
     * Implementations should ensure that the bot and any associated resources are properly cleaned up.
     *
     * @param botID The unique ID of the bot to remove.
     */
    void removeBot(UUID botID);

    /**
     * Attempts to spawn all registered {@link Parabot} instances into the game world.
     * Implementations should handle any necessary spawning logic and conditions.
     */
    void spawnAllBots();

    /**
     * Attempts to despawn and remove all active {@link Parabot} instances from the game world.
     * Implementations should ensure bots are properly removed without leaving any traces.
     */
    void despawnAllBots();

    void cleanUp();
}

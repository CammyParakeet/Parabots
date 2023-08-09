package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

/**
 * Represents a program responsible for managing the life cycle and behavior
 * of an in-game entity associated with a {@link Parabot}.
 *
 * <p>This interface provides a set of methods for creating, managing,
 * and disposing of the entity. Implementers of this interface should ensure
 * the correct behavior of the bot based on these provided methods.</p>
 */
public interface EntityProgram {

    /**
     * Builds or prepares the entity associated with the given {@link Parabot} at a specified location.
     *
     * @param bot The Parabot instance for which the entity is to be built.
     * @param loc The location in the game world where the entity should be initialized.
     */
    void build(Parabot bot, Location loc);

    /**
     * Cleans up any resources or states associated with this program and the underlying entity.
     * This method should be called when the entity is no longer needed.
     */
    void dispose();

    /**
     * Attempts to spawn the entity in the game world at the given location and for a specified reason.
     *
     * @param location The location in the game world where the entity should be spawned.
     * @param reason The reason for spawning the entity.
     * @return {@code true} if the entity was successfully spawned; {@code false} otherwise.
     */
    boolean spawn(Location location, CreatureSpawnEvent.SpawnReason reason);

    /**
     * Despawns or removes the associated entity from the game world.
     * Implementations should ensure that the entity is properly removed without leaving any traces.
     */
    void despawn();

    /**
     * Retrieves the underlying Bukkit entity associated with this program.
     *
     * @return The associated Bukkit entity.
     */
    Entity getBukkitEntity();
}

package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public interface EntityProgram {

    void build(Parabot bot, Location loc);

    void dispose();

    boolean spawn(Location location, CreatureSpawnEvent.SpawnReason reason);

    void despawn();

    Entity getBukkitEntity();

}

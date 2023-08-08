package com.parakeetstudios.bot;

import com.parakeetstudios.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface EntityBuilder {

    void build(Parabot bot, Location loc);

    void dispose();

    boolean spawn();

    boolean despawn();

    Entity getBukkitEntity();

}

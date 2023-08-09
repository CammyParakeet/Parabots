package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface EntityProgram {

    void build(Parabot bot, Location loc);

    void dispose();

    boolean spawn();

    void despawn();

    Entity getBukkitEntity();

}

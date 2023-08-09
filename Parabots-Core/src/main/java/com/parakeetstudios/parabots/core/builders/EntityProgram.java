package com.parakeetstudios.parabots.core.builders;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface EntityProgram {

    void build(Parabot bot, Location loc);

    void dispose();

    boolean spawn();

    boolean despawn();

    Entity getBukkitEntity();

}

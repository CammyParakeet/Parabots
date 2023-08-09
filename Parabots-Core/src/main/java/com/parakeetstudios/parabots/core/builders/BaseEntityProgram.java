package com.parakeetstudios.parabots.core.builders;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.net.NMS;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public abstract class BaseEntityProgram implements EntityProgram {

    protected Entity bukkitEntity;

    @Override
    public void build(Parabot bot, Location loc) {
        bukkitEntity = buildBukkitEntity(bot, loc);
    }

    protected abstract Entity buildBukkitEntity(Parabot bot, Location loc);

    @Override
    public void dispose() {
        //TODO
    }

    @Override
    public boolean spawn() {
        return NMS.addEntityToNMSWorld(bukkitEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public boolean despawn() {
        //TODO
        return false;
    }

    @Override
    public Entity getBukkitEntity() {
        return bukkitEntity;
    }
}

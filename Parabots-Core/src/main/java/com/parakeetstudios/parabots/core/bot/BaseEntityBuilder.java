package com.parakeetstudios.parabots.core.bot;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.utils.NMS;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public abstract class BaseEntityBuilder implements EntityBuilder {

    private Entity bukkitEntity;

    @Override
    public void build(Parabot bot, Location loc) {
        this.bukkitEntity = buildBukkitEntity(bot, loc);
    }

    protected abstract Entity buildBukkitEntity(Parabot bot, Location loc);

    @Override
    public void dispose() {

    }

    @Override
    public boolean spawn() {
        return NMS.addEntityToNMSWorld(this.bukkitEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public boolean despawn() {
        return false;
    }

    @Override
    public Entity getBukkitEntity() {
        return null;
    }
}

package com.parakeetstudios.bot;

import com.parakeetstudios.api.bot.Parabot;
import com.parakeetstudios.utils.NMS;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

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

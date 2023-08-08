package com.parakeetstudios.parabots.core.bot;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.core.bot.v1_20_R1.ParaPlayer;
import com.parakeetstudios.parabots.core.utils.NMS;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Optional;

public abstract class BaseEntityBuilder<E extends Entity> implements EntityBuilder<E> {

    protected E bukkitEntity;

    @Override
    public void build(Parabot bot, Location loc) {
        bukkitEntity = buildBukkitEntity(bot, loc);
    }

    protected abstract E buildBukkitEntity(Parabot bot, Location loc);

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
    public E getBukkitEntity() {
        return bukkitEntity;
    }
}

package com.parakeetstudios.parabots.core.v1_20_R1;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.EntityProgram;
import com.parakeetstudios.parabots.core.v1_20_R1.net.NMSHelper;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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
        despawn();
        bukkitEntity = null;
    }

    @Override
    public boolean spawn(Location location, CreatureSpawnEvent.SpawnReason reason) throws NullPointerException {
        return NMSHelper.addEntityToNMSWorld(bukkitEntity, reason);
    }

    @Override
    public void despawn() {
        if (bukkitEntity == null) return;
        if (bukkitEntity instanceof Player) {
            NMSHelper.removeEntityFromNMSWorld(bukkitEntity);
            NMSHelper.killNMSEntity(bukkitEntity);
        } else {
            bukkitEntity.remove();
        }
    }

    @Override
    public Entity getBukkitEntity() {
        return bukkitEntity;
    }
}

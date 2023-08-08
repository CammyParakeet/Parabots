package com.parakeetstudios.utils;

import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NMS {

    public static boolean addEntityToNMSWorld(Entity entity, CreatureSpawnEvent.SpawnReason reason) {
        return (getNMSEntity(entity)).level().addFreshEntity(getNMSEntity(entity), reason);
    }

    public static net.minecraft.world.entity.Entity getNMSEntity(Entity entity) {
        return ((CraftEntity) entity).getHandle();
    }

}

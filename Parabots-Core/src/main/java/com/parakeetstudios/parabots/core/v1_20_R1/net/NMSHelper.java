package com.parakeetstudios.parabots.core.v1_20_R1.net;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class NMSHelper {

    public static boolean addEntityToNMSWorld(@NotNull Entity entity, CreatureSpawnEvent.SpawnReason reason) {
        return (getNMSEntity(entity)).level().addFreshEntity(getNMSEntity(entity), reason);
    }

    public static void removePlayerFromPlayerList(Player player) {
        ((CraftServer) Bukkit.getServer()).getHandle().players.remove(getNMSEntity(player));
    }

    public static void killNMSEntity(@NotNull Entity entity) {
        getNMSEntity(entity).remove(net.minecraft.world.entity.Entity.RemovalReason.KILLED);
    }

    public static void removeEntityFromNMSWorld(@NotNull Entity entity) {
        getNMSWorldFromEntity(entity).getChunkSource().removeEntity(getNMSEntity(entity));
    }

    public static net.minecraft.world.entity.Entity getNMSEntity(@NotNull Entity entity) {
        return ((CraftEntity) entity).getHandle();
    }

    public static ServerLevel getNMSWorldFromLocation(Location loc) {
        return ((CraftWorld) loc.getWorld()).getHandle();
    }

    public static ServerLevel getNMSWorldFromEntity(Entity entity) {
        return (ServerLevel) getNMSEntity(entity).level();
    }

}

package com.parakeetstudios.parabots.core.v1_20_R1.net;

import com.mojang.authlib.properties.Property;
import com.parakeetstudios.parabots.core.utils.Paralog;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TickingTracker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class NMSHelper {

    public static boolean addEntityToNMSWorld(@NotNull Entity entity, CreatureSpawnEvent.SpawnReason reason) {
        return getNMSWorldFromEntity(entity).addFreshEntity(getNMSEntity(entity), reason);
    }

    public static boolean addPlayerEntityToNMSWorld(Entity player, CreatureSpawnEvent.SpawnReason reason) {
        if (!(player instanceof Player)) return false;
        ChunkMap chunkMap;
        try {
            chunkMap = getNMSWorldFromEntity(player).getChunkSource().chunkMap;
            //TODO change viewdistance
        } catch (Throwable e) {
            Paralog.severe("Failed to assign chunk map view distance: " + e.getMessage());
            e.printStackTrace();
        }
        boolean success = addEntityToNMSWorld(player, reason);
        try {
            //TODO reset viewdistance
        } catch (Throwable e) {
            Paralog.severe("Failed to reset chunk view distance: " + e.getMessage());
            e.printStackTrace();
        }



        return true;
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

    public static Property getTexturePropertyFromPlayer(Player player) {
        return (((CraftPlayer) player).getHandle().getGameProfile().getProperties().get("textures").iterator().next());
    }
}

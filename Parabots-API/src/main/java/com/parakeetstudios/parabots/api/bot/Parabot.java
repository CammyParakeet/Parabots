package com.parakeetstudios.parabots.api.bot;

import com.parakeetstudios.parabots.api.BotManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import java.util.UUID;
import java.util.function.Consumer;

public interface Parabot {

    Consumer<Parabot> addTask(Runnable task);

    UUID getBotID();
    UUID getMinecraftID();

    void setBotName(String name);
    String getBotName();

    void setDisplayName(String name);
    String getDisplayName();

    Parabot clone();
    Parabot copy();

    boolean spawn();
    boolean spawn(Location location);
    boolean spawn(Location location, CreatureSpawnEvent.SpawnReason reason);

    boolean spawnFor(Player player);
    boolean spawnFor(Player player, Location location);
    boolean spawnFor(Player player, Location location, String reason);

    boolean despawn();
    boolean isSpawned();
    boolean setSpawned(boolean spawned);

    void delete();

    Location getLocation();
    void setLocation(Location location);
    void teleport(Location location, TeleportCause cause);

    void facingLocation(Location location);
    Location getFacingLocation();

    void setEntityType(EntityType type);
    EntityType getEntityType();
    Entity getBukkitEntity();

    void setUsingMinecraftAI(boolean useAI);
    boolean usingMinecraftAI();

    BotManager getOwningManager();

    void load();
    void save();

}

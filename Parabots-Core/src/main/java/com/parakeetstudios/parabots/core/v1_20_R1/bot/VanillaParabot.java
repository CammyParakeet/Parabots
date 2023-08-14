package com.parakeetstudios.parabots.core.v1_20_R1.bot;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.bot.BaseParabot;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.EntityProgram;
import com.parakeetstudios.parabots.core.v1_20_R1.EntityProgramRegistry;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Optional;

public class VanillaParabot extends BaseParabot {

    private EntityProgram entityProgram;

    public VanillaParabot(EntityType type, String name, Location loc, BotManager manager) {
        super(type, name, loc, manager);
        Bukkit.getLogger().info(type.toString());
        Bukkit.getLogger().info(EntityProgramRegistry.supplyBuilderForType(type).toString());
        setEntityProgram(EntityProgramRegistry.supplyBuilderForType(type));
    }

    /**
     * Sets a new {@link EntityProgram} for the current entity.
     * <p>
     * If the entity was previously spawned using an older program, it will be despawned
     * and then immediately respawned at its last known location using the new program.
     * </p>
     *
     * @param newProgram The new program to set for the entity. This cannot be {@code null}.
     * @throws IllegalArgumentException if the provided {@link EntityProgram} is {@code null}.
     *
     * @see EntityProgram
     */
    public void setEntityProgram(EntityProgram newProgram) {
        if (newProgram == null) throw new IllegalArgumentException("EntityProgram cannot be null");
        Optional<Location> currentLoc = Optional.empty();
        if (entityProgram != null && isSpawned()) {
            currentLoc = Optional.of(getBukkitEntity().getLocation());
            despawn();
        }
        entityProgram = newProgram;
        currentLoc.ifPresent(this::spawn);
    }

    @Override
    public boolean spawn() {
        return spawn(getLocation(), CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public boolean spawn(Location location) {
        return spawn(location, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public boolean spawn(Location location, CreatureSpawnEvent.SpawnReason reason) {
        if (isSpawned()) {
            Bukkit.getLogger().info("Tried to spawn existing entity");
            return false;
        }
        setSpawned(entityProgram.spawn(location, reason));
        return isSpawned();
    }

    @Override
    public boolean spawnFor(Player player) {
        return false;
    }

    @Override
    public boolean spawnFor(Player player, Location location) {
        return false;
    }

    @Override
    public boolean spawnFor(Player player, Location location, String reason) {
        return false;
    }

    @Override
    public boolean despawn() {
        setSpawned(false);
        return false;
    }


    @Override
    public void delete() {

    }


    @Override
    public void teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {

    }

    @Override
    public void facingLocation(Location location) {

    }

    @Override
    public Location getFacingLocation() {
        return null;
    }

    @Override
    public Entity getBukkitEntity() {
        return entityProgram.getBukkitEntity();
    }

    @Override
    public void setUsingMinecraftAI(boolean useAI) {

    }

    @Override
    public boolean usingMinecraftAI() {
        return false;
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}

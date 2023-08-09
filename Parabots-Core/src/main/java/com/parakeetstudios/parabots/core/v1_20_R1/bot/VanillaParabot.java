package com.parakeetstudios.parabots.core.v1_20_R1.bot;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.bot.BaseParabot;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.EntityProgram;
import com.parakeetstudios.parabots.core.v1_20_R1.EntityProgramRegistry;
import net.minecraft.core.Direction;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class VanillaParabot extends BaseParabot {

    private EntityProgram entityProgram;

    public VanillaParabot(EntityType type, String name, Location loc, BotManager manager) {
        super(type, name, loc, manager);
        setEntityBuilder(EntityProgramRegistry.supplyBuilderForType(type));
    }

    public void setEntityBuilder(EntityProgram newProgram) {
        boolean hasSpawned = entityProgram != null && isSpawned();
        Location currentLoc = null;

        if (hasSpawned) {
            currentLoc = getBukkitEntity().getLocation();
            despawn();
        }
        entityProgram = newProgram;
        if (hasSpawned) {
            spawn(currentLoc);
        }
    }

    @Override
    public Parabot clone() {
        return null;
    }

    @Override
    public Parabot copy() {
        return null;
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
    public void facingDirection(Direction direction) {

    }

    @Override
    public Direction getFacingDirection() {
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

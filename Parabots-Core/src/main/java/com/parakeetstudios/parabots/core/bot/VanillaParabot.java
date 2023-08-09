package com.parakeetstudios.parabots.core.bot;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.bot.BaseParabot;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.builders.EntityBuilder;
import net.minecraft.core.Direction;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import static com.parakeetstudios.parabots.core.utils.EntityBuilderRegistry.supplyBuilderForType;

public class VanillaParabot extends BaseParabot {

    private EntityBuilder entityBuilder;

    public VanillaParabot(String name, BotManager manager, EntityType type) {
        super(name, manager, type);
        setEntityBuilder(supplyBuilderForType(type));
    }

    public void setEntityBuilder(EntityBuilder newBuilder) {
        //TODO pre checks for if entity is spawned already etc etc
        this.entityBuilder = newBuilder;
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
        return false;
    }

    @Override
    public boolean spawn(Location location) {
        return false;
    }

    @Override
    public boolean spawn(Location location, String reason) {
        return false;
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
        return false;
    }

    @Override
    public boolean isSpawned() {
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
        return entityBuilder.getBukkitEntity();
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

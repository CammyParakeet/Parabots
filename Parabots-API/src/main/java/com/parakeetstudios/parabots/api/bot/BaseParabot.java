package com.parakeetstudios.parabots.api.bot;

import com.parakeetstudios.parabots.api.BotManager;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public abstract class BaseParabot implements Parabot {

    private final BotManager manager;
    private final Map<String, Runnable> taskMap;
    private final UUID botID;
    private final UUID minecraftID;
    private String botName;
    private String displayName;
    private Location currentLocation;
    private EntityType entityType;
    private boolean usingMinecraftAI;
    private boolean isSpawned;

    protected BaseParabot(String name, BotManager manager, EntityType type) {
        this.taskMap = new ConcurrentHashMap<>();
        this.botID = UUID.randomUUID();
        this.minecraftID = UUID.randomUUID();
        this.botName = name;
        this.manager = manager;
        this.entityType = type;
    }

    @Override
    public Consumer<Parabot> addTask(Runnable task) {
        return null;
    }

    @Override
    public UUID getBotID() {
        return botID;
    }

    @Override
    public UUID getMinecraftID() {
        return minecraftID;
    }

    @Override
    public void setBotName(String name) {
        this.botName = name;
    }

    @Override
    public String getBotName() {
        return botName;
    }

    @Override
    public void setDisplayName(String name) {
        this.displayName = name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public Location getLocation() {
        return currentLocation;
    }

    @Override
    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    @Override
    public void setEntityType(EntityType type) {
        this.entityType = type;
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public BotManager getOwningManager() {
        return manager;
    }
}

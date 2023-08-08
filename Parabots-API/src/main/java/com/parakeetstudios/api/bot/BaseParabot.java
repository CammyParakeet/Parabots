package com.parakeetstudios.api.bot;

import com.parakeetstudios.api.BotManager;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseParabot implements Parabot {

    private final Map<String, Runnable> taskMap;
    private final UUID botID;
    private final UUID minecraftID;
    private String botName;
    private String displayName;
    private ServerPlayer entity; // change to entity handler
    private BotManager manager;
    private Location currentLocation;
    private EntityType entityType;
    private boolean usingMinecraftAI;
    private boolean isSpawned;

    protected BaseParabot(String name, BotManager manager) {
        this.taskMap = new ConcurrentHashMap<>();
        this.botID = UUID.randomUUID();
        this.minecraftID = UUID.randomUUID();
        this.botName = name;
        this.manager = manager;
    }
}

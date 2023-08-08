package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.bot.VanillaParabot;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParabotManager implements BotManager {

    private final ConcurrentHashMap<UUID, Parabot> parabots = new ConcurrentHashMap<>();

    private VanillaParabot createBot(EntityType type, String name) {
        return new VanillaParabot(name, this, type);
    }

    @Override
    public Parabot createBot(String name, Location location) {
        return null;
    }

    @Override
    public Parabot createBot(String name) {
        return null;
    }

    @Override
    public Parabot getBotByID(UUID botID) {
        return null;
    }

    @Override
    public List<Parabot> getAllParabots() {
        return null;
    }

    @Override
    public boolean removeBot(UUID botID) {
        return false;
    }

    @Override
    public boolean spawnAllBots() {
        return false;
    }

    @Override
    public boolean despawnAllBots() {
        return false;
    }
}

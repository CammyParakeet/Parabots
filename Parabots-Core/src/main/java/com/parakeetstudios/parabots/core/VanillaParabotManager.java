package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.v1_20_R1.bot.VanillaParabot;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class VanillaParabotManager implements BotManager {

    private final ConcurrentHashMap<UUID, Parabot> parabots = new ConcurrentHashMap<>();

    private VanillaParabot createVanillaBot(EntityType type, String name, Location loc) {
        return new VanillaParabot(type, name, loc, this);
    }

    @Override
    public Parabot createBot(EntityType type, String name, Location location) {
        return createVanillaBot(type, name, location);
    }

    @Override
    public Parabot createBot(EntityType type, String name) {
        Location location = new Location(Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0);
        return createVanillaBot(type, name, location);
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

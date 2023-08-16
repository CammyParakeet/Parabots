package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.BotManager;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.utils.Paralog;
import com.parakeetstudios.parabots.core.v1_20_R1.bot.VanillaParabot;
import com.parakeetstudios.parabots.core.v1_20_R1.net.NMSHelper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class VanillaBotManager implements BotManager {

    private final ConcurrentHashMap<UUID, Parabot> bots = new ConcurrentHashMap<>();

    private VanillaParabot createVanillaBot(EntityType type, String name, Location loc) {
        return new VanillaParabot(type, name, loc, this);
    }

    @Override
    public Parabot createBot(EntityType type, String name, Location location) {
        // Check parameter validity
        Objects.requireNonNull(type, "EntityType cannot be null");
        Objects.requireNonNull(name, "Bot name cannot be null");
        Objects.requireNonNull(location, "Location cannot be null");

        Parabot bot = createVanillaBot(type, name, location);
        bots.put(bot.getBotID(), bot);

        Paralog.info(NMSHelper.getNMSEntity(bot.getBukkitEntity()).tracker.toString());

        return bot;
    }

    @Override
    public Parabot createBot(EntityType type, String name) {
        Location location = Bukkit.getWorlds().get(0).getSpawnLocation();
        return createBot(type, name, location);
    }

    @Override
    public Parabot getBotByID(UUID botID) { return bots.get(botID); }

    @Override
    public List<Parabot> getAllParabots() {
        return new ArrayList<>(bots.values());
    }

    @Override
    public void removeBot(UUID botID) { bots.remove(botID); }

    @Override
    public void spawnAllBots() {
        for (Parabot bot : bots.values()) {
            bot.spawn(bot.getLocation(), CreatureSpawnEvent.SpawnReason.CUSTOM);
        }
    }

    @Override
    public void despawnAllBots() {
        for (Parabot bot : bots.values()) {
            bot.despawn();
        }
    }

    @Override
    public void cleanUp() {
        despawnAllBots();
    }
}

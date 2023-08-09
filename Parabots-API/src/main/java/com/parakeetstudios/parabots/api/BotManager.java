package com.parakeetstudios.parabots.api;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.List;
import java.util.UUID;

public interface BotManager {

    Parabot createBot(EntityType type, String name, Location location);
    Parabot createBot(EntityType type, String name);

    Parabot getBotByID(UUID botID);
    List<Parabot> getAllParabots();

    boolean removeBot(UUID botID);

    boolean spawnAllBots();
    boolean despawnAllBots();

}

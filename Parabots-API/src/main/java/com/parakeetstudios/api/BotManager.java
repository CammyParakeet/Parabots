package com.parakeetstudios.api;

import com.parakeetstudios.api.bot.Parabot;
import org.bukkit.Location;

import java.util.UUID;

public interface BotManager {

    Parabot createBot(String name, Location location);
    Parabot createBot(String name);

    Parabot getBotByID(UUID botID);

    boolean removeBot(UUID botID);

    boolean spawnAllBots();
    boolean despawnAllBots();

}

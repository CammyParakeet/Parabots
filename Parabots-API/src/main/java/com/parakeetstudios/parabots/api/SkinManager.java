package com.parakeetstudios.parabots.api;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface SkinManager {

    Skin createFromPlayer(Player player);

    Skin createFromURL(String URL);

    /**
     * Fetches the {@link Skin} details for a given player from Mojang's API.
     *
     * @param playerName The name of the player whose skin details are to be fetched.
     * @param callback   A {@link Consumer} callback that is triggered with the fetched skin
     *                   or null if there's an error during the process.
     */
    void fetchFromMojang(String playerName, Consumer<Skin> callback);

    Skin getSkin(UUID skinID);

    void saveSkin(Skin skin);

    List<Skin> getCachedSkins();


}

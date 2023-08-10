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
     * Fetches a {@link Skin} object for the given player name from Mojang's API.
     * This method works asynchronously, meaning it will not block the calling thread.
     * Once the skin data is retrieved and the Skin object is created, it will pass the Skin
     * to the provided callback.
     * <p>
     * If there are any issues during the fetching or processing, the exceptions will be printed to the error stream.
     * </p>
     *
     * @param playerName The name of the player for whom the skin needs to be fetched.
     * @param callback   A consumer callback that will be invoked with the Skin object once it's ready.
     */
    void fetchFromMojang(String playerName, Consumer<Skin> callback);

    Skin getSkin(UUID skinID);

    void saveSkin(Skin skin);

    List<Skin> getCachedSkins();


}

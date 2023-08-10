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

    void fetchFromMojang(String playerName, Consumer<Skin> callback);

    Skin getSkin(UUID skinID);

    void saveSkin(Skin skin);

    List<Skin> getCachedSkins();


}

package com.parakeetstudios.parabots.api;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface SkinManager {

    Skin createFromPlayer(Player player);

    Skin createFromURL(String URL);

    Skin fetchFromMojang(String playerName);

    Skin getSkin(UUID skinID);

    void saveSkin(Skin skin);

    List<Skin> getCachedSkins();


}

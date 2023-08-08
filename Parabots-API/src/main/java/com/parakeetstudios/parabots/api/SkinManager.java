package com.parakeetstudios.parabots.api;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface SkinManager {

    Skin getSkin(UUID skinID);

    List<Skin> getCachedSkins();

    List<Skin> getPlayerCachedSkins(Player p);

    List<Skin> getBotCachedSkins(Parabot bot);

}

package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.SkinManager;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HumanSkinManager implements SkinManager {

    private HashMap<UUID, >

    @Override
    public Skin getSkin(UUID skinID) {
        return null;
    }

    @Override
    public List<Skin> getCachedSkins() {
        return null;
    }

    @Override
    public List<Skin> getPlayerCachedSkins(Player p) {
        return null;
    }

    @Override
    public List<Skin> getBotCachedSkins(Parabot bot) {
        return null;
    }
}

package com.parakeetstudios.parabots.core;

import com.mojang.authlib.properties.Property;
import com.parakeetstudios.parabots.api.SkinManager;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.core.skin.HumanSkin;
import com.parakeetstudios.parabots.core.v1_20_R1.net.NMSHelper;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HumanSkinManager implements SkinManager {

    private Map<UUID, Skin> skinCache = new ConcurrentHashMap<>();

    @Override
    public Skin createFromPlayer(Player player) {
        return new HumanSkin(UUID.randomUUID(), NMSHelper.getTexturePropertyFromPlayer(player));
    }

    @Override
    public Skin createFromURL(String URL) {
        return null;
    }

    @Override
    public Skin fetchFromMojang(String playerName) {
        return null;
    }

    @Override
    public Skin getSkin(UUID skinID) {
        return skinCache.get(skinID);
    }

    @Override
    public void saveSkin(Skin skin) {
        skinCache.put(skin.getSkinID(), skin);
    }

    @Override
    public List<Skin> getCachedSkins() {
        return new ArrayList<>(skinCache.values());
    }
}

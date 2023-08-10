package com.parakeetstudios.parabots.core;

import com.parakeetstudios.parabots.api.SkinManager;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.core.skin.HumanSkin;
import com.parakeetstudios.parabots.core.utils.MojangAPI;
import com.parakeetstudios.parabots.core.v1_20_R1.net.NMSHelper;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class HumanSkinManager implements SkinManager {

    private Map<UUID, Skin> skinCache = new ConcurrentHashMap<>();

    @Override
    public Skin createFromPlayer(Player player) {
        return new HumanSkin(UUID.randomUUID(), NMSHelper.getTexturePropertyFromPlayer(player));
    }

    @Override
    public Skin createFromURL(String URL) {
        //TODO
        return null;
    }

    @Override
    public void fetchFromMojang(String playerName, Consumer<Skin> callback) {
        CompletableFuture.supplyAsync(() -> {
            // Get the UUID from playerName
            UUID playerUUID = MojangAPI.getUUIDFromPlayerName(playerName);
            if (playerUUID == null) {
                throw new RuntimeException("Unable to fetch UUID for player: " + playerName);
            }

            // Fetch the skin details using playerUUID
            Skin skin = MojangAPI.getSkinFromUUID(playerUUID);
            if (skin == null) {
                throw new RuntimeException("Unable to fetch skin for UUID: " + playerUUID);
            }

            return skin;
        }).thenAccept(callback).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
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

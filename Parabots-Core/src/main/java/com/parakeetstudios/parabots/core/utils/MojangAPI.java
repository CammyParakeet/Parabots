package com.parakeetstudios.parabots.core.utils;

import com.google.gson.Gson;
import com.parakeetstudios.parabots.api.skin.Skin;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class MojangAPI {

    private static final String profileURL = "https://api.mojang.com/users/profiles/minecraft/";

    public static UUID getUUIDFromPlayerName(String playerName) {
        String toCall = profileURL + playerName;
        try {
            URL url = new URL(toCall);


            // Parse JSON content
            Gson gson = new Gson();
            CompletableFuture<UUID> uuidFuture = ParaHTTP.asyncGETJson(url).thenApply(response -> {
                if (response.has("id")) {
                    String uuidString = response.get("id").getAsString();
                    return UUID.fromString(
                            uuidString.replaceFirst(
                                    "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w+)",
                                    "$1-$2-$3-$4-$5"
                            )
                    );
                } else {
                    throw new IllegalArgumentException("Response does not contain 'id' key.");
                }
            }).exceptionally(e -> {
                System.err.println("Error fetching data: " + e.getMessage());
                return null;
            });

            uuidFuture.thenAccept(uuid -> {
                System.out.println("UUID: " + uuid);
            }).exceptionally(e -> {
                System.err.println("Error fetching or parsing data: " + e.getMessage());
                return null;
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Skin getSkinFromUUID(UUID pID) {
        //TODO
        //return new HumanSkin();
        return null;
    }


}

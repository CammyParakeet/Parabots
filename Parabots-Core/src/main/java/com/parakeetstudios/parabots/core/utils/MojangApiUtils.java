package com.parakeetstudios.parabots.core.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.parakeetstudios.parabots.api.skin.Skin;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class MojangApiUtils {

    private static final String PROFILE_URL = "https://api.mojang.com/users/profiles/minecraft/";

    /**
     * Retrieves the UUID associated with a given player name from Mojang's API.
     * <p>
     * The method constructs a URL using the player's name and sends a GET request
     * to Mojang's API to fetch the UUID. The response is expected to be a JSON object
     * containing an 'id' field which represents the player's UUID.
     * </p>
     * <p>
     * The UUID is then formatted and returned. If any issues arise during the
     * request, processing of the response, or if the 'id' field is not present
     * in the response, the method will return null.
     * </p>
     * <b>Note:</b> Any exceptions encountered during the operation will be printed to
     * the error stream but will not be thrown further.
     *
     * @param playerName The name of the player whose UUID needs to be retrieved.
     * @return The UUID of the player if found and successfully processed, otherwise null.
     * @throws IOException If an I/O exception occurs during the HTTP request.
     */
    public static UUID getUUIDFromPlayerName(String playerName) throws IOException {
        try {
            URL url = new URL(PROFILE_URL + playerName);
            JsonObject response = ParaHTTP.GETJson(url);
            if (response.has("id")) {
                return UUID.fromString(
                        response.get("id").getAsString().replaceFirst(
                                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w+)",
                                "$1-$2-$3-$4-$5"
                        )
                );
            }
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Skin getSkinFromUUID(UUID pID) {
        //TODO
        //return new HumanSkin();
        return null;
    }


}

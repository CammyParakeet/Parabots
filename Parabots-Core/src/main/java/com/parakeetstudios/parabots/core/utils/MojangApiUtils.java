package com.parakeetstudios.parabots.core.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.core.skin.HumanSkin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class MojangApiUtils {

    private static final String PROFILE_URL = "https://api.mojang.com/users/profiles/minecraft/";
    private static final String SKIN_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";

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
     * @throws RuntimeException If an I/O exception occurs during the HTTP request.
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
            throw new RuntimeException("Failed to fetch UUID for playerName" + playerName, e);
        }
        throw new RuntimeException("UUID not found for playerName: " + playerName);
    }

    /**
     * Fetches the player skin data from Mojang's API based on the provided UUID.
     *
     * @param pID The UUID of the player.
     * @return The {@link Skin} object containing the skin data of the player.
     * @throws RuntimeException If there's an error during the fetching process or if the skin isn't found.
     */
    public static Skin getSkinFromUUID(UUID pID) {
        try {
            URL url = new URL(SKIN_URL + pID.toString().replace("-", ""));
            JsonObject response = ParaHTTP.GETJson(url);

            if (response.has("properties")) {
                JsonArray properties = response.getAsJsonArray("properties");
                for (JsonElement element : properties) {
                    JsonObject property = element.getAsJsonObject();
                    if (property.has("name") && "textures".equals(property.get("name").getAsString())) {
                        String texture = property.get("value").getAsString();
                        String signature = property.get("signature").getAsString();
                        return new HumanSkin(UUID.randomUUID(), texture, signature);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch skin for UUID" + pID, e);
        }
        throw new RuntimeException("Skin not found for UUID: " + pID);
    }

}

package com.parakeetstudios.parabots.core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * Utility class for HTTP operations.
 */
public class ParaHTTP {

    /**
     * Sends a synchronous GET request to the specified URL.
     *
     * @param url The URL to send the request to.
     * @return The response content as a string.
     * @throws IOException If an I/O exception occurs.
     */
    public static String GET(URL url) throws IOException {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP GET failed with code " + responseCode);
            }

            // Using try-with-resources to ensure BufferedReader is closed
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
                return content.toString();
            }
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * Sends an asynchronous GET request to the specified URL.
     *
     * @param url The URL to send the request to.
     * @return A CompletableFuture containing the response content as a string or an exception if an error occurs.
     */
    public static CompletableFuture<String> asyncGET(URL url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return GET(url);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

    /**
     * Sends a synchronous GET request to the specified URL and parses the response as JSON.
     *
     * @param url The URL to send the request to.
     * @return The parsed response content as a JsonObject.
     * @throws IOException If an I/O exception occurs.
     */
    public static JsonObject GETJson(URL url) throws IOException {
        return new Gson().fromJson(GET(url), JsonObject.class);
    }

    /**
     * Sends an asynchronous GET request to the specified URL and parses the response as JSON.
     *
     * @param url The URL to send the request to.
     * @return A CompletableFuture containing the parsed response as a JsonObject or an exception if an error occurs.
     */
    public static CompletableFuture<JsonObject> asyncGETJson(URL url) {
        return CompletableFuture.supplyAsync(() -> {
           try {
               return GETJson(url);
           } catch (IOException e) {
               throw new CompletionException(e);
           }
        });
    }

}

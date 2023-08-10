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

public class ParaHTTP {

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

    public static CompletableFuture<String> asyncGET(URL url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return GET(url);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

    public static JsonObject GETJson(URL url) throws IOException {
        return new Gson().fromJson(GET(url), JsonObject.class);
    }

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

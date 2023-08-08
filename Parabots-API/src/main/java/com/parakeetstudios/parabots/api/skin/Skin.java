package com.parakeetstudios.parabots.api.skin;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface Skin {

    UUID getSkinID();

    String getTexture();

    String getSignature();

    void applyTo(Parabot bot);
    void applyTo(Player player);

}

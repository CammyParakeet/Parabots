package com.parakeetstudios.parabots.api.skin;

import com.parakeetstudios.parabots.api.bot.Parabot;
import org.bukkit.entity.Player;

import java.util.EnumSet;
import java.util.UUID;

public interface Skin {

    UUID getSkinID();

    String getTexture();
    String getSignature();

    void applyTo(Parabot bot);
    void applyTo(Player player);

    EnumSet<SkinPart> getVisibleSkinParts();
    void setVisibleSkinParts(EnumSet<SkinPart> parts);

    public enum SkinPart {
        CAPE,
        JACKET,
        LEFT_SLEEVE,
        RIGHT_SLEEVE,
        LEFT_PANT_LEG,
        RIGHT_PANT_LEG,
        HAT
    }

}

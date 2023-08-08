package com.parakeetstudios.parabots.api.skin;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.utils.SkinUtils.SkinPart;
import org.bukkit.entity.Player;

import java.util.EnumSet;
import java.util.UUID;

public interface Skin {

    UUID getSkinID();

    void setSkinName(String name);
    String getSkinName();

    String getTexture();
    String getSignature();

    void applyTo(Parabot bot);
    void applyTo(Player player);

    EnumSet<SkinPart> getVisibleSkinParts();
    void setVisibleSkinParts(EnumSet<SkinPart> parts);

}

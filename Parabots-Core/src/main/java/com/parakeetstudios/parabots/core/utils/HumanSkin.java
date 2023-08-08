package com.parakeetstudios.parabots.core.utils;

import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.api.utils.SkinUtils.SkinPart;
import org.bukkit.entity.Player;

import java.util.EnumSet;
import java.util.UUID;

public class HumanSkin implements Skin {

    private final UUID skinID;
    private final String texture;
    private final String signature;
    private String skinName;
    private EnumSet<SkinPart> visibleSkinParts;

    public HumanSkin(UUID skinID, String texture, String signature) {
        this.skinID = skinID;
        this.texture = texture;
        this.signature = signature;
        this.visibleSkinParts = EnumSet.noneOf(SkinPart.class);
    }

    @Override
    public UUID getSkinID() {
        return skinID;
    }

    @Override
    public void setSkinName(String name) {
        this.skinName = name;
    }

    @Override
    public String getSkinName() {
        return skinName;
    }

    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public void applyTo(Parabot bot) {

    }

    @Override
    public void applyTo(Player player) {

    }

    @Override
    public EnumSet<SkinPart> getVisibleSkinParts() {
        return visibleSkinParts;
    }

    @Override
    public void setVisibleSkinParts(EnumSet<SkinPart> parts) {
        this.visibleSkinParts = parts;
    }
}

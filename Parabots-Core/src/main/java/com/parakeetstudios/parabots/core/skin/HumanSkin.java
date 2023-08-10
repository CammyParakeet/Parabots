package com.parakeetstudios.parabots.core.skin;

import com.mojang.authlib.properties.Property;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.api.utils.SkinUtils.SkinPart;

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

    public HumanSkin(UUID id, Property property) {
        this(id, property.getValue(), property.getSignature());
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
    public final EnumSet<SkinPart> getVisibleSkinParts() {
        return visibleSkinParts;
    }

    @Override
    public void setVisibleSkinParts(EnumSet<SkinPart> parts) {
        this.visibleSkinParts = parts;
    }


}

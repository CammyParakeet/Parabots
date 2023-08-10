package com.parakeetstudios.parabots.api.skin;

import com.parakeetstudios.parabots.api.utils.SkinUtils.SkinPart;
import java.util.EnumSet;
import java.util.UUID;

public interface Skin {

    UUID getSkinID();

    void setSkinName(String name);
    String getSkinName();

    String getTexture();
    String getSignature();

    EnumSet<SkinPart> getVisibleSkinParts();
    void setVisibleSkinParts(EnumSet<SkinPart> parts);

}

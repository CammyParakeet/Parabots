package com.parakeetstudios.parabots.core.skin;

import com.parakeetstudios.parabots.api.skin.Skin;

public interface Skinnable {

    Skin getSkin();
    void setSkin(Skin skin);
    void applySkin(Skin skin);

}

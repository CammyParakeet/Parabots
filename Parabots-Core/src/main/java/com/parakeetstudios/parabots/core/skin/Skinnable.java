package com.parakeetstudios.parabots.core.skin;

import com.parakeetstudios.parabots.api.skin.Skin;

public interface Skinnable {

    Skin getSkin();
    void setSkin(Skin skin);

    /**
     * Applies the specified skin to the player and sets the visible skin parts based on the {@link Skin} object.
     * <p>
     * This method first clears any existing skin textures associated with the player's game profile.
     * Next, it sets the new skin's texture and signature. Finally, it computes a combined visibility flag
     * from the provided skin's visible parts and updates the player entity's customisation data.
     * </p>
     *
     * @param skin The {@link Skin} object containing the skin data and visible parts to be applied.
     */
    void applySkin(Skin skin);

}

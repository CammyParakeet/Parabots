package com.parakeetstudios.parabots.core.bot.v1_20_R1;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.api.skin.Skinnable;
import com.parakeetstudios.parabots.api.utils.SkinUtils.SkinPart;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class ParaPlayer extends ServerPlayer implements Skinnable {

    private Parabot bot;
    private Skin skin;

    public ParaPlayer(Parabot bot, MinecraftServer server, ServerLevel world, GameProfile profile) {
        super(server, world, profile);
        this.bot = bot;
    }

    




    public Skin getSkin() {
        return skin;
    }

    @Override
    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void applySkin(Skin skin) {
        byte flags = 0;
        super.getGameProfile().getProperties().get("textures").clear();
        super.getGameProfile().getProperties().put("textures", new Property(skin.getTexture(), skin.getSignature()));
        for (SkinPart part : skin.getVisibleSkinParts()) {
            flags |= part.getFlag();
        }
        super.getEntityData().set(DATA_PLAYER_MODE_CUSTOMISATION, flags);
    }

}

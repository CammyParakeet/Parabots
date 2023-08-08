package com.parakeetstudios.parabots.core.v1_20_R1;

import com.mojang.authlib.GameProfile;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class ParaPlayer extends ServerPlayer {

    private Parabot bot;
    private Skin skin;

    public ParaPlayer(MinecraftServer server, ServerLevel world, GameProfile profile, Parabot bot) {
        super(server, world, profile);
        this.bot = bot;
    }

    public Skin getSkin() {
        return this.skin;
    }

}

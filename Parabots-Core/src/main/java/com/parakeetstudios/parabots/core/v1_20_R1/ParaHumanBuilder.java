package com.parakeetstudios.parabots.core.v1_20_R1;

import com.mojang.authlib.GameProfile;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.api.skin.Skin;
import com.parakeetstudios.parabots.core.bot.BaseEntityBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.Entity;

public class ParaHumanBuilder extends BaseEntityBuilder {

    private Entity entity;
    private Skin skin;

    public ParaHumanBuilder() {
       super();
    }

    public void setHumanSkin(Skin skin) {
        this.skin = skin;
    }

    @Override
    protected Entity buildBukkitEntity(Parabot bot, Location loc) {

        final ServerLevel nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        final GameProfile gameProfile = new GameProfile(bot.getMinecraftID(), bot.getBotName());
        final ParaPlayer paraPlayer = new ParaPlayer(MinecraftServer.getServer(), nmsWorld, gameProfile, bot);

        if (skin != null) {
            //skin.applyTo(paraPlayer);
        }

        return paraPlayer.getBukkitEntity(); 
    }
}

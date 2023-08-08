package com.parakeetstudios.impl.v1_20_R1;

import com.mojang.authlib.GameProfile;
import com.parakeetstudios.api.bot.Parabot;
import com.parakeetstudios.api.bot.Skin;
import com.parakeetstudios.bot.BaseEntityBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

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

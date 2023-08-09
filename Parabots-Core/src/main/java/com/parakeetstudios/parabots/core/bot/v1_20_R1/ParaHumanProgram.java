package com.parakeetstudios.parabots.core.bot.v1_20_R1;

import com.mojang.authlib.GameProfile;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.builders.BaseEntityProgram;
import com.parakeetstudios.parabots.core.builders.ProgramForType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@ProgramForType(EntityType.PLAYER)
public class ParaHumanProgram extends BaseEntityProgram {

    public ParaHumanProgram() {
       super();
    }

    @Override
    protected Entity buildBukkitEntity(Parabot bot, Location loc) {

        final ServerLevel nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
        final GameProfile gameProfile = new GameProfile(bot.getMinecraftID(), bot.getBotName());
        final ParaPlayer paraPlayer = new ParaPlayer(bot, MinecraftServer.getServer(), nmsWorld, gameProfile);

        return paraPlayer.getBukkitEntity(); 
    }

    @Override
    public Player getBukkitEntity() {
        return (Player) super.getBukkitEntity();
    }
}


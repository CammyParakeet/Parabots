package com.parakeetstudios.parabots.core.v1_20_R1.program;

import com.mojang.authlib.GameProfile;
import com.parakeetstudios.parabots.api.bot.Parabot;
import com.parakeetstudios.parabots.core.ProgramForType;
import com.parakeetstudios.parabots.core.utils.Paralog;
import com.parakeetstudios.parabots.core.v1_20_R1.BaseEntityProgram;
import com.parakeetstudios.parabots.core.v1_20_R1.bot.ParaPlayer;
import com.parakeetstudios.parabots.core.v1_20_R1.net.NMSHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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

        Location location = Bukkit.getWorlds().get(0).getSpawnLocation();
        Paralog.info("Test? " + NMSHelper.getNMSWorldFromLocation(location));
        final ServerLevel nmsWorld = NMSHelper.getNMSWorldFromLocation(loc);
        final GameProfile gameProfile = new GameProfile(bot.getMinecraftID(), bot.getDisplayName());
        final ParaPlayer paraPlayer = new ParaPlayer(bot, MinecraftServer.getServer(), nmsWorld, gameProfile);

        return paraPlayer.getBukkitEntity(); 
    }

    @Override
    public Player getBukkitEntity() {
        return (Player) super.getBukkitEntity();
    }
}


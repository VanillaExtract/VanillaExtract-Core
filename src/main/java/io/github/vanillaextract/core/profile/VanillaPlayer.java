package io.github.vanillaextract.core.profile;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VanillaPlayer
{
    // Has to be public and have a getter as we will remove it onQuit.
    public static Map<UUID, VanillaPlayer> playerData;

    private long joinTime = 0;

    static
    {
        playerData = new HashMap<>();
    }

    // Instead of using HashMaps all the time, we will just use this profile system that holds everything in 1 HashMap, making it super hard to have memory leaks, and also easy to log dada.

    public static VanillaPlayer getPlayerData(final Player player)
    {
        final UUID uuid = player.getUniqueId();

        if (VanillaPlayer.playerData.containsKey(uuid)) {
            return VanillaPlayer.playerData.get(uuid);
        }
        final VanillaPlayer data = new VanillaPlayer(player);
        VanillaPlayer.playerData.put(uuid, data);

        return data;
    }

    private final Player player;

    private VanillaPlayer(final Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }

    public long getJoinTime()
    {
        return joinTime;
    }

    public long setJoinTime(long i)
    {
        return joinTime = i;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!(object instanceof VanillaPlayer)) {
            return false;
        }
        return this.player == ((VanillaPlayer) object).player;
    }
}

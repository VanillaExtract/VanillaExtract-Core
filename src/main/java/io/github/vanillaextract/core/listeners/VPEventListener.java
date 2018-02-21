package io.github.vanillaextract.core.listeners;

import io.github.vanillaextract.core.profile.VanillaPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VPEventListener implements Listener
{

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        if (VanillaPlayer.playerData.containsKey(event.getPlayer().getUniqueId()))
        {
            VanillaPlayer.playerData.remove(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        VanillaPlayer.getPlayerData(event.getPlayer()).setJoinTime(System.currentTimeMillis());
    }

}

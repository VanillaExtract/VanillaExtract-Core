package io.github.vanillaextract.core.platforming.platforms.activity;

import com.google.common.collect.ImmutableList;
import io.github.vanillaextract.core.platforming.Platform;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginPlatform extends Platform
{
     public LoginPlatform()
     {
         super("Sends a message to staff when another staff joins the server", 778, true);

         // Don't use "this" as when it actually gets registered it will error.
         this.registerClazz(new LoginPlatform());
     }

     @EventHandler
     public void onJoin(PlayerJoinEvent event)
     {
         final ImmutableList<Player> players = ImmutableList.copyOf(Bukkit.getOnlinePlayers());
         for (int i = 0; i < players.size(); i++) {
             final Player analyzedPlayer = players.get(i);

             String staffPermission = this.getPlatformConfig().generalStaffPermission;
             String staffLoginMessage = this.getPlatformConfig().staffLoginMessage.replace("%player%", event.getPlayer().getDisplayName());

             if (analyzedPlayer.hasPermission(staffPermission))
             {
                 analyzedPlayer.sendMessage(staffLoginMessage);
             }
         }
     }
}

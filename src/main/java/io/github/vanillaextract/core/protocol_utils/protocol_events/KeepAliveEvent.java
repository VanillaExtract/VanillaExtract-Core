package io.github.vanillaextract.core.protocol_utils.protocol_events;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class KeepAliveEvent extends Event
{
    public Player player;
    private static final HandlerList handlers;
    
    static
    {
        handlers = new HandlerList();
    }
    
    public KeepAliveEvent(final Player Player) {
        this.player = Player;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public HandlerList getHandlers() {
        return KeepAliveEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return KeepAliveEvent.handlers;
    }
}

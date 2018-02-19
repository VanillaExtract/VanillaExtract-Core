package io.github.vanillaextract.core.protocol_utils.protocol_events;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class EntityActionEvent extends Event
{
    public int action;
    public Player player;
    private static final HandlerList handlers;
    
    static
    {
        handlers = new HandlerList();
    }
    
    public EntityActionEvent(final Player Player, final int Action)
    {
        this.player = Player;
        this.action = Action;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public int getAction() {
        return this.action;
    }
    
    public HandlerList getHandlers() {
        return EntityActionEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return EntityActionEvent.handlers;
    }
    
    public class PlayerAction
    {
    }
}

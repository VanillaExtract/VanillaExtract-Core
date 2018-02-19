package io.github.vanillaextract.core.protocol_utils.protocol_events;

import com.comphenix.protocol.wrappers.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class UseEntityEvent extends Event
{
    public EnumWrappers.EntityUseAction action;
    public Player attacker;
    public Entity attacked;
    private static final HandlerList handlers;
    
    static
    {
        handlers = new HandlerList();
    }
    
    public UseEntityEvent(final EnumWrappers.EntityUseAction action, final Player attacker, final Entity attacked)
    {
        this.action = action;
        this.attacker = attacker;
        this.attacked = attacked;
    }
    
    public EnumWrappers.EntityUseAction getAction() {
        return this.action;
    }
    
    public Player getAttacker() {
        return this.attacker;
    }
    
    public Entity getAttacked() {
        return this.attacked;
    }
    
    public HandlerList getHandlers() {
        return UseEntityEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return UseEntityEvent.handlers;
    }

}

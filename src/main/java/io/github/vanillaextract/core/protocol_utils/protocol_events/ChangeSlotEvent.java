package io.github.vanillaextract.core.protocol_utils.protocol_events;

import org.bukkit.entity.*;
import com.comphenix.protocol.events.*;
import org.bukkit.event.*;

public class ChangeSlotEvent extends Event
{
    public Player player;
    public PacketEvent Event;
    private static final HandlerList handlers;
    
    static
    {
        handlers = new HandlerList();
    }
    
    public ChangeSlotEvent(final PacketEvent Event, final Player Player)
    {
        this.player = Player;
        this.Event = Event;
    }
    
    public PacketEvent getPacketEvent() {
        return this.Event;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public HandlerList getHandlers() {
        return ChangeSlotEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return ChangeSlotEvent.handlers;
    }
}

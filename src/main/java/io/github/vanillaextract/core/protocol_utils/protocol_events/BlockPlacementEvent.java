package io.github.vanillaextract.core.protocol_utils.protocol_events;

import org.bukkit.entity.*;
import com.comphenix.protocol.events.*;
import org.bukkit.event.*;

public class BlockPlacementEvent extends Event
{
    public Player player;
    public PacketEvent event;
    private static final HandlerList handlers;
    
    static
    {
        handlers = new HandlerList();
    }
    
    public BlockPlacementEvent(final PacketEvent event, final Player player)
    {
        this.player = player;
        this.event = event;
    }
    
    public PacketEvent getPacketEvent() {
        return this.event;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public HandlerList getHandlers() {
        return BlockPlacementEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return BlockPlacementEvent.handlers;
    }
}

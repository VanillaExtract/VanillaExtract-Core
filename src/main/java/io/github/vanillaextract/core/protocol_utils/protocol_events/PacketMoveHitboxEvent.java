package io.github.vanillaextract.core.protocol_utils.protocol_events;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PacketMoveHitboxEvent extends Event
{
    private Player player;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;
    private static final HandlerList handlers;
    private HitboxChangeType type;
    
    static
    {
        handlers = new HandlerList();
    }
    
    public PacketMoveHitboxEvent(final Player player, final double x, final double y, final double z, final float yaw, final float pitch, final HitboxChangeType type)
    {
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.type = type;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public HitboxChangeType getType() {
        return this.type;
    }
    
    public HandlerList getHandlers() {
        return PacketMoveHitboxEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return PacketMoveHitboxEvent.handlers;
    }
}

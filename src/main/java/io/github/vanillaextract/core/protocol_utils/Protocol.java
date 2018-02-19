package io.github.vanillaextract.core.protocol_utils;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.EnumWrappers;
import io.github.vanillaextract.core.VanillaCore;
import io.github.vanillaextract.core.protocol_utils.protocol_events.*;
import net.minecraft.server.v1_8_R1.PacketPlayInUseEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;

public class Protocol
{

    private VanillaCore plugin;

    public Protocol(VanillaCore plugin)
    {
        this.plugin = plugin;

        this.registerPacketEvents();
    }

    private void registerPacketEvents()
    {
        ProtocolLibrary.getProtocolManager().addPacketListener(
                (PacketListener) new PacketAdapter(this.plugin, new PacketType[] { PacketType.Play.Client.USE_ENTITY }) {
                    public void onPacketReceiving(final PacketEvent event) {
                        final PacketContainer packet = event.getPacket();
                        final Player player = event.getPlayer();
                        if (player == null) {
                            return;
                        }
                        if (packet.getHandle() instanceof PacketPlayInUseEntity) {
                            final PacketPlayInUseEntity packetNMS = (PacketPlayInUseEntity) packet.getHandle();
                            if (packetNMS.a() == null) {
                                return;
                            }
                        }
                        final EnumWrappers.EntityUseAction type = (EnumWrappers.EntityUseAction) packet
                                .getEntityUseActions().read(0);
                        final int entityId = (int) packet.getIntegers().read(0);
                        Entity entity = null;
                        for (final Entity entityentity : getEntities(player.getWorld())) {
                            if (entityentity.getEntityId() == entityId) {
                                entity = entityentity;
                            }
                        }
                        Bukkit.getServer().getPluginManager()
                                .callEvent((Event) new UseEntityEvent(type, player, entity));
                    }
                });
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener) new PacketAdapter(this.plugin,
                new PacketType[] { PacketType.Play.Client.POSITION_LOOK }) {
            public void onPacketReceiving(final PacketEvent event) {
                final Player player = event.getPlayer();
                if (player == null) {
                    return;
                }
                Bukkit.getServer().getPluginManager().callEvent((Event) new PacketMoveHitboxEvent(player,
                        (double) event.getPacket().getDoubles().read(0),
                        (double) event.getPacket().getDoubles().read(1),
                        (double) event.getPacket().getDoubles().read(2), (float) event.getPacket().getFloat().read(0),
                        (float) event.getPacket().getFloat().read(1), HitboxChangeType.POSLOOK));
            }
        });
        ProtocolLibrary.getProtocolManager().addPacketListener(
                (PacketListener) new PacketAdapter(this.plugin, new PacketType[] { PacketType.Play.Client.LOOK }) {
                    public void onPacketReceiving(final PacketEvent event) {
                        final Player player = event.getPlayer();
                        if (player == null) {
                            return;
                        }
                        Bukkit.getServer().getPluginManager()
                                .callEvent((Event) new PacketMoveHitboxEvent(player, player.getLocation().getX(),
                                        player.getLocation().getY(), player.getLocation().getZ(),
                                        (float) event.getPacket().getFloat().read(0),
                                        (float) event.getPacket().getFloat().read(1), HitboxChangeType.LOOK));
                    }
                });
        ProtocolLibrary.getProtocolManager().addPacketListener(
                (PacketListener) new PacketAdapter(this.plugin, new PacketType[] { PacketType.Play.Client.POSITION }) {
                    public void onPacketReceiving(final PacketEvent event) {
                        final Player player = event.getPlayer();
                        if (player == null) {
                            return;
                        }
                        Bukkit.getServer().getPluginManager()
                                .callEvent((Event) new PacketMoveHitboxEvent(player,
                                        (double) event.getPacket().getDoubles().read(0),
                                        (double) event.getPacket().getDoubles().read(1),
                                        (double) event.getPacket().getDoubles().read(2), player.getLocation().getYaw(),
                                        player.getLocation().getPitch(), HitboxChangeType.POSITION));
                    }
                });
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener) new PacketAdapter(this.plugin,
                new PacketType[] { PacketType.Play.Client.ENTITY_ACTION }) {
            public void onPacketReceiving(final PacketEvent event) {
                final PacketContainer packet = event.getPacket();
                final Player player = event.getPlayer();
                if (player == null) {
                    return;
                }
                Bukkit.getServer().getPluginManager()
                        .callEvent((Event) new EntityActionEvent(player, (int) packet.getIntegers().read(1)));
            }
        });
        ProtocolLibrary.getProtocolManager().addPacketListener(
                (PacketListener) new PacketAdapter(this.plugin, new PacketType[] { PacketType.Play.Client.KEEP_ALIVE }) {
                    public void onPacketReceiving(final PacketEvent event) {
                        final Player player = event.getPlayer();
                        if (player == null) {
                            return;
                        }
                        Bukkit.getServer().getPluginManager().callEvent((Event) new KeepAliveEvent(player));
                    }
                });
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener) new PacketAdapter(this.plugin,
                new PacketType[] { PacketType.Play.Client.ARM_ANIMATION }) {
            public void onPacketReceiving(final PacketEvent event) {
                final Player player = event.getPlayer();
                if (player == null) {
                    return;
                }
                Bukkit.getServer().getPluginManager().callEvent((Event) new PacketAnimationEvent(event, player));
            }
        });
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener) new PacketAdapter(this.plugin,
                new PacketType[] { PacketType.Play.Client.HELD_ITEM_SLOT }) {
            public void onPacketReceiving(final PacketEvent event) {
                final Player player = event.getPlayer();
                if (player == null) {
                    return;
                }
                Bukkit.getServer().getPluginManager().callEvent((Event) new ChangeSlotEvent(event, player));
            }
        });
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener) new PacketAdapter(this.plugin,
                new PacketType[] { PacketType.Play.Client.BLOCK_PLACE }) {
            public void onPacketReceiving(final PacketEvent event) {
                final Player player = event.getPlayer();
                if (player == null) {
                    return;
                }
                Bukkit.getServer().getPluginManager().callEvent((Event) new BlockPlacementEvent(event, player));
            }
        });
        ProtocolLibrary.getProtocolManager().addPacketListener(
                (PacketListener) new PacketAdapter(this.plugin, new PacketType[] { PacketType.Play.Client.FLYING }) {
                    public void onPacketReceiving(final PacketEvent event) {
                        final Player player = event.getPlayer();
                        if (player == null) {
                            return;
                        }
                        Bukkit.getServer().getPluginManager()
                                .callEvent((Event) new PacketMoveHitboxEvent(player, player.getLocation().getX(),
                                        player.getLocation().getY(), player.getLocation().getZ(),
                                        player.getLocation().getYaw(), player.getLocation().getPitch(),
                                        HitboxChangeType.FLYING));
                    }
                });
    }

    @SuppressWarnings("unchecked")
    public List<Entity> getEntities(final World world) {
        final List<Entity> entities = new ArrayList<Entity>();
        final net.minecraft.server.v1_8_R1.World nmsworld = (net.minecraft.server.v1_8_R1.World)((CraftWorld)world).getHandle();
        for (final Object o : new ArrayList<Object>(nmsworld.entityList)) {
            if (o instanceof net.minecraft.server.v1_8_R1.Entity) {
                final net.minecraft.server.v1_8_R1.Entity mcEnt = (net.minecraft.server.v1_8_R1.Entity)o;
                final Entity bukkitEntity = (Entity)mcEnt.getBukkitEntity();
                if (bukkitEntity == null) {
                    continue;
                }
                entities.add(bukkitEntity);
            }
        }
        return entities;
    }
}


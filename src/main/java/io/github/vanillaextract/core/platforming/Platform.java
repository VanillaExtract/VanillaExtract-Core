package io.github.vanillaextract.core.platforming;

import io.github.vanillaextract.core.VanillaCore;
import io.github.vanillaextract.core.platforming.platforms.PlatformConfig;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public abstract class Platform implements Listener
{
    private String platformDescription;
    private long platformID;
    private PlatformConfig platformConfig;
    private boolean register;

    public Platform(String platformDescription, long platformID, boolean register)
    {
        this.platformDescription = platformDescription;
        this.platformID = platformID;
        this.register = register;
        this.platformConfig = new PlatformConfig();
    }

    public long getPlatformID()
    {
        return platformID;
    }

    public String getPlatformDescription()
    {
        return platformDescription;
    }

    public PlatformConfig getPlatformConfig()
    {
        return platformConfig;
    }

    public void registerClazz(Listener listener)
    {
        PluginManager pluginManager = Bukkit.getPluginManager();

        if (register) {
            try {
                pluginManager.registerEvents(listener, VanillaCore.getMainClass());

            } catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

package io.github.vanillaextract.core;

import io.github.vanillaextract.core.listeners.EventListener;
import io.github.vanillaextract.core.platforming.platforms.PlatformConfig;
import io.github.vanillaextract.core.protocol_utils.Protocol;
import org.bukkit.Bukkit;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;


public class VanillaCore extends JavaPlugin {
    
    private static VanillaCore main = null;
    private Protocol protocol;
    private PlatformConfig platformConfig;

    @Override
    public void onEnable(){
        main = this;
        //load disk operations, inject dependencies, etc

        protocol = new Protocol(this);

        this.registerListeners();
        this.registerConfig();

        getLogger().info("VanillaExtract (Core) v0.1-ALPHA enabled");
    }

    @Override
    public void onDisable(){
        //gc,flushing,saving,etc.
        main = null;
        getLogger().info("VanillaExtract (Core) v0.1-ALPHA disabled");
    }
    
    /**Gets the main class, if it is enabled. This will never return null, however it will throw an IllegalStateException
      *when the plugin is disabled. A reference to the main class should ideally be kept once gotten.
      *@return A reference to the main class object
      *@throws IllegalStateException If the core is currently disabled
      */

    public static final VanillaCore getMainClass() throws IllegalStateException {
        if (!enabled()) throw new IllegalStateException("VanillaCore is disabled");
        return main;
    }

    private void registerListeners()
    {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new EventListener(), this);
    }

    private void registerConfig()
    {
        if (!this.getConfig().contains("platform"))
        {
            this.saveDefaultConfig();

            if (!getConfig().contains("platform"))
                getConfig().set("platform", "");

            if (!getConfig().contains("platform.config"))
                getConfig().set("platform.config", "");

            if (!getConfig().contains("platform.config.staff-permission"))
                getConfig().set("platform.config.staff-permission", "vanilla.staff");

            if (!getConfig().contains("platform.config.staff-login-message"))
                getConfig().set("platform.config.staff-login-message", "&c&l[STAFF]&b %player% has joined the server.");

            this.saveConfig();
            this.reloadConfig();
        }
    }

    
    public static final boolean enabled() {
        return main != null;
    }
}

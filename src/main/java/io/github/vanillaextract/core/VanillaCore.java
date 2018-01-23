package io.github.vanillaextract.core;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Synch on 2018-01-20.
 */
public class VanillaCore extends JavaPlugin {
    
    private static VanillaCore main = null;

    @Override
    public void onEnable(){
        main = this;
        //load disk operations, inject dependencies, etc
        
        getLogger().info("VanillaExtract (Core) v0.1-ALPHA enabled");
    }

    @Override
    public void onDisable(){
        //gc,flushing,saving,etc.
        main = null;
        
        getLogger().info("VanillaExtract (Core) v0.1-ALPHA disabled");
    }
    
    public static VanillaCore getMainClass() {
        if (!enabled()) throw new IllegalStateException("VanillaCore is disabled");
        return main;
    }
    
    public static boolean enabled() {
        return main != null;
    }
}

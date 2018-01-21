package io.github.vanillaextract.core;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Synch on 2018-01-20.
 */
public class VanillaCore extends JavaPlugin {

    @Override
    public void onEnable(){
        //load disk operations, inject dependencies, etc
    }

    @Override
    public void onDisable(){
        //gc,flushing,saving,etc.
    }
}

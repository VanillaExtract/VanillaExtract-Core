package io.github.vanillaextract.core.utils;

import org.bukkit.plugin.Plugin;

public interface Initializable<P extends Plugin> {

    public void initialize(P plugin);
    
}

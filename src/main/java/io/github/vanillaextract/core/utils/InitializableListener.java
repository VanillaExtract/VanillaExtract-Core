package io.github.vanillaextract.core.utils;

import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

public interface InitializableListener<P extends Plugin> extends Listener, Initializable<P> {

    /**Runs any required initialization code before this listener is registered. If this method has
      *already been called, this should do nothing.
      */
    @Override
    public void initialize(P plugin);

}

package io.github.vanillaextract.core.utils;

import org.bukkit.plugin.Plugin;
import java.util.ArrayList;

public class Initializer<P extends Plugin> {

    protected final P plugin;
    private ArrayList<Initializable<P>> list = new ArrayList<Initializable<P>>();

    public Initializer(P plugin) throws IllegalArgumentException {
        if (plugin == null) throw new IllegalArgumentException("Plugin specified cannot be null");
        this.plugin = plugin;
    }
    
    public Initializer(P plugin, Collection<Initializable<P>> initializables) {
        if (plugin == null) throw new IllegalArgumentException("Plugin specified cannot be null");
        if (initializables == null) throw new IllegalArgumentException("Collection of initializables specified cannot be null"_;
        for (Initializable<P> initializable : initializables) {
            if (initializable == null) continue;
            if (
        }
    }
    
    public void addToQueue(Initializable<P> initializable) throws IllegalArgumentException {
        if (initializable == null) return;
        int index = list.lastIndexOf(initializable);
        if (containsExact(initializable)) throw new IllegalArgumentException("This initializable was already added...");
        list.add(initializable);
    }
    
    public boolean initializeNext() throws NoSuchElementException, RuntimeException {
    if (list.isEmpty()) throw new NoSuchElementException("No more elements exist");
    Initializable<P> next = list.remove(0);
    if (next == null) throw new NullPointerException("Element is null");
    next.initialize(plugin);
    }
    
    public boolean hasNext() {
    return !list.isEmpty();
    }
    
    public boolean containsExact(Initializable<P> initializable) {
        if (initializable == null) return false;
        int index = list.lastIndexOf(initializable);
        return index != -1 && list.get(index) == initializable;
    }

}

package io.github.vanillaextract.core.protocol_utils.protocol_events;

public enum HitboxChangeType
{
    POSLOOK("POSLOOK", 0), 
    POSITION("POSITION", 1), 
    LOOK("LOOK", 2), 
    FLYING("FLYING", 3);
    
    private HitboxChangeType(final String s, final int n)
    {
    }
}

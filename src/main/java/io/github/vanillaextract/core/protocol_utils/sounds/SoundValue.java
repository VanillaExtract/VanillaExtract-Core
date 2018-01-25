package io.github.vanillaextract.core.protocol_utils.sounds;

import org.bukkit.Sound;

public class SoundValue {

Sound sound;
float volume;
float pitch;

public static final SoundValue SILENT = new SoundValue(Sounds.trySounds("DIG_WOOL", "BLOCK_CLOTH_BREAK"), 0.00001f, 1f);


/**Creates a trio of sound values with the given sound enum, volume, and pitch. This does not permit null values.
  *All SoundValue objects are immutable, unless they are a MutableSoundValue.
  *
  *@throws IllegalArgumentException If the sound provided is null
  *@see io.github.vanillaextract.core.protocol_utils.sounds.MutableSoundValue
  */
public SoundValue(Sound sound, float volume, float pitch) {
    if (sound == null) throw new IllegalArgumentException("Sound provided cannot be null");
    this.sound = sound;
    this.volume = volume;
    this.pitch = pitch;
    }
    
/**Returns the stored sound value. This should never return null.
  *
  */
public final Sound getSound() {
    return Sound;
    }
    
public final float getVolume() {
    return volume;
    }

public final float getPitch() {
    return pitch;
    }

}

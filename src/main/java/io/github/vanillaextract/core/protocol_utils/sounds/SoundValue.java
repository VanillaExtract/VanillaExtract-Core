public class SoundValue {

private Sound sound;
private float volume;
private float pitch;

public static final SoundValue SILENT = new SoundValue(Sounds.trySounds("DIG_WOOL", "BLOCK_CLOTH_BREAK"), 0.00001f, 1f);


/**Creates a trio of sound values with the given sound enum, volume, and pitch. This does not permit null values.
  *
  *@throws IllegalArgumentException If the sound provided is null
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
public Sound getSound() {
    return Sound;
    }
    
public float getVolume() {
    return volume;
    }

public float getPitch() {
    return pitch;
    }

}

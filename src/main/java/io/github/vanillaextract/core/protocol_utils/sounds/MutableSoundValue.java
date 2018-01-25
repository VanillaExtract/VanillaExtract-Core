/**A SoundValue object that allows for the editing of the sound, volume and pitch.
  *
  *{@inheritDoc}
  */

public class MutableSoundValue extends SoundValue {

    public MutableSoundValue(Sound sound, float volume, float pitch) {
        super(sound, volume, pitch);
    }
    
    /**Sets the sound to the given sound value.
      *@throws IllegalArgumentException If the sound provided is null
      */
    public final void setSound(Sound sound) throws IllegalArgumentException {
    if (sound == null) throw new IllegalArgumentException("Sound cannot be null");
    this.sound = sound;
    }
    
    public final void setVolume(float volume) {
    this.volume = volume;
    }
    
    public final void setPitch(float pitch) {
    this.pitch = pitch;
    }

}

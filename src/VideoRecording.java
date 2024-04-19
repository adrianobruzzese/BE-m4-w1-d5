package m4.w1.d5;

public class VideoRecording extends PlayableElement implements VolumeControl, BrightnessControl {
    private int brightnessLevel;
    private int soundLevel;

    public VideoRecording(String name, int duration, int brightnessLevel, int soundLevel) {
        super(name, duration);
        this.brightnessLevel = brightnessLevel;
        this.soundLevel = soundLevel;
    }

    //aumento/diminiusco la luminosità del video
    @Override
    public void increaseBrightness() {
        brightnessLevel++;
    }


    @Override
    public void decreaseBrightness(){
        if (brightnessLevel > 0) {
            brightnessLevel--;
        }
    }
    //Aumento/diminiusco il volume del video

    @Override
    public void lowerVolume() {
        if (soundLevel > 0) {
            soundLevel--;
        }
    }

    @Override
    public void raiseVolume() {
        soundLevel++;
    }

    //riproduzione principale, titolo/volume/luminosità

    @Override
    public void play() {
        for (int i = 0; i < duration; i++) {
            System.out.print(name);

            for (int j = 0; j < soundLevel; j++) {
                System.out.print("!");
            }
            for (int m = 0; m < brightnessLevel; m++) {
                System.out.print("!");
            }
            System.out.println();
        }
    }

    // Rappresentazione in stringa di VideoRecording
    @Override
    public String toString() {
        return "VideoRecording [Nome:" + name + ", Durata:" + duration + ", Volume:" + soundLevel + ", Luminosità:" + brightnessLevel + "]";
    }
}


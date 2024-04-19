package m4.w1.d5;

public class AudioRecording extends PlayableElement implements VolumeControl {
    private int soundLevel; //sostituiscela variabile del volume

    public AudioRecording(String name, int duration, int soundLevel) {
        super(name, duration);
        this.soundLevel = soundLevel;
    }
    //livello corrente volume
    public int getSoundLevel(){
        System.out.println("Volume a:" + soundLevel);
        return soundLevel;
    }
    //Imposto il volume
    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }
    // Rappresentazione in stringas di AudioRecording
    @Override
    public String toString(){
        return "AudioRecording [Volume a:" + soundLevel + ", Nome: " + name + ", Durata: " + duration + "]";
    }


    @Override
    public void lowerVolume() {
        if (soundLevel > 0) soundLevel--;
    }

    @Override
    public void raiseVolume(){
        soundLevel++;
    }

    @Override
    public void play() {
        for (int i = 0; i < duration; i++){
            System.out.print(name);
            for (int j=0; j < soundLevel; j++) {
                System.out.print("!"); //stampo un punto esclamativo ! per ogni unità di volume
            }
            System.out.println();
        }
    }
}
package m4.w1.d5;

public class Img extends MediaElement implements BrightnessControl {
    private int brightness;

    public Img(String name, int brightness) {
        super(name);
        this.brightness = brightness;
    }

    // Ottiene luminosità immagine
    public int getBrightness() {
        return brightness;
    }

    // Imposta nuova luminosità
    public void setBrightness(int newBrightness) {
        this.brightness = newBrightness;
    }

    // Aumenta la luminosità dell'immagine
    @Override
    public void increaseBrightness() {
        brightness++;
    }

    // Diminuisce la luminosità
    @Override
    public void decreaseBrightness() {
        if (brightness > 0) {
            brightness--;
        }
    }

    // Visualizzo
    public void show() {
        StringBuilder display = new StringBuilder(name);
        for (int i = 0; i < brightness; i++) {
            display.append("*");
        }
        System.out.println(display);
    }

    // Rappresentazione in stringa dell'immagine
    @Override
    public String toString() {
        return "Img: " + name + " - Luminosità: " + brightness;
    }
}
package m4.w1.d5;

abstract class PlayableElement extends MediaElement {
    protected int duration;

    public PlayableElement(String name, int duration) {
        super(name);
        this.duration = duration;
    }

    //ottiene la durata dell'elemento riproducibile
    public int getDuration(){
        return duration;
    }

    //imposta una nuova durata per l'elemento riproducibile
    public void setDuration(int duration) {
        this.duration = duration;
    }

    //metodo per riprodurre l'elemento
    public void play() {
        System.out.print("Nome: " + name + " - Durata: " + duration);
    }

    //rappresentazione in stringa
    @Override
    public String toString() {
        return "Elemento Riproducibile: " + name + " - Durata: " + duration;
    }
}
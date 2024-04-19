package m4.w1.d5;

abstract class MediaElement {

    protected String name;

    public MediaElement(String name) {
        this.name = name;
    }

    // Ottiene il titolo dell'elemento multimediale
    public String getName() {
        return name;
    }

    // Imposta un nuovo titolo
    public String setName(String newName) {
        this.name = newName;
        return newName;
    }

    // Rappresentazione stringa dell'elemento
    @Override
    public String toString() {
        return "Elemento Multimediale: " + name;
    }
}
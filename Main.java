import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaPlayer player = new MediaPlayer(scanner);

        // Ciclo per creazione e aggiunta di elementi multimediali
        for (int i = 0; i < 5; i++) {
            System.out.println("\nScegli un elemento da aggiungere:");
            System.out.println("1 - Video");
            System.out.println("2 - Audio");
            System.out.println("3 - Immagine");
            System.out.print("Scelta: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Seleziona un numero fra quelli indicati");
                scanner.nextLine(); // Termina la riga di input errato
                i--; // Ritorna al ciclo per far ripetere la scelta
                continue;
            }
            scanner.nextLine(); // Consuma il carattere di fine riga

            MediaElement element = null;
            switch (choice) {
                case 1:
                    System.out.println("\nHai scelto l'opzione Video. Inserisci i dati:");
                    System.out.print("Titolo: ");
                    String videoTitle = scanner.nextLine();
                    System.out.print("Durata (in secondi): ");
                    int videoDuration = scanner.nextInt();
                    System.out.print("Volume (da 0 a 100): ");
                    int videoVolume = scanner.nextInt();
                    System.out.print("Luminosità (da 0 a 100): ");
                    int videoBrightness = scanner.nextInt();
                    scanner.nextLine(); // Termina il caratere di fine riga
                    element = new VideoRecording(videoTitle, videoDuration, videoBrightness, videoVolume);
                    break;

                case 2:
                    System.out.println("\nHai scelto l'opzione Audio. Inserisci i dati:");
                    System.out.print("Titolo: ");
                    String audioTitle = scanner.nextLine();
                    System.out.print("Durata (in secondi): ");
                    int audioDuration = scanner.nextInt();
                    System.out.print("Volume (da 0 a 100): ");
                    int audioVolume = scanner.nextInt();
                    scanner.nextLine(); // Termina il carattere di fine riga
                    element = new AudioRecording(audioTitle, audioDuration, audioVolume);
                    break;

                case 3:
                    System.out.println("\nHai scelto l'opzione Immagine. Inserisci i dati:");
                    System.out.print("Titolo: ");
                    String imgTitle = scanner.nextLine();
                    System.out.print("Luminosità (da 0 a 100): ");
                    int imgBrightness = scanner.nextInt();
                    scanner.nextLine(); // Termina il carattere alla fine riga
                    element = new Img(imgTitle, imgBrightness);
                    break;

                default:
                    System.out.println("Scelta non valida. Per favore, segui le istruzioni.");
                    i--; // Ritorna al ciclo per far ripetere la scelta
                    continue;
            }

            if (element != null) {
                player.add(element, i);
            }
        }

        // Ciclo per la riproduzione e la visualizzazione degli elementi
        player.execute();
        scanner.close();

    }
}

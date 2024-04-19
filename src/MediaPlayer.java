package m4.w1.d5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MediaPlayer {
    private MediaElement[] mediaElements;
    private Scanner scanner;

    public MediaPlayer(Scanner scanner) {
        this.mediaElements = new MediaElement[5];
        this.scanner = scanner;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MediaPlayer player = new MediaPlayer(scanner);

        for (int  i = 0; i < 5; i++) {
            System.out.println("Premi 1 - Video, 2 - Audio, 3 - Immagine");
            int choice = 0;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input non corretto. Seleziona un numero fra quelli indicati");
                scanner.nextLine();
                i--;
                continue;
            }
            scanner.nextLine();
            MediaElement element = null;

            switch (choice) {
                case 1:
                    System.out.println("Hai scelto l'opzione Video. Titolo del video:");
                    String videoTitle = scanner.nextLine();
                    System.out.println("Durata del video:");
                    int videoDuration = scanner.nextInt();
                    System.out.println("Volume del video:");
                    int videoVolume = scanner.nextInt();
                    System.out.println("Luminosità:");
                    int videoBrightness = scanner.nextInt();

                    element = new VideoRecording (videoTitle, videoDuration, videoBrightness, videoVolume);
                    break;

                case 2:
                    System.out.println("Hai scelto l'opzione Audio. Titolo dell'audio:");
                    String audioTitle = scanner.nextLine();
                    System.out.println("Durata del l'audio:");
                    int audioDuration = scanner.nextInt();
                    System.out.println("Volume dell'audio:");
                    int audioVolume = scanner.nextInt();

                    element = new AudioRecording(audioTitle, audioDuration, audioVolume);
                    break;
                case 3:
                    System.out.println("Hai scelto l'opzione Immagine. Titolo dell'immagine:");
                    String title = scanner.nextLine();
                    System.out.println("Luminosità:");
                    int brightness = scanner.nextInt();
                    element = new Img(title, brightness);
                    break;
                default:
                    System.out.println("Scelta invalida. Per favore, segui le istruzioni.");
                    i--;
                    continue;
            }
            player.add(element, i);
        }
        player.execute();
        scanner.close();
    }
    public void add(MediaElement element, int index) {
        if (index >= 0 && index < mediaElements.duration) {
            mediaElements[index] = element;
        }
    }
    public void execute() {
        while (true) {
            System.out.println("Scegli un elemento da eseguire premendo un numero da 1 a 5, oppure 0 per terminare:");
            if (!scanner.hasNextInt()) {
                System.out.println("Seleziona un numero valido");
                scanner.next();
            }
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= 5 && mediaElements[choice - 1] != null) {
                if (mediaElements[choice - 1] instanceof PlayableElement) {
                    ((PlayableElement) mediaElements[choice - 1]).play();
                } else if (mediaElements[choice - 1] instanceof Img) {
                    ((Img) mediaElements[choice - 1]).show();
                }
            } else {
                System.out.println("IScelta non corretta, seleziona un numero valido.");

            }

        }
    }
}
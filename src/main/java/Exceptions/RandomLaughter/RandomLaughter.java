package Exceptions.RandomLaughter;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RandomLaughter {

    /*
    Laughter Clips from: https://soundbible.com/tags-laugh.html
     */

    public static void main(String[] args) {

        playTheLoop(20);
    }

    static void playTheLoop(int times){
        for (int i = 0; i < times; i++) {
            playOneClip();
        }
    }

    static void playOneClip() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(setSoundFile())));
            clip.start();
            try {
                TimeUnit.MICROSECONDS.sleep(clip.getMicrosecondLength() + 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clip.close();
        } catch (NullPointerException e) {
            System.err.println(e.getClass().getSimpleName() + ": Diese Datei ist nicht vorhanden.");
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getClass().getSimpleName() + ": Dieses System erkennt diesen Dateityp nicht als gültigen Datentypen für eine Sounddatei.");
        } catch (FileNotFoundException e) {
            System.err.println(e.getClass().getSimpleName() +  ": Das System kann diese Datei nicht finden.");
        } catch (IOException e) {
            System.err.println(e.getClass() + " " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println(e.getClass().getSimpleName() + ": Dieses Sound-Format wird nicht unterstützt.\n" + e.getMessage());
        }

    }

    public static String setSoundFile() {

        String soundFile;
        int index = (int)Math.round(Math.random() * 15) + 1;
        System.out.println("case # " + index);

        switch (index) {

            case 1:
                soundFile = "cartoonish-laugh";
                break;
            case 2:
                soundFile = "children-laughing";
                break;
            case 3:
                soundFile = "comedy-punch";
                break;
            case 4:
                soundFile = "crowd-laughing";
                break;
            case 5:
                soundFile = "hyena-laugh-1";
                break;
            case 6:
                soundFile = "hyena-laugh-2";
                break;
            case 7:
                soundFile = "hyena-laugh-3";
                break;
            case 8, 9:    // making this sound more likely to appear
                soundFile = "kid-giggle";
                break;
            case 10:
                soundFile = "kookaburra-birds";
                break;
            case 11:
                soundFile = "male-laughter-1";
                break;
            case 15:
                soundFile = "male-laughter-2";
                break;
            case 16:
                soundFile = "witch-laugh";
                break;
            default:        // default clip is also served on numbers 12, 13, and 14, making it the most likely clip to appear
                soundFile = "kid-laugh";
                break;
        }

        // WORKING PATH:
         return "src\\main\\java\\Exceptions\\RandomLaughter\\sounds\\" + soundFile + ".wav";

        // PATH RETURNING ERROR MESSAGES:
        // return null;                                                                     // NullPointerException
        // return "src\\main\\java\\Exceptions\\RandomLaughter\\sounds\\kid-giggle.mp3";    // UnsupportedAudioFileException
        // return "src\\main\\java\\Exceptions\\RandomLaughter\\sounds\\kid-giggles.wav";   // FileNotFoundException
        // return "src\\main\\java\\Exceptions\\RandomLaughter\\sounds\\" + "kid-laugh-notsupported" + ".wav";  // LineUnavailableException
    }
}

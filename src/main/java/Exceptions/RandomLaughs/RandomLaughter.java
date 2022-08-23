package Exceptions.RandomLaughs;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RandomLaughter {

    /*
    Laughter Clips from: https://soundbible.com/tags-laugh.html
     */

    /*
    Still in the Making...
     */

    public static void main(String[] args) throws LineUnavailableException, InterruptedException, UnsupportedAudioFileException, IOException {

        for (int i = 0; i < 19; i++) {

            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(setSoundFile())));
                clip.start();
                TimeUnit.MICROSECONDS.sleep(clip.getMicrosecondLength() + 20);
                clip.close();
            } catch (NullPointerException e) {
                System.err.println("NullPointerException: Diese Datei ist nicht vorhanden.");
            }

        }
    }

    public static String setSoundFile() {

        String soundFile;
        int index = (int)Math.round(Math.random() * 15) + 1;
        System.out.println(index);

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
            case 7:
                soundFile = "hyena-laugh-1";
                break;
            case 8:
                soundFile = "hyena-laugh-2";
                break;
            case 9:
                soundFile = "hyena-laugh-3";
                break;
            case 10:
                soundFile = "kid-giggle";
                break;
            case 11:
                soundFile = "kid-laugh";
                break;
            case 12:
                soundFile = "kookaburra-birds";
                break;
            case 14:
                soundFile = "male-laughter-1";
                break;
            case 15:
                soundFile = "male-laughter-2";
                break;
            case 16:
                soundFile = "witch-laugh";
                break;
            default:
                soundFile = "kid-giggle";
                break;
       }

        return "src\\main\\java\\Exceptions\\RandomLaughs\\Sounds\\" + soundFile + ".wav";
        // return "src\\main\\java\\Exceptions\\RandomLaughs\\" + "kid-laugh-notsupported" + ".wav";
    }
}

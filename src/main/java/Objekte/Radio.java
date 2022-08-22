package Objekte;

import java.util.Scanner;

public class Radio {

    boolean isOn;
    int volume;
    double frequency = 100.;

    public int getVolume() {
        return volume;
    }

    public void startRadio() {
        System.out.println("Möchtest du das Radio einschalten?");
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\"1\" für ein oder \"0\" für aus: ");
            byte isOn = new Scanner(System.in).nextByte();

            if (isOn == 1) {
                this.isOn = true;
                validInput = true;
                try {
                    setVolume();
                    System.out.println(this);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            } else if (isOn == 0) {
                this.isOn = false;
                validInput = true;
                System.out.println(this);
            } else {
                System.out.println("Bitte korrigiere deine Eingabe!");
            }
        }
    }

    private void setVolume() throws IllegalArgumentException {
        System.out.println("Wie laut soll das Radio spielen?");
        System.out.print("Bitte gib einen Wert zwischen \"0\" und \"100\" an: ");

        this.volume = new Scanner(System.in).nextInt();

        if (volume < 0) {
            volume = 0;
            throw new IllegalArgumentException("Die Lautstärke darf keinen negativen Wert haben!");
        } else if (volume > 100) {
            volume = 100;
            throw new IllegalArgumentException("Die Lautstärke darf maximal 100 betragen.");
        }
    }

    private void changeVolume(int value) {
        if (isOn) {
            if (volume + value > 100) {
                System.out.println("Die maximale Lautstärke beträgt 100.");
                volume = 100;
            } else if (volume + value < 0) {
                System.out.println("Die minimale Lautstärke beträgt 0.");
                volume = 0;
            } else {
                volume += value;
            }
        } else {
            System.out.println("Das Radio ist ausgeschaltet.");
        }
    }

    public void volumeUp() {
        changeVolume(1);
    }

    public void volumeDown() {
        changeVolume(-1);
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Das Radio " + (isOn ? "läuft auf der Frequenz " + getFrequency() + " mit Lautstärke " + getVolume() + "." : "läuft nicht.");
    }

    public static double stationNameToFrequency(String name) {

        name = name.trim().toLowerCase();
        if (name.equals("walking the plank")) {
            return 98.3;
        } else {
            return 0.0;
        }
    }
}

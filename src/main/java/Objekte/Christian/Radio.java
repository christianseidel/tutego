package Objekte.Christian;

import java.util.Scanner;

public class Radio {

    // I have yet to handel this exception...

    boolean isOn;
    int volume;

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
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
            } else if (isOn == 0) {
                this.isOn = false;
                validInput = true;
            } else {
                System.out.println("Bitte korrigiere deine Eingabe!");
            }
        }
        showRadio();
    }

    private void setVolume() throws IllegalArgumentException {
        System.out.println("Wie laut soll das Radio spielen?");
        System.out.print("Bitte gib einen Wert zwischen \"0\" und \"100\" an: ");

        if (volume < 0) {
            throw new IllegalArgumentException("Die Lautstärke kann nicht kleiner sein als 0!");
        } else if (volume > 100) {
            throw new IllegalArgumentException("Die Lautstärke kann maximal 100 betragen");
        }

        this.volume = new Scanner(System.in).nextInt();
    }

    private void showRadio() {
        if (this.isOn) {
            System.out.println("Das Radio läuft auf der Lautstärke: " + this.getVolume());
        } else {
            System.out.println("Das Radio ist ausgeschaltet.");
        }
    }
}

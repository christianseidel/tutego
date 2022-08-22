package Objekte;

import java.util.Scanner;

public class Radio {

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
                    showRadio();
                } catch (IllegalArgumentException e) {
                    System.err.println(e);
                }
            } else if (isOn == 0) {
                this.isOn = false;
                validInput = true;
                showRadio();
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
            throw new IllegalArgumentException("Die Lautstärke darf keinen negativen Wert haben!");
        } else if (volume > 100) {
            throw new IllegalArgumentException("Die Lautstärke darf maximal 100 betragen.");
        }
    }

    private void showRadio() {
        if (this.isOn) {
            System.out.println("Das Radio läuft auf der Lautstärke: " + this.getVolume());
        } else {
            System.out.println("Das Radio ist ausgeschaltet.");
        }
    }
}

package Objekte;

public class RadioApplication {
    /*
        Exercise from: http://www.tutego.de/javabuch/aufgaben/oop_classes.html#_klassendeklaration_und_objekteigenschaften
    */

    public static void main(String[] args) {

        Radio myRadio = new Radio();
        myRadio.startRadio();

        /*
        myRadio.volumeUp();
        myRadio.volumeUp();
        myRadio.volumeUp();
        myRadio.volumeUp();
        System.out.println("\n" + myRadio);

        myRadio.setFrequency(250);
        System.out.println("\n" + myRadio);

        myRadio.off();
        System.out.println("\n" + myRadio);
*/
        System.out.println(Radio.stationNameToFrequency("Mein Lieblingssender"));
        System.out.println(Radio.stationNameToFrequency("Walking the Plank "));

    }
}

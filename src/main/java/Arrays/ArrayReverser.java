package Arrays;

import java.util.Arrays;

public class ArrayReverser {

    public static void main(String[] args) {
/*  Array umdrehen:
    Charlie Creevey macht für Captain CiaoCiao die Finanzen. Doch statt die Einnahmen aufsteigend zu sortieren, hat er
    sie absteigend sortiert. Daher muss die Liste umgedreht werden. Ein Array umzudrehen bedeutet, dass das erste
    Element mit dem letzten Element vertauscht wird, das zweite mit dem zweitletzten usw.

    Aufgabe:
    Schreibe eine neue statische Methode reverse(), die ein gegebenes Array umdreht:

    public static void reverse( double[] numbers ) {
      // TODO
    }

    Die Operation soll in place sein, also das übergebene Array ändern. Wir wollen kein neues Array anlegen.
    Die Übergabe null führt zu einer Ausnahme.

    Beispiel:
            { } → { }
            { 1 } → { 1 }
            { 1, 2 } → { 2, 1 }
            { 1, 2, 3 } → { 3, 2, 1 }

 */

    }

    public double[] reverse(double[] numbers) {

        if (numbers == null) {
            throw new RuntimeException("this array is null");
        }

        int loops = numbers.length / 2;
        int end = numbers.length - 1;
        double swapper = 0;
        for (int i = 0; i < loops; i++) {
            swapper = numbers[end - i];
            numbers[end - i] = numbers[i];
            numbers[i] = swapper;
        }
        return numbers;
    }
}

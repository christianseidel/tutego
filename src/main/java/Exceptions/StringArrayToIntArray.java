package Exceptions;

public class StringArrayToIntArray {

    /*
    Task: Convert an array of Strings into an array of ints. Set a "0" where no conversion is possible.
    However, a value of null is to set off an Exception. For further details, see: http://www.tutego.de/javabuch/aufgaben/exception.html#_string_array_in_int_array_konvertieren_und_nachsichtig_bei_nichtzahlen_sein
     */

    public static void main(String[] args) {

    }

        static int[] parseInts(String... numbers) {

            int[] intsParsed = new int[numbers.length];

            for (int i = 0; i < intsParsed.length; i++) {
                try {
                    intsParsed[i] = Integer.parseInt(numbers[i]);
                } catch (NumberFormatException e) {
                    intsParsed[i] = 0;
                }
            }

            return intsParsed;
    }
}

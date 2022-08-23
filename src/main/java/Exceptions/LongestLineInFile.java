package Exceptions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LongestLineInFile {

    /*
    Task: Specify the two longest names in a list of family names.
     */

    public static void main(String[] args) {

        Path path = Paths.get("D:\\Programmieren\\Java\\ullenboom\\tutego\\src\\main\\java\\sources\\family-names.txt");

        List<String> allNames = List.of();

        try {
            allNames = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Die Datei konnte nicht gefunden werden.");
        }

        String longestName = "";
        String secondLongestName = "";
        int numberOfCharactersOfLongestName = 0;
        int numberOfCharactersOfSecondLongestName = 0;

        if (allNames.size() > 0) {
            for (String name : allNames) {
                if (name.length() > longestName.length()) {
                    secondLongestName = longestName;
                    longestName = name;
                    numberOfCharactersOfSecondLongestName = numberOfCharactersOfLongestName;
                    numberOfCharactersOfLongestName = name.length();
                }
            }
            System.out.println("" +
                    "Der längste Name lautet: \"" + longestName
                    + "\" und hat " + numberOfCharactersOfLongestName + " Buchstaben."
            + "\nDer zweitlängste Name lautet: \"" + secondLongestName
                    + "\" und hat " + numberOfCharactersOfSecondLongestName + " Buchstaben.");
        }


    }
}

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

        Path path = Paths.get("src\\main\\java\\sources\\family-names.txt");

        try {
            List<String> allNames = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (allNames.size() > 0) {
                String longestName = "", secondLongestName = "";
                int lengthOfLongestName = 0, lengthOfSecondLongestName = 0;

                for (String name : allNames) {
                    if (name.length() > longestName.length()) {
                        secondLongestName = longestName;
                        longestName = name;
                        lengthOfSecondLongestName = lengthOfLongestName;
                        lengthOfLongestName = name.length();
                    } else if (name.length() > secondLongestName.length()) {
                        secondLongestName = name;
                        lengthOfLongestName = name.length();
                    }
                }
                System.out.println("" +
                        "Der längste Name lautet: \"" + longestName
                        + "\" und hat " + lengthOfLongestName + " Buchstaben."
                        + "\nDer zweitlängste Name lautet: \"" + secondLongestName
                        + "\" und hat " + lengthOfSecondLongestName + " Buchstaben.");
            }

        } catch (IOException e) {
            System.err.println("Die Datei \"" + path.getFileName() + "\" konnte nicht gefunden werden.");
        }

    }
}

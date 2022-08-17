package Arrays;

import java.awt.*;

public class MinDistance {

/*  Aufgabe:
    Gegeben ist eine Menge von Point-Objekten in einem Array points für verschiedene Positionen:

    Point[] points = { new Point(10, 20), new Point(12, 2), new Point(44, 4) };

    Schreibe eine Methode double minDistance(Point[] points), die den Abstand des Punktes zurückliefert,
    der die geringste Distanz zum Nullpunkt besitzt.

    null als Übergabe ist nicht erlaubt, auch dürfen die Punkte nicht null sein;
    es muss eine Ausnahme ausgelöst werden.
 */


    public double computeMinDistance(Point[] points) {

        if (points == null) {
            throw new NullPointerException("Das Array hat den Wert null.");
        } else if (points.length == 0) {
            throw new RuntimeException("Ein Array ohne Elemente ist nicht zulässig.");
        }

        double minDistance = points[0].distance(new Point());

        if (points.length == 1) {
            return Math.round(minDistance * 100.0) / 100.0;
        }

        for (int i = 1; i < points.length; i++) {
            double nextPoint = points[i].distance(new Point());
            if (nextPoint < minDistance) {
                minDistance = nextPoint;
            }
        }
        return Math.round(minDistance * 100.0) / 100.0;
    }
}

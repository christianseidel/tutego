package Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MinDistanceTest {

    MinDistance minDistance;

    @BeforeEach
    public void setupAll() {
        minDistance = new MinDistance();
    }

    @Test
    @DisplayName("-> das Array hat den Wert null")
    void shouldThrowNullPointerException() {

        Point[] points = null;

        Exception exception = assertThrows(NullPointerException.class, () -> {
            minDistance.computeMinDistance(null);
        });

        assertEquals("Das Array hat den Wert null.", exception.getMessage());
    }

    @Test
    @DisplayName("-> ein Array ohne Elemente ist nicht zulässig")
    void shouldThrowRuntimeException_ArrayEmpty() {

        Point[] points = {};

        Exception exception = assertThrows(RuntimeException.class, () -> {
            minDistance.computeMinDistance(points);
        }, "Ein Array ohne Elemente ist nicht zulässig.");

        assertEquals("Ein Array ohne Elemente ist nicht zulässig.", exception.getMessage());
    }

    @Test
    @DisplayName("One Point On Axes Intersection")
    void shouldReturnZero() {

        Point[] pointOnZ = {new Point(0, 0)};

        assertEquals(0.0, minDistance.computeMinDistance(pointOnZ));
        assertEquals(0, minDistance.computeMinDistance(pointOnZ));
    }


    @Test
    @DisplayName("One Point On Axis")
    void shouldReturn12() {

        Point[] pointOnX = {new Point(12, 0)};
        Point[] pointOnY = {new Point(0, 12)};

        assertEquals(12.0, minDistance.computeMinDistance(pointOnX));
        assertEquals(12.0, minDistance.computeMinDistance(pointOnY));
    }

    @Test
    @DisplayName("One Point")
    void shouldReturnDistance_OnePoint() {

        Point[] onePoint = {new Point(12, 12)};

        assertEquals(16.97, minDistance.computeMinDistance(onePoint));
    }


    @Test
    @DisplayName("Three Points")
    void shouldReturnShortestDistance_ThreePoints() {

        Point[] points = {new Point(10, 20), new Point(12, 2), new Point(44, 4)};

        assertEquals(12.17, minDistance.computeMinDistance(points));
    }

    @Test
    @DisplayName("Six Points")
    void shouldReturnShortestDistance_SixPoints() {

        Point[] points = {new Point(100, 200), new Point(120, 20), new Point(440, 40), new Point(12, 12), new Point(300, 200), new Point(120, 120)};

        assertEquals(16.97, minDistance.computeMinDistance(points));
    }
}
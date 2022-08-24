package Exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayToIntArrayTest {

    @Test
    void shouldReturnArrayOfInts() {

        int[] actual = StringArrayToIntArray.parseInts("444", "123", "1000", "22");

        assertArrayEquals(new int[]{444, 123 , 1000, 22}, actual);
    }

    @Test
    void shouldReturnArrayWithOneZero() {

        int[] actual = StringArrayToIntArray.parseInts("444", "123", "1000", "Abracadabra");

        assertArrayEquals(new int[]{444, 123 , 1000, 0}, actual);
    }

    @Test
    void shouldReturnArrayWithOnlyZeros() {

        int[] actual = StringArrayToIntArray.parseInts("Abra-", "ca", "da", "bra");

        assertArrayEquals(new int[]{0, 0 , 0, 0}, actual);
    }

    @Test
    void expectNullPointerException() {

        assertThrows(NullPointerException.class, () -> {
            StringArrayToIntArray.parseInts(null);
        });
    }

    @Test
    void shouldPassWithValueOfNull() {

        int[] actual = StringArrayToIntArray.parseInts("Abra-", "ca", null, "bra");

        assertArrayEquals(new int[]{0, 0 , 0, 0}, actual);
    }
}
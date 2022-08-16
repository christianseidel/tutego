package Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


public class ArrayReverserTest {

    @Test
    void shouldProvokeException() {

        // given
        double[] emptyArray01 = null;
        ArrayReverser reverser = new ArrayReverser();

        // then
        assertThrows(RuntimeException.class, () -> {
            reverser.reverse(emptyArray01);
        }, "this array is null");
    }


    @Test
    void shouldReturnEmptyArray() {

        // given
        double[] emptyArray02 = new double[0];
        double[] emptyArray03 = new double[]{5.3, 3.5};
        emptyArray03[0] = 0.0;
        emptyArray03[1] = 0.0;
        ArrayReverser reverser = new ArrayReverser();

        // when
        double[] result02 = reverser.reverse(emptyArray02);
        double[] result03 = reverser.reverse(emptyArray03);

        // then
        assertArrayEquals(new double[]{}, result02);
        assertArrayEquals(new double[0], result02);
        assertArrayEquals(new double[]{0.0, 0.0}, result03);

    }

    @Test
    void shouldSwapElements_ArrayWith2Elements() {

        // given
        double[] array04 = new double[]{5.3, 3.5};
        ArrayReverser reverser = new ArrayReverser();

        // when
        double[] result04 = reverser.reverse(array04);

        // then
        assertArrayEquals(new double[]{3.5, 5.3}, result04);
    }

    @Test
    void shouldSwapElements_ArrayWith3Elements() {

        // given
        double[] array05 = {6.7, 7.8, 9.8};
        ArrayReverser reverser = new ArrayReverser();

        // when
        double[] result05 = reverser.reverse(array05);

        // then
        System.out.println(Arrays.toString(result05));
        assertArrayEquals(new double[]{9.8, 7.8, 6.7}, result05);

    }

    @Test
    void shouldSwapElements_ArrayWith8Elements() {

        // given
        double[] array06 = {6.7, 7.8, 9.8, 5.0, 40.0, 5.6, 6.6, 7.9};
        ArrayReverser reverser = new ArrayReverser();

        // when
        double[] result06 = reverser.reverse(array06);

        // then
        System.out.println(Arrays.toString(result06));
        assertArrayEquals(new double[]{7.9, 6.6, 5.6, 40.0, 5.0, 9.8, 7.8, 6.7}, result06);

    }

    @Test
    void shouldSwapElements_ArrayWith9Elements() {

        // given
        double[] array06 = {11.1, 6.7, 7.8, 9.8, 5.0, 40.0, 5.6, 6.6, 7.9};
        ArrayReverser reverser = new ArrayReverser();

        // when
        double[] result06 = reverser.reverse(array06);

        // then
        System.out.println(Arrays.toString(result06));
        assertArrayEquals(new double[]{7.9, 6.6, 5.6, 40.0, 5.0, 9.8, 7.8, 6.7, 11.1}, result06);

    }
}

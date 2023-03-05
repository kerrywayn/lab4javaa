package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();

    }

    @ParameterizedTest
    @CsvSource({"1, -3.858407", "1.7, 16.496383", "4, 1.255272"})
    void testF(double x, double expected) {
        double actual = main.f(x);
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    void testCalcSteps() {
        double start = 0;
        double end = 10;
        double step = 0.1;
        int expected = 101;
        int actual = main.calcSteps(start, end, step);
        assertEquals(expected, actual);
    }

    @Test
    void testFillX() {
        double start = 0.8;
        double end = 2.0;
        double step = 0.005;
        double[] expected = {
                0.8, 1.7, 2.0
        };
        double[] x = main.fillX(start, end, step);
        double[] actual = {x[0], x[180], x[240]};
        assertArrayEquals(expected, actual, 1e-6);
    }

    @Test
    void testFillY() {
        double start = 0.8;
        double end = 2.0;
        double step = 0.005;
        double[] expected = {
                -8.926881, 16.496383, 1.075528
        };
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double[] actual = {y[0], y[180], y[240]};
        assertArrayEquals(expected, actual, 1e-6);
    }

    @Test
    void testNumMin() {
        double[] a = {
                0.9, 7, -2.086, 3.47, -10.5, 4.6
        };
        int expected = 4;
        int actual = main.numMin(a);
        assertEquals(expected, actual);

    }

    @Test
    void testNumMax() {
        double[] a = {
                0.9, 7, -2.086, 3.47, -10.5, 4.6
        };
        int expected = 1;
        int actual = main.numMax(a);
        assertEquals(expected, actual);

    }

    @Test
    void testSum() {
        double[] a = {1.2, 0.8, 4.3, -7.7, 2.1};
        double expected = 0.7;
        double actual = main.sum(a);
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    void testAvg() {
        double[] a = {
                1.2, 0.8, 4.3, -7.7, 2.1
        };
        double expected = 0.14;
        double actual = main.avg(a);
        assertEquals(expected, actual, 1e-6);
    }
}

package test.model;

import org.junit.jupiter.api.Test;

import main.model.BisectionHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BisectionHandlerTest {

    @Test
    void testCompute() {
        // Test case 1: f(x) = x^2 - 4, expected root: 2.0
        double result1 = BisectionHandler.compute(1.0, 3.0, 1);
        assertEquals(2.0, result1, 0.00001);

        // Test case 2: f(x) = x^3 - x^2 - 4, expected root: 1.597
        double result2 = BisectionHandler.compute(1.5, 2.0, 2);
        assertEquals(1.597, result2, 0.001);

        // Test case 3: f(x) = x - cos(x), expected root: 0.739
        double result3 = BisectionHandler.compute(0.5, 1.0, 3);
        assertEquals(0.739, result3, 0.001);
    }
}

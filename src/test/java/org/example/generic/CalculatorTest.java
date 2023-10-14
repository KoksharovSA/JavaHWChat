package org.example.generic;

import junit.framework.TestCase;
import static org.junit.Assert.assertThrows;

public class CalculatorTest extends TestCase {

    public void testSum() {
        assertEquals(6.6, Calculator.sum(3, 3.6));
    }

    public void testSubtract() {
        assertEquals(-0.6000000000000001, Calculator.subtract(3, 3.6));
    }

    public void testDivide() {
        assertEquals(0.8333333333333333, Calculator.divide(3, 3.6));
        assertThrows(ArithmeticException.class, ()->{Calculator.divide(3, 0);});
    }

    public void testMultiply() {
        assertEquals(10.8, Calculator.multiply(3, 3.6));
    }
}
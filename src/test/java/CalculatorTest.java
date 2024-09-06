import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        int[] array = {1, 2, 3, 4, 5};
        int result = calculator.sum(array);
        assertEquals(15, result);
    }

    @Test
    public void testMinValue() {
        int[] array = {5, 2, 8, 1, 3};
        int result = calculator.minValue(array);
        assertEquals(1, result);
    }

    @Test
    public void testMaxValue() {
        int[] array = {5, 2, 8, 1, 3};
        int result = calculator.maxValue(array);
        assertEquals(8, result);
    }

    @Test
    public void testEvenNumber() {
        int[] array = {1, 2, 3, 4, 5, 6};
        int result = calculator.evenNumber(array);
        assertEquals(3, result);
    }

    @Test
    public void testNumberInAscendingOrder() {
        int[] array = {2, 3, 6, 8, 1, 5};
        int result = calculator.numberInAscendingOrder(array);
        assertEquals(2, result);
    }
}
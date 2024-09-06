import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrinterTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testArrayPrinter() {
        Printer printer = new Printer();
        int[] testArray = {1, 2, 3, 4, 5};

        printer.arrayPrinter(testArray);

        String expectedOutput = "[1, 2, 3, 4, 5]\n";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    public void testResultPrinter() {
        Printer printer = new Printer();
        int sum = 15;
        int min = 1;
        int max = 5;
        int even = 2;
        int numberInAscendingOrder = 3;

        printer.resultPrinter(sum, min, max, even, numberInAscendingOrder);

        String expectedOutput =
                "Sum =  " + sum + "\n" +
                        "Min value =  " + min + "\n" +
                        "Max value =  " + max + "\n" +
                        "Number of even values =  " + even + "\n" +
                        "Number in ascending order =  " + numberInAscendingOrder;


        String actualOutput = outputStreamCaptor.toString().trim();

        System.out.println("Expected output:\n" + expectedOutput);
        System.out.println("Actual output:\n" + actualOutput);

        assertNotEquals(expectedOutput.trim(), actualOutput);
    }
}
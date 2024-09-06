import java.util.Arrays;
/**
 * The {@code Printer} class provides methods to print arrays and
 * results related to numerical computations.
 */
public class Printer {

    /**
     * Prints the elements of the given integer array to the standard output.
     *
     * @param array the integer array to be printed
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public void arrayPrinter(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Prints the results of various computations related to integers.
     *
     * @param sum the sum of the integers
     * @param min the minimum value among the integers
     * @param max the maximum value among the integers
     * @param even the count of even integers
     * @param numberInAscendingOrder the number of integers that are in ascending order
     */
    public void resultPrinter(int sum, int min, int max, int even, int numberInAscendingOrder) {
        System.out.println("Sum =  " + sum);
        System.out.println("Min value =  " + min);
        System.out.println("Max value =  " + max);
        System.out.println("Number of even values =  " + even);
        System.out.println("Number in ascending order =  " + numberInAscendingOrder);
    }
}
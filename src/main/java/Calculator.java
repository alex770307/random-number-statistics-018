/**
 * The {@code Calculator} class provides methods to perform various calculations
 * on an array of integers, including summation, finding minimum and maximum values,
 * counting even numbers, and determining the number of integers in ascending order.
 */
public class Calculator {

    /**
     * Calculates the sum of the elements in the given integer array.
     *
     * @param array the integer array for which the sum is to be calculated
     * @return the sum of the elements in the array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Finds the minimum value among the elements in the given integer array.
     *
     * @param array the integer array from which to find the minimum value
     * @return the minimum value found in the array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public int minValue(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    /**
     * Finds the maximum value among the elements in the given integer array.
     *
     * @param array the integer array from which to find the maximum value
     * @return the maximum value found in the array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public int maxValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    /**
     * Counts the number of even numbers in the given integer array.
     *
     * @param array the integer array in which to count even numbers
     * @return the count of even numbers found in the array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public int evenNumber(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the number of integers in the given array that are in ascending order.
     * <p>
     * An integer is considered to be in ascending order if it is greater than its
     * preceding and less than its following integer.
     *
     * @param array the integer array in which to count integers in ascending order
     * @return the count of integers in ascending order found in the array
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public int numberInAscendingOrder(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] < array[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
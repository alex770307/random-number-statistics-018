
/**
 * The {@code Main} class serves as the entry point for the application.
 * It demonstrates the functionality of writing random integers to a file,
 * reading those integers, and performing calculations on them.
 */
public class Main {
    /**
     * The main method that initiates the program.
     * It creates a {@code MyFileWriter} to write random integers to a file,
     * then a {@code MyFileReader} to read those integers back, and finally,
     * it uses a {@code Calculator} to compute various statistics on the integer array.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Printer printer = new Printer();

        MyFileWriter myFileWriter = new MyFileWriter("Text.txt");
        myFileWriter.write();
        myFileWriter.close();

        MyFileReader myFileReader = new MyFileReader("Text.txt");
        int[] array = myFileReader.createArray();
        myFileReader.close();

        Calculator calculator = new Calculator();
        int sum = calculator.sum(array);
        int min = calculator.minValue(array);
        int max = calculator.maxValue(array);
        int even = calculator.evenNumber(array);
        int numberInAscendingOrder = calculator.numberInAscendingOrder(array);

        printer.arrayPrinter(array);
        printer.resultPrinter(sum, min, max, even, numberInAscendingOrder);
    }
}

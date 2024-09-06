import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The {@code MyFileReader} class provides functionality to read integers from a file.
 * It wraps a {@code BufferedReader} for reading lines from the file and supports
 * converting those lines into integers for further processing.
 */
public class MyFileReader {
    private BufferedReader bufferedReader;
    private static final int MAX_VALUE_OF_NUMBER = 100;

    /**
     * Constructs a {@code MyFileReader} for the specified file.
     *
     * @param fileName the name of the file to read from
     * @throws FileNotFoundException if the specified file does not exist
     */
    public MyFileReader(String fileName) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the next integer from the file.
     *
     * @return the integer read from the file, or -1 if there are no more integers
     *         or if a non-integer is encountered
     * @throws IOException if an I/O error occurs while reading from the file
     */
    public int read() throws IOException {
        String string = bufferedReader.readLine();
        if (string == null) {
            return -1;
        }
        try {
            int num = Integer.parseInt(string);
            return num;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Creates an array of integers read from the file.
     * <p>
     * The method reads integers until it reaches the maximum limit or
     * until there are no more integers to read.
     *
     * @return an array containing integers read from the file, truncated to the length
     *         of the actual number of integers read
     */
    public int[] createArray() {
        int[] array = new int[MAX_VALUE_OF_NUMBER];
        int count = 0;

        try {
            while (count < MAX_VALUE_OF_NUMBER) {
                int num = read();
                if (num == -1) {
                    break;
                }
                array[count] = num;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Closes the underlying {@code BufferedReader}.
     * This method should be called to release system resources associated with the reader.
     */
    public void close() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
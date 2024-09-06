import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * The {@code MyFileWriter} class provides functionality to write random integers to a file.
 * It generates random integers and writes each one to a specified file using a {@code BufferedWriter}.
 */
public class MyFileWriter {
    private BufferedWriter bufferedWriter;
    private Random random;
    private static final int MAX_VALUE_OF_NUMBER = 100;

    /**
     * Constructs a {@code MyFileWriter} with the specified file name.
     *
     * @param file the name of the file to write to
     * @throws IOException if an I/O error occurs while creating the writer
     */
    public MyFileWriter(String file) {
        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(file));
            this.random = new Random();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes an array of random integers to the file.
     * Each integer is written to a new line in the file.
     */
    public void write() {
        try {
            int[] array = rand();
            for (int num : array) {
                bufferedWriter.write(String.valueOf(num));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the underlying {@code BufferedWriter}.
     * This method should be called to release system resources associated with the writer.
     */
    public void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates an array of random integers.
     *
     * @return an array filled with random integers ranging from 0 to {@code MAX_VALUE_OF_NUMBER - 1}
     */
    public int[] rand() {
        int[] array = new int[MAX_VALUE_OF_NUMBER];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_VALUE_OF_NUMBER);
        }
        return array;
    }
}
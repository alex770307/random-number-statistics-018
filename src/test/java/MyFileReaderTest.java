import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class MyFileReaderTest {
    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = Files.createTempFile("testFile", ".txt");
    }

    @AfterEach
    public void tearDown() throws IOException {

        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testReadValidNumber() throws IOException {
        Files.writeString(tempFile, "42\n");

        MyFileReader myFileReader = new MyFileReader(tempFile.toString());
        int result = myFileReader.read();

        assertEquals(42, result);
        myFileReader.close();
    }

    @Test
    public void testReadInvalidNumber() throws IOException {
        Files.writeString(tempFile, "invalid\n");

        MyFileReader myFileReader = new MyFileReader(tempFile.toString());
        int result = myFileReader.read();

        assertEquals(-1, result);
        myFileReader.close();
    }

    @Test
    public void testReadEndOfFile() throws IOException {
        MyFileReader myFileReader = new MyFileReader(tempFile.toString());
        int result = myFileReader.read(); // Файл пустой для начала

        assertEquals(-1, result);
        myFileReader.close();
    }

    @Test
    public void testCreateArrayWithValidNumbers() throws IOException {
        Files.writeString(tempFile, "1\n2\n3\n4\n5\n");

        MyFileReader myFileReader = new MyFileReader(tempFile.toString());
        int[] result = myFileReader.createArray();

        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, java.util.Arrays.copyOf(result, 5));

        for (int i = 5; i < result.length; i++) {
            assertEquals(0, result[i]);
        }

        myFileReader.close();
    }

    @Test
    public void testCreateArrayWithEndOfFile() throws IOException {
        MyFileReader myFileReader = new MyFileReader(tempFile.toString());
        int[] result = myFileReader.createArray();

        int[] expected = new int[100];
        assertArrayEquals(expected, result);
        myFileReader.close();
    }

    @Test
    public void testCloseBufferedReader() throws IOException {
        MyFileReader myFileReader = new MyFileReader(tempFile.toString());

        assertDoesNotThrow(() -> myFileReader.close());
    }

    @Test
    public void testConstructorFileNotFound() {
        MyFileReader myFileReader = new MyFileReader("invalid_file.txt");
    }
}

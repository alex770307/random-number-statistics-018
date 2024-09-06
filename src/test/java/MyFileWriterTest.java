import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFileWriterTest {
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
    public void testWrite() throws IOException {
        MyFileWriter myFileWriter = new MyFileWriter(tempFile.toString());
        myFileWriter.write();
        myFileWriter.close();

        try (BufferedReader bufferedReader = Files.newBufferedReader(tempFile)) {
            int count = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int number = Integer.parseInt(line);
                assertEquals(true, number >= 0 && number < 100);
                count++;
            }
            assertEquals(100, count);
        }
    }

    @Test
    public void testClose() {
        MyFileWriter myFileWriter = new MyFileWriter(tempFile.toString());

        assertDoesNotThrow(() -> myFileWriter.close());
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileToStringTest {

    @Test
    void getFileOutput() {
        String path = "/home/jamsid/Desktop/text.txt";
        FileToString test = new FileToString(path);
        String testResults = test.getFileOutput();
        String expected = "This is the\noutput test\n";
        assertEquals(expected,testResults);
    }
}
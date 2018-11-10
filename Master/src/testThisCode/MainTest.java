import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        String javaPath = "/home/jamsid/Desktop/test.java";
        String outPutPath = "/home/jamsid/Desktop/text.txt";
        Main test = new Main(javaPath,outPutPath);
        test.runStudentFile();
        String expectedOutput = test.expectedOutputFile.getFileOutput();
        String studentOutput = test.studentSubmissionFile.getProgramOutput();
        assertEquals(expectedOutput,studentOutput);
    }
}
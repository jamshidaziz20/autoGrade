import com.sun.xml.internal.bind.v2.TODO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        String javaFile = "Test";
        String textFile = "SampleTextFile";

        String javaPath = "/home/jamshid/IntelliJWorkspace/jtester/Master/TestingFiles1/src/"+javaFile+".java";
        String outPutPath = "/home/jamshid/IntelliJWorkspace/jtester/Master/TestingFiles1/textFiles/"+textFile+".txt";
        Main test = new Main(javaPath,outPutPath);
        test.runStudentFile();
        String expectedOutput = test.expectedOutputFile.getFileOutput();
        String studentOutput = test.studentSubmissionFile.getProgramOutput();
        assertEquals(expectedOutput,studentOutput);

    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentSubmissionFileTest {

    @Test
    void getJavaCode() {
        String path = "/home/jamsid/Desktop/test.java";
        StudentSubmissionFile test = new StudentSubmissionFile(path);
        String temp = test.getJavaCode();
        System.out.println(temp);
    }
}
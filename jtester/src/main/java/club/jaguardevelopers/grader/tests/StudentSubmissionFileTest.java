package club.jaguardevelopers.grader.tests;

import club.jaguardevelopers.grader.ExpectedOutputFile;
import club.jaguardevelopers.grader.StudentSubmissionFile;
import org.apache.commons.math3.util.Precision;
import info.debatty.java.stringsimilarity.JaroWinkler;


public class StudentSubmissionFileTest {

    private StudentSubmissionFile studentFile;
    private ExpectedOutputFile expectedFile;
    private JaroWinkler similarityPercent = new JaroWinkler();

    public StudentSubmissionFileTest(StudentSubmissionFile studentFile, ExpectedOutputFile expectedFile) {
        this.studentFile = studentFile;
        this.expectedFile = expectedFile;

    }

    public double isOutputSameAsExpectedOutput() {

        if (!studentFile.getProgramOutput().equals(expectedFile.toString())) {
            double percent = similarityPercent.similarity(studentFile.getProgramOutput(), expectedFile.toString());
            return Precision.round(percent, 3);
        } else {
            return 1;
        }

    }


}
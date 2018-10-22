package club.jaguardevelopers.grader;


import club.jaguardevelopers.grader.tests.StudentSubmissionFileTest;
import org.json.*;

public class Main {

    private TerminalCommands terminal;
    private StudentSubmissionFile studentFile;
    private ExpectedOutputFile expectedFile;

    public Main(String studentFilePath, String expectedOutputFilePath) {
        terminal = new TerminalCommands();
        studentFile = new StudentSubmissionFile(studentFilePath);
        expectedFile = new ExpectedOutputFile(expectedOutputFilePath);
    }

    private void run() {
        //Total Compile Time
        long compileTimeStart = System.nanoTime();
        terminal.runJAVAC(studentFile);
        long compileTimeEnd = System.nanoTime();
        long totalCompileTime = (compileTimeEnd - compileTimeStart) / 1000000000;

        //Total Run Time
        long runTimeStart = System.nanoTime();
        terminal.runJAVA(studentFile);
        long runTimeEnd = System.nanoTime();
        long totalRunTime = (runTimeEnd - runTimeStart) / 1000000000;

        StudentSubmissionFileTest test = new StudentSubmissionFileTest(studentFile, expectedFile);

        try {

            JSONObject mainJSON = new JSONObject();
            JSONObject timeJSON = new JSONObject();

            //Json objects for compile and run time of student file
            timeJSON.put("totalRunTimeInSeconds", totalRunTime);
            timeJSON.put("totalCompileTimeInSeconds", totalCompileTime);
            JSONArray jsonTimeArray = new JSONArray();
            jsonTimeArray.put(timeJSON);

            //Json objects for student output
            mainJSON.put("exitStatus", studentFile.getExitStatus());
            if (studentFile.getExitStatus() != 0) {
                mainJSON.put("message", studentFile.getErrorOutput());
            } else {
                mainJSON.put("message", "Compiled Successfully");
            }
            mainJSON.put("studentOutput", studentFile.getProgramOutput());
            mainJSON.put("similarityPercentage", test.isOutputSameAsExpectedOutput());
            mainJSON.put("expectedOutput", expectedFile.toString());
            mainJSON.put("processTimes", jsonTimeArray);
            String output = mainJSON.toString(3);
            System.out.println(output);


        } catch (Exception e) {
            System.out.println("Critical error in creating json object");
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        Main main = new Main(args[0], args[1]);
        main.run();
    }
}

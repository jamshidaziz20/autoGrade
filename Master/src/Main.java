/**
 * What needs to be done:
 * IF STUDENT CODE COMPILES:
 * RUN EACH TEST (WILL BE A JAR FILE)
 * DEPENDING ON EACH TEST, WILL NEED TO PASS DIFFERENT PARAMETERS
 * THE TEST MUST RETURN A JSON FILE
 */



public class Main {

    public static TerminalCommands terminalCommands;
    public static StudentSubmissionFile studentSubmissionFile;
    public static FileToString expectedOutputFile;
    public String[] Tests;

    /**
     * This constructor makes 3 new objects: terminalCommands, studentSubmissionFile, fileToStrings
     * @param studentFilePath- the path to the java file to test
     * @param expectedOutputFilePath- the path to expected output text file
     * @param - a list of test that we need to runStudentFile on each file
     */
    public Main(String studentFilePath, String expectedOutputFilePath) {
        terminalCommands = new TerminalCommands();
        studentSubmissionFile = new StudentSubmissionFile(studentFilePath);
        expectedOutputFile = new FileToString(expectedOutputFilePath);
//        this.Tests = Tests.split(",");
    }

    /**
     * Compiles the student file
     * Runs the student file
     * Measure the compile & runStudentFile time
     */
    public void runStudentFile() {

        terminalCommands.runJAVAC(studentSubmissionFile);
        terminalCommands.runJAVA(studentSubmissionFile);

//        studentSubmissionFile.print();
//        System.out.println(expectedOutputFile.getFileOutput());


    }

    /**
     * First argument is the path to java file
     * Second argument is the path to the "expected" text file
     * Third argument is a string of tests separated by comma
     */
    public static void main(String[] args) {

        Main assignment = new Main(args[0],args[1]);
        assignment.runStudentFile();
        /**TODO:
         * Iterate through the tests array and execute each test
         *
         */

    }//end of main method

}//end of class

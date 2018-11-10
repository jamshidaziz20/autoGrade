/**
 * What needs to be done:
 * IF STUDENT CODE COMPILES:
 * RUN EACH TEST (WILL BE A JAR FILE)
 * DEPENDING ON EACH TEST, WILL NEED TO PASS DIFFERENT PARAMETERS
 * THE TEST MUST RETURN A JSON FILE
 */



public class Main {

    public TerminalCommands terminalCommands;
    public StudentSubmissionFile studentSubmissionFile;
    public FileToString expectedOutputFile;
    public String[] Tests;
    public double totalCompileTime;
    public double totalRunTime;

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
        //Total Compile Time
        double compileTimeStart = System.nanoTime();
        terminalCommands.runJAVAC(studentSubmissionFile);
        double compileTimeEnd = System.nanoTime();
        totalCompileTime = (compileTimeEnd - compileTimeStart) / 1000000000;

        //Total Run Time
        double runTimeStart = System.nanoTime();
        terminalCommands.runJAVA(studentSubmissionFile);
        double runTimeEnd = System.nanoTime();
        totalRunTime = (runTimeEnd - runTimeStart) / 1000000000;

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

    }//end of main method

}//end of class

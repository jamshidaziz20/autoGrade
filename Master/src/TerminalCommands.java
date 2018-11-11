
import java.io.*;
import java.util.Scanner;

public class TerminalCommands {


    public TerminalCommands() {

    }

    /**
     * This method compiles the given student java file using the executeCommand() method
     * @param file - the student java file
     */
    public void runJAVAC(StudentSubmissionFile file) {
        String command = "javac " + file.getPath();
        try {
            Process process = Runtime.getRuntime().exec(command);
            file.setErrorOutput(readFromTerminal(process.getErrorStream()));
            process.waitFor();
            file.setExitStatus(process.exitValue());
//            process.destroy(); not sure if should destroy the process
        } catch (IOException e) {
            System.out.println("IOException: runStudentCode() in TerminalCommands.java");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: runStudentCode() in TerminalCommands.java");
        }

    }

    /**
     * This method runs the given student java file
     * @param file - the student java file
     */
    public void runJAVA(StudentSubmissionFile file) {
        String command = "java -cp " + file.getParentFilePath() + " " + file.getFileName();
        try {
            Process process = Runtime.getRuntime().exec(command);
            file.setProgramOutput(readFromTerminal(process.getInputStream()));
            file.setErrorOutput(readFromTerminal(process.getErrorStream()));
            process.waitFor();
            file.setExitStatus(process.exitValue());
//            process.destroy(); not sure if should destroy the process
        } catch (IOException e) {
            System.out.println("IOException: runStudentCode() in TerminalCommands.java");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: runStudentCode() in TerminalCommands.java");
        }
    }


    /**
     * executeCommand() calls this method 2 times:
     * 1st time for the program output
     * 2nd time for the error output stream (only if the program does not compile properly)
     * @param input - receives an InputStream object
     * @return - returns a string (the output read from the terminal)
     * @throws IOException
     */
    private String readFromTerminal(InputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        StringBuilder terminalOutput = new StringBuilder();
        String temp = "";
        while ((temp = bufferedReader.readLine()) != null) {
            terminalOutput.append(temp);
            terminalOutput.append("\n");
        }

//        if(terminalOutput.length()>0){
//            terminalOutput.delete(terminalOutput.length()-2,terminalOutput.length());
//        }

        return terminalOutput.toString();
    }


}//end of class

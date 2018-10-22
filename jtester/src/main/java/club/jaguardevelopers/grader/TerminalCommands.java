package club.jaguardevelopers.grader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TerminalCommands {

    public TerminalCommands() {

    }

    public void runJAVAC(IJavaFile file) {
        String command = "javac " + file.getPath();
        executeCommand(command, file);

    }

    public void runJAVA(IJavaFile file) {
        String command = "java -cp " + file.getParentFilePath() + " " + file.getFileName();
        executeCommand(command, file);
    }


    private void executeCommand(String command, IJavaFile file) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            file.setProgramOutput(generateOutput(process.getInputStream()));
            file.setErrorOutput(generateOutput(process.getErrorStream()));
            process.waitFor();
            file.setExitStatus(process.exitValue());
        } catch (IOException e) {
            System.out.println("IOException: runStudentCode() in TerminalCommands.java");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: runStudentCode() in TerminalCommands.java");
        }
    }

    private String generateOutput(InputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        StringBuilder line = new StringBuilder();
        String temp = "";

        while ((temp = bufferedReader.readLine()) != null) {
            line.append(temp);
            line.append("\n");
        }

        return line.toString();
    }


}

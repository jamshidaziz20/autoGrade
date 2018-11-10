
import java.io.File;

public class StudentSubmissionFile  {

    private File file;

    private String programOutput;
    private String errorOutput;
    private String javaCode;

    private int exitStatus;

    public StudentSubmissionFile(String filePath) {
        file = new File(filePath);

        FileToString javaCodeObject = new FileToString(filePath);
        javaCode = javaCodeObject.getFileOutput();
    }

    public String getFileName() {
        return file.getName().replace(".java","");
    }

    public String getPath() {
        return file.getPath();
    }

    public String getParentFilePath(){
        return file.getParent();
    }

    public String getErrorOutput() {
        return errorOutput;
    }

    public String getProgramOutput() {
        return programOutput;
    }

    public String getJavaCode() {
        return javaCode;
    }


    public void setProgramOutput(String programOutput) {
        this.programOutput = programOutput;
    }

    public void setErrorOutput(String errorOutput) {
        this.errorOutput = errorOutput;
    }

    public void setExitStatus(int exitStatus) {
        this.exitStatus = exitStatus;
    }


    public int getExitStatus() {
        return exitStatus;
    }


    //***********************************************
    //DEBUG METHODS
    //***********************************************
    public void print() {
        System.out.println("Java file full path:    " +getPath());
        System.out.println("Java file name:         " +getFileName());
        System.out.println("Jave file parent path:  " +file.getParent());
        System.out.println("Java file Code: \n" +getJavaCode());
        System.out.println("Java file compilation error: \n" +getErrorOutput());
        System.out.println("Program Output \n" +getProgramOutput());
    }
}

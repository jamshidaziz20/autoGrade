package club.jaguardevelopers.grader;

import java.io.File;

public class StudentSubmissionFile implements IJavaFile {

    private File file;
    private String programOutput;
    private String errorOutput;
    private int exitStatus;

    public StudentSubmissionFile(String filePath) {
        file = new File(filePath);
    }

    @Override
    public String getFileName() {
        return file.getName().replace(".java","");
    }

    @Override
    public String getPath() {
        return file.getPath();
    }

    @Override
    public String getParentFilePath(){
        return file.getParent();
    }

    public String getProgramOutput() {
        return programOutput;
    }

    public void setProgramOutput(String programOutput) {
        this.programOutput = programOutput;
    }

    public String getErrorOutput() {
        return errorOutput;
    }

    public void setErrorOutput(String errorOutput) {
        this.errorOutput = errorOutput;
    }

    public int getExitStatus() {
        return exitStatus;
    }

    public void setExitStatus(int exitStatus) {
        this.exitStatus = exitStatus;
    }


    //***********************************************
    //DEBUG METHODS
    //***********************************************

    public void print() {
        System.out.println(getPath());
        System.out.println(getFileName());
        System.out.println(file.getParent());
        System.out.println(errorOutput);
    }

}

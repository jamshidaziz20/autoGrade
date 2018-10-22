package club.jaguardevelopers.grader;

public interface IJavaFile {
    String getFileName();
    String getPath();
    String getParentFilePath();
    String getErrorOutput();
    void setErrorOutput(String errorOutput);
    void setProgramOutput(String programOutput);
    void setExitStatus(int exitStatus);
}

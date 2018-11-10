
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileToString {

    private File file;
    private StringBuilder fileOutput;

    public FileToString(String path) {
        this.file = new File(path);
        fileOutput = new StringBuilder();
        readFile();
    }

    private void readFile() {
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String phrase = scan.nextLine();
                fileOutput.append(phrase);
                fileOutput.append("\n");
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: readFile() in FileToString.java");
            e.printStackTrace();
        }
    }

    public String getFileOutput() {
        return fileOutput.toString();
    }


}//end of class

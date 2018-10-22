package club.jaguardevelopers.grader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ExpectedOutputFile {

    private File file;
    private List<String[]> fileOutputList;

    public ExpectedOutputFile(String path){
        this.file = new File(path);
        fileOutputList = new LinkedList<>();
        parseExpectedOutputFile();
    }


    private void parseExpectedOutputFile() {
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String phrase = scan.nextLine();
                fileOutputList.add(phrase.split("\\s+"));
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: getExpectedOutput() in ExpectedOutputFile.java");
        }
    }

    public List<String[]> getFileOutputList() {
        return fileOutputList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String[] arr : fileOutputList) {
            for (String string : arr) {
                stringBuilder.append(string);
                stringBuilder.append(" ");
            }

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }


}

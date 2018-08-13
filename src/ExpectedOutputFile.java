import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExpectedOutputFile {
	
	private String pathToFile;
	private String fileOutput;
	
	public ExpectedOutputFile(String pathToFile) {
		setPathToFile(pathToFile);
		try {
			setFileOutput(generateOutput(new File(pathToFile)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String generateOutput(File input) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(input));
		String line = "";
		String temp = "";
		while((temp = in.readLine()) != null)
			line += temp + "\n";
		return line;
	}//end of generateOutput

	public String getPathToFile() {
		return pathToFile;
	}
	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}
	
	public String getFileOutput() {
		return fileOutput;
	}
	public void setFileOutput(String fileOutput) {
		this.fileOutput = fileOutput;
	}

}//end of class

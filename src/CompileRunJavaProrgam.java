import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CompileRunJavaProrgam {
	
	private static StudentSubmission stdnt; 
	private static ExpectedOutputFile file;
	
	public static void main(String[] args) {
		
		file = new ExpectedOutputFile(args[1]);//args[1] is the path to the text file
		stdnt = new StudentSubmission(args[0]);//args[0] is the path to the java file

		try {	
			System.out.println("Terminal Command: "+stdnt.compileJavaCommand());
			runProcess(stdnt.compileJavaCommand());
			System.out.println("*****");
			
			System.out.println("Terminal Command: "+stdnt.runJavaCommand());
			runProcess(stdnt.runJavaCommand());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(file.getFileOutput().equals(stdnt.getProgramOutput()));

		
	}//end of main
	
	private static String generateOutput(InputStream input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String line = "";
		String temp = "";
		while((temp = in.readLine()) != null)
			line += temp + "\n";
		return (!(line.equals(null))) ? line: "";
	}//end of generateOutput
	
	private static void runProcess(String command) throws IOException, InterruptedException {
		Process proc = Runtime.getRuntime().exec(command);
		stdnt.setProgramOutput(generateOutput(proc.getInputStream()));
		stdnt.setErrOutPut(generateOutput(proc.getErrorStream()));
		System.out.println(stdnt.getProgramOutput());
		System.out.print(stdnt.getErrOutPut());
		proc.waitFor();
		System.out.println("exitvalue(): "+proc.exitValue());
	}


}//end of class


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.*;

public class CompileRunJavaProrgam {
	
	private static StudentSubmission stdnt; 
	private static ExpectedOutputFile textFile;
	
	public static void main(String[] args) {
		
		textFile = new ExpectedOutputFile(args[1]);//args[1] is the path to the text file
		stdnt = new StudentSubmission(args[0]);//args[0] is the path to the java file

		try {	
			
			long startCompileTime = System.nanoTime();
			runProcess(stdnt.compileJavaCommand());
			long endCompileTime   = System.nanoTime();
			double totalCompileTime = (double)(endCompileTime-startCompileTime)/ 1000000000.0;

			long startRunTime = System.nanoTime();
			runProcess(stdnt.runJavaCommand());
			long endRunTime = System.nanoTime();
			double totalRunTime = (double)(endRunTime-startRunTime)/ 1000000000.0;
			
			stdnt.setResult((textFile.getFileOutput().equals(stdnt.getProgramOutput())? "pass" : "fail")); //sets the student result, whether pass or fail
			JSONObject mainJson = new JSONObject();
			JSONObject tempJson = new JSONObject();
			tempJson.put("totalCompileTime", totalCompileTime);
			tempJson.put("totalRunTime", totalRunTime);
			JSONArray jsonArray = new JSONArray();
			jsonArray.put(tempJson);
			
			mainJson.put("status", stdnt.getExitStatus());
			mainJson.put("result", stdnt.getResult());
			if(stdnt.getExitStatus() != 0)
				mainJson.put("message", stdnt.getErrOutPut());
			else
				mainJson.put("message", "Compiled Succesfully!");
			mainJson.put("studentOutput", stdnt.getProgramOutput());
			mainJson.put("expectedOutput", textFile.getFileOutput());
			mainJson.put("processTime", jsonArray);
			String message = mainJson.toString(3);
			System.out.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//end of main
	
	private static String generateOutput(InputStream input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String line = "";
		String temp = "";
		while((temp = in.readLine()) != null)
			line += temp + "\n";
		return (!(line.equals(null))) ? line: "";
	}//end of generateOutput
	
	
	/*
	 * This method runs a given command in the terminal
	 * stores the given output in the stdnt object
	 * waits for current process to end before starting a new one
	 * prints the exit value, signifying whether the process was successful
	 */
	private static void runProcess(String command) throws Exception {
		Process proc = Runtime.getRuntime().exec(command);
		stdnt.setProgramOutput(generateOutput(proc.getInputStream()));
		stdnt.setErrOutPut(generateOutput(proc.getErrorStream()));
		proc.waitFor();
		stdnt.setExitStatus(proc.exitValue());
	}


}//end of class

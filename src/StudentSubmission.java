

public class StudentSubmission {
	private String javaFileName;
	private String programOutput;
	private String errOutPut;
	private String fullPath;
	private String filteredPath;
	private int exitStatus;
	private String result;
	
	public StudentSubmission(String fullPath) {
		this.fullPath = fullPath;
		this.filteredPath = filterPathName(fullPath);
		this.javaFileName = filterJavaFileName(fullPath);
	}

	
	public String compileJavaCommand() {
		return "javac "+this.fullPath;
	}
	
	public String runJavaCommand() {
		return "java -classpath "+this.filteredPath+" "+this.javaFileName;
	}
	
	public String getProgramOutput() {
		return programOutput;
	}
	
	public void setProgramOutput(String programOutput) {
		this.programOutput = programOutput;
	}

	public String getErrOutPut() {
		return errOutPut;
	}

	public void setErrOutPut(String errOutPut) {
		this.errOutPut = errOutPut;
	}
	
	/*
	 * This method extracts the filename without the .java part
	 */
	public String filterJavaFileName(String path) {
		String[] pathArr = path.split("/");
		return pathArr[pathArr.length-1].split("\\.")[0];
	}
	
	/*
	 * This method removes the .java part of the path
	 * And returns back a string of the path without the .java
	 */
	public String filterPathName(String path) {
		String[] pathArr = path.split("\\/");
		String x= "";
		for(int i=0;i<pathArr.length-1;i++) {
			x += pathArr[i] + "/";
		}
		return x;
	}


	public int getExitStatus() {
		return exitStatus;
	}


	public void setExitStatus(int exitStatus) {
		this.exitStatus = exitStatus;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	
}

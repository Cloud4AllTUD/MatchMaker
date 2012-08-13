import java.io.*;

public class IOOperations {

	public IOOperations() {}
	
	public String getFileContents(String fileName) throws FileNotFoundException, IOException {
		String fileContents = "";
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		while( (line = reader.readLine()) != null ) {
			fileContents = fileContents + line;
		}
		reader.close();
		return fileContents;
	}

}

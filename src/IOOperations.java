import java.io.*;

public class IOOperations {

	public IOOperations() {}
	
    /**
     * returns the contents of a text file
     */
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

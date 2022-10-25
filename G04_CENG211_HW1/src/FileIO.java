import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	public static String[][] readFile(String filename) throws IOException{
		String[][] array = new String[25][10];
		
		//Reads the file and creates a two-dimensional array
		//Reads a line, then separate by commas. 
		//Example: "ID,Name,Email,Country,Address" is first line, ID is [0][0], name is [0][1]...
 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String str;
			int count = 0;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
				array[count] = str.split(",");
				count++;
			}
			
			reader.close();

		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;

	}

}

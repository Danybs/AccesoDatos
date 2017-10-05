import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("TextTest.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("TextTest2.txt"));
				String rLine=in.readLine();
				while (rLine!=null) {
					out.write(rLine);
					rLine=in.readLine();
					}
				in.close();
				out.flush();
				out.close();				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
}
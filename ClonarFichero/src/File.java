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
			BufferedReader in = new BufferedReader(new FileReader("TextTest"));
			BufferedWriter out = new BufferedWriter(new FileWriter("TextTest2"));
			BufferedReader in2 = new BufferedReader(new FileReader("TextTest2"));
				String rLine=in.readLine();
				while (rLine!=null) {
					out.write(rLine);
					out.newLine();
					rLine=in.readLine();
					}
				in.close();
				out.flush();
				out.close();
				String rLine2=in2.readLine();
				while(rLine2!=null) {
					System.out.println(rLine2);
					rLine2=in2.readLine();					
				}	
				in2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
}
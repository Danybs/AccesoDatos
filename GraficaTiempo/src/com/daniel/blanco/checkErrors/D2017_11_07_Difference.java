package com.daniel.blanco.checkErrors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D2017_11_07_Difference {
	//20171109_Pronostico.csv
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader read1 = new BufferedReader(new FileReader("20171109_Pronostico.csv"));
			String a;
			while((a=read1.readLine())!=null) {
				
				System.out.println(a);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

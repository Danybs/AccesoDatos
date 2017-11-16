package com.daniel.blanco.checkErrors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D2017_11_07_Difference {
	//20171109_Pronostico.csv
	
	public static void main(String[] args) throws IOException {
		BufferedReader r1;
		BufferedReader r2;
		String l1,l2;
		
			try {
				r1 = new BufferedReader(new FileReader("datosAemet.csv"));
				r2 = new BufferedReader(new FileReader("20171109_Pronostico.csv"));
				for (int i = 0; i < 5; i++) {
					r1.readLine();
				}				
				l1 = r1.readLine();
				l2 = r2.readLine();
				while((r1!=null) && (r2!=null))  {					
					if(l1<l2) {//fechas
						l1 = r1.readLine();
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("No se encuentra fichero.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Problemas leyendo el fichero maestro");
			}
			
			try {
		
			}catch (Exception e) {
				// TODO: handle exception
			}		
		
			
	}

}

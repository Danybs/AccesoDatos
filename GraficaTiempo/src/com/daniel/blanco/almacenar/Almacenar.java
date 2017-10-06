/**
 * 
 */
package com.daniel.blanco.almacenar;

/**
 * @(#)Almacenar.java
 * @author Dani
 * @version 1.00 2017/10/06
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Almacenar {
	public static void main(String[] args) throws IOException {
		try {
			int i = 0;
			DecimalFormat df=new DecimalFormat("#.00");//Damos formato de 2 digitos
			BufferedReader in = new BufferedReader(new FileReader("wrf_arw_det_history_d02_20151015_1200.txt"));
			String rLine = in.readLine();
			while (rLine != null) {
				rLine = in.readLine();//nos saltamos el enunciado
				String[] storeValue = rLine.split(",");
				for (int j = 0; j < storeValue.length; j++) {
					if (j == 0 || j == 8) { //indicamos hora y temperatura
						System.out.print(storeValue[j] + " ");
						if (j == 8) {
							String k=storeValue[j];
							double c=Double.parseDouble(k);
							c=c-273.15F;
							System.out.print(df.format(c));
						}
					}
				}
				System.out.println();

				rLine = in.readLine();
			}
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

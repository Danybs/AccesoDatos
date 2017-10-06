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

public class Almacenar {
	void read() throws IOException{
		try {
			BufferedReader in=new BufferedReader(new FileReader("wrf_arw_det_history_d02_20151015_1200.txt"));
			String dateFile = in.readLine();
			String rLine=in.readLine();
			while (dateFile!=null) {
				rLine=in.readLine();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

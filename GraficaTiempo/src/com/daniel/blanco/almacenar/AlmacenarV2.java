package com.daniel.blanco.almacenar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;

/*Para cada día Temp max, temp min, horas a las que esta prevista y temp media del dia
Para el periodo completo, temperatura maxima, temperatura minima que dia y hora, temp media del periodo y si esta prevista lluvia(4dias)*/
/*date,lat[unit="degrees_north"],lon[unit="degrees_east"],
 * dir[unit="degree"],mod[unit="m s-1"],mslp[unit="Pa"],
 * prec[unit="kg m-2"],rh[unit="1"],temp[unit="K"],wind_gust[unit="m s-1"]
*/
/*https://docs.oracle.com/javase/7/docs/api/java/util/Date.html*/
/**
 * @(#)Almacenar.java
 * @author Dani
 * @version 2.00 2017/10/25
 */
public class AlmacenarV2 {
	public static void main(String[] args) {
		float temp_max,temp_min,temp_avg;
		try {
			BufferedReader in = new BufferedReader(new FileReader("wrf_arw_det_history_d02_20151015_1200.txt"));
			String rLine;
			rLine=in.readLine(); // Nos saltamos la cabecera 
			TreeSet<Dia> tS = new TreeSet<Dia>(); // Array donde almacenaremos cada fecha
			while((rLine=in.readLine())!=null) { // Leemos el fichero y almacenamos cada fecha
				Dia day = new Dia(rLine.split(","));
				tS.add(day);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

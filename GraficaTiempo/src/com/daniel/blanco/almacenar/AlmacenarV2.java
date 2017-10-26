package com.daniel.blanco.almacenar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
		int dias=5; // Dias que queremos que cuente
		float temp_max = 0;
		float temp_min = 500;
		float temp_avg = 0;
		float temp_avg_sum = 0;
		int count = 0; //contador de la media temp
		int count2 = 0; //contador para detectar dias
		Date hora_prevTM = null;
		Date hora_prevTMN = null;
		Date print_day = null;
		int last_day = 0;
		int num_day = 0;
		boolean rain = false;
		boolean print = false;
		boolean hola = false;
		try {
			BufferedReader in = new BufferedReader(new FileReader("wrf_arw_det_history_d02_20151015_1200.txt"));
			/*DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);//Formato fecha dia, para cabecera
			DateFormat dateF2 = new SimpleDateFormat("HH:mm:ss", Locale.FRANCE);//Damos formato horas, para temp max y min*/
			String rLine;
			rLine = in.readLine(); // Nos saltamos la cabecera
			DecimalFormat df = new DecimalFormat("0");// Damos formato de 2 digitos
			TreeSet<Dia> tS = new TreeSet<Dia>(); // Array donde almacenaremos cada fecha
			while ((rLine = in.readLine()) != null) { // Leemos el fichero y almacenamos cada fecha
				Dia day = new Dia(rLine.split(","));
				tS.add(day);
			}
			in.close();
			// Por dias
			for (Dia dia : tS) {				
				num_day = dia.getFechaYhora().getDay(); // Esta fecha la comparamos con la del ultimo dia
				if (num_day != last_day) { // Comenzamos algoritmo B para detectar 4 dias
					if (print) {
						System.out.println("----------------Dia: " + print_day.toInstant() + "----------------" 
								+ "\nLa temperatura maxima " + df.format(temp_max) + "ºC a las "
								+ hora_prevTM.toInstant() + "\nLa temperatura minima " + df.format(temp_min) + "ºC a las "
								+ hora_prevTMN.toInstant() + "\nLa temperatura media "
								+ (df.format(temp_avg = (temp_avg_sum / count))) + "ºC"
								+ "\nLa probabilidad de lluvia es " + rain + "\n");
						count2++;
						if (count2 == dias) { // Dias que queremos que cuente
							break;
						}
					}
					temp_max = 0; // Reseteamos todos los valores para hacer un nuevo dia
					temp_min = 500;
					temp_avg = 0;
					temp_avg_sum = 0;
					count = 0;
					hora_prevTM = null;
					hora_prevTMN = null;
					rain = false;
				}
				
				
				if (dia.getTemp() > temp_max) { // Seleccionamos la temp max y su hora
					temp_max = dia.getTemp();
					hora_prevTM = dia.getFechaYhora();
				}
				if (dia.getTemp() < temp_min) { // Seleccionamos la temp min y su hora
					temp_min = dia.getTemp();
					hora_prevTMN = dia.getFechaYhora();
				}
				if (dia.getPrec() != 0.0) { // Seleccionamos si lloverá
					rain = true;
				}
				temp_avg_sum = temp_avg_sum + dia.getTemp(); // Media diaria de las temperaturas
				count++; // contador para hacer la media de las temperaturas diarias
				print = true; // Ponemos a true para que cuando el dia sea diferente imprima el dia
				print_day = dia.getFechaYhora(); // Almacenamos el dia para imprimirlo
				last_day = dia.getFechaYhora().getDay(); // Comparamos la ultima fecha con la siguiente fecha
				/*if(tS.last().equals(dia)) {
					if (print) {
						System.out.println("----------------Dia: " + print_day.toInstant() + "----------------" 
								+ "\nLa temperatura maxima " + df.format(temp_max) + "ºC a las "
								+ hora_prevTM.toInstant() + "\nLa temperatura minima " + df.format(temp_min) + "ºC a las "
								+ hora_prevTMN.toInstant() + "\nLa temperatura media "
								+ (df.format(temp_avg = (temp_avg_sum / count))) + "ºC"
								+ "\nLa probabilidad de lluvia es " + rain + "\n");
						count2++;
						if (count2 == dias) { // Dias que queremos que cuente
							break;
						}
					}
					temp_max = 0; // Reseteamos todos los valores para hacer un nuevo dia
					temp_min = 500;
					temp_avg = 0;
					temp_avg_sum = 0;
					count = 0;
					hora_prevTM = null;
					hora_prevTMN = null;
					rain = false;
				}*/
			}
			// Global
			temp_max = 0; // Reseteamos todos los valores para hacer el periodo de 4 dias
			temp_min = 500;
			temp_avg = 0;
			temp_avg_sum = 0;
			count = 0;
			count2 = 0;
			hora_prevTM = null;
			hora_prevTMN = null;
			last_day = 0;
			num_day = 0;
			rain = false;
			print = false;
			for (Dia dia : tS) {
				num_day = dia.getFechaYhora().getDay();// Esta fecha la comparamos con la del ultimo dia
				if (num_day != last_day) { // Comenzamos algoritmo B para detectar 4 dias
					if (print) {
						count2++;
						if (count2 == dias) { // Dias que queremos que cuente
							break;
						}
					}
				} // Finalizamos
				if (dia.getTemp() > temp_max) {
					temp_max = dia.getTemp();
					hora_prevTM = dia.getFechaYhora();
				}
				if (dia.getTemp() < temp_min) {
					temp_min = dia.getTemp();
					hora_prevTMN = dia.getFechaYhora();
				}
				if (dia.getPrec() != 0.0) {
					rain = true;
				}
				temp_avg_sum = temp_avg_sum + dia.getTemp();
				count++;
				print = true; // Parte algoritmo B
				last_day = dia.getFechaYhora().getDay(); // Comparamos la ultima fecha con la siguiente fecha
				temp_avg = temp_avg_sum / count;
			}
			System.out.println(
					"\nDatos globales (4 primeros dias):" + "\nLa temperatura maxima del periodo " + (df.format(temp_max)) + "ºC el dia "
							+ hora_prevTM.toInstant() + "\nLa temperatura minima del periodo " + (df.format(temp_min))
							+ "ºC el día " + hora_prevTMN.toInstant() + "\nLa temperatura media del periodo "
							+ (df.format(temp_avg)) + "ºC" + "\nLa probabiliad de lluvia en el periodo es " + rain);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

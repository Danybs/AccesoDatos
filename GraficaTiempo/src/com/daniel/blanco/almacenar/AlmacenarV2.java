package com.daniel.blanco.almacenar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TreeSet;

/*Para cada d�a Temp max, temp min, horas a las que esta prevista y temp media del dia
Para el periodo completo, temperatura maxima, temperatura minima que dia y hora, temp media del periodo y si esta prevista lluvia(4dias)*/

/**
 * @(#)Almacenar.java
 * @author Dani
 * @version 2.00 2017/10/25
 */
public class AlmacenarV2 {
	public static void main(String[] args) {
		int dias = 10; // Dias que queremos que cuente, en caso de querer solo los 4 primeros
		float temp_max = 0;
		float temp_min = 500;
		float temp_avg = 0;
		float temp_avg_sum = 0;
		int count = 0; // contador de la media temp
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
			DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");// Formato fecha dia, para cabecera
			DateFormat dateF2 = new SimpleDateFormat("HH:mm");// Damos formato horas, para temp max y min
			DecimalFormat df = new DecimalFormat("0");// Damos formato de 2 digitos
			String rLine;
			rLine = in.readLine(); // Nos saltamos la cabecera
			TreeSet<Dia> tS = new TreeSet<Dia>(); // Array donde almacenaremos cada fecha
			while ((rLine = in.readLine()) != null) { // Leemos el fichero y almacenamos cada fecha
				Dia day = new Dia(rLine.split(","));
				tS.add(day);
			}
			in.close();
			// Por dias
			for (Dia dia : tS) {
				num_day = dia.getFechaYhora().getDate(); // Esta fecha la comparamos con la del ultimo dia
				if (num_day != last_day) { // Comenzamos algoritmo B para detectar 4 dias
					if (print) {
						System.out.println("----------------Dia: " + dateF.format(print_day) + "----------------"
								+ "\nLa temperatura maxima " + df.format(temp_max) + "�C a las "
								+ dateF2.format(hora_prevTM) + "\nLa temperatura minima " + df.format(temp_min)
								+ "�C a las " + dateF2.format(hora_prevTMN) + "\nLa temperatura media "
								+ (df.format(temp_avg = (temp_avg_sum / count))) + "�C");
						if (rain) {
							System.out.println("Hay probabilidad de lluvia\n");
						} else {
							System.out.println("No hay probabilidad de lluvia\n");
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
				if (dia.getPrec() != 0.0) { // Seleccionamos si llover�
					rain = true;
				}
				temp_avg_sum = temp_avg_sum + dia.getTemp(); // Media diaria de las temperaturas
				count++; // contador para hacer la media de las temperaturas diarias
				print = true; // Ponemos a true para que cuando el dia sea diferente imprima el dia
				print_day = dia.getFechaYhora(); // Almacenamos el dia para imprimirlo
				last_day = dia.getFechaYhora().getDate(); // Comparamos la ultima fecha con la siguiente fecha
				if (tS.last().equals(dia)) {
					if (print) {
						System.out.println("----------------Dia: " + dateF.format(print_day) + "----------------"
								+ "\nLa temperatura maxima " + df.format(temp_max) + "�C a las "
								+ dateF2.format(hora_prevTM) + "\nLa temperatura minima " + df.format(temp_min)
								+ "�C a las " + dateF2.format(hora_prevTMN) + "\nLa temperatura media "
								+ (df.format(temp_avg = (temp_avg_sum / count))) + "�C");
						if (rain) {
							System.out.println("Hay probabilidad de lluvia\n");
						} else {
							System.out.println("No hay probabilidad de lluvia\n");
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
			}
			// Global
			temp_max = 0; // Reseteamos todos los valores para hacer el periodo de 4 dias
			temp_min = 500;
			temp_avg = 0;
			temp_avg_sum = 0;
			count = 0;
			hora_prevTM = null;
			hora_prevTMN = null;
			last_day = 0;
			num_day = 0;
			rain = false;
			print = false;
			for (Dia dia : tS) {
				num_day = dia.getFechaYhora().getDate();// Esta fecha la comparamos con la del ultimo dia
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
				last_day = dia.getFechaYhora().getDate(); // Comparamos la ultima fecha con la siguiente fecha
				temp_avg = temp_avg_sum / count;
			}
			System.out.println("\nDatos globales: " + "\nLa temperatura maxima del periodo " + (df.format(temp_max))
					+ "�C el dia " + dateF.format(hora_prevTM) + " a las " + dateF2.format(hora_prevTM)
					+ "\nLa temperatura minima del periodo " + (df.format(temp_min)) + "�C el dia "
					+ dateF.format(hora_prevTMN) + " a las " + dateF2.format(hora_prevTMN)
					+ "\nLa temperatura media del periodo " + (df.format(temp_avg)) + "�C");
			if (rain) {
				System.out.println("Hay probabilidad de lluvia\n");
			} else {
				System.out.println("No hay probabilidad de lluvia\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

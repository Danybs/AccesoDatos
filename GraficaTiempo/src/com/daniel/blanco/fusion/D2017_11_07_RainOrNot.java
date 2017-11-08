package com.daniel.blanco.fusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TreeSet;

import com.daniel.blanco.DatosAemet.DatosAemetV2;
import com.daniel.blanco.DatosAemet.Dia;

/**
 * 
 * @author Daniel Blanco Sanz 2DAM
 *
 */
public class D2017_11_07_RainOrNot {
	TreeSet<Dia> ts = new TreeSet<Dia>();
	Date date; // Variable para almacenar las fechas
	DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);// Formato fecha
	File fichero1 = new File("noRainDays.csv");
	File fichero2 = new File("RainDays.csv");

	// Metodo para leer el fichero y almacenarlo en un TreeSet para ordenarlo
	void readFile() {
		try {
			System.out.println("Leyendo fichero...");
			BufferedReader read = new BufferedReader(new FileReader("datosAemet.csv"));
			String city, update, whitespace, head; // Cabecera
			city = read.readLine(); // Lectura ciudad
			update = read.readLine(); // Lectura update
			whitespace = read.readLine(); // Lectura espacio en blanco
			head = read.readLine(); // Lectura cabecera
			String rLine;
			while ((rLine = read.readLine()) != null) {
				String a1 = rLine.replaceAll("\"", "");
				Dia day = new Dia(a1.split(","));
				ts.add(day);
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo para escribir los dias no lluviosos
	void writeNoRainDays() {
		if (!fichero1.exists()) {
			try {
				System.out.println("Escribiendo dias no lluviosos...");
				BufferedWriter write = new BufferedWriter(new FileWriter("noRainDays.csv"));
				for (Dia dia : ts) {
					if (dia.getPrecipi() == 0) {
						date = dia.getFechaYhora();
						write.write(dateF.format(date));
						write.newLine();
					}
				}
				write.flush();
				write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			fichero1.delete();
		}
	}

	// Metodo para escribir los dias lluviosos
	void writeRainDays() {
		if (!fichero2.exists()) {
			try {
				System.out.println("Escribiendo días lluviosos");
				BufferedWriter write = new BufferedWriter(new FileWriter("RainDays.csv"));
				for (Dia dia : ts) {
					if (dia.getPrecipi() != 0) {
						date = dia.getFechaYhora();
						write.write(dateF.format(date));
						write.newLine();
					}
				}
				write.flush();
				write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			fichero1.delete();
		}
	}

	public static void main(String[] args) {
		// Llamada al metodo main de la otra clase para actualizar el fichero DatosAemetV2 con los nuevos días
		DatosAemetV2.main(args);

		// Llamamos a los metodos de la clase
		D2017_11_07_RainOrNot obj = new D2017_11_07_RainOrNot();
		obj.readFile();
		obj.writeNoRainDays();
		obj.writeRainDays();
	}
}

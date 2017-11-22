package com.daniel.blanco.checkErrors;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;



public class D2017_11_07_Difference{
	// Falta convertir la lluvia
	private BufferedReader fMaestro, fMovimientos;
	private BufferedWriter fEnfrentamientos;
	private String lMaestro, lMovimientos;
	private String head=("Fecha CET, Fecha GMT, Velocidad del viento (m/s), Presion atmosférica (Pa), Precipitación (mm), Humedad (1) , Temperatura (Cº)");
	private 
	
	void read() {
		try {
			System.out.println("Abriendo buffers...");
			fMaestro = new BufferedReader(new FileReader("datosAemet.csv"));
			fMovimientos = new BufferedReader(new FileReader("20171109_Pronostico.csv"));
			fEnfrentamientos = new BufferedWriter(new FileWriter("Enfrentamientos.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Problema en la apertura de los fichero");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error");
		}
	}

	public void header() {
		try {
			System.out.println("Leyendo y escribiendo cabeceras...");
			for (int i = 0; i < 4; i++) { // Omitimos la cabecera del fichero datosAemet.csv
				fMaestro.readLine();
			}
			lMaestro = fMaestro.readLine();
			fMovimientos.readLine(); //Nos saltamos la cabecera del archivo movimientos
			fEnfrentamientos.write(head);//Escribimos la cabecera del archivo
			fEnfrentamientos.newLine();
			lMovimientos = fMovimientos.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Problema en la cabecera del fichero");
		}
	}

	public void compare() {
		try {
			System.out.println("Comparando y escribiendo dias...");
			while ((fMaestro != null) && (fMovimientos != null)) {
				lMaestro = lMaestro.replaceAll("\"", "");
				if (lMovimientos == null || lMaestro == null) { // Si alguno de los ficheros se queda a null salimos ya que no hay datos
					break; // que comparar
				}
				C_aemet d1 = new C_aemet(lMaestro.split(","));
				C_stbn d2 = new C_stbn(lMovimientos.split(","));
				if (d1.getFechaYhora().before(d2.getFechaYhora())) {// fechas
					lMaestro = fMaestro.readLine();
				} else if (d1.getFechaYhora().after(d2.getFechaYhora())) {
					lMovimientos = fMovimientos.readLine();
				} else {
					C_writer d3 = new C_writer();
					d3.setFechaYhora1(d1.getFechaYhora());
					d3.setFechaYhora2(d2.getFechaYhora().toGMTString());
					d3.setVelVient(d1.getVelVient() - d2.getVelVient());
					d3.setPresion(d1.getPresion() - d2.getPresion());
					d3.setPrecipi(d1.getPrecipi() - d2.getPrecipi());
					System.out.println(d1.getPrecipi()-d2.getPrecipi());
					d3.setHumedad(d1.getHumedad() - d2.getHumedad());
					d3.setTemperatura(d1.getTemp() - d2.getTemp());
					fEnfrentamientos.write(d3.toString());
					fEnfrentamientos.newLine();
					lMaestro = fMaestro.readLine();
					lMovimientos = fMovimientos.readLine();
				}
			}
			fMaestro.close();
			fMovimientos.close();
			fEnfrentamientos.close();
			System.out.println("Fichero completado");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("No se encuentra fichero.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problemas leyendo el fichero maestro");
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print("Problemas haciendo el parse");
		}
	}

	public static void main(String[] args) {
		D2017_11_07_Difference mainOb = new D2017_11_07_Difference();
		mainOb.read();
		mainOb.header();
		mainOb.compare();
	}
}

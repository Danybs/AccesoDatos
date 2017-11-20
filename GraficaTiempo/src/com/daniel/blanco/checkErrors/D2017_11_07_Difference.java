package com.daniel.blanco.checkErrors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class D2017_11_07_Difference {
	// 20171109_Pronostico.csv

	public static void main(String[] args) throws IOException {
		BufferedReader r1, r2;
		BufferedWriter w1;
		String l1, l2;
		float velVient, dirVient,presion,precipi,humedad;		

		try {
			r1 = new BufferedReader(new FileReader("datosAemet.csv"));
			r2 = new BufferedReader(new FileReader("20171109_Pronostico.csv"));
			w1 = new BufferedWriter(new FileWriter("Difference.csv"));
			for (int i = 0; i < 4; i++) { // Omitimos la cabecera del fichero datosAemet.csv
				r1.readLine();
			}
			l1 = r1.readLine();
			l2 = r2.readLine();
			l2 = r2.readLine();
			while ((r1 != null) && (r2 != null)) {
				l1 = l1.replaceAll("\"", "");
				C_aemet d1 = new C_aemet(l1.split(","));
				C_stbn d2 = new C_stbn(l2.split(","));
				if (d1.getFechaYhora().before(d2.getFechaYhora())) {// fechas
					l1 = r1.readLine();
				} else if (d1.getFechaYhora().after(d2.getFechaYhora())) {
					l2 = r2.readLine();
				} else {
						C_writer d3 = new C_writer();
						System.out.println(d1.getFechaYhora()+" "+d2.getFechaYhora());
						System.out.println(d1.getTemp()+" "+d2.getTemp());
						
						/*d3.setFechaYhora(d1.getFechaYhora());
						d3.setVelVient(d1.getVelVient()-d2.getVelVient());
						d3.setPresion(d1.getPresion()-d2.getPresion());
						d3.setPrecipi(d1.getPrecipi()-d2.getPrecipi());
						d3.setHumedad(d1.getHumedad()-d2.getHumedad());
						d3.setTemperatura(d1.getTemp()-d2.getTemp());*/
//						w1.write(d3.toString());
						/*System.out.println(d3.toString());*/
						l1 = r1.readLine();
						l2 = r2.readLine();
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.print("Problemas haciendo el parse");
		}

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

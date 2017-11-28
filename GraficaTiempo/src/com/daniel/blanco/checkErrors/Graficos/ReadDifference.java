package com.daniel.blanco.checkErrors.Graficos;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.daniel.blanco.checkErrors.C_writer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReadDifference {
	private BufferedReader r;
	private String rLine;
	private ArrayList<C_datos> list = new ArrayList<C_datos>();
	private C_datos o1;
	private Date[] fechas;
	protected int[] velViento, presionAtm, precipitacion, humedad, temperatura;

	void readFtoA() {
		try {
			r = new BufferedReader(new FileReader("Enfrentamientos.csv"));
			rLine = r.readLine();
			while((rLine=r.readLine())!=null) {
			rLine = rLine.replaceAll("\"", "");
			o1 = new C_datos(rLine.split(","));
			list.add(o1);
			}			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void init() {
		fechas = new Date[list.size()];
		velViento = new int[list.size()];
		presionAtm = new int[list.size()];
		precipitacion = new int[list.size()];
		humedad = new int[list.size()];
		temperatura = new int[list.size()];
		int cont=0;
		
		for (C_datos o : list) {
			velViento+=o.getVelVient();
			fechas[cont]=o.getFechaYhora();
			presionAtm[cont]=o.getHumedad();
			precipitacion[cont]=o.getHumedad();
			temperatura[cont]=o.getTemp();
			cont++;
		}		
	}
	
}

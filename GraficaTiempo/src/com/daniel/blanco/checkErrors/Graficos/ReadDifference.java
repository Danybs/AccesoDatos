package com.daniel.blanco.checkErrors.Graficos;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.daniel.blanco.checkErrors.C_writer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReadDifference {
	private BufferedReader r;
	private String rLine;
	private ArrayList<C_datos> list = new ArrayList<C_datos>();
	private C_datos o1;
	protected String fechas;
	protected String velViento, presionAtm, precipitacion, humedad, temperatura;

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
//	private DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.UK);
	private DateFormat format = new SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.UK);
	void init() {		
		int cont=0;
		for (C_datos o : list) {
			if(cont==0) {
			velViento=Integer.toString(o.getVelVient());
			presionAtm=Integer.toString(o.getPresion());
			precipitacion+=Integer.toString(o.getPrecipi());
			humedad=Integer.toString(o.getHumedad());
			temperatura=Integer.toString(o.getTemp());
			fechas=format.format(o.getFechaYhora());	
			}
			else {
			velViento+=","+Integer.toString(o.getVelVient());			
			presionAtm+=","+Integer.toString(o.getPresion());
			precipitacion+=","+Integer.toString(o.getPrecipi());
			humedad+=","+Integer.toString(o.getHumedad());
			temperatura+=","+Integer.toString(o.getTemp());	
			fechas+=","+format.format(o.getFechaYhora());
			}
			cont++;
		}	
	}

	
}

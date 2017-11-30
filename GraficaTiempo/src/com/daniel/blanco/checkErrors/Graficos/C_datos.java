package com.daniel.blanco.checkErrors.Graficos;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class C_datos {
//	private DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.UK);
	private DateFormat format = new SimpleDateFormat("yyy MMM dd HH:mm:ss zzz yyyy", Locale.UK);
	private Date fechaYhora;
	private int temp;
	private int velVient;
	private int precipi;
	private int presion;
	private int humedad;
	
	public C_datos(String campos[]) throws ParseException {
		fechaYhora = format.parse(campos[0]);
		velVient = Integer.parseInt(campos[1]);
		presion = Integer.parseInt(campos[2]);
		precipi = Integer.parseInt(campos[3]);
		humedad = Integer.parseInt(campos[4]);
		temp = Integer.parseInt(campos[5]);
	}

	public Date getFechaYhora() {
		return fechaYhora;
	}

	public int getTemp() {
		return temp;
	}

	public int getVelVient() {
		return velVient;
	}

	public int getPrecipi() {
		return precipi;
	}

	public int getPresion() {
		return presion;
	}

	public int getHumedad() {
		return humedad;
	}

	
	

}
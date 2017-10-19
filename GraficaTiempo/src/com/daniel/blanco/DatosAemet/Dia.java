package com.daniel.blanco.DatosAemet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dia implements Comparable<Dia>{
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm", Locale.FRANCE);//Damos formato a la fecha
	Date fechaYhora;
	float temp;
	float velVient;
	String dirVient;
	float racha;
	String dirRach;
	float precipi;
	float presion;
	float tendencia;
	float humedad;
	
	@Override
	public String toString() {
		return "\""+format.format(fechaYhora)+"\"" + "," + "\""+temp+"\"" + "," + "\""+velVient+"\"" + "," + "\""+dirVient+"\""
				+ "," + "\""+racha+"\"" + "," + "\""+dirRach+"\"" + "," + "\""+precipi+"\"" + "," + "\""+presion+"\""
				+ "," + "\""+tendencia+"\"" + "," + "\""+humedad+"\"";
	}

	public Dia(String campos[]) throws ParseException{
		fechaYhora=format.parse(campos[0]);
		temp=Float.parseFloat(campos[1]);
		velVient=Float.parseFloat(campos[2]);
		dirVient=String.valueOf(campos[3]);
		racha=Float.parseFloat(campos[4]);
		dirRach=String.valueOf(campos[5]);
		precipi=Float.parseFloat(campos[6]);
		presion=Float.parseFloat(campos[7]);
		tendencia=Float.parseFloat(campos[8]);
		humedad=Float.parseFloat(campos[9]);
	}
	
	public DateFormat getFormat() {
		return format;
	}
	public Date getFechaYhora() {
		return fechaYhora;
	}
	public float getTemp() {
		return temp;
	}
	public float getVelVient() {
		return velVient;
	}
	public String getDirVient() {
		return dirVient;
	}
	public float getRacha() {
		return racha;
	}
	public String getDirRach() {
		return dirRach;
	}
	public float getPrecipi() {
		return precipi;
	}
	public float getPresion() {
		return presion;
	}
	public float getTendencia() {
		return tendencia;
	}
	public float getHumedad() {
		return humedad;
	}
	
	@Override
	public int compareTo(Dia o) {
		return getFechaYhora().compareTo(o.getFechaYhora());
	}	
	
	
}
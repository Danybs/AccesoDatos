package com.daniel.blanco.checkErrors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C_writer {
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm");// Damos formato a la fecha
	Date fechaYhora;
	float velVient,presion,precipi,humedad,temperatura;
	
	public void setFechaYhora(Date fechaYhora) {
		this.fechaYhora = fechaYhora;
	}


	public void setVelVient(float velVient) {
		this.velVient = velVient;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}


	public void setPrecipi(float precipi) {
		this.precipi = precipi;
	}


	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}
	
	
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "\""+ format.format(fechaYhora) +"\""+ ","+ "\"" + velVient +"\""+ ","+ "\""
	+ "\"" +presion+"\""+ ","+ "\"" +precipi+"\""+ ","+ "\"" +humedad+"\""+ ","+ "\"" +temperatura+"\"";
	}
	
	
}

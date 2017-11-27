package com.daniel.blanco.checkErrors;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class C_writer {
	Date fechaYhora1;
	Date fechaYhora2;
	float velVient, presion, precipi, humedad, temperatura;
	DecimalFormat df = new DecimalFormat("0");// Damos formato de 2 digitos

//	public void setFechaYhora1(Date fechaYhora1) {
//		this.fechaYhora1 = fechaYhora1;
//	}

	public void setFechaYhora2(Date fechaYhora2) {
		this.fechaYhora2 = fechaYhora2;
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
		return "\"" + fechaYhora2 + "\"" + "," + "\"" + df.format(velVient) + "\""
				+ "," + "\"" + "\"" + df.format(presion) + "\"" + "," + "\"" + df.format(precipi) + "\"" + "," + "\""
				+ df.format(humedad) + "\"" + "," + "\"" + df.format(temperatura) + "\"";
	}

}

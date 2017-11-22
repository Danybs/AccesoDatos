package com.daniel.blanco.checkErrors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*date,lat[unit="degrees_north"],lon[unit="degrees_east"],dir[unit="degree"],
 * mod[unit="m s-1"],mslp[unit="Pa"],prec[unit="kg m-2"],rh[unit="1"],temp[unit="K"]
 */

public class C_stbn{
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");// Damos formato a la fecha
	TimeZone gmtTime = TimeZone.getTimeZone("GMT");
	Date fechaYhora;
	float lat;
	float lon;
	float dirVient;
	float velVient;
	float presion;
	float precipi;
	float humedad;
	float temp;

	public C_stbn(String campos[]) throws ParseException {
		format.setTimeZone(gmtTime);//Cuando se almacene la fecha en el objeto lo hara en formato GMT
		fechaYhora = format.parse(campos[0]);
		lat = Float.parseFloat(campos[1]);
		lon = Float.parseFloat(campos[2]);
		dirVient = Float.parseFloat(campos[3]);
		velVient = Float.parseFloat(campos[4]);
		presion = Float.parseFloat(campos[5]);
		precipi = Float.parseFloat(campos[6]);
		humedad = Float.parseFloat(campos[7]);
		temp = Float.parseFloat(campos[8]);
	}
	
	public Date getFechaYhora() {
		return fechaYhora;
	}

	public float getLat() {
		return lat;
	}

	public float getLon() {
		return lon;
	}

	public float getDirVient() {
		return dirVient;
	}

	public float getVelVient() {
		return velVient;
	}

	public float getPresion() {
		return presion/100;
	}

	public float getPrecipi() {
		return precipi;
	}

	public float getHumedad() {
		return humedad;
	}

	public float getTemp() {
		return temp-273.15f;
	}
	
}
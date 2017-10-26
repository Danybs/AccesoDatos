package com.daniel.blanco.almacenar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/*date,lat[unit="degrees_north"],lon[unit="degrees_east"],
 * dir[unit="degree"],mod[unit="m s-1"],mslp[unit="Pa"],
 * prec[unit="kg m-2"],rh[unit="1"],temp[unit="K"],wind_gust[unit="m s-1"]
*/
/* Cada registro consistira de fecha[0], latitud[1],longitud[2],direccion[3], modulo[4],
 * mslp[5], precipitacion[6], rh[7], temperatura[8] y viento[9]*/
public class Dia implements Comparable<Dia>{
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.FRANCE);//Damos formato a la fecha
	Date fechaYhora;
	float lat;
	float lon;
	float dir;
	float mod;
	float mslp;
	float prec;
	float rh;
	float temp;
	float wind_gust;	

	@Override
	public String toString() {
		return "Dia [format=" + format + ", fechaYhora=" + fechaYhora + ", lat=" + lat + ", lon=" + lon + ", dir=" + dir
				+ ", mod=" + mod + ", mslp=" + mslp + ", prec=" + prec + ", rh=" + rh + ", temp=" + temp
				+ ", wind_gust=" + wind_gust + "]";
	}
	public Dia(String campos[]) throws ParseException{
		try {
		fechaYhora=format.parse(campos[0]);
		lat=Float.parseFloat(campos[1]);
		lon=Float.valueOf(campos[2]);
		dir=Float.parseFloat(campos[3]);
		mod=Float.valueOf(campos[4]);
		mslp=Float.parseFloat(campos[5]);
		prec=Float.parseFloat(campos[6]);
		rh=Float.parseFloat(campos[7]);
		temp=Float.parseFloat(campos[8]);
		wind_gust=Float.parseFloat(campos[9]);
		}catch (Exception e) {
			System.out.println("Problemas introduciendo datos");
		}
	}
		
	public DateFormat getFormat() {
		return format;
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
	public float getDir() {
		return dir;
	}
	public float getMod() {
		return mod;
	}
	public float getMslp() {
		return mslp;
	}
	public float getPrec() {
		return prec;
	}
	public float getRh() {
		return rh;
	}
	public float getTemp() {
		return temp-273;
	}
	public float getWind_gust() {
		return wind_gust;
	}
	@Override
	public int compareTo(Dia o) {
		return getFechaYhora().compareTo(o.getFechaYhora());
	}	
	
	
}
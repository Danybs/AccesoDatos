package com.daniel.blanco.fusion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Campo implements Comparable<Campo>{
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);//Damos formato a la fecha
	Date fechaYhora;
	
	@Override
	public String toString() {
		return "format.format(fechaYhora)";
	}

	public Campo(String campos[]) throws ParseException{
		fechaYhora=format.parse(campos[0]);
	}
	
	public DateFormat getFormat() {
		return format;
	}
	public Date getFechaYhora() {
		return fechaYhora;
	}
	
	@Override
	public int compareTo(Campo o) {
		return getFechaYhora().compareTo(o.getFechaYhora());
	}	
	
	
}
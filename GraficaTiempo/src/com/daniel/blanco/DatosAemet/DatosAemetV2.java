/**
 * 
 */
package com.daniel.blanco.DatosAemet;

/**
 * @author alumno
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
//https://stackoverflow.com/questions/4216745/java-string-to-date-conversion#4216767
//ordenar por fecha
public class DatosAemetV2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// URL
			URL url = new URL(
					"http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
			// URL Directorio
			Path path = Paths.get("datosAemet.csv");
			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Si el fichero no existe lo creamos
			if (Files.notExists(path)) {
				// Se obtiene el inputStream del documento y se abre el fichero local
				InputStream is = urlCon.getInputStream();
				FileOutputStream fos = new FileOutputStream("datosAemet.csv");
				// Lectura del CSV y escritura en local
				byte[] array = new byte[1000]; // buffer temporal de lectura
				int leido = is.read(array);
				while (leido > 0) {
					fos.write(array, 0, leido);
					leido = is.read(array);
				}

				// cierre de conexion y fichero
				is.close();
				fos.close();
			}
			
			//Array donde se almacenaran los nuevos datos
			String city;
			String update;
			String whitespace;
			String head;
			BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));
			city = is.readLine();
			update = is.readLine();
			whitespace = is.readLine();
			head = is.readLine();
			String line1 = is.readLine();
			TreeSet<Dia> tS1 = new TreeSet<Dia>();
			while ((line1 = is.readLine()) != null) {
				String noob=line1.replaceAll("\"","");
				Dia day=new Dia(noob.split(","));
				tS1.add(day);
			}
			is.close();
			
			// Lectura del fichero local
			BufferedReader read = new BufferedReader(new FileReader("datosAemet.csv"));

			String line = read.readLine();// Lectura ciudad
			System.out.println(city); //Mostramos la ciudad del nuevo archivo
			line = read.readLine();// Lectura update
			System.out.println(update);// Mostramos el nuevo update
			line = read.readLine();// Lectura espacio en blanco
			System.out.println(whitespace); // Espacio en blanco
			line = read.readLine();// Lectura cabecera
			System.out.println(head); //Mostramos la nueva cabecera
			//Almacenamos todas las lineas en un TreeSet y como no se pueden repetir solo nos aparecera un valor por fecha
			TreeSet<Dia> tS = new TreeSet<Dia>();
			while ((line = read.readLine()) != null) {
				String noob=line.replaceAll("\"","");
				Dia day=new Dia(noob.split(","));
				tS.add(day);
			}
			tS.addAll(tS1);
			read.close();
			
			//Recorremos el TreeSet con los nuevos valores y los almacenamos en un TXT
			Iterator<Dia> it = tS.iterator();
			Dia newDate;
			BufferedWriter write = new BufferedWriter(new FileWriter("datosAemet.csv"));
			write.write(city);
			write.newLine();
			write.write(update);
			write.newLine();
			write.write(whitespace);
			write.newLine();
			write.write(head);
			write.newLine();
			for (Dia dia : tS) {
				write.write(dia.toString());
				write.newLine();
				System.out.println(dia);
			}
			read.close();
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
//"Fecha y hora oficial","Temperatura (ºC)","Velocidad del viento (km/h)","Dirección del viento","Racha (km/h)","Dirección de racha","Precipitación (mm)","Presión (hPa)","Tendencia (hPa)","Humedad (%)"
//"16/10/2017 23:00","15.4","4","Este","10","Este","0.0","981.7","-0.9","88"
class Dia implements Comparable<Dia>{
	
	DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.GERMANY);//Damos formato a la fecha
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
		return "Dia [fechaYhora=" + fechaYhora + ", temp=" + temp + ", velVient=" + velVient + ", dirVient=" + dirVient
				+ ", racha=" + racha + ", dirRach=" + dirRach + ", precipi=" + precipi + ", presion=" + presion
				+ ", tendencia=" + tendencia + ", humedad=" + humedad + "]";
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
		// TODO Auto-generated method stub
		return getFechaYhora().compareTo(o.getFechaYhora());
	}	
	
	
}
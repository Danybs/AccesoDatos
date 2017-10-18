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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
//https://stackoverflow.com/questions/4216745/java-string-to-date-conversion#4216767
//ordenar por fecha
public class DatosAemetV2 implements Comparable<Fecha> {
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
			
			ArrayList<String> Copia = new ArrayList<String>(); //Array donde se almacenaran los nuevos datos, da igual orden
			String city;
			String update;
			String whitespace;
			String head;

			// Lectura del fichero web y almacenamiento en ArrayList
			BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));
			city = is.readLine();
			update = is.readLine();
			whitespace = is.readLine();
			head = is.readLine();
			String LCopy;
			while ((LCopy = is.readLine()) != null) {
				Copia.add(LCopy);
			}

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
			TreeSet<String> tS = new TreeSet<String>();  
			while ((line = read.readLine()) != null) {
				tS.add(line);

			}
			for (int i = 0; i < Copia.size(); i++) {
				tS.add(Copia.get(i));
			}
			//DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.GERMANY);//Damos formato a la fecha
			//Date dateTxt;
			
			//Recorremos el TreeSet con los nuevos valores y los almacenamos en un TXT
			Iterator<String> it = tS.iterator();
			String newDate;
			BufferedWriter write = new BufferedWriter(new FileWriter("datosAemet.csv"));
			write.write(city);
			write.newLine();
			write.write(update);
			write.newLine();
			write.write(whitespace);
			write.newLine();
			write.write(head);
			write.newLine();
			while (it.hasNext()) {
				newDate = (String) it.next();
				write.write(newDate);
				write.newLine();
				System.out.println(newDate);
			}
			read.close();
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public int compareTo(Fecha o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Fecha {
	
}
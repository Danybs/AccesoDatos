/**
 * 
 */
package com.daniel.blanco.DatosAemet;

/**
 * @author alumno
 *
 */
//Leer La segunda linea en una variable almacenarla y luego sobrescribir la segunda linea del fichero
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class DatosAemetV2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// URL
			URL url = new URL(
					"http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
			Path path = Paths.get("datosAemet.csv");
			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Si el fichero no existe lo creamos
			if (Files.notExists(path)) {
				// Se obtiene el inputStream de la foto web y se abre el fichero
				// local
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
			ArrayList<String> Copia = new ArrayList<String>();
			if (Files.exists(path)) {
				// Leemos los nuevos datos y lo almacenamos en el treeset, como no se pueden
				// repetir datos no se almacenaran.
				BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));				
				String LCopy = is.readLine();
				LCopy = is.readLine();
				LCopy = is.readLine();
				LCopy = is.readLine();
				while ((LCopy = is.readLine()) != null) {
					Copia.add(LCopy);
				}
			}

			// lectura del fichero
			BufferedReader read = new BufferedReader(new FileReader("datosAemet.csv"));	
			FileWriter write = new FileWriter("datosAemet.csv",true);
			String line = read.readLine();// Lectura ciudad
			System.out.println(line);
			line = read.readLine();// Lectura ciudad
			System.out.println(line);
			line = read.readLine();// Lectura ciudad
			System.out.println(line);
			line = read.readLine();// Lectura ciudad
			System.out.println(line);
			TreeSet<String> tS = new TreeSet<String>();
			while ((line = read.readLine()) != null) {
				tS.add(line);
				
			}
			for (int i = 0; i < Copia.size(); i++) {
				tS.add(Copia.get(i));
			}
			Iterator<String> it = tS.iterator();
			String a;
			while (it.hasNext()) {
				a = (String) it.next();
				write.append(a);
				System.out.println(a);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
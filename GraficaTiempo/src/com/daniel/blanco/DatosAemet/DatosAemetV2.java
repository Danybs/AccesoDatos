package com.daniel.blanco.DatosAemet;

/**
 * @author alumno
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class DatosAemetV2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// URL
			URL url = new URL(
					"http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");
			// URL Directorio
			Path path = Paths.get("datosAemet.csv");
			// Establecemos conexion
			URLConnection urlCon = url.openConnection();
			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Leemos el fichero remoto
			System.out.println("LEYENDO REMOTO");
			String city, update, whitespace, head; // Variables para declarar las primeras lineas mas actuales
			BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));// Abrimos la lectura del
																							// fichero remoto
			city = is.readLine(); // Lectura ciudad
			update = is.readLine(); // Lectura update
			whitespace = is.readLine(); // Lectura espacio en blanco
			head = is.readLine(); // Lectura cabecera
			String rLine = is.readLine();
			TreeSet<Dia> tS = new TreeSet<Dia>();// TreeSet donde almacenaremos TODOS los datos, los datos repetidos no
													// se almacenaran
			while ((rLine = is.readLine()) != null) {
				String a1 = rLine.replaceAll("\"", ""); // Quitamos " del codigo, ya que si no darian error
				Dia day = new Dia(a1.split(",")); // Almacenamos en cada objeto todos los splits de la linea
				tS.add(day);
			}
			is.close();// Cerramos lectura del fichero remoto

			if (Files.exists(path)) {
				// Lectura del fichero local
				System.out.println("LEYENDO LOCAL");
				BufferedReader read = new BufferedReader(new FileReader("datosAemet.csv"));
				String rLine2 = read.readLine();// Lectura ciudad
				rLine2 = read.readLine();// Lectura update
				rLine2 = read.readLine();// Lectura espacio en blanco
				rLine2 = read.readLine();// Lectura cabecera
				// Almacenamos todas las lineas del fichero local en el TreeSet para descartar
				// repetidos
				while ((rLine2 = read.readLine()) != null) {
					String a2 = rLine2.replaceAll("\"", ""); // Quitamos " del codigo, ya que si no darian error
					Dia day = new Dia(a2.split(",")); // Almacenamos en cada objeto todos los splits de la linea
					tS.add(day);
				}
				read.close(); // Cerramos lectura del fichero local
			}
			System.out.println("IMPRIMIENDO TXT");
			// Recorremos el TreeSet con los nuevos valores, lo mostramos por pantalla y
			// simultaneamente lo escribimos en un nuevo .CSV
			BufferedWriter write = new BufferedWriter(new FileWriter("datosAemet.csv"));
			write.write(city); 
			System.out.println(city);
			write.newLine();
			write.write(update);
			System.out.println(update);
			write.newLine();
			write.write(whitespace);
			System.out.println(whitespace);
			write.newLine();
			write.write(head);
			System.out.println(head);
			write.newLine();
			for (Dia day : tS) { // Recorremos el treeSet
				write.write(day.toString());
				write.newLine();
				System.out.println(day);
			}
			write.close(); //Cerramos la escritura
		} catch (Exception e) {
		}

	}
}

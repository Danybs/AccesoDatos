/**
 * 
 */
package com.daniel.blanco.DatosAemet;

/**
 * @author alumno
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DatosAemet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// URL
			URL url = new URL(
					"http://www.aemet.es/es/eltiempo/observacion/ultimosdatos_1249X_datos-horarios.csv?k=ast&l=1249X&datos=det&w=0&f=temperatura&x=h24");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

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

			// lectura del fichero
			BufferedReader read = new BufferedReader(new FileReader("datosAemet.csv"));
			String line = read.readLine();//Lectura ciudad
			String[] ciudad = line.split("\"");
			for (int i = 0; i < ciudad.length; i++) {
				System.out.println(ciudad[i]);
			}
			line = read.readLine();//Lectura update
			System.out.println(line);
			line = read.readLine();//Espacio en blanco	
			System.out.println(line);
			line = read.readLine();//Lectura cabecera
			String[] head = line.split(",");
			for (int i = 0; i < head.length; i++) {
				System.out.print(head[i]+" ");
			}
			System.out.println();
			ArrayList<String> aL = new ArrayList<String>();
			while((line=read.readLine())!=null){
				aL.add(line);
			}
			for (int i = aL.size()-1; i>0; i--) {
				System.out.println(aL.get(i));
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

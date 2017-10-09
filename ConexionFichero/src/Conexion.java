import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		//URL con la foto
		URL url = new URL ("https://upload.wikimedia.org/wikipedia/commons/8/88/ImageJScreenshot.png");
		
		//establecemos conexion
		URLConnection urlCon = url.openConnection();
		
		//sacamos por pantalla el tipo de fichero
		System.out.println(urlCon.getContentType());
		
		//Se obtiene el inputStream de la foto web y se abre el fichero
		//local
		InputStream is = urlCon.getInputStream();
		
		FileOutputStream fos = new FileOutputStream("foto.jpg");
		
		//Lectura de la foto de la web y escritura en fichero local
		byte[] array = new byte[1000]; //buffer temporal de lectura
		int leido = is.read(array);
		while ( leido > 0) {
			fos.write(array, 0, leido);
			leido = is.read(array);
		}
		
		//cierre de conexion y fichero
		is.close();
		fos.close();
	}catch (Exception e) {
		// TODO: handle exception
	}
}

}

package com.daniel.blanco.fusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class D2017_11_08_Fusion {

	public static void main(String[] args) throws IOException, ParseException {
		DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);// Formato fecha
		File fichero1 = new File("Fusion.csv");
		if (!fichero1.exists()) {
			try {
				//Llamamos al metodo main de la otra clase para sincronizar el fichero y que se actualice todo
				D2017_11_07_RainOrNot.main(args);
				
				System.out.println("\nFusionando archivo...");
				BufferedReader read1 = new BufferedReader(new FileReader("noRainDays.txt"));
				BufferedReader read2 = new BufferedReader(new FileReader("RainDays.txt"));
				BufferedWriter write = new BufferedWriter(new FileWriter("Fusion.txt",true));
				Date registry1, registry2;
				String line1 = "", line2 = "";
				try {	
					line1 = read1.readLine();
					line2 = read1.readLine();
					while (line1 != null && line2 != null) {						
						registry1 = dateF.parse(line1);
						registry2 = dateF.parse(line2);
						if (registry1.before(registry2)) {
							write.write(dateF.format(registry1));
							write.newLine();
							line1 = read1.readLine();
						} else {
							write.write(dateF.format(registry2));
							write.newLine();
							line2 = read2.readLine();
						}
					}
					if (line1 == null) {
						while (line2 != null) {
							write.write(line2);
							write.newLine();
							read2.readLine();
							line2 = read2.readLine();
						}
					} else {
						while (line1 != null) {
							write.write(line1);
							write.newLine();
							line1 = read1.readLine();
						}
					}
					read1.close();
					read2.close();
					write.close();
					System.out.println("Fusion realizada con exito");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
		fichero1.delete();
		}
	}
	
}

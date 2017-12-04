package com.daniel.blanco.checkErrors.Graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class G_Temperatura extends JPanel {
	private int[] yValuesInt;
	private int[] xValuesInt;
	private String[] dias;
	private final int proporcionX = 20;
	private final int proporcionY = 20;
	private final int initX = 100;
	private final int initY = 20;
	private final int finalX = 900;
	private final int finalY = 510;
	
	G_Temperatura(String yValues[],String dias[]) {
		this.yValuesInt = new int[yValues.length];
		this.xValuesInt = new int[yValues.length];
		this.dias = new String[dias.length];
		for (int i = 0; i <yValuesInt.length; i++) {
			yValuesInt[i] = Integer.parseInt(yValues[i]); //Valores
			yValuesInt[i]*=proporcionY;//proporcion
			yValuesInt[i]+=260;//posicion
		}
		
		for (int i = 0; i < yValuesInt.length; i++) {
			xValuesInt[i]=(i);  //Valores
			xValuesInt[i]*=proporcionX;//proporcion
			xValuesInt[i]+=100;//posicion
		}
		
		for (int i = 0; i < dias.length; i++) {
			this.dias[i]=dias[i]; //Rellenamos los dias
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		//Pie de pagina
//		g.drawString("Daniel Blanco Sanz Copyright © Todos los Derechos Reservados", initX, finalY+100);
				
		//Eje X
		g.setColor(Color.GRAY);
		for (int i = 0; i<25 ; i++) {
			g.drawLine(initX-10,initY+(i*proporcionY),finalX, initY+(i*proporcionY));
		}
		//Eje Y
		g.setColor(Color.GRAY);
		for (int i = 0; i < yValuesInt.length; i++) {
			g.drawLine(initX+(i*proporcionX), initY, initX+(i*proporcionX), finalY);
		}
		//Leyenda Y
				g.setColor(Color.BLACK);
				int k=0;
				int lastPy=0;
				for (int i = 12; i > -1; i--) {
					g.drawString((Integer.toString(i)), initX-30, lastPy=initY+(k*proporcionY));
					k++;
				}
				k=1;
				for (int i = -1; i > -13; i--) {
					g.drawString((Integer.toString(i)), initX-30, lastPy+(k*proporcionY));
					k++;
				}
		// Leyenda en vertical
				Graphics2D g3 = (Graphics2D) g;
				Font font = new Font("Arial", Font.PLAIN, 14);
				AffineTransform affineTransform = new AffineTransform();
				affineTransform.rotate(Math.toRadians(45), 0, 0);
				Font rotatedFont = font.deriveFont(affineTransform);
				g3.setFont(rotatedFont);
				g3.setColor(Color.BLACK);
				
				//Leyenda X
				for (int i = 0; i < dias.length; i++) {
					g3.drawString(dias[i], initX+(i*proporcionX), finalY+20);
				}
				
				
				
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawPolyline(xValuesInt, yValuesInt, xValuesInt.length);
	}
}








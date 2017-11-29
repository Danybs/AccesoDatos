package com.daniel.blanco.checkErrors.Graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
//xValues[i]= 30 + i * 15;	
public class G_Viento extends JPanel {
	private int[] yValuesInt;
	private int[] xValuesInt;
	private final int proporcionX = 15;
	private final int proporcionY = 20;
	
	G_Viento(String yValues[]) {
		yValuesInt = new int[yValues.length];
		xValuesInt = new int[yValues.length];
		for (int i = 0; i <yValuesInt.length; i++) {
			yValuesInt[i] = Integer.parseInt(yValues[i]); //Valores
			yValuesInt[i]*=proporcionY;//proporcion
			yValuesInt[i]+=260;//posicion
		}
		
		for (int i = 0; i < yValuesInt.length; i++) {
			xValuesInt[i]=(i);  //Valores
			xValuesInt[i]*=proporcionX;//proporcion
			xValuesInt[i]+=50;//posicion
		}		
	}
	@Override
	protected void paintComponent(Graphics g) {
		//Eje X
		g.setColor(Color.gray);
		for (int i = 0; i<25 ; i++) {
			g.drawLine(40,20+(i*proporcionY),650, 20+(i*proporcionY));
		}
		//Eje Y
		g.setColor(Color.GRAY);
		for (int i = 0; i < yValuesInt.length; i++) {
			g.drawLine(50+(i*proporcionX), 20, 50+(i*proporcionX), 510);
		}
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawPolyline(xValuesInt, yValuesInt, xValuesInt.length);
	}
}








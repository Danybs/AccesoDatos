package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Graphics;

import javax.swing.JPanel;
//xValues[i]= 30 + i * 15;	
public class G_Viento extends JPanel {
	private int[] yValuesInt;
	private int[] xValuesInt;
	G_Viento(String yValues[]) {
		yValuesInt = new int[yValues.length];
		
		for (int i = 0; i <yValuesInt.length; i++) {
			yValuesInt[i] = Integer.parseInt(yValues[i]);
		}
		
		for (int i = 0; i < yValuesInt.length; i++) {
			xValuesInt[i]= (i+1) * 2;	
		}
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
//		g.clearRect(0, 0, 800, 800);	
		g.drawPolyline(xValuesInt, yValuesInt, xValuesInt.length);
	}
}








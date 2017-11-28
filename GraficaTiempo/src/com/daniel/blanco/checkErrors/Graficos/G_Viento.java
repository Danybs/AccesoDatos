package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Graphics;

import javax.swing.JPanel;

public class G_Viento extends JPanel {
	private int yValues[];
	private int xValues[];
	G_Viento(int yValues[]) {
		System.out.println(yValues[0]);
		System.out.println(yValues[1]);
		this.yValues=yValues;	
		xValues = new int[yValues.length];
		for (int i = 0; i <yValues.length; i++) {
			xValues[i]= 30 + i * 15;			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
//		g.clearRect(0, 0, 800, 800);
		g.drawPolyline(xValues, yValues, xValues.length);
	}
}








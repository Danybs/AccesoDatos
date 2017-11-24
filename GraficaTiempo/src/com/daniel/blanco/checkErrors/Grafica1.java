package com.daniel.blanco.checkErrors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grafica1 extends JPanel {
	Grafica1() {

	}

	
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		if (PW.isCheck()) {
			
			Grafica2.paintComponent(g);
		} else {
			super.paintComponent(g);
			int xValues[] = { getWidth() / 2, 100, 200, 300, 400, 500 };
			int yValues[] = { getHeight() / 2, 100, 50, 100, 200, 300, 400 };
			g.drawPolyline(xValues, yValues, 5);
		}
	}
}

class Grafica2 {
	public static void paintComponent(Graphics g) {
		
//		int xValues[] = { 500, 100, 200, 300, 400, 500 };
//		int yValues[] = { 400, 100, 50, 100, 200, 300, 400 };
//		g.drawPolyline(xValues, yValues, 5);
		g.clearRect(0, 0, 1000, 1000);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 20, 100, 200, 300, 400, 500 };
		int yValues[] = { 20, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}
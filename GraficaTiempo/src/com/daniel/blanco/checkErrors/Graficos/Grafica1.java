package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grafica1 extends JPanel {
	Grafica1() {
		setBackground(Color.WHITE);
	}	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		if (PW.isC1()) {		
			super.paintComponent(g);
			int xValues[] = { getWidth() / 2, 100, 200, 300, 400, 500 };
			int yValues[] = { getHeight() / 2, 100, 50, 100, 200, 300, 400 };
			g.drawPolyline(xValues, yValues, 5);
		} else if(PW.isC2()) {
			Grafica2.paintComponent(g);
		} else if(PW.isC3()) {
			Grafica3.paintComponent(g);
		} else if(PW.isC4()) {
			Grafica4.paintComponent(g);
		} else if(PW.isC5()) {
			Grafica4.paintComponent(g);
		}
		
	}
}

class Grafica2 {
	public static void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 20, 100, 200, 300, 400, 500 };
		int yValues[] = { 20, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}

class Grafica3 {
	public static void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 432, 100, 200, 300, 400, 500 };
		int yValues[] = { 432, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}

class Grafica4 {
	public static void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 123, 100, 200, 300, 400, 500 };
		int yValues[] = { 123, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}

class Grafica5 {
	public static void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 67, 100, 200, 300, 400, 500 };
		int yValues[] = { 67, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}
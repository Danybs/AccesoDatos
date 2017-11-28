package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Grafica4 extends JPanel{
	int xValues[];
	int yValues[];
	Grafica4(int xValues[], int yValues[]) {
		this.xValues=xValues;
		this.yValues=yValues;
	}
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		
		g.drawPolyline(xValues, yValues, xValues.length);
	}
}
package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Graphics;

import javax.swing.JPanel;

public class G_Precipitacion extends JPanel{
	private int xValues[];
	private int yValues[];
	G_Precipitacion(int xValues[], int yValues[]) {
		this.xValues=xValues;
		this.yValues=yValues;
	}
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 123, 100, 200, 300, 400, 500 };
		int yValues[] = { 123, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}
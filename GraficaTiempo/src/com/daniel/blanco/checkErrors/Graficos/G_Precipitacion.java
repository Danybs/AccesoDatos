package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Graphics;

public class G_Precipitacion{
	G_Precipitacion(int xValues[], int yValues[]) {

	}
	public static void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 123, 100, 200, 300, 400, 500 };
		int yValues[] = { 123, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}
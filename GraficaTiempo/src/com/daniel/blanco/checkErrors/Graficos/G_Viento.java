package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Graphics;

import javax.swing.JPanel;

public class G_Viento extends JPanel {
	private int xValues[]; 
	private int yValues[];
	G_Viento(int xValues[], int yValues[]) {
		this.xValues=xValues;
		this.yValues=yValues;
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		g.fillRect(100, 100, 200, 200);
		int xValues[] = { 67, 100, 200, 300, 400, 500 };
		int yValues[] = { 67, 100, 50, 100, 200, 300, 400 };
		g.drawPolyline(xValues, yValues, 5);
	}
}








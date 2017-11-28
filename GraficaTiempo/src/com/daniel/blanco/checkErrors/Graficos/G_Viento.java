package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class G_Viento extends JPanel {
	int xValues[], yValues[];
	G_Viento(int xValues[], int yValues[]) {
		this.xValues=xValues;
		this.yValues=yValues;
	}
	@Override
	protected void paintComponent(Graphics g) {

		if (PW.isC1()) {
			super.paintComponent(g);
			ReadDifference o = new ReadDifference();
			g.drawPolyline(xValues, yValues, xValues.length);
		} else if (PW.isC2()) {
			G_Presion.paintComponent(g);
		} else if (PW.isC3()) {
			Grafica3.paintComponent(g);
		} else if (PW.isC4()) {
			G_.paintComponent(g);
		} else if (PW.isC5()) {
			G_.paintComponent(g);
		}

	}
}








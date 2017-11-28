package com.daniel.blanco.checkErrors.Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grafica extends JPanel {
	int xValues[], yValues[];
	Grafica(int xValues[], int yValues[]) {
		this.xValues=xValues;
		this.yValues=yValues;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (PW.isC1()) {			
			g.clearRect(0, 0, 800, 800);
			g.drawPolyline(xValues, yValues, xValues.length);
//		} else if (PW.isC2()) {
//			g.clearRect(0, 0, 800, 800);
//			g.drawPolyline(xValues, yValues, xValues.length);
		} else if (PW.isC3()) {
			g.clearRect(0, 0, 800, 800);
			g.drawPolyline(xValues, yValues, xValues.length);
		} else if (PW.isC4()) {
			g.clearRect(0, 0, 800, 800);
			g.drawPolyline(xValues, yValues, xValues.length);
		} else if (PW.isC5()) {
			g.clearRect(0, 0, 800, 800);
			g.drawPolyline(xValues, yValues, xValues.length);
		}

	}
	
}








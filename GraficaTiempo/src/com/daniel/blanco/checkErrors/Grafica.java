package com.daniel.blanco.checkErrors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grafica extends JPanel {
	private int width = 800;
	private int height = 800;
	Grafica(){
		setSize(400,400);
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(width, (int) (height / 1.25)));
	
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int xValues[]= {getWidth()/2,100,200,300,400,500};
		int yValues[]= {getHeight()/2,100,50,100,200,300,400};
		g.drawPolyline(xValues,yValues, 5);
	}
	
	
}

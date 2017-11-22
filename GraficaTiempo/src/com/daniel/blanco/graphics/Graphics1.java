package com.daniel.blanco.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Graphics1 extends JFrame {

	private int width=500;
	private int height=500;
	JFrame f1;
	JPanel p1;
	

	public Graphics1() {
		setTitle("Graficos");
		pack();
//		setUndecorated(true);
		setSize(width, height);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1 = new JPanel();
		JButton b1 = new JButton("HOLA");
		add(p1);
		p1.setSize(500, 500);
		p1.setLocation(width/2, height/2);
		p1.setVisible(true);
		p1.add(b1);
		b1.setBounds(100,150,100,30);
	}
	public void panel() {
		
		
		
		
		
		
		
	}

	public void paint (Graphics g) {	
		super.paint(g);
		int xValues[]= {0,100,200,300,400,500};
		int yValues[]= {0,100,50,100,200,300,400};
		g.drawPolyline(xValues, yValues, 5);
		
		g.drawOval((int)97,(int)97, 5, 5);
	}
	
	public static void main(String[] args) {
		Graphics1 ga = new Graphics1();
		
	}

}

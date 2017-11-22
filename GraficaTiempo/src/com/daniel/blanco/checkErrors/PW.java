package com.daniel.blanco.checkErrors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PW extends JFrame {
	
	private JButton b1,b2,b3,b4,b5;
	private JPanel p1,p2;
	
	public PW() {
		setTitle("Graficas");
		pack();
		
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);
		setVisible(true);
		
		getContentPane().setLayout(new BorderLayout());
		
		p1 = new JPanel();
		add(p1, BorderLayout.SOUTH);
		p1.setBackground(Color.WHITE);
		p1.setPreferredSize(new Dimension(getWidth(), (int) ((int) getHeight()/1.1)));
		
		p2 = new JPanel();
		add(p2, BorderLayout.NORTH);
		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(getWidth(), getHeight()/8));
		
		
		
//		b1 = new JButton("Velocidad del viento");
//		add(b1);
//		
//		b2 = new JButton("Presion");
//		add(b2);
//		
//		b3 = new JButton("Precipitación");
//		add(b3);
//		
//		b4 = new JButton("Humedad");
//		add(b4);
//		
//		b5 = new JButton("Temperatura");
//		add(b5);
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	public static void main(String[] args) {
		PW window = new PW();
	}
}

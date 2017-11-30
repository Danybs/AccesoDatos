package com.daniel.blanco.checkErrors.Graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PW extends JFrame implements ActionListener {

	private JButton b1, b2, b3, b4, b5;
	private JPanel p1, p2, comienzo;
	private int width = 800;
	private int height = 800;

	ReadDifference datos;

	G_Viento g_v;
	G_Humedad g_h;
	G_Precipitacion g_p;
	G_Presion g_pr;
	G_Temperatura g_t;
	
	String dias[];
	String Viento[];
	public PW(String Viento[],String dias[]) {
		this.Viento=Viento;
		this.dias=dias;
		// Caracteristicas de la ventana principal
		setTitle("Graficas");

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack(); // default size
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);

		getContentPane().setLayout(new BorderLayout());

		// Panel de la grafica
		p1 = new JPanel();
		p1.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
		add(p1, BorderLayout.SOUTH);
		p1.setBackground(Color.WHITE);
		p1.setVisible(false);

		// Intro


		// Instanciamos las grafica
		//Viento
		
		g_v = new G_Viento(Viento,dias);
		g_v.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
		g_v.setBackground(Color.WHITE);
		p1.add(g_v);		
		
		//Humedad
//		g_h = new G_Humedad(yValues);
//		g_h.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
//		g_h.setBackground(Color.WHITE);
//		p1.add(g_h);	
//		//Precipitacion
//		g_p = new G_Precipitacion(yValues);
//		g_p.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
//		g_p.setBackground(Color.WHITE);
//		p1.add(g_p);	
//		//Presion
//		g_pr = new G_Presion(yValues);
//		g_pr.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
//		g_pr.setBackground(Color.WHITE);
//		p1.add(g_pr);	
//		//Temperatura
//		g_t = new G_Temperatura(yValues);
//		g_t.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
//		g_t.setBackground(Color.WHITE);
//		p1.add(g_t);	
		

		// Panel de los botones
		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 6)));
		p2.setLayout(new GridLayout(0, 5));
		add(p2, BorderLayout.NORTH);

		// Instanciamos botones
		b1 = new JButton("Velocidad del viento");
		b1.addActionListener(this);
		p2.add(b1);

		b2 = new JButton("Presion");
		b2.addActionListener(this);
		p2.add(b2);

		b3 = new JButton("Precipitación");
		b3.addActionListener(this);
		p2.add(b3);

		b4 = new JButton("Humedad");
		b4.addActionListener(this);
		p2.add(b4);

		b5 = new JButton("Temperatura");
		b5.addActionListener(this);
		p2.add(b5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == b1) {
			p1.setVisible(true);
			g_v.setVisible(true);
			g_h.setVisible(false);
			g_p.setVisible(false);
			g_pr.setVisible(false);
			g_p.setVisible(false);
		} else if ((JButton) e.getSource() == b2) {
			p1.setVisible(true);
			g_v.setVisible(false);
			g_h.setVisible(true);
			g_p.setVisible(false);
			g_pr.setVisible(false);
			g_p.setVisible(false);		
		} else if ((JButton) e.getSource() == b3) {
			p1.setVisible(true);
			g_v.setVisible(false);
			g_h.setVisible(false);
			g_p.setVisible(true);
			g_pr.setVisible(false);
			g_p.setVisible(false);
		} else if ((JButton) e.getSource() == b4) {
			p1.setVisible(true);
			g_v.setVisible(false);
			g_h.setVisible(false);
			g_p.setVisible(false);
			g_pr.setVisible(true);
			g_p.setVisible(false);			
		} else if ((JButton) e.getSource() == b5) {
			p1.setVisible(true);
			g_v.setVisible(false);
			g_h.setVisible(false);
			g_p.setVisible(false);
			g_pr.setVisible(false);
			g_p.setVisible(true);
		}
	}

	public static void main(String[] args) {
		ReadDifference o = new ReadDifference();
		o.readFtoA();
		o.init();
		PW window = new PW(o.velViento.split(","),o.fechas.split(","));
		

	}
}

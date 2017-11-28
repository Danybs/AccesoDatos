package com.daniel.blanco.checkErrors.Graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PW extends JFrame implements ActionListener {

	private JButton b1, b2, b3, b4, b5;
	private JPanel p1, p2;
	private int width = 800;
	private int height = 800;
	protected static boolean C1 = false, C2 = false, C3 = false, C4 = false, C5 = false;

	Grafica gf1;
	private int xValues[];
	private int yValues[];

	public static boolean isC1() {
		return C1;
	}

	public static boolean isC2() {
		return C2;
	}

	public static boolean isC3() {
		return C3;
	}

	public static boolean isC4() {
		return C4;
	}

	public static boolean isC5() {
		return C5;
	}

	public PW() {
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
		add(p1, BorderLayout.SOUTH);
		p1.setBackground(Color.WHITE);
		p1.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
		p1.setVisible(true);

		// Instanciamos las grafica
		
		gf1 = new Grafica(xValues, yValues);
		add(gf1);
		

		// Panel de los botones
		p2 = new JPanel();
		add(p2, BorderLayout.NORTH);
		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 6)));
		p2.setLayout(new GridLayout(1, 5));

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
	Grafica4 g;
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == b1) {
			xValues = new int[] { 227, 100, 200, 300, 400, 500 };
			yValues = new int[] { 227, 100, 50, 100, 200, 300, 400};	
			C1 = true;
			C2 = false;
			C3 = false;
			C4 = false;
			C5 = false;
			p1.setVisible(false);
			gf1.setVisible(true);
			gf1.repaint();
			
		} else if ((JButton) e.getSource() == b2) {
			g = new Grafica4(xValues, yValues);
			add(g);
			xValues = new int[] { 67, 100, 200, 300, 400, 500 };
			yValues = new int[] { 67, 100, 50, 100, 200, 300, 400};	
			C1 = false;
			C2 = true;
			C3 = false;
			C4 = false;
			C5 = false;
			p1.setVisible(false);
			gf1.setVisible(true);
			gf1.repaint();
		} else if ((JButton) e.getSource() == b3) {
			C1 = false;
			C2 = false;
			C3 = true;
			C4 = false;
			C5 = false;
			p1.setVisible(false);
			gf1.setVisible(true);
			gf1.repaint();
		} else if ((JButton) e.getSource() == b4) {
			C1 = false;
			C2 = false;
			C3 = false;
			C4 = true;
			C5 = false;
			p1.setVisible(false);
			gf1.setVisible(true);
			gf1.repaint();

		} else if ((JButton) e.getSource() == b5) {
			C1 = false;
			C2 = false;
			C3 = false;
			C4 = false;
			C5 = true;
			p1.setVisible(false);
			gf1.setVisible(true);
			gf1.repaint();
		}
	}

	public static void main(String[] args) {
		ReadDifference o = new ReadDifference();
		o.readFtoA();
		o.init();
		PW window = new PW();

	}
}

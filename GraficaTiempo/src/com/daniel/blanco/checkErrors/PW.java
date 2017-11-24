package com.daniel.blanco.checkErrors;

import java.awt.BorderLayout;
import java.awt.Color;
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
	protected static boolean check = false;
	public static boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	Grafica1 ga;

	public PW() {
		//Caracteristicas de la ventana principal
		setTitle("Graficas");

		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// pack(); //default size
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);

		getContentPane().setLayout(new BorderLayout());
		
		//Panel de la grafica
		p1 = new JPanel();
		ga = new Grafica1(); //Instanciamos las graficas
		add(p1, BorderLayout.SOUTH);
		p1.setBackground(Color.GRAY);
		p1.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));
		p1.setVisible(true);
		
		//Instanciamos las grafica
		ga = new Grafica1();
		add(ga);
		ga.setVisible(false);		
		
		
		//Panel de los botones
		p2 = new JPanel();
		add(p2, BorderLayout.NORTH);
		p2.setBackground(Color.GRAY);
		p2.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 6)));
		p2.setLayout(new GridLayout(1, 5));
		
		
		//Instanciamos botones
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
			check=true;
			p1.setVisible(false);
			ga.setVisible(true);
			
		} else if ((JButton) e.getSource() == b2) {
			check=false;
			p1.setVisible(false);
			ga.setVisible(true);
			ga.repaint();
			
		} else if ((JButton) e.getSource() == b3) {
	
		} else if ((JButton) e.getSource() == b4) {
			
		} else if ((JButton) e.getSource() == b5) {
			
		}
		
	
	}

	public static void main(String[] args) {
		PW window = new PW();
	}
}

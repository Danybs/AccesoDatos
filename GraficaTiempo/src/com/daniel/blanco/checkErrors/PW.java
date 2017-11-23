package com.daniel.blanco.checkErrors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

	public PW() {
		setTitle("Graficas");

		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// pack(); //default size
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);

		getContentPane().setLayout(new BorderLayout());

		p1 = new JPanel();
		add(p1, BorderLayout.SOUTH);
		p1.setBackground(Color.GRAY);
		p1.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 1.25)));

		p2 = new JPanel();
		add(p2, BorderLayout.NORTH);
		p2.setBackground(Color.GRAY);
		p2.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() / 6)));
		p2.setLayout(new GridLayout(1, 5));

		b1 = new JButton("Velocidad del viento");

		b1.addActionListener(this);
		b1.setActionCommand("B1");
		p2.add(b1);

		b2 = new JButton("Presion");
		b2.addActionListener(this);
		b2.setActionCommand("B2");
		p2.add(b2);

		b3 = new JButton("Precipitación");
		b3.addActionListener(this);
		b3.setActionCommand("B3");
		p2.add(b3);

		b4 = new JButton("Humedad");
		b4.addActionListener(this);
		b4.setActionCommand("B4");
		p2.add(b4);

		b5 = new JButton("Temperatura");
		b5.addActionListener(this);
		b5.setActionCommand("B5");
		p2.add(b5);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ((JButton) e.getSource() == b1) {
			p1.setBackground(Color.pink);
		} else if ((JButton) e.getSource() == b2) {
			p1.setBackground(Color.blue);
		}
		
		 if (e.getActionCommand().equals("B1")) {
			 p1.setBackground(Color.orange);
			 } else if (e.getActionCommand().equals("B2")) {
			 p1.setBackground(Color.blue);
			 } else if (e.getActionCommand().equals("B3")) {
			 p1.setBackground(Color.green);
			 } else if (e.getActionCommand().equals("B4")) {
			 p1.setBackground(Color.PINK);
			 } else if (e.getActionCommand().equals("B5")) {
			 p1.setBackground(Color.pink);
			 }
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

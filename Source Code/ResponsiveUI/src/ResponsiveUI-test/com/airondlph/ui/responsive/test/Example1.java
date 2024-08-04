package com.airondlph.ui.responsive.test;

import javax.swing.JFrame;

/**
 * 
 * @author Airondlph
 * 
 */
public class Example1 {
	public static void main(String[] args) {
		new Example1();
	}
	
	// -----------------------------------------------------------

	private static int WIDTH = 1000;
	private static int HEIGHT = 675;
	
	private JFrame frame;

	public Example1() {
		initComponents();
	}

	private void initComponents() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}


}

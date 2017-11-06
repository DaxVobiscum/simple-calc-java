package com.polonius.java;

import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {
		
		Controller.initialize();
		
		Window.setDefaultLookAndFeelDecorated(true);
		
		Window programWindow = new Window();
		
		programWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		programWindow.setLocationRelativeTo(null);
		programWindow.setVisible(true);
	}

}

package com.polonius.java.panels;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.polonius.java.components.InputButton;

public class NumberPanel {
	
	private static final String[][] NUMBER_MATRIX = {
		{ "7", "8", "9" }, 
		{ "4", "5", "6" },
		{ "1", "2", "3" },
		{ "0", ".", "%" }
	};

	public static HashMap<String, JComponent> create(JFrame parentFrame) {
		
		HashMap<String, JComponent> numberComponents = new HashMap<String, JComponent>();
		
		JPanel numberPanel = new JPanel();
		
		numberPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		numberPanel.setBounds(0, 140, 260, 260);
		
		parentFrame.getContentPane().add(numberPanel);
		
		numberPanel.setLayout(new GridLayout(4, 3, 0, 0));
		
		for (String[] numberRow:NUMBER_MATRIX) {
			
			for (String number:numberRow) {
				
				InputButton numberButton = new InputButton(number);
				numberPanel.add(numberButton);
				
				numberComponents.put(number, numberButton);
			}
		}
		
		return numberComponents;
	}
}

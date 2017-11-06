package com.polonius.java.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.polonius.java.components.InputButton;

public class OperatorPanel {
	
	private static final String[][] OPERATOR_MATRIX = {
		{ "DEL", "CLR" },
		{ "/", "*" },
		{ "-", "+" },
		{ "%", "=" }
	};

	public static HashMap<String, JComponent> create(JFrame parentFrame) {
		
		HashMap<String, JComponent> operatorComponents = new HashMap<String, JComponent>();
		
		JPanel operatorPanel = new JPanel();
		
		operatorPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		operatorPanel.setBounds(260, 140, 140, 260);
		
		parentFrame.getContentPane().add(operatorPanel);
		
		GridBagLayout operatorLayout = new GridBagLayout();
		
		operatorLayout.columnWidths = new int[] { 60, 60 };
		operatorLayout.rowHeights = new int[] { 60, 60, 60, 60 };
		
		operatorPanel.setLayout(operatorLayout);
		
		int gridY = 0;
		int gridX = 0;
		
		for (String[] operatorRow:OPERATOR_MATRIX) {
			
			for (String operator:operatorRow) {
				
				InputButton operatorButton = new InputButton(operator);
				GridBagConstraints buttonConstraints = new GridBagConstraints();
				
				buttonConstraints.fill = GridBagConstraints.BOTH;
				
				buttonConstraints.gridx = gridX;
				buttonConstraints.gridy = gridY;
				
				if ("=" == operator) {
					
					operatorButton.setBackground(new Color(0, 128, 255));
					operatorButton.setForeground(Color.WHITE);
				}
				
				operatorPanel.add(operatorButton, buttonConstraints);
				
				operatorComponents.put(operator, operatorButton);
				
				if (gridX == 1) {
					
					gridX = 0;
					gridY++;
				}
				else {
					
					gridX = 1;
				}
			}
		}
		
		return operatorComponents;
	}
}

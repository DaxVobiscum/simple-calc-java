package com.polonius.java.panels;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.polonius.java.components.InputField;

public class IOPanel {

	private IOPanel() { }
	
	public static HashMap<String, JComponent> create(JFrame parentFrame) {
		
		JPanel ioPanel = new JPanel();
		
		ioPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		ioPanel.setBounds(0, 0, 400, 140);
		
		parentFrame.getContentPane().add(ioPanel);
		
		ioPanel.setLayout(new BoxLayout(ioPanel, BoxLayout.Y_AXIS));
		
		JTextField outputField = new JTextField();
		
		outputField.setBackground(Color.WHITE);
		outputField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		outputField.setHorizontalAlignment(JTextField.RIGHT);
		outputField.setEditable(false);
		
		ioPanel.add(outputField);
		
		InputField inputField = new InputField();
		
		inputField.setBackground(Color.WHITE);
		inputField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputField.setHorizontalAlignment(JTextField.RIGHT);
		//inputField.setEditable(false);
		
		ioPanel.add(inputField);
		
		HashMap<String, JComponent> componentHash = new HashMap<String, JComponent>();
		
		componentHash.put("output", outputField);
		componentHash.put("input",  inputField);
		
		return componentHash;
	}
}

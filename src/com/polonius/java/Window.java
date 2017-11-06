package com.polonius.java;

import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.polonius.java.panels.IOPanel;
import com.polonius.java.panels.NumberPanel;
import com.polonius.java.panels.OperatorPanel;

/**
 * Simple calculator app.
 * @author polonius
 *
 */
public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 788400080501200852L;
	
	private static HashMap<String, JComponent> ioComponents;
	
	public Window() {
		
		this.setBounds(0,  0, 410, 430);
		
		getContentPane().setLayout(null);
		
		ioComponents = IOPanel.create(this);
		
		NumberPanel.create(this);
		OperatorPanel.create(this);
	}
	
	/**
	 * Takes input from the Controller and appends it to the input text field.
	 * @param newInput - New input to be added to the field.
	 * @return - Current value of the field.
	 */
	public static String appendInput(String newInput) {
		
		JTextField inputField = (JTextField)ioComponents.get("input");
		
		String currentValue = inputField.getText();
		
		inputField.setText(currentValue + newInput);
		
		return inputField.getText();
	}
	
	/**
	 * Deletes the last character of input from the input text field.
	 * @return - Current value of the field.
	 */
	public static String deleteInput() {
		
		JTextField inputField = (JTextField)ioComponents.get("input");
		
		String currentValue = inputField.getText();
		
		inputField.setText(currentValue.substring(0, currentValue.length() - 1));
		
		return inputField.getText();
	}
	
	/**
	 * Resets the input text field to an empty value.
	 */
	public static void resetInput() {
		
		JTextField inputField = (JTextField)ioComponents.get("input");
		
		inputField.setText("");
	}
	
	/**
	 * Sets the output text field to the computed result and clears the input field.
	 * @param computationResult - The result of computing all input.
	 */
	public static void submitResult(float computationResult) {
		
		JTextField inputField = (JTextField)ioComponents.get("input");
		JTextField outputField = (JTextField)ioComponents.get("output");
		
		inputField.setText("");
		outputField.setText(String.valueOf(computationResult));
	}
}

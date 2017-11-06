package com.polonius.java.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import com.polonius.java.Controller;
import com.polonius.java.common.Utility;

public class InputField extends JTextField implements InputSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 407292693443588062L;
	
	private String inputValue = "";
	
	public InputField() {
		
		super();
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				String keyVal = String.valueOf(e.getKeyChar());
				
				Boolean numberMatch = Utility.numbersPattern.matcher(keyVal).matches();
				Boolean operatorMatch = Utility.operatorsPattern.matcher(keyVal).matches();
				
				if (numberMatch || operatorMatch) {
					
					inputValue = keyVal;
					
					submitInput();
					
					if (keyVal.equals("=")) {
						
						e.consume();
					}
				}
				else if (keyVal.equals("\b")) {
					
					deleteInput();
				}
				else {
					
					e.consume();
				}
			}
		});
	}
	
	@Override
	public void deleteInput() {
		
		Controller.deleteInput(false);
	}
	
	@Override
	public void resetInput() { }

	@Override
	public void submitInput() {
		
		Controller.submitInput(this.inputValue, false);
	}
}

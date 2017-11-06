package com.polonius.java.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.polonius.java.Controller;

public class InputButton extends JButton implements InputSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6967384048741898680L;
	
	private String value;
	
	public InputButton(String value) {
		
		super(value);
		
		this.value = value;
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				handleInput();
			}
		});
	}
	
	private void handleInput() {
		
		if (this.value.equals("DEL")) {
			
			deleteInput();
		}
		else if (this.value.equals("CLR")) {
			
			resetInput();
		}
		else {
			
			submitInput();
		}
	}
	
	@Override
	public void deleteInput() {
		
		Controller.deleteInput();
	}
	
	@Override
	public void resetInput() {
		
		Controller.resetInput();
	}

	@Override
	public void submitInput() {
		
		Controller.submitInput(this.value);
	}
}

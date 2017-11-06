package com.polonius.java;

import com.polonius.java.common.Utility;

public class Controller {

	private static StringBuilder numberBuffer;
	
	private static String lastEntry;
	
	private static boolean decimalSet;
	
	public static void initialize() {
		
		reset();
	}
	
	public static void reset() {
		
		numberBuffer = new StringBuilder();
		
		lastEntry = "";
		
		decimalSet = false;
	}
	
	public static void deleteInput() {
		
		deleteInput(true);
	}
	
	public static void deleteInput(Boolean updateField) {
		
		lastEntry = "";
		
		numberBuffer.deleteCharAt(numberBuffer.length() - 1);
		
		if (updateField) {
			
			Window.deleteInput();
		}
	}
	
	public static void resetInput() {
		
		Window.resetInput();
		
		Computer.reset();
		
		reset();
	}
	
	public static void submitInput(String inputValue) {
		
		submitInput(inputValue, true);
	}
	
	public static void submitInput(String inputValue, Boolean updateField) {
		
		if (inputValue.equals("=")) {
			
			Computer.addInput(numberBuffer.toString());
			
			Window.submitResult(Computer.computeResult());
			
			resetInput();
		}
		else if (inputValue.equals(".") && !lastEntry.equals(".") && !lastEntry.equals("%")) {
			
			if (!decimalSet) {
				
				numberBuffer.append(inputValue);
				
				decimalSet = true;
				
				Window.appendInput(inputValue);	
			}
		}
		else if (inputValue.equals("%") && !lastEntry.equals("%")) {
			
			float numberValue = Float.parseFloat(numberBuffer.toString());
			
			numberBuffer = new StringBuilder(String.valueOf(numberValue / 100));
		}
		else {
			
			if (Utility.numbersPattern.matcher(inputValue).matches() && !lastEntry.equals("%")) {
				
				numberBuffer.append(inputValue);
				
				if (updateField) {
					
					Window.appendInput(inputValue);
				}
			}
			else if (Utility.operatorsPattern.matcher(inputValue).matches() && 
					0 < numberBuffer.length()) {
				
				if (!Computer.operatorSet()) {
					
					Computer.addInput(numberBuffer.toString());
					
					Computer.addInput(inputValue);
					
					if (updateField) {
						
						Window.appendInput(inputValue);
					}
					
					reset();
				}
			}
		}
		
		lastEntry = inputValue;
	}
}

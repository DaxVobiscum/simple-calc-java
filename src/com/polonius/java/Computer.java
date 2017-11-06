package com.polonius.java;

import java.util.HashMap;

import com.polonius.java.common.Constants;
import com.polonius.java.common.Operator;
import com.polonius.java.common.Utility;

public class Computer {
	
	static final HashMap<String, Operator> OPERATOR_HASH_MAP = Constants.getOperatorHashMap();

	static float firstNumber = Float.MIN_VALUE;
	static float secondNumber = Float.MIN_VALUE;
	
	static Operator operator = null;
	
	static boolean hasData = false;
	
	public static float computeResult() {
		
		float computationResult = Float.MIN_VALUE;
		
		if (null != operator) {
			
			if (operator == Operator.Divide) {
				
				if (0 == secondNumber) {
					
					// black hole!
				}
				else {
					
					computationResult = firstNumber / secondNumber;
				}
			}
			else if (operator == Operator.Multiply) {
	
				computationResult = firstNumber * secondNumber;
			}
			else if (operator == Operator.Minus) {
				
				computationResult = firstNumber - secondNumber;
			}
			else if (operator == Operator.Plus) {
				
				computationResult = firstNumber + secondNumber;
			}
			else if (operator == Operator.Modulo) {
				
				if (secondNumber <= firstNumber && 0 < secondNumber) {
				
					computationResult = firstNumber % secondNumber;
				}
				else {
					
					// you dun goofed!
				}
			}
			else {
				
				// invalid operation!
			}
		}
		
		return computationResult;
	}
	
	public static void addInput(String inputValue) {
		
		if (Utility.numbersPattern.matcher(inputValue).matches()) {
			
			if (!hasData) {
				
				firstNumber = Float.parseFloat(inputValue);
				
				hasData = true;
			}
			else {
				
				secondNumber = Float.parseFloat(inputValue);
			}
		}
		else if (Utility.operatorsPattern.matcher(inputValue).matches()) {
			
			operator = OPERATOR_HASH_MAP.get(inputValue);
		}
	}
	
	public static boolean operatorSet() {
		
		return (null != operator);
	}
	
	public static void reset() {
		
		firstNumber = Float.MIN_VALUE;
		secondNumber = Float.MIN_VALUE;
		
		operator = null;
		
		hasData = false;
	}
}

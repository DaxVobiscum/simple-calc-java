package com.polonius.java.common;

import java.util.HashMap;

public class Constants {

	public static final String PATTERN_NUMBERS = "[0-9.]+";
	public static final String PATTERN_OPERATORS = "[/*\\-+%=]{1}";
	
	public static HashMap<String, Operator> getOperatorHashMap() {
		
		HashMap<String, Operator> operatorHashMap = new HashMap<String, Operator>();
		
		operatorHashMap.put("/", Operator.Divide);
		operatorHashMap.put("*", Operator.Multiply);
		operatorHashMap.put("-", Operator.Minus);
		operatorHashMap.put("+", Operator.Plus);
		operatorHashMap.put("%", Operator.Modulo);
		
		return operatorHashMap;
	}
}

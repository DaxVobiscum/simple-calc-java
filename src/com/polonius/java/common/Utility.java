package com.polonius.java.common;

import java.util.regex.Pattern;

public class Utility {

	public static Pattern numbersPattern = Pattern.compile(Constants.PATTERN_NUMBERS);
	public static Pattern operatorsPattern = Pattern.compile(Constants.PATTERN_OPERATORS);
}

package com.stgtest.framework.utils;

import java.util.Random;

/**
 * {@link NumberUtils} class holding utility methods for number generation and manipulation
 * 
 * @author Vinnie-Mac
 *
 */
public class NumberUtils {
	
	/**
	 * Return a random integer value from a minimum and maximum bound given to the method itself
	 * 
	 * @param {@link Integer} min lower bound
	 * @param {@link Integer} max upper bound
	 * @return {@link Integer}
	 */
	public static Integer chooseRandomNumberWithinGivenRange(Integer min, Integer max) {
		// double check to see if the max value is less than the min
		if(min > max) {
			throw new IllegalArgumentException("The maximum number must be greater than the minimum");
		}
		return new Random().nextInt((max - min) + 1) + min;
	}

}

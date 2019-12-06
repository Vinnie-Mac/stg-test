package com.stgtest.framework.utils;

import java.util.Random;

/**
 * 
 * @author Vinnie-Mac
 *
 */
public class NumberUtils {
	
	/**
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static Integer chooseRandomNumberWithinGivenRange(Integer min, Integer max) {
		// double check to see if the max value is less than the min
		if(min > max) {
			throw new IllegalArgumentException("The maximum number must be greater than the minimum");
		}
		return new Random().nextInt((max - min) + 1) + min;
	}

}

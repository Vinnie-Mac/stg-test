package com.stgtest.framework.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Vinnie-Mac
 *
 */
public class TimeUtils {
	
	/**
	 * 
	 * @param timeInMinutes
	 * @return
	 */
	public static Integer convertMinutesToSeconds(Integer timeInMinutes) {
		Long timeInSeconds = TimeUnit.MINUTES.toSeconds(timeInMinutes);
		return timeInSeconds.intValue();
	}
}

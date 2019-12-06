package com.stgtest.framework.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.TimeZone;

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
	
	
	/**
	 * Get a local date time instance with ISO formatting
	 * 
	 * @return {@link String} standard ISO formatted date time instance of now
	 */
	public static String getDateTimeNowInISOFormat() {
		return LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
	}
}

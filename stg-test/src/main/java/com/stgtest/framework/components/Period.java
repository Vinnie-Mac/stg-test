package com.stgtest.framework.components;

/**
 * {@link Period} enum responsible for holding two values that stipulate the specific period a football match is currently at OR 
 * to stipulate when a goal is scored within a given period of a football game
 * 
 * @author Vinnie-Mac
 *
 */
public enum Period {
	
	FIRST_HALF("FIRST_HALF"),
	SECOND_HALF("SECOND_HALF");
	
	String period;


	/**
	 * Basic constructor
	 * 
	 * @param {@link String} period of when the goal is scored
	 */
	Period(final String period)
	{
		this.period = period;
	}
	
	/**
	 * Get the string value of a specific period enum that is going to be used to stipulate
	 * in which half a goal is scored for a POST operation to the API
	 * 
	 * @return {@link String} the period value
	 */
	public String getPeriod() {
		return this.period;
	}

}

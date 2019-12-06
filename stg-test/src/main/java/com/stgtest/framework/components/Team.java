package com.stgtest.framework.components;

/**
 * {@link Team} enum responsible for holding two values that stipulate the specific period a football match is currently at OR 
 * to stipulate when a goal is scored within a given period of a football game
 * 
 * @author Vinnie-Mac
 *
 */
public enum Team {
	
	HOME("HOME"),
	AWAY("HOME");
	
	String team;


	/**
	 * Basic constructor
	 * 
	 * @param {@link String} period of when the goal is scored
	 */
	Team(final String team)
	{
		this.team = team;
	}
	
	/**
	 * Get the string value of a specific team enum that is going to be used to stipulate
	 * in which team has scored a goal
	 * 
	 * @return {@link String} the team value
	 */
	public String getTeam() {
		return this.team;
	}

}

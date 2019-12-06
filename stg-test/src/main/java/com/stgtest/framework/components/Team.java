package com.stgtest.framework.components;

/**
 * {@link Team} enum responsible for stipulating if a team is an AWAY team or a HOME team
 * 
 * @author Vinnie-Mac
 *
 */
public enum Team {
	
	HOME("HOME"),
	AWAY("AWAY");
	
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

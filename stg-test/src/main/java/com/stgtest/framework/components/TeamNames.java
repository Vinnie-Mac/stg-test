package com.stgtest.framework.components;

/**
 * {@link TeamNames} class responsible for listing out all different teams
 * 
 * @author Vinnie-Mac
 */
public enum TeamNames {
	
	OSTERREICH("Österreich"),
	DAGENHAM_AND_REDBRIDGE("Dagenham-&-Redbridge"),
	MANCHESTER_UNITED("Manchester United"),
	GARFORTH_FC("Garforth-FC"),
	LEEDS_UNITED("Leeds-United"),
	YORK_FC("York-FC"),
	SWANSEA("Swansea"),
	CARDIFF("Cardiff");
	
	String teamName;


	/**
	 * Basic constructor
	 * 
	 * @param {@link String} team the specific team name
	 */
	TeamNames(final String teamName)
	{
		this.teamName = teamName;
	}
	
	/**
	 * Get the string value of a specific team name
	 * 
	 * @return {@link String} the team value
	 */
	public String getTeamName() {
		return this.teamName;
	}

}

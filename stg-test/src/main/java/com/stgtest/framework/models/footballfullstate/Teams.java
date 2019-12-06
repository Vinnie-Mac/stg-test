package com.stgtest.framework.models.footballfullstate;


import com.stgtest.framework.components.Team;

/**
 * 
 * {@link Team} class responsible  for storing Team based information 
 *
 * @author Vinnie-Mac
 */
public class Teams {
	
	private String association;
	private String name;
	private String teamId;
	
	
	/**
	 * Basic constructor 
	 * 
	 * @param {@link String} association
	 * @param {@link String} name
	 * @param {@link String} teamId
	 */
	public Teams(String association, String name, String teamId) {
		this.association = association;
		this.name = name;
		this.teamId = teamId;
	}
	
	
	/**
	 * @return the association
	 */
	public String getAssociation() {
		return association;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}
	
	/**
	 * @param association the association to set
	 */
	public void setAssociation(String association) {
		this.association = association;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
}

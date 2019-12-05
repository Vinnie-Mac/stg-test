package com.stgtest.framework.models.footballfullstate;

import java.util.ArrayList;
import java.util.Map;

import com.stgtest.framework.models.Fixture;

/**
 * 
 * @author Vinnie Mac
 * 
 * {@link FootballFullState} POJO for the 'footballFullState' JSON object which resides within the {@link Fixture} JSON object
 */
public class FootballFullState {
	private String homeTeam;
	private String awayTeam;
	private Boolean finished;
	private Double gameTimeInSeconds;
	private Map<String, Goals> goals;
	private String period;
	private Map<String, Possibles> possibles;
	private Map<String, Corners> corners;
	private Map<String, RedCards> redCards;
	private Map<String, YellowCards> yellowCards;
	private String startDateTime;
	private Boolean started;
	private Map<String, Teams> teams;
	
	
	/**
	 * @return the homeTeam
	 */
	public String getHomeTeam() {
		return homeTeam;
	}
	
	/**
	 * @return the awayTeam
	 */
	public String getAwayTeam() {
		return awayTeam;
	}
	
	/**
	 * @return the finished
	 */
	public Boolean getFinished() {
		return finished;
	}
	
	/**
	 * @return the gameTimeInSeconds
	 */
	public Double getGameTimeInSeconds() {
		return gameTimeInSeconds;
	}
	
	/**
	 * @return the goals
	 */
	public Map<String, Goals> getGoals() {
		return goals;
	}
	
	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * @return the possibles
	 */
	public Map<String, Possibles> getPossibles() {
		return possibles;
	}
	
	/**
	 * @return the corners
	 */
	public Map<String, Corners> getCorners() {
		return corners;
	}
	
	/**
	 * @return the redCards
	 */
	public Map<String, RedCards> getRedCards() {
		return redCards;
	}
	
	/**
	 * @return the yellowCards
	 */
	public Map<String, YellowCards> getYellowCards() {
		return yellowCards;
	}
	
	/**
	 * @return the startDateTime
	 */
	public String getStartDateTime() {
		return startDateTime;
	}
	
	/**
	 * @return the started
	 */
	public Boolean getStarted() {
		return started;
	}
	
	/**
	 * @return the teams
	 */
	public Map<String, Teams> getTeams() {
		return teams;
	}
	
}

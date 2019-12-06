/**
 * 
 */
package com.stgtest.framework.models.footballfullstate;

/**
 * {@link Goals} POJO for the 'goals' JSON object which resides within the {@link FootballFullState} JSON object
 *
 * @author Vinnie-Mac
 */
public class Goals {
	private Integer clockTime;
	private Boolean confirmed = true;
	private Double id;
	private Boolean ownGoal;
	private Boolean penalty;
	private String period;
	private Double playerId;
	private String teamId;
	
	
	/**
	 * @return the clockTime
	 */
	public Integer getClockTime() {
		return clockTime;
	}
	
	/**
	 * @return the confirmed
	 */
	public Boolean getConfirmed() {
		return confirmed;
	}
	
	/**
	 * @return the id
	 */
	public Double getId() {
		return id;
	}
	
	/**
	 * @return the ownGoal
	 */
	public Boolean getOwnGoal() {
		return ownGoal;
	}
	
	/**
	 * @return the penalty
	 */
	public Boolean getPenalty() {
		return penalty;
	}
	
	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * @return the playerId
	 */
	public Double getPlayerId() {
		return playerId;
	}
	
	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}
}

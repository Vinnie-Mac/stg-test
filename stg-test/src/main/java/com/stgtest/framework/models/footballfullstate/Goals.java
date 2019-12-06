/**
 * 
 */
package com.stgtest.framework.models.footballfullstate;

import java.util.concurrent.TimeUnit;

import com.stgtest.framework.components.Period;
import com.stgtest.framework.steps.AssertionSteps;
import com.stgtest.framework.utils.TimeUtils;

import net.thucydides.core.annotations.Shared;

/**
 * {@link Goals} POJO for the 'goals' JSON object which resides within the {@link FootballFullState} JSON object
 *
 * @author Vinnie-Mac
 */
public class Goals {
	private Integer clockTime;
	private Boolean confirmed;
	private Integer id;
	private Boolean ownGoal;
	private Boolean penalty;
	private String period;
	private Integer playerId;
	private String teamId;
	
	
	/**
	 * 
	 * @author Vinnie-Mac
	 *
	 */
	public static class GoalsBuilder {

		private Integer clockTime;
		private Boolean confirmed;
		private Integer id;
		private Boolean ownGoal;
		private Boolean penalty;
		private String period;
		private Integer playerId;
		private String teamId;
		
		
		/**
		 * 
		 * @param gameTimeInMinutes
		 * @param clockTime
		 * @return
		 */
		public GoalsBuilder withClockTime(Integer gameTimeInMinutes, Integer clockTime) {
			if(TimeUtils.convertMinutesToSeconds(clockTime) < TimeUtils.convertMinutesToSeconds(gameTimeInMinutes)) {
				this.clockTime = clockTime.intValue();
			} else {
				System.out.println("You cannot have a goal scored beyond the game time as that's not possible - "
						+ "Choose a goal time that is within the game time in secodns boundary");
				System.exit(1);
			}
			return this;
		}
		
		/**
		 * 
		 * @param confirmed
		 * @return
		 */
		public GoalsBuilder withConfirmed(Boolean confirmed) {
			this.confirmed = confirmed;
			return this;
		}
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		public GoalsBuilder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		
		/**
		 * 
		 * @param ownGoal
		 * @return
		 */
		public GoalsBuilder withOwnGoal(Boolean ownGoal) {
			this.ownGoal = ownGoal;
			return this;
		}
		
		
		/**
		 * 
		 * @param penalty
		 * @return
		 */
		public GoalsBuilder withPenalty(Boolean penalty) {
			this.penalty = penalty;
			return this;
		}
	
		
		/**
		 * 
		 * @param period
		 * @return
		 */
		public GoalsBuilder withPeriod(Period period) {
			this.period = period.getPeriod();
			return this;
		}
		
		/**
		 * 
		 * @param playerId
		 * @return
		 */
		public GoalsBuilder withPlayerId(Integer playerId) {
			this.playerId = playerId;
			return this;
		}
		
		
		/**
		 * 
		 * @param teamId
		 * @return
		 */
		public GoalsBuilder withTeamId(String teamId) {
			this.teamId = teamId;
			return this;
		}
		
		
		/**
		 * 
		 * @return
		 */
		public Goals build() {
			Goals goals = new Goals();
			
			
			return goals;
		}
		
	}
	
	
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
	public Integer getId() {
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
	public Integer getPlayerId() {
		return playerId;
	}
	
	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}
}

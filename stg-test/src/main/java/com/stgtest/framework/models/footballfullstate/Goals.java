package com.stgtest.framework.models.footballfullstate;


import com.stgtest.framework.components.Period;
import com.stgtest.framework.utils.TimeUtils;

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
	 * {@link GoalsBuilder} builder pattern to create a Goals instance more easily
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
		 * Apply Clock Time value
		 * 
		 * @param {@link Integer} gameTimeInMinutes
		 * @param {@link Integer} clockTime
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withClockTime(Integer clockTime, Integer gameTimeInMinutes) {
			Integer compareValue = TimeUtils.convertMinutesToSeconds(clockTime).compareTo(TimeUtils.convertMinutesToSeconds(gameTimeInMinutes));
			
			if(compareValue <= 0) {
				this.clockTime = clockTime.intValue();
			} else {
				System.out.println("You cannot have a goal scored beyond the game time as that's not possible - "
						+ "Choose a goal time that is within the game time in seconds boundary");
				System.exit(1);
			}
			return this;
		}
		
		/**
		 * Apply Confirmed value
		 * 
		 * @param {@link Boolean} confirmed
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withConfirmed(Boolean confirmed) {
			this.confirmed = confirmed;
			return this;
		}
		
		/**
		 * Apply ID value
		 * 
		 * @param {@link Integer} id
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		
		/**
		 * Apply Own Goal value
		 * 
		 * @param {@link Boolean} ownGoal
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withOwnGoal(Boolean ownGoal) {
			this.ownGoal = ownGoal;
			return this;
		}
		
		
		/**
		 * Apply Penalty value
		 * 
		 * @param {@link Boolean} penalty
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withPenalty(Boolean penalty) {
			this.penalty = penalty;
			return this;
		}
	
		
		/**
		 * Apply Period value
		 * 
		 * @param {@link Period} period
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withPeriod(Period period) {
			this.period = period.getPeriod();
			return this;
		}
		
		
		/**
		 * Apply Player ID value
		 * 
		 * @param {@link Integer} playerId
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withPlayerId(Integer playerId) {
			this.playerId = playerId;
			return this;
		}
		
		
		/**
		 * Apply Team ID value
		 * 
		 * @param {@link String} teamId
		 * @return {@link GoalsBuilder}
		 */
		public GoalsBuilder withTeamId(String teamId) {
			this.teamId = teamId;
			return this;
		}
		
		
		/**
		 * Build all the values together in order to create the Goals instance itself
		 * 
		 * @return {@link Goals} instance
		 */
		public Goals build() {
			Goals goals = new Goals();
			
			goals.clockTime = this.clockTime;
			goals.confirmed = this.confirmed;
			goals.id = this.id;
			goals.ownGoal = this.ownGoal;
			goals.penalty = this.penalty;
			goals.period = this.period;
			goals.playerId = this.playerId;
			goals.teamId = this.teamId;
			
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

package com.stgtest.framework.models.footballfullstate;

import java.util.List;

import com.stgtest.framework.models.Fixture;

/**
 * {@link FootballFullState} POJO for the 'footballFullState' JSON object which resides within the {@link Fixture} JSON object
 * 
 * @author Vinnie-Mac
 */
public class FootballFullState {
	private String homeTeam;
	private String awayTeam;
	private Boolean finished;
	private Integer gameTimeInSeconds;
	private List<Goals> goals;
	private String period;
	private List<Possibles> possibles;
	private List<Corners> corners;
	private List<RedCards> redCards;
	private List<YellowCards> yellowCards;
	private String startDateTime;
	private Boolean started;
	private List<Teams> teams;
	
	
	/**
     * {@link FootballFullStateBuilder} builder pattern to create a FootballFullState instance more easily - use with POST request and place
     * into the body parameter
     */
    public static class FootballFullStateBuilder {
    	private String homeTeam;
    	private String awayTeam;
    	private Boolean finished;
    	private Integer gameTimeInSeconds;
    	private List<Goals> goals;
    	private String period;
    	private List<Possibles> possibles;
    	private List<Corners> corners;
    	private List<RedCards> redCards;
    	private List<YellowCards> yellowCards;
    	private String startDateTime;
    	private Boolean started;
    	private List<Teams> teams;
    	
      
        /**
         * FootballFullStateBuilder constructor 
         *
         */
        public FootballFullStateBuilder() {
        }

        
        /**
         * Apply HomeTeam value
         *
         * @param  {@link String}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withHomeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }
        
        
        /**
         * Apply AwayTeam value
         *
         * @param  {@link String}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withAwayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }
        
        
        /**
         * Apply Finished value
         *
         * @param  {@link Boolean}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withFinished(Boolean finished) {
            this.finished = finished;
            return this;
        }
        
        
        /**
         * Apply GameTimeInSeconds value
         *
         * @param  {@link Integer }
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withGameTimeInSeconds(Integer gameTimeInSeconds) {
            this.gameTimeInSeconds = gameTimeInSeconds;
            return this;
        }
        
        
        /**
         * Apply Goals value
         *
         * @param  {@link List<Goals>}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withGoals(List<Goals> goals) {
            this.goals = goals ;
            return this;
        }
        
        
        /**
         * Apply Period value
         *
         * @param  {@link String}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder with(String period) {
            this.period = period;
            return this;
        }
        
        
        /**
         * Apply Possibles value
         *
         * @param  {@link List<Possibles>}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withPossibles(List<Possibles> possibles) {
            this.possibles = possibles;
            return this;
        }
        
        
        /**
         * Apply Corners value
         *
         * @param  {@linkList<Corners>}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withCorners(List<Corners> corners) {
            this.corners = corners;
            return this;
        }
        
        
        /**
         * Apply RedCards value
         *
         * @param  {@link List<RedCards>}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withRedCards(List<RedCards> redCards) {
            this.redCards = redCards;
            return this;
        }
        
        
        /**
         * Apply YellowCards value
         *
         * @param  {@link List<YellowCards>}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withYellowCards(List<YellowCards> yellowCards) {
            this.yellowCards = yellowCards;
            return this;
        }
        
        
        /**
         * Apply StartDateTime value
         *
         * @param  {@link String}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder withStartDateTime(String startDateTime) {
            this.startDateTime = startDateTime;
            return this;
        }
        
        
        /**
         * Apply Started value
         *
         * @param  {@link Boolean}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder with(Boolean started) {
            this.started = started;
            return this;
        }
        
        
        /**
         * Apply Teams value
         *
         * @param  {@link List<Teams>}
         * @return {@link FootballFullStateBuilder}
         */
        public FootballFullStateBuilder with(List<Teams> teams) {
            this.teams = teams ;
            return this;
        }

        
        /**
         * Build the Fixture instance after setting all needed values to the fixture fields that are called upon
         *
         * @return {@link Fixture}
         */
        public FootballFullState build() {
            FootballFullState footballFullState = new FootballFullState();
            footballFullState.homeTeam = this.homeTeam;
            footballFullState.awayTeam = this.awayTeam;
            footballFullState.finished = this.finished;
            footballFullState.gameTimeInSeconds = this.gameTimeInSeconds;
            footballFullState.goals = this.goals;
            footballFullState.period = this.period;
            footballFullState.possibles = this.possibles;
            footballFullState.corners = this.corners;
            footballFullState.redCards = this.redCards;
            footballFullState.yellowCards = this.yellowCards;
            footballFullState.startDateTime = this.startDateTime;
            footballFullState.started = this.started;
            footballFullState.teams = this.teams;

            
            return footballFullState;
        }
    }
	
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
	public Integer getGameTimeInSeconds() {
		return gameTimeInSeconds;
	}
	/**
	 * @return the goals
	 */
	public List<Goals> getGoals() {
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
	public List<Possibles> getPossibles() {
		return possibles;
	}
	/**
	 * @return the corners
	 */
	public List<Corners> getCorners() {
		return corners;
	}
	/**
	 * @return the redCards
	 */
	public List<RedCards> getRedCards() {
		return redCards;
	}
	/**
	 * @return the yellowCards
	 */
	public List<YellowCards> getYellowCards() {
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
	public List<Teams> getTeams() {
		return teams;
	}
}

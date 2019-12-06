package com.stgtest.framework.models;

import com.stgtest.framework.models.footballfullstate.FootballFullState;

/**
 * {@link Fixture} class containing the Fixture object values and the FixtureBuilder used to construct a new fixture if
 * needing to create one in the system/database
 * 
 * @author Vinnie-Mac
 */
public class Fixture {

    private Integer fixtureId;
    private FixtureStatus fixtureStatus;
    private FootballFullState footballFullState;


   
    /**
     * {@link FixtureBuilder} builder pattern to create a Fixture instance more easily - use with POST request and place
     * into the body parameter
     */
    public static class FixtureBuilder {
        private Integer fixtureID;
        private FixtureStatus fixtureStatus;
        private FootballFullState footballFullState;
        
      
        /**
         * FixtureBuilder constructor with mandatory field set of adding the 'name' otherwise the API will not allows a
         * fixture to be create without this value being set
         *
         * @param name {@link String} value of the fixture name
         */
        public FixtureBuilder(Integer id) {
        	this.fixtureID = id;
        }


        /**
         * Apply FixtureStatus value
         *
         * @param fixtureStatus {@link FixtureStatus}
         * @return {@link FixtureBuilder}
         */
        public FixtureBuilder withFixtureStatus(FixtureStatus fixtureStatus) {
            this.fixtureStatus = fixtureStatus;
            return this;
        }

        /**
         * Apply FootballFullState value
         *
         * @param footballFullState {@link FootballFullState}
         * @return {@link FixtureBuilder}
         */
        public FixtureBuilder withFootballFullStateStatus(FootballFullState footballFullState) {
            this.footballFullState = footballFullState;
            return this;
        }


        /**
         * Build the Fixture instance after setting all needed values to the fixture fields that are called upon
         *
         * @return {@link Fixture}
         */
        public Fixture build() {
            Fixture fixture = new Fixture();
            
            fixture.fixtureId = this.fixtureID;
            fixture.fixtureStatus = this.fixtureStatus;
            fixture.footballFullState = this.footballFullState;
           
            return fixture;
        }
    }



	/**
	 * @return the fixtureId
	 */
	public Integer getFixtureId() {
		return fixtureId;
	}


	/**
	 * @return the fixtureStatus
	 */
	public FixtureStatus getFixtureStatus() {
		return fixtureStatus;
	}


	/**
	 * @return the footballFullState
	 */
	public FootballFullState getFootballFullState() {
		return footballFullState;
	}
}

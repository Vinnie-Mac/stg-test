package com.stgtest.post;

import com.google.gson.reflect.TypeToken;
import com.stgtest.framework.components.Period;
import com.stgtest.framework.components.Team;
import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.models.FixtureStatus;
import com.stgtest.framework.models.footballfullstate.FootballFullState;
import com.stgtest.framework.models.footballfullstate.Goals;
import com.stgtest.framework.models.footballfullstate.Teams;
import com.stgtest.framework.steps.AssertionSteps;
import com.stgtest.framework.steps.GetSteps;
import com.stgtest.framework.steps.PostSteps;
import com.stgtest.framework.utils.MapResponseToClass;
import com.stgtest.framework.utils.ModelGenerator;
import com.stgtest.framework.utils.TimeUtils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Tests to adhere to the following criteria</h2>
 *
 * <h3>2. Using the model guide in apiDocs.html, store a new fixture in the database.</h3
 * <i>i. Get the new fixture.</i>
 * <br><i>ii. Assert, within the teams array, that the first object has a teamId of 'HOME'.</i>
 *
 * <br/><br/>
 *
 * <h3>3. To simulate latency within systems, there is an intentional, random delay to store a new fixture on the server.</h3>
 * <i>Bearing the delay in mind, create a new fixture and then retrieve it as soon as it's available</i>
 * 
 * @author Vinnie-Mac
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostFixtureTests {
	
    @Shared
    GetSteps getSteps;

    @Shared
    PostSteps postSteps;

    @Shared
    AssertionSteps assertionSteps;
    
    
    private Long newFixtureId = 333L;
	private Integer gameTimeInMinutes = 45;
	private Integer amountOfGoalsToGenerate = 2;
	
	private List<Teams> teamsList;
    private List<Goals> listOfGoalsInAFixture;
    private List<Fixture> listOfAllFixturesBeforeUpdate;
    
    private Fixture fixtureToCreate;
    private Fixture fixtureToRetrieve;
    
    private Type fixtureListType = new TypeToken<ArrayList<Fixture>>() {}.getType();

    @Before
    public void Setup() {
    	this.listOfGoalsInAFixture = ModelGenerator.generateAListOfGoalsForAFixture(
    			this.amountOfGoalsToGenerate, 
    			this.gameTimeInMinutes, 
    			false, 
    			false,
    			Period.FIRST_HALF);
    	
    	this.teamsList = ModelGenerator.generateAListOfTwoTeamsAtRandom();
    	
    	FootballFullState fullState = new FootballFullState.FootballFullStateBuilder()
    			.withHomeTeam(this.getSteps.getTeamByAssociation(this.teamsList, Team.HOME.getTeam()))
    			.withAwayTeam(this.getSteps.getTeamByAssociation(this.teamsList, Team.AWAY.getTeam()))
    			.withFinished(true)
    			.withGameTimeInSeconds(this.gameTimeInMinutes)
    			.withGoals(this.listOfGoalsInAFixture)
    			.withPeriod(this.listOfGoalsInAFixture.get(0).getPeriod())
    			.withStartDateTime(TimeUtils.getDateTimeNowInISOFormat())
    			.withStarted(true)
    			.withTeams(this.teamsList)
    			.build();
    	
    	this.fixtureToCreate = new Fixture.FixtureBuilder(this.newFixtureId)
    			.withFixtureStatus(new FixtureStatus(true))
    			.withFootballFullStateStatus(fullState)
    			.build();
    	
    	/* Full list of fixtures before you post a new one to the database */
        this.listOfAllFixturesBeforeUpdate = 
        		MapResponseToClass.getJSONObjectsAsClass(
        				this.getSteps.getAllFixtures().jsonPath().prettify(), 
        				fixtureListType);

    }
    

    @Test
    @WithTags({
            @WithTag("Fixtures"),
            @WithTag("Post"),
            @WithTag("New Fixture")
    })
    @Title("Store new fixture in database then retrieve it")
    public void storeNewFixtureInDatabaseTest()
    {
    	assertionSteps.assertEqual("Fixture has been added", this.postSteps.createNewFixture(fixtureToCreate).getBody().toString());
    	
    	this.fixtureToRetrieve = this.getSteps.getNewlyCreatedFixtureWhenAvailable(this.newFixtureId, this.listOfAllFixturesBeforeUpdate);
    }


    @Test
    @WithTags({
            @WithTag("Fixtures"),
            @WithTag("Post"),
            @WithTag("HOME")
    })
    @Title("Assert within the teams array that that the first object has a teamId of HOME")
    public void assertFirstObjectInTeamsArrayHasHOMETeamId() {
    	assertionSteps.assertEqual(
    			this.fixtureToRetrieve
    			.getFootballFullState()
    			.getTeams()
    			.get(0)
    			.getTeamId(), 
    			Team.HOME.getTeam());
    }
}

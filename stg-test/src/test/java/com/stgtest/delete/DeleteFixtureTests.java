package com.stgtest.delete;

import com.google.gson.reflect.TypeToken;
import com.stgtest.framework.components.Period;
import com.stgtest.framework.components.Team;
import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.models.FixtureStatus;
import com.stgtest.framework.models.footballfullstate.FootballFullState;
import com.stgtest.framework.models.footballfullstate.Goals;
import com.stgtest.framework.models.footballfullstate.Teams;
import com.stgtest.framework.steps.AssertionSteps;
import com.stgtest.framework.steps.DeleteSteps;
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
 * <h3>4. Create and delete a new fixture.</h3
 * <i>i. Assert that the fixture no longer exists.</i>
 * 
 * @author Vinnie-Mac
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteFixtureTests {

    @Shared
    GetSteps getSteps;

    @Shared
    PostSteps postSteps;

    @Shared
    DeleteSteps deleteSteps;

    @Shared
    AssertionSteps assertionSteps;
    
    
    private Fixture fixtureToCreate;
    private Long newFixtureId = 333L;
	private Integer gameTimeInMinutes = 45;
	private Integer amountOfGoalsToGenerate = 2;
	
	private List<Teams> teamsList;
    private List<Goals> listOfGoalsInAFixture;
    private List<Fixture> listOfAllFixturesBeforeAddition;
    private List<Fixture> listOfAllFixturesAfterAddition;
    private List<Fixture> listOfAllFixturesAfterDeletion;
    
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

        this.listOfAllFixturesBeforeAddition = 
        		MapResponseToClass.getJSONObjectsAsClass(
        				this.getSteps.getAllFixtures().jsonPath().prettify(), 
        				this.fixtureListType);
        
        this.postSteps.createNewFixture(this.fixtureToCreate);
        
        this.listOfAllFixturesAfterAddition = this.getSteps.getUpdatedListOfAllFixturesWhenAvailable(this.listOfAllFixturesBeforeAddition);
    }


    @Test
    @WithTags({
            @WithTag("Fixtures"),
            @WithTag("Delete"),
    })
    @Title("Create fixture, delete it then assert it no longer appears within the database")
    public void createFixtureThenDeleteThenAssertNoLongerExistsTest()
    {
        this.deleteSteps.deleteFixtureById(this.newFixtureId);
        
        this.listOfAllFixturesAfterDeletion = this.getSteps.getUpdatedListOfAllFixturesWhenAvailable(this.listOfAllFixturesAfterAddition);
        
        assertionSteps.assertNotEqual(
        		this.listOfAllFixturesAfterAddition.size(),
        		this.listOfAllFixturesAfterDeletion.size());
    }
}

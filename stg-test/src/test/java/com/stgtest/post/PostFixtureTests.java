package com.stgtest.post;

import com.google.gson.reflect.TypeToken;
import com.stgtest.framework.components.Period;
import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.models.FixtureStatus;
import com.stgtest.framework.models.footballfullstate.FootballFullState;
import com.stgtest.framework.models.footballfullstate.Goals;
import com.stgtest.framework.steps.AssertionSteps;
import com.stgtest.framework.steps.GetSteps;
import com.stgtest.framework.steps.PostSteps;
import com.stgtest.framework.utils.MapResponseToClass;
import com.stgtest.framework.utils.ModelGenerator;

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
import java.util.Arrays;
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

	private Integer fixtureId = 333;
	private Integer gameTimeInMinutes = 45;
	private Integer amountOfGoalsToGenerate = 2;
	
    private List<Fixture> listOfAllFixtures;
    private List<Goals> listOfGoalsInAFixture;

    @Shared
    GetSteps getSteps;

    @Shared
    PostSteps postSteps;


    @Shared
    AssertionSteps assertionSteps;

    @Before
    public void Setup() {
    	this.listOfGoalsInAFixture = ModelGenerator.generateAListOfGoalsForAFixture(
    			this.amountOfGoalsToGenerate, 
    			this.gameTimeInMinutes, 
    			true, 
    			false,
    			Period.FIRST_HALF);
    	
    	FootballFullState fullState = new FootballFullState.FootballFullStateBuilder()
    			.withHomeTeam("Swansea")
    			.withAwayTeam("Cardiff")
    			.withFinished(true)
    			.withGameTimeInSeconds(this.gameTimeInMinutes)
    			.withGoals(this.listOfGoalsInAFixture)
    			.withPeriod(this.listOfGoalsInAFixture.get(0).getPeriod())
    			
    			.build();
    	
    	Fixture fixture = new Fixture.FixtureBuilder(this.fixtureId)
    			.withFixtureStatus(new FixtureStatus(true))
    			.withFootballFullStateStatus(fullState)
    			.build();
    	
    	
    	Type fixtureListType = new TypeToken<ArrayList<Fixture>>() {}.getType();
    	
    	/* Full list of fixtures before you post a new one to the database */
        this.listOfAllFixtures = 
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
    @Title("")
    public void storeNewFixtureInDatabaseTest()
    {
    	

    }


//    @Test
//    @WithTags({
//            @WithTag("Fixtures"),
//            @WithTag("Post"),
//            @WithTag("HOME")
//    })
//    @Title("")
//    public void assertFirstObjectInTeamsArrayHasHOMETeamId()
//    {
//
//    }
//
//
//    @Test
//    @WithTags({
//            @WithTag("Fixtures"),
//            @WithTag("Post"),
//            @WithTag("Latency")
//    })
//    @Title("")
//    public void createNewFixtureAgainstSimulatedDelayThenRetrieve()
//    {
//        //create a builder for a fixture here so that you may send it off via body parameter in the post method
//        Fixture fixtureSentToDatabase = new Fixture();
//        
//        
//        this.postSteps.createNewFixture(fixtureSentToDatabase);
//
//        Fixture fixtureReceivedFromDatabase = this.getSteps.getNewlyCreatedFixtureWhenAvailable(this.fixtureIdForFixtureToSendViaPostRequest);
//
//        assertionSteps.assertEqual(fixtureSentToDatabase.getFixtureId(), fixtureReceivedFromDatabase.getFixtureId());
//    }
}

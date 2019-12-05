package com.stgtest.framework.steps;

import com.google.gson.reflect.TypeToken;
import com.stgtest.framework.base.TestBase;
import com.stgtest.framework.components.StatusCode;
import com.stgtest.framework.components.UriPath;
import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.utils.MapResponseToClass;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link GetSteps} Steps class to use the GET http method exclusively in test operations
 */
public class GetSteps {
	@Shared
	AssertionSteps assertionSteps;

	/* Type token needed at fixture response beginning due to root element of JSON being '[{...}]' and not the usual '{...}' */
	private Type fixtureListType = new TypeToken<ArrayList<Fixture>>() {}.getType();
		
    /* Anything higher than 3 minutes means a fault lies within API however I am open to hear explanation if 3 minutes would need to be increased */
    private Integer latencyDelayWaitDuration = 180_000;
    

    /**
     * Gather full list of fixtures currently stored within the database
     *
     * @return {@link Response}
     */
    @Step("Gather all fixtures currently within the database")
    public Response getAllFixtures()
    {
        Response response = SerenityRest.given()
                        .baseUri(TestBase.getBaseUri())
                        .when()
                        .get(UriPath.ALL_FIXTURES.getUriPathString());
        
        assertionSteps.assertEqual(response.getStatusCode(), StatusCode.OK.getValue());
        
        return response;
    }


    /**
     * Gather a singular fixture from the database, using the fixtureId value only
     *
     * @param fixtureId {@link String} fixtureId value
     * @return {@link Response}
     */
    @Step("Gather a singular fixture by ID value only")
    public Response getFixtureById(String fixtureId)
    {
        Response response = SerenityRest.given()
                .baseUri(TestBase.getBaseUri())
                .when()
                .get(UriPath.FIXTURE_ID.getFormattedUriPath(fixtureId));
        
        assertionSteps.assertEqual(response.getStatusCode(), StatusCode.OK.getValue());
        
        return response;
    }


    /**
     * Get a full list of fixtures when system makes a newly created fixture available.
     *
     * <p>This method is useful when immediately trying to retrieve a list of fixtures that include one which has been recently created (as of the last few seconds).
     *
     * A built-in system delay of random value (imitation of latency) prevents you from immediately gathering a newly created fixture.
     * This method gives 3 minutes ({@link #latencyDelayWaitDuration} is where this is set) as a maximum wait duration to allow the system to
     * give access to the newly created fixture. If a fixture is not available beyond that point then you may be experiencing system
     * faults of a different calibre.
     *
     * <h3>To Note:</h3> It is recommended to pick something other than ID to filter out the newly created fixture due to needing further http requests
     * to interrogate a list of fixtures via ID value.</p>
     *
     * @param listOfFixturesBeforeUpdate {@link String} criteria to be used to gather a specific fixture
     * @return {@link List<Fixture>} object retrieved from database
     */
    @Step("Gather a full listof fixtures after the system receives a brand new fixture - handling the built-in system latency/delay")
    public List<Fixture> getUpdatedListOfAllFixturesWhenAvailable(List<Fixture> listOfFixturesBeforeUpdate) {
        Long currentTimeOutsideOfLoop = System.currentTimeMillis();
        List<Fixture> fixturesReceivedFromDatabase = new ArrayList<Fixture>();

        while(true) {
            Long currentTimeDuringLoop = System.currentTimeMillis();
            if(currentTimeDuringLoop - currentTimeOutsideOfLoop >= this.latencyDelayWaitDuration) {
                break;
            } else if (listOfFixturesBeforeUpdate.size() == MapResponseToClass.getJSONObjectsAsClass(
            		this.getAllFixtures().jsonPath().prettify(), 
            		Fixture.class).size()) {
            	
                //you're doing the operation again so this is quite costly really - how to enhance or minify your impact to API performance??
                fixturesReceivedFromDatabase = MapResponseToClass.getJSONObjectsAsClass(
                				this.getAllFixtures().jsonPath().prettify(), 
                				fixtureListType);
                
                break;
            } else {
                System.out.println("Fixture list not updated due to latency/delay in the system. Retrying to gather fixtures again pal...");
            }

            try{
                Thread.sleep(500);//slight sleep wait in order to not absolutely hammer the API with requests within the loop
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return fixturesReceivedFromDatabase;
    }


    /**
     * Get a fixture by {CRITERIA HERE} when system makes it available.
     *
     * <p>This method is useful when immediately trying to retrieve a fixture that has just been created within the database.
     * A built-in system delay of random value (imitation of latency) prevents you from immediately gathering a newly created fixture.
     * This method gives 3 minutes ({@link #latencyDelayWaitDuration} is where this is set) as a maximum wait duration to allow the system to
     * give access to the newly created fixture. If a fixture is not available beyond that point then you may be experiencing system
     * faults of a different calibre.
     *
     * <h3>To Note:</h3> It is recommended to pick something other than ID to filter out the newly created fixture due to needing further http requests
     * to interrogate a list of fixtures via ID value.</p>
     *
     * @param fixtureCriteria {@link String} criteria to be used to gather a specific fixture
     * @return {@link Fixture} object retrieved from database
     */
    @Step("Gather a singular, newly created fixture by id which handles built-in system latency/delay")
    public Fixture getNewlyCreatedFixtureWhenAvailable(String fixtureId) {
        Fixture fixtureReceivedFromDatabase = new Fixture();
        Long currentTimeOutsideOfLoop = System.currentTimeMillis();

        while(true) {
            Long currentTimeDuringLoop = System.currentTimeMillis();
            if(currentTimeDuringLoop - currentTimeOutsideOfLoop >= this.latencyDelayWaitDuration) {
                break;
            } else if (this.getFixtureById(fixtureId).body().asString().length() >= 0) {
            	
                //you're doing the operation again so this is quite costly really - how to enhance or minify your impact to API performance??
                fixtureReceivedFromDatabase = MapResponseToClass.getJSONObjectAsClass(
                		this.getFixtureById(fixtureId).jsonPath().prettify(), 
                		Fixture.class);
                
                break;
            } else {
                System.out.println("Fixture not yet retrieved due to latency/delay in the system. Retrying to gather fixture again pal...");
            }

            try{
                Thread.sleep(500);//slight sleep wait in order to not absolutely hammer the API with requests within the loop
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return fixtureReceivedFromDatabase;
    }
}

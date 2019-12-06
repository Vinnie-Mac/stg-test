package com.stgtest.delete;

import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.models.FixtureStatus;
import com.stgtest.framework.models.footballfullstate.FootballFullState;
import com.stgtest.framework.steps.AssertionSteps;
import com.stgtest.framework.steps.DeleteSteps;
import com.stgtest.framework.steps.GetSteps;
import com.stgtest.framework.steps.PostSteps;
import com.stgtest.framework.utils.MapResponseToClass;
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

import java.util.List;

/**
 * <h2>Tests to adhere to the following criteria</h2>
 * <h3>4. Create and delete a new fixture.</h3
 * <i>i. Assert that the fixture no longer exists.</i>
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteFixtureTests {

    private Fixture fixtureToSendToDatabase;
    private Integer fixtureIdForFixtureToSendViaPostRequest = 333;
    private List<Fixture> listOfAllFixturesAfterCreatingNewFixture;
    private List<Fixture> listOfAllFixturesBeforeCreatingNewFixture;

    @Shared
    GetSteps getSteps;

    @Shared
    PostSteps postSteps;

    @Shared
    DeleteSteps deleteSteps;


    @Shared
    AssertionSteps assertionSteps;

    @Before
    public void Setup() {
    	this.fixtureToSendToDatabase = new Fixture.FixtureBuilder(this.fixtureIdForFixtureToSendViaPostRequest)
    			.withFixtureStatus(new FixtureStatus(true))
    			.withFootballFullStateStatus(new FootballFullState())
    			.build();
    	
    	
        this.listOfAllFixturesBeforeCreatingNewFixture = MapResponseToClass.getJSONObjectsAsClass(
        		this.getSteps.getAllFixtures().jsonPath().prettify(), 
        		Fixture.class);

        this.postSteps.createNewFixture(this.fixtureToSendToDatabase);

        this.listOfAllFixturesAfterCreatingNewFixture = this.getSteps.getUpdatedListOfAllFixturesWhenAvailable(this.listOfAllFixturesBeforeCreatingNewFixture);
    }


    @Test
    @WithTags({
            @WithTag("Fixtures"),
            @WithTag("Delete"),
    })
    @Title("Create fixture, delete it then assert it no longer appears within the database")
    public void createFixtureThenDeleteThenAssertNoLongerExistsTest()
    {
        this.deleteSteps.deleteFixtureById(this.fixtureIdForFixtureToSendViaPostRequest);

        List<Fixture> listOfAllFixturesAfterDeletion = MapResponseToClass.getJSONObjectsAsClass(
        		this.getSteps.getAllFixtures().jsonPath().prettify(), 
        		Fixture.class);

        for(int i = 0; i < listOfAllFixturesAfterDeletion.size(); i++) {
            assertionSteps.assertEqual(
                    listOfAllFixturesAfterDeletion.get(i).getFixtureId().toString(),
                    this.listOfAllFixturesBeforeCreatingNewFixture.get(i).getFixtureId().toString()
            );
        }
    }
}

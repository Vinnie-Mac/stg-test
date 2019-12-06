package com.stgtest.get;

import com.google.gson.reflect.TypeToken;
import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.steps.AssertionSteps;
import com.stgtest.framework.steps.GetSteps;
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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Tests to adhere to the following criteria</h2>
 * <h3>1. Retrieve all fixtures</h3
 * <i>i. Assert that there are 3 fixtures within the returned object.</i>
 * <br><i>ii. Assert that each of the 3 fixtures has a fixtureId value.</i>
 * 
 * @author Vinnie-Mac
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetFixtureTests {

    @Shared
    GetSteps getSteps;

    @Shared
    AssertionSteps assertionSteps;
    
    private List<Fixture> listOfAllFixtures;
    
    //Type token needed at fixture response beginning due to root element of JSON being '[{...}]' and not the usual '{...}'
	Type fixtureListType = new TypeToken<ArrayList<Fixture>>() {}.getType();

    @Before
    public void Setup() {
        this.listOfAllFixtures = 
        		MapResponseToClass.getJSONObjectsAsClass(
        				this.getSteps.getAllFixtures().jsonPath().prettify(), 
        				this.fixtureListType);

    }


    @Test
    @WithTags({
            @WithTag("Fixtures"),
            @WithTag("Get"),
            @WithTag("list")
    })
    @Title("Get all fixtures that currently live within the database and assert that the list size is equal to 3")
    public void assertAllFixturesListSizeEqualToThreeTest()
    {
    	Integer expected = 3;
    	Integer actual = this.listOfAllFixtures.size();
    	
        assertionSteps.assertEqual(expected, actual);
    }


    @Test
    @WithTags({
            @WithTag("Fixtures"),
            @WithTag("Get"),
            @WithTag("id")
    })
    @Title("Use the total list of fixtures gathered from the database and assert they each have a fixtureid value")
    public void assertAllFixturesContainIdValueTest()
    {
        for (int i = 0; i < this.listOfAllFixtures.size(); i++)
        {	
			String expected = String.valueOf(i+1);
        	String actual =  this.listOfAllFixtures.get(i).getFixtureId().toString();
        	
            assertionSteps.assertEqual(expected, actual);
        }
    }
}

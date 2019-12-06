package com.stgtest.framework.steps;

import com.stgtest.framework.base.TestBase;
import com.stgtest.framework.components.StatusCode;
import com.stgtest.framework.components.UriPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;

/**
 * {@link DeleteSteps} Steps class to use the DELETE HTTP method exclusively in test operations
 * 
 * @author Vinnie-Mac
 */
public class DeleteSteps {

	@Shared
	AssertionSteps assertionSteps;
	
	
    /**
     * Delete a fixture using the fixture id that is currently stored within the database
     *
     * @return {@link Response}
     */
    @Step("Delete fixture by Id value of '{0}'")
    public Response deleteFixtureById(Integer fixtureId)
    {
        Response response =  SerenityRest.given()
                .baseUri(TestBase.getBaseUri())
                .when()
                .delete(UriPath.FIXTURE_ID.getFormattedUriPath(fixtureId.toString()));
        
        assertionSteps.assertEqual(response.getStatusCode(), StatusCode.OK.getValue());
        
        return response;
    }
}

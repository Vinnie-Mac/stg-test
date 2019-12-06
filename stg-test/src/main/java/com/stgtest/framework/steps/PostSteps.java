package com.stgtest.framework.steps;

import com.stgtest.framework.base.TestBase;
import com.stgtest.framework.components.StatusCode;
import com.stgtest.framework.components.UriPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;

/**
 * {@link PostSteps} Steps class to use the POST HTTP method exclusively in test operations
 * 
 * @author Vinnie-Mac
 */
public class PostSteps {

	@Shared
	AssertionSteps assertionSteps;

    /**
     * Create new fixture on the database by supplying the information needed to submit to the API (use of the Fixture 
     * Builder object is needed here)
     *
     * @param body {@link Object} contents of object to send to API
     * @return {@link Response} object returned after successful request
     */
    @Step("Send a request to the database that will create a new fixture")
    public Response createNewFixture(Object body)
    {
        Response response = SerenityRest.given()
                .baseUri(TestBase.getBaseUri())
                .when()
                .body(body)
                .post((UriPath.FIXTURE.getUriPathString()));
        
        assertionSteps.assertEqual(response.getStatusCode(), StatusCode.OK.getValue());
        
        return response;
    }
}

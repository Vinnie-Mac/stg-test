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
 */
public class PostSteps {

	@Shared
	AssertionSteps assertionSteps;

    /**
     * Create new fixture on the database
     *
     * @param body {@link Object}
     * @return {@link Response}
     */
	/**
	 * 
	 * @param body
	 * @return
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

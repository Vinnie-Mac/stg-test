package com.stgtest.framework.steps;

import com.stgtest.framework.base.TestBase;
import com.stgtest.framework.components.UriPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * {@link PostSteps} Steps class to use the POST http method exclusively in test operations
 */
public class PostSteps {


    /**
     * Create new fixture on the database
     *
     * @return {@link Response}
     */
    @Step("Send a request to the database that will create a new fixture")
    public Response createNewFixture(Object body)
    {
        return  SerenityRest.given()
                .baseUri(TestBase.getBaseUri())
                .when()
                .body(body)
                .post((UriPath.FIXTURE.getUriPathString()));
    }
}

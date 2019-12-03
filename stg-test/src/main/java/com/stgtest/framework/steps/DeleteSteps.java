package com.stgtest.framework.steps;

import com.stgtest.framework.base.TestBase;
import com.stgtest.framework.components.UriPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * {@link DeleteSteps} Steps class to use the DELETE http method exclusively in test operations
 */
public class DeleteSteps {

    /**
     * Delete a fixture using the fixture id that is currently stored within the database
     *
     * @return {@link Response}
     */
    @Step("Delete fixture by Id value of '{0}'")
    public Response deleteFixtureById(String fixtureId)
    {
        return  SerenityRest.given()
                .baseUri(TestBase.getBaseUri())
                .when()
                .delete(UriPath.FIXTURE_ID.getFormattedUriPath(fixtureId));
    }
}
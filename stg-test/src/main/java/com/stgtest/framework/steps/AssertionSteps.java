package com.stgtest.framework.steps;

import org.junit.Assert;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

/**
 * {@link AssertionSteps} Steps class to use assertions throughout testing operations
 */
public class AssertionSteps {

    /**
     * Equals assertion on two string values
     *
     * @param actual {@link String} actual string value of object
     * @param expected {@link String} expected integer value to be compared against
     */
	@Step("Assert that the actual String value of {0} is equal to the expected String value of {1}")
    public void assertEqual(String actual, String expected)
    {
        Assert.assertEquals(actual, expected);
    }


    /**
     * Equals assertion on two integer values
     *
     * @param actual {@link Integer} actual integer value of object
     * @param expected {@link Integer} expected integer value to be compared against
     */
	@Step("Assert that the actual value Integer of {0} is equal to the expected Integer value of {1}")
    public void assertEqual(Integer actual, Integer expected)
    {
        Assert.assertEquals(actual, expected);
    }
	
    
    /**
     * Assertions on whether or not the body of a HTTP response via REST Assured contains values and is not
     * empty
     * 
     * @param {@link Response} rest assured response object
     */
	@Step("Assert that the response body contains body values and is not coming back as empty")
	public void assertThatBodyIsnotEmpty(Response response) {
		Assert.assertNotEquals(response.getBody().asString().length(), 0);
	}
}

package com.stgtest.framework.steps;

import org.junit.Assert;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

/**
 * {@link AssertionSteps} Steps class to use assertions throughout testing operations
 * 
 * @author Vinnie-Mac
 */
public class AssertionSteps {

    /**
     * Equals assertion on two string values
     *
     * @param actual {@link String} actual string value of object
     * @param expected {@link String} expected integer value to be compared against
     */
	@Step("Assert that the expected String value of {0} is equal to the actual String value of {1}")
    public void assertEqual(String expected, String actual)
    {
        Assert.assertEquals(expected, actual);
    }


    /**
     * Equals assertion on two integer values
     *
     * @param actual {@link Integer} actual integer value of object
     * @param expected {@link Integer} expected integer value to be compared against
     */
	@Step("Assert that the expected value Integer of {0} is equal to the actual Integer value of {1}")
    public void assertEqual(Integer expected, Integer actual)
    {
        Assert.assertEquals(expected, actual);
    }
	
	
	 /**
     * Not-Equals assertion on two integer values
     *
     * @param actual {@link Integer} actual integer value of object
     * @param expected {@link Integer} expected integer value to be compared against
     */
	@Step("Assert that the expected value Integer of {0} is not-equal to the actual Integer value of {1}")
    public void assertNotEqual(Integer expected, Integer actual)
    {
        Assert.assertNotEquals(expected, actual);
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

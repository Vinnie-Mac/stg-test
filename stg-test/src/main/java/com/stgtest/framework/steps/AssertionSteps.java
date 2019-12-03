package com.stgtest.framework.steps;

import org.junit.Assert;

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
    public void assertEqual (String actual, String expected)
    {
        Assert.assertEquals(actual, expected);
    }


    /**
     * Equals assertion on two integer values
     *
     * @param actual {@link Integer} actual integer value of object
     * @param expected {@link Integer} expected integer value to be compared against
     */
    public void assertEqual (Integer actual, Integer expected)
    {
        Assert.assertEquals(actual, expected);
    }
}

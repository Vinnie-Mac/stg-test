package com.stgtest.framework.components;

/**
 * {@link UriPath} Enum class containing all variations of Uri Path needed to exact various HTTP requests
 * 
 * @author Vinnie-Mac
 */
public enum UriPath {
    ALL_FIXTURES("/fixtures"),

    FIXTURE("/fixture"),

    FIXTURE_ID("/fixture/%s"),

    CREATE_NEW_FIXTURE("UPDATE THIS VALUE ASAP");

    private final String path;

    UriPath (String path) {
        this.path = path;
    }

    /**
     * Get the uri path as a string value
     *
     * @return {@link String}
     */
    public String getUriPathString()
    {
        return this.path;
    }


    /**
     * Get the uri path string which has been formatted based upon a given value
     * (hence why '%s' exists in uri paths that will need unique values for given http operations)
     *
     * @param value {@link String} value of the string to use for the formatting
     * @return {@link String} newly formatted uri path with 'value' string bing applied
     */
    public String getFormattedUriPath (String value)
    {
        return String.format(this.path, value);
    }


    /**
     * Get the uri path string which has been formatted based upon a given value
     * (hence why '%s' exists in uri paths that will need unique values for given http operations)
     *
     * <h3>To be noted: This is for extension for any uri paths that might need a second value being added - currently not in use but a nice to have</h3>
     *
     * @param value {@link String} value of the string to use for the formatting
     * @param additionalValue {@link String} additional value to be formatted into the uri path string
     * @return {@link String} newly formatted uri path with 'value' string bing applied
     */
    public String getFormattedUri (String value, String additionalValue)
    {
        return String.format(this.path, value, additionalValue);
    }
}

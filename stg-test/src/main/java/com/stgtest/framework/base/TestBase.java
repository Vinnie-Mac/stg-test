package com.stgtest.framework.base;

import com.stgtest.framework.utils.PropertiesLoader;

import java.nio.file.Paths;

/**
 * {@link TestBase} class responsible for holding base level information in order to allow the framework to execute tests
 */
public class TestBase {

    private static final String BASE_URI_PROPERTY_KEY = "base.uri";
    private static final String PROPERTIES = "src/main/resources/properties";
    private static final String API_PROPERTIES_FILE = "api.properties";


    /**
     * Return the base uri as string format in order to be used throughout SerenityRest calls within each of the steps
     * classes
     *
     * @return {@link String} base uri value as string
     */
    public static String getBaseUri()
    {
        return PropertiesLoader
                .loadProperties(Paths.get(PROPERTIES, API_PROPERTIES_FILE).toString())
                .getProperty(BASE_URI_PROPERTY_KEY);
    }
}

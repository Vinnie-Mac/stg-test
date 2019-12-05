package com.stgtest.framework.utils;

import io.restassured.response.ResponseBody;
import net.thucydides.core.annotations.Step;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stgtest.framework.models.Fixture;

/**
 * {@link MapResponseToClass} class responsible for mapping JSON values to their corresponding Java class (POJO)
 */
public class MapResponseToClass {
	static Gson gson = new Gson();
	
	
    /**
     * <h3>This function will take a singular value from the response body and map it to a given class object.</h3>
     *
     * <p>The 'T' value represents any given class in which you may enter so that it may have corresponding JSON values mapped accordingly
     * (the fields of the given class need tobe an exact match to those being returned in the JSON)</p>
     *
     * @param responseBody {@link ResponseBody} rest assured response object contained the necessary JSON information within the response body
     * @param clazz {@link Class} any given java class object to map values to
     * @return {@link Class} this will return the class object along with values assigned to the internal fields based upon what was in the JSON
     */
    @Step("Map JSON body value/field to a given {1} java class")
    public static <T> T getJSONObjectAsClass(String jsonValues, Class<T> clazz) {
        return gson.fromJson(jsonValues, clazz);
    }


    /**
     * <h3>This function will take multiple values from the response body and map it to a list containing the given class object.</h3>
     *
     * <p>The 'T' value represents any given class in which you may enter so that it may have corresponding JSON values mapped accordingly
     * (the fields of the given class need tobe an exact match to those being returned in the JSON)</p>
     *
     * @param responseBody {@link ResponseBody} rest assured response object contained the necessary JSON information within the response body
     * @param clazz {@link Class} any given java class object to map values to
     * @return {@link List<T>} this will return the class object list - each class instance having the internal field values mapped according to the instances within response body JSON fields
     */
    @Step("Map JSON body values/fields to a given java class - multiple instances of {1} class as there are multiple results being retrieved")
    public static <T> List<T> getJSONObjectsAsClass(String jsonValues, Class<T> clazz) {
    	return Arrays.asList(gson.fromJson(jsonValues, clazz));
    }
    
    
    public static void dealWithJsonArrays()
    {
    	
    }
}

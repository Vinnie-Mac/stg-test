package com.stgtest.framework.utils;

import java.io.*;
import java.util.Properties;

/**
 * {@link PropertiesLoader} class responsible for housing the properties file loading operation
 * 
 * @author Vinnie-Mac
 */
public class PropertiesLoader {


    /**
     * Load a properties file using the specific path to said file - The object returned allows you to gather all property keys from
     * the file that has been loaded due to the operation within.
     *
     * <p>There's always debate when returning a whole properties object containing a full list of key when a given method might only need one of them, but
     * due to the size of this framework and what is needed it was just a showcase of ability and to display how a use of properties files is done vs a java class
     * that may contain constants such as the baseUri for example.</p>
     *
     * @param pathToPropertiesFile {@link String} path to properties file
     * @return {@link Properties} object to gather property keys from
     */
    public static Properties loadProperties(String pathToPropertiesFile)
    {
        Properties prop = new Properties();
        try(InputStream input = new FileInputStream(new File(pathToPropertiesFile))) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

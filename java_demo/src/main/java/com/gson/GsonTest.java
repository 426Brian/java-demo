package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 17:05 2018/4/30
 */
public class GsonTest {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(GsonTest.class);

    public static void main(String[] args) {
        String jsonString="{\"name\": \"Maxsu\", \"age\": \"24\"}";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Student student = gson.fromJson(jsonString, Student.class);


    }
}

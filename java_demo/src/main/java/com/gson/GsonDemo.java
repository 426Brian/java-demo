package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 14:02 2018/4/30
 */
public class GsonDemo {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(GsonDemo.class);

    public static void main(String[] args) {
        String jsonString="{\"name\": \"Maxsu\", \"age\": \"24\"}";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Student student = gson.fromJson(jsonString, Student.class);
        log.info(student);

        jsonString = gson.toJson(student);
        log.info(jsonString);
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.gson;

import com.google.gson.*;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.*;

/**
 * Created by Brian in 17:10 2018/4/30
 */
public class GsonTester {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(GsonTester.class);

    private String jsonPath;

    public static void main(String[] args) {

        GsonTester tester = new GsonTester();
        String claspath = tester.getClass().getResource("/").getPath();
        String jsonPath = claspath+ "//json";
        if(!new File(jsonPath).exists()){
            new File(jsonPath).mkdirs();
        }
        tester.jsonPath = jsonPath;

        Student student = new Student();
        student.setAge(10);
        student.setName("Mahesh");

        try {
            tester.writeJson(student);
            Student student_r = tester.readJson();
            log.info(student_r.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jsonString = "{\"name\":\"Brian\", \"age\":\"24\", \"marks\":[10, 25, 3]}";
        tester.jsonParse(jsonString);
    }

    private void writeJson(Student student) throws Exception {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        FileWriter writer = new FileWriter(jsonPath+"/student.json");

        writer.write(gson.toJson(student));
        writer.close();
    }

    public void mkdir_f (File file){
        if(!file.exists()){
            mkdir_f(file.getParentFile());
        }
    }
    private Student readJson() throws Exception {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonPath+"/student.json"));
        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }

    public void jsonParse(String jsonString){
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonString);

        if(jsonElement.isJsonObject()){
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonElement name = jsonObject.get("name");
            log.info("name "+name.getAsString());

            JsonElement age = jsonObject.get("age");
            log.info("age "+age.getAsInt());

            JsonElement marks = jsonObject.get("marks");
            JsonArray jsonArray = marks.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonPrimitive value = jsonArray.get(i).getAsJsonPrimitive();
                log.info(value.getAsInt());
            }
        }
    }
}

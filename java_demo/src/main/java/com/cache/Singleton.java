package com.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian in 13:44 2018/5/14
 */
public class Singleton {
    private final static String DEFAULT_KEY = "one";

    private static Map<String, Singleton> map = new HashMap<>();

    private Singleton(){

    }

    public static Singleton getInstance(){
        Singleton instance = map.get(DEFAULT_KEY);

        if(instance == null){
            instance = new Singleton();
            map.put(DEFAULT_KEY, instance);
        }

        return instance;
    }
}

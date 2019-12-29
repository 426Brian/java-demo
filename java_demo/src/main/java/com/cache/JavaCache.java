package com.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian in 13:41 2018/5/14
 */
public class JavaCache {
    private Map<String, Object> map = new HashMap<>();

    public Object getValue(String key){
        Object obj = map.get(key);

        if(obj == null){
            obj = key+", value";
            map.put(key, obj);
        }

        return obj;
    }

}

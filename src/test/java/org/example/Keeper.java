package org.example;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class Keeper {
    private static final Map<String, Object>storage = new HashMap<>();

    public static void put(String key, Object value){
        storage.put(key, value);
    }
    public static Object get(String key){
        return storage.get(key);
    }
}

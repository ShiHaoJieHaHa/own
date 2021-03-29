package com.ognl.test;

import java.util.HashMap;
import java.util.Map;

public class mapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("map1",1);
        map.put("map2",2);
        for ( Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}

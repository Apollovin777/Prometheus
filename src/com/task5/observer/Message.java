package com.task5.observer;

import java.util.HashMap;
import java.util.Map;

public class Message {
    Map<String,String> intelligenceData = new HashMap<>();
    boolean hasFullData = false;

    public boolean isHasFullData() {
        return hasFullData;
    }

    public void addData(String type, String data){
        intelligenceData.put(type,data);
        if(intelligenceData.size()==3)
            hasFullData = true;
    }

}

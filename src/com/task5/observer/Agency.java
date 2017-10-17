package com.task5.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agency {
    private List<Spy> list = new ArrayList<>();
    private Map<Spy,Message> intelligence = new HashMap<>();

    void addSpy(Spy s){
        this.list.add(s);

    }

    void getMessage(Spy spy,Message message){
        intelligence.put(spy,message);
    }


}

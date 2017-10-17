package com.task5.observer;

import java.util.ArrayList;
import java.util.List;

public class Congress implements Subject {
    List<Observer> list = new ArrayList<>();
    private String expansion;
    private String laundering;
    private String bribes;

    public void setExpansion(String expansion) {
        this.expansion = expansion;
        notifyObserver();
    }

    public void setLaundering(String laundering) {
        this.laundering = laundering;
        notifyObserver();
    }

    public void setBribes(String bribes) {
        this.bribes = bribes;
        notifyObserver();
    }

    public String getExpansion() {
        return expansion;
    }

    public String getLaundering() {
        return laundering;
    }

    public String getBribes() {
        return bribes;
    }

    @Override
    public void register(Observer o) {
        list.add(o);
    }

    @Override
    public void disclosure(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : list){
            o.update();
        }
    }
}

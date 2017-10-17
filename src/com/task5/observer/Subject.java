package com.task5.observer;

public interface Subject {
        void register(Observer o);
        void disclosure(Observer o);
        void notifyObserver();
}

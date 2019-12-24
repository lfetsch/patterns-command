package com.github.lfetsch.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String key, Object value) {
        observers.forEach(observer -> observer.update(this, key, value));
    }
}

package com.battle.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ListenerEntryToConsole implements Subject {
    private List<Observer> observers;
    private String text;

    public ListenerEntryToConsole() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(text);
        }
    }

    @Override
    public void setNewTextForConsole(String text) {
        this.text = text;
        notifyObserver();
    }
}

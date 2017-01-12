package com.battle.view;

public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();

    void setNewTextForConsole(String text);
}

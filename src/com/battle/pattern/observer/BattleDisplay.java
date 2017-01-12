package com.battle.pattern.observer;

import javax.swing.*;

public class BattleDisplay implements Observer, Display {
    private String textBattle;
    private Subject lisstenerDisplay;
    private JTextArea console;

    public BattleDisplay(Subject listenerDisplay, JTextArea console) {
        this.lisstenerDisplay = listenerDisplay;
        listenerDisplay.registerObserver(this);
        this.console = console;
        console.setText(null);
    }

    @Override
    public void display() {
        console.append(textBattle);
    }

    @Override
    public void update(String text) {
        this.textBattle = text;
        display();
    }
}

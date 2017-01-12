package com.battle.view;

import com.battle.controlers.UserInterfaceController;
import com.battle.utils.Battle;

public class ConsoleObserver implements Observer {
    private UserInterface userInterface;

    public ConsoleObserver(UserInterfaceController controller, Battle battle) {
        battle.registerObserver(this);
        userInterface = new UserInterface(controller);
    }

    @Override
    public void update(String text) {
        userInterface.consoleText.append(text);
    }}

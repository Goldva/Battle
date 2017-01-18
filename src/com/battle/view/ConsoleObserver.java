package com.battle.view;

import com.battle.controlers.UserInterfaceController;
import com.battle.Utils.Battle;

public class ConsoleObserver implements Observer {//не очень понятно, что это за наблюдатель, содержащий ui. скорее, ui является наблюдателем (и сам должен реализовывать Observer)
    private UserInterface userInterface;

    public ConsoleObserver(UserInterfaceController controller, Battle battle) {
        battle.registerObserver(this);
        userInterface = new UserInterface(controller);
    }

    @Override
    public void update(String text) {
        userInterface.consoleText.append(text);
    }}

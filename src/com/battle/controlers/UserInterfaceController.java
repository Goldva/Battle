package com.battle.controlers;

import com.battle.Utils.Battle;
import com.battle.view.UserInterface;
import com.battle.warriors.Character;
import com.battle.warriors.FactoryCharacters;

import javax.swing.*;

public class UserInterfaceController {

    private Battle battle;
    private UserInterface userInterface;

    public UserInterfaceController(Battle battle) {
        this.battle = battle;
        userInterface = new UserInterface(this, battle);
    }

    public String[] getAllCharactersName() {
        return FactoryCharacters.getAllCharactersName();
    }

    public void addCharacter(String nameSquad, JTextArea listSquad) {
        String character = userInterface.getCharacters().getSelectedItem().toString();
        String name = userInterface.getWarriorName().getText();
        listSquad.append(character + " - " + name + "\n");

        Character soldier = FactoryCharacters.createCharacter(character);
        assert soldier != null;
        soldier.setSquadName(nameSquad);
        soldier.setMyName(name);
        battle.addCharacter(soldier);
    }

    public void fight(String squadFirst, String squadSecond) {
        userInterface.getConsoleText().setText(null);
        battle.battleProgress(squadFirst, squadSecond);

    }

}

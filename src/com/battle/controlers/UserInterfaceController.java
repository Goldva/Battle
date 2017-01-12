package com.battle.controlers;

import com.battle.UserInterface;
import com.battle.data.InfoAboutPerson;
import com.battle.pattern.factory.FactoryCharacters;
import com.battle.pattern.observer.BattleDisplay;
import com.battle.pattern.observer.ListenerEntryToConsole;
import com.battle.utils.Battle;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceController {

    public String[] getAllCharactersName() {
        return FactoryCharacters.getAllCharactersName();
    }

    public void fight(UserInterface frame) {
        Battle battle = new Battle();
        ListenerEntryToConsole listener = new ListenerEntryToConsole();
        BattleDisplay battleDisplay = new BattleDisplay(listener, frame.getConsoleText());

        String nameSquad = frame.getNameSquadFirst().getText();
        String listSquad = frame.getListSquadFirst().getText();
        battle.newSquads(nameSquad, getListPerson(listSquad, nameSquad));

        nameSquad = frame.getNameSquadSecond().getText();
        listSquad = frame.getListSquadSecond().getText();
        battle.newSquads(nameSquad, getListPerson(listSquad, nameSquad));

        battle.battleProgress(listener);
    }

    private List<InfoAboutPerson> getListPerson(String personsText, String nameSquad) {
        List<InfoAboutPerson> listPersons = new ArrayList<>();
        String[] persons = personsText.split("\n");
        for (String person : persons) {
            InfoAboutPerson info = new InfoAboutPerson();
            info.setCharacterPerson(person.split(" - ")[0]);
            info.setNamePerson(person.split(" - ")[1]);
            info.setNameSquad(nameSquad);
            listPersons.add(info);
        }
        return listPersons;
    }

}

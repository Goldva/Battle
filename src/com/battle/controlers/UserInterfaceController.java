package com.battle.controlers;

import com.battle.Factory.FactoryCharacters;
import com.battle.UserInterface;
import com.battle.Utils.Battle;
import com.battle.data.InfoAboutPerson;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceController {

    public String[] getAllCharactersName() {
        return FactoryCharacters.getAllCharactersName();
    }

    public void fight(UserInterface frame) {
        Battle battle = new Battle();

        String nameSquad = frame.getNameSquadFirst().getText();
        String listSquad = frame.getListSquadFirst().getText();
        battle.newSquads(nameSquad, getListPerson(listSquad));

        nameSquad = frame.getNameSquadSecond().getText();
        listSquad = frame.getListSquadSecond().getText();
        battle.newSquads(nameSquad, getListPerson(listSquad));

        String beginBattle = "Начало поединка " + battle.getDateHelper().getFormattedStartDate() + "\n";
        frame.getConsoleText().setText(beginBattle);
        frame.getConsoleText().append(battle.battleProgress() + "\n");
        frame.getConsoleText().append(battle.getDateHelper().getFormattedDiff() + "\n");
    }

    private List<InfoAboutPerson> getListPerson(String personsText) {
        List<InfoAboutPerson> listPersons = new ArrayList<>();
        String[] persons = personsText.split("\n");
        for (String person : persons) {
            InfoAboutPerson info = new InfoAboutPerson();
            info.setCharacterPerson(person.split(" - ")[0]);
            info.setNamePerson(person.split(" - ")[1]);
            listPersons.add(info);
        }
        return listPersons;
    }

}

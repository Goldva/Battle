package com.battle.controlers;

import com.battle.view.UserInterface;
import com.battle.data.InfoAboutPerson;
import com.battle.warriors.FactoryCharacters;
import com.battle.view.ConsoleObserver;
import com.battle.Utils.Battle;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceController {

    private Battle battle;
    private ConsoleObserver userInterface;

    public UserInterfaceController(Battle battle) {
        this.battle = battle;
        userInterface = new ConsoleObserver(this, battle);
    }

    public String[] getAllCharactersName() {
        return FactoryCharacters.getAllCharactersName();
    }

    public void fight(UserInterface frame) { //из-за странной прослойки в виде ConsoleObserver контроллеру приходится передавать представление, хотя контроллер по-сути его и создал
        frame.getConsoleText().setText(null);
        String nameSquad = frame.getNameSquadFirst().getText();
        String listSquad = frame.getListSquadFirst().getText();
        battle.newSquads(nameSquad, getListPerson(listSquad, nameSquad));

        nameSquad = frame.getNameSquadSecond().getText(); //дублирование
        listSquad = frame.getListSquadSecond().getText();
        battle.newSquads(nameSquad, getListPerson(listSquad, nameSquad));

        battle.battleProgress();
    }

    private List<InfoAboutPerson> getListPerson(String personsText, String nameSquad) { //зачем парсить текстовый список, вместо того чтобы добавлять бойцов сразу по нажатию кнопки?
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

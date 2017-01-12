package com.battle.warriors;

import com.battle.data.InfoAboutPerson;
import com.battle.warriors.Archer;
import com.battle.warriors.Character;
import com.battle.warriors.Viking;
import com.battle.warriors.Warrior;

public class FactoryCharacters {
    public static Character createCharacter(InfoAboutPerson info) {
        if ("Archer".equals(info.getCharacterPerson())) {
            return new Archer(info.getNamePerson(), info.getNameSquad());
        } else if ("Viking".equals(info.getCharacterPerson())) {
            return new Viking(info.getNamePerson(), info.getNameSquad());
        } else if ("Warrior".equals(info.getCharacterPerson())) {
            return new Warrior(info.getNamePerson(), info.getNameSquad());
        }
        return null;
    }

    public static String[] getAllCharactersName() {
        return new String[]{"Archer", "Viking", "Warrior"};
    }
}

package Factory;

import data.InfoAboutPerson;
import interfaces.Character;
import warriors.Archer;
import warriors.Viking;
import warriors.Warrior;

public class FactoryCharacters {
    public static Character createCharacter(InfoAboutPerson info) {
        if ("Archer".equals(info.getCharacterPerson())) {
            return new Archer(info.getNamePerson());
        } else if ("Viking".equals(info.getCharacterPerson())) {
            return new Viking(info.getNamePerson());
        } else if ("Warrior".equals(info.getCharacterPerson())) {
            return new Warrior(info.getNamePerson());
        }
        return null;
    }
}

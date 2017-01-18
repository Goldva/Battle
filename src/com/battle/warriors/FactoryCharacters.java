package com.battle.warriors;

public class FactoryCharacters {
    public static Character createCharacter(String character) {
        if ("Archer".equals(character)) {
            return new Archer();
        } else if ("Viking".equals(character)) {
            return new Viking();
        } else if ("Warrior".equals(character)) {
            return new Warrior();
        }
        return null;
    }

    public static String[] getAllCharactersName() {
        return new String[]{"Archer", "Viking", "Warrior"};
    }
}

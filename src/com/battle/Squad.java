package com.battle;

import com.battle.warriors.Character;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Squad implements Cloneable {
    private String squadName;
    private List<Character> listSquads = new ArrayList<>();
    private Random random = new Random();

    public Squad(String squadName, List<Character> listSquads) {
        this.squadName = squadName;
        this.listSquads = listSquads;
    }

    public Squad(String squadName) {
        this.squadName = squadName;
    }

    public void addWarriors(Character warrior) {
//        warrior.setSquadName(this.squadName);
        this.listSquads.add(warrior);
    }

    public Character getRandomWarrior() {
        Character warrior;

        List<Character> warriorAlive = new LinkedList<>();
        for (Character nextWarrior : listSquads) {
            if (nextWarrior.isAlive())
                warriorAlive.add(nextWarrior);
        }

        int i = random.nextInt(warriorAlive.size());
        warrior = warriorAlive.get(i);
        return warrior;
    }

    public boolean hasAliveWarriors() {
        for (Character warrior : listSquads) {
            if (warrior.isAlive())
                return true;
        }
        return false;
    }


    public void newSquadList() {
        listSquads = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Отряд: " + squadName;
    }

    @Override
    public Squad clone() throws CloneNotSupportedException {
        Squad newSquad = (Squad) super.clone();

        newSquad.newSquadList();
        for (Character soldier : this.listSquads) {
            Character character = (Character) soldier.clone();
            character.setSquadName(newSquad.getSquadName());
            newSquad.addWarriors(character);
        }
        return newSquad;
    }

    public String getSquadName() {
        return squadName;
    }
}

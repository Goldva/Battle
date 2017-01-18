package com.battle.Utils;

import com.battle.Squad;
import com.battle.view.Observer;
import com.battle.view.Subject;
import com.battle.warriors.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Battle implements Subject{
    private List<Observer> observers;
    private String newText;
    private Map<String, Squad> squads;
    private DateHelper dateHelper;

    public Battle() {
        this.observers = new ArrayList<>();
        squads = new HashMap<>();
        dateHelper = new DateHelper();
    }

    private String battleSoldiers(Character soldierOne, Character soldierTwo) {
        int damage = soldierOne.attack();
        soldierTwo.takeDamage(damage);
        int health = soldierTwo.getMyHealth();
        String text = "%s из отряда %s нанес %d урона по %s из отряда %s, ";
        if (health >= 1)
            text += String.format("остаток %d жизней", soldierTwo.getMyHealth());
        else
            text += "боец мертв";

        return String.format(text, soldierOne.getMyName(), soldierOne.getSquadName(),
                damage, soldierTwo.getMyName(), soldierTwo.getSquadName());
    }

    public void battleProgress(String squadNameFirst, String squadNameSecond) {
        try {
            String statusBattle = "Начало поединка " + getDateHelper().getFormattedStartDate() + "\n";
            setNewTextForConsole(statusBattle);
            Squad squadFirst = squads.get(squadNameFirst).clone();
            Squad squadSecond = squads.get(squadNameSecond).clone();

            boolean queueAttack = true;
            while (squadFirst.hasAliveWarriors() && squadSecond.hasAliveWarriors()) {
                if (queueAttack) {
                    statusBattle = battleSoldiers(squadFirst.getRandomWarrior(), squadSecond.getRandomWarrior());
                    queueAttack = false;
                } else {
                    statusBattle = battleSoldiers(squadSecond.getRandomWarrior(), squadFirst.getRandomWarrior());
                    queueAttack = true;
                }
                setNewTextForConsole(statusBattle + "\n");
                dateHelper.skipTime();
            }

            if (squadFirst.hasAliveWarriors())
                statusBattle = "Победил " + squadFirst.toString();
            else
                statusBattle = "Победил " + squadSecond.toString();

            setNewTextForConsole(statusBattle + "\n");
            setNewTextForConsole(getDateHelper().getFormattedDiff() + "\n");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    public void addCharacter(Character character) {
        String squadName = character.getSquadName();
        if (!squads.containsKey(squadName))
            newSquads(squadName);
        squads.get(squadName).addWarriors(character);
    }

    public void newSquads(String nameSquad) {
        squads.put(nameSquad, new Squad(nameSquad));
    }

    public DateHelper getDateHelper() {
        return dateHelper;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(newText);
        }
    }

    @Override
    public void setNewTextForConsole(String text) {
        this.newText = text;
        notifyObserver();
    }
}

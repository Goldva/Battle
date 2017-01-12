package com.battle.Utils;

import com.battle.Squad;
import com.battle.data.InfoAboutPerson;
import com.battle.warriors.FactoryCharacters;
import com.battle.view.Observer;
import com.battle.view.Subject;
import com.battle.warriors.Character;

import java.util.ArrayList;
import java.util.List;

public class Battle implements Subject{
    private List<Observer> observers;
    private String newText;
    private List<Squad> squads;
    private DateHelper dateHelper;

    public Battle() {
        this.observers = new ArrayList<>();
        squads = new ArrayList<>();
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

    public void battleProgress() {
        String statusBattle = "Начало поединка " + getDateHelper().getFormattedStartDate() + "\n";
        setNewTextForConsole(statusBattle);

        boolean queueAttack = true;
        while (squads.get(0).hasAliveWarriors() && squads.get(1).hasAliveWarriors()) {
            if (queueAttack) {
                statusBattle = battleSoldiers(squads.get(0).getRandomWarrior(), squads.get(1).getRandomWarrior());
                queueAttack = false;
            } else {
                statusBattle = battleSoldiers(squads.get(1).getRandomWarrior(), squads.get(0).getRandomWarrior());
                queueAttack = true;
            }
            setNewTextForConsole(statusBattle + "\n");
            dateHelper.skipTime();
        }

        if (squads.get(0).hasAliveWarriors())
            statusBattle = "Победил " + squads.get(0).toString();
        else
            statusBattle = "Победил " + squads.get(1).toString();

        setNewTextForConsole(statusBattle + "\n");
        setNewTextForConsole(getDateHelper().getFormattedDiff() + "\n");
        squads.clear();
    }

    public void newSquads(String nameSquad,  List<InfoAboutPerson> warriors) {
        List<Character> squad = new ArrayList<>();
        for (InfoAboutPerson warrior : warriors) {
            squad.add(FactoryCharacters.createCharacter(warrior));
        }
        squads.add(new Squad(nameSquad, squad));
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

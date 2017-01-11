package com.battle.warriors;


import java.util.Random;

public abstract class AbstractCharacter implements Character {
    protected String squadName;
    protected String myName;
    protected int myDamage;
    protected int myHealth;

    protected Random random;

    @Override
    public abstract int attack();

    @Override
    public void takeDamage(int damage) {
        myHealth -= damage;
    }

    @Override
    public boolean isAlive() {
        return myHealth >= 1;
    }


    @Override
    public String toString() {
        return "Имя бойца: " + this.getMyName() +
                "Класс: " + this.getClass().getName() +
                "Отряд: " + this.getSquadName();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String getMyName() {
        return myName;
    }

    @Override
    public String getSquadName() {
        return squadName;
    }

    @Override
    public void setSquadName(String name) {
        squadName = name;
    }

}

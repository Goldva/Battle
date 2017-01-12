package com.battle.warriors;


import java.util.Random;

public abstract class Character implements Cloneable {
    protected String squadName;
    protected String myName;
    protected int myDamage;
    protected int myHealth;

    protected Random random;

    public abstract int attack();

    public void takeDamage(int damage) {
        myHealth -= damage;
    }

    public boolean isAlive() {
        return myHealth >= 1;
    }


    public String toString() {
        return "Имя бойца: " + this.getMyName() +
                "Класс: " + this.getClass().getName() +
                "Отряд: " + this.getSquadName();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getMyName() {
        return myName;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String name) {
        squadName = name;
    }

    public int getMyHealth() {
        return myHealth;
    }
}

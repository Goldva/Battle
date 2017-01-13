package com.battle.warriors;


import java.util.Random;

public class Warrior extends Character {
    public Warrior(String myName, String squadName) {
        this.myName = myName;
        this.myDamage = 50;
        this.myHealth = 160;
        this.random = new Random(this.myDamage - 10);
        this.squadName = squadName;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage + 29) + 40;
    }
}

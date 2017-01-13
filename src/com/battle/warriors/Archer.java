package com.battle.warriors;

import java.util.Random;

public class Archer extends Character {
    public Archer(String myName, String squadName) {
        this.myName = myName;
        this.myDamage = 80;
        this.myHealth = 100;
        this.random = new Random();
        this.squadName = squadName;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage - 59) + 70;
    }
}

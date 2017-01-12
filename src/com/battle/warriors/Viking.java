package com.battle.warriors;

import java.util.Random;

public class Viking extends Character {

    public Viking(String myName, String squadName) {
        this.myName = myName;
        this.myDamage = 120;
        this.myHealth = 100;
        this.random = new Random(this.myDamage - 20);
        this.squadName = squadName;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage + 21);
    }

}

package com.battle.warriors;

import java.util.Random;

public class Archer extends AbstractCharacter {
    public Archer(String myName) {
        this.myName = myName;
        this.random = new Random(this.myDamage - 10);
        this.myDamage = 80;
        this.myHealth = 100;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage + 11);
    }
}

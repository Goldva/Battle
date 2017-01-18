package com.battle.warriors;

import java.util.Random;

public class Viking extends Character {

    public Viking() {
        this.myDamage = 120;
        this.myHealth = 100;
        this.random = new Random();
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage - 79) + 100;
    }

}

package com.battle.warriors;

import java.util.Random;

public class Archer extends Character {
    public Archer() {
        this.myDamage = 80;
        this.myHealth = 100;
        this.random = new Random();
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage - 59) + 70;
    }
}

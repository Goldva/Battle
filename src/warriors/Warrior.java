package warriors;

import interfaces.WarriorClass;

import java.util.Random;

/**
 * Created by ermakov on 21.11.2016.
 */
public class Warrior implements WarriorClass {
    private String nameSquad;
    private int myDamage = 50;
    private int myHealth = 160;

    private Random random = new Random(40);
    @Override
    public int attack() {
        return random.nextInt(61);
    }

    @Override
    public void takeDamage(int damage) {
        myHealth -= damage;
    }

    @Override
    public boolean isAlive() {
        return myHealth >= 1;
    }

    @Override
    public void setSquadName(String name) {
        nameSquad = name;
    }

    @Override
    public String toString() {
        return "Имя бойца: " + this.getClass().getSimpleName() +
                "Класс: " + this.getClass().getName() +
                "Отряд: " + this.nameSquad;
    }

    @Override
    public Warrior clone() throws CloneNotSupportedException {
        return new Warrior();
    }

}
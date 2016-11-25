package warriors;

import interfaces.WarriorClass;

import java.util.Random;

public class Viking implements WarriorClass {
    private String nameSquad;
    private int myDamage = 120;
    private int myHealth = 100;

    private Random random = new Random(myDamage - 20);

    @Override
    public int attack() {
        return random.nextInt(myDamage + 21);
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
    public Viking clone() throws CloneNotSupportedException {
        return (Viking)super.clone();
    }

}

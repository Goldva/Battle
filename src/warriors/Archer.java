package warriors;

import interfaces.WarriorClass;

import java.util.Random;

public class Archer implements WarriorClass {
    private String nameSquad;
    private int myHealth = 100;

    private Random random = new Random(70);

    @Override
    public int attack() {
        return random.nextInt(91);
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
        return "Имя бойца: " + this.getClass().getSimpleName() + "\n" +
                "Класс: " + this.getClass().getName() + "\n" +
                "Отряд: " + this.nameSquad;
    }

    @Override
    public Archer clone() throws CloneNotSupportedException {
        return new Archer();
    }
}

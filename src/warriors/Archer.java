package warriors;

import interfaces.WarriorClass;

import java.util.Random;

public class Archer implements WarriorClass {
    private String squadName;
    private String myName;
    private int myDamage = 80;
    private int myHealth = 100;

    private Random random = new Random(myDamage - 10);

    public Archer(String myName) {
        this.myName = myName;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage + 11);
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
    public String toString() {
        return "Имя бойца: " + this.getMyName() + "\n" +
                "Класс: " + this.getClass().getName() + "\n" +
                "Отряд: " + this.getSquadName();
    }


    @Override
    public Archer clone() throws CloneNotSupportedException {
        return (Archer) super.clone();
    }

    public String getMyName() {
        return myName;
    }

    public String getSquadName() {
        return squadName;
    }

    @Override
    public void setSquadName(String name) {
        squadName = name;
    }
}

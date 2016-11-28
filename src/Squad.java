import interfaces.Character;
import warriors.Archer;
import warriors.Viking;
import warriors.Warrior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Squad implements Cloneable {
    private String squadName;
    private List<Character> listSquads = new ArrayList<>();
    private Random random = new Random();

    public Squad(String squadName) {
        this.squadName = squadName;
    }

    public Squad(String squadName, List<Character> listSquads) {
        this.squadName = squadName;
        this.listSquads = listSquads;
    }

    public void createDefaultSquads() {
        String[] names = {"Арагорн", "Рогнар", "Леголас", "Гарт", "Марис", "Робин", "Дореан", "Лис"};
        String name;
        for (int i = 0; i < 5; i++) {
            int numberWarrior = random.nextInt(3);
            switch (numberWarrior) {
                case 0:
                    name = names[random.nextInt(names.length)];
                    addWarriors(new Archer(name));
                    break;
                case 1:
                    name = names[random.nextInt(names.length)];
                    addWarriors(new Warrior(name));
                    break;
                case 2:
                    name = names[random.nextInt(names.length)];
                    addWarriors(new Viking(name));
                    break;
            }
        }
    }

    private void addWarriors(Character warrior) {
        warrior.setSquadName(this.squadName);
        this.listSquads.add(warrior);
    }

    public Character getRandomWarrior() {
        Character warrior;

        List<Character> warriorAlive = new LinkedList<>();
        for (Character nextWarrior : listSquads) {
            if (nextWarrior.isAlive())
                warriorAlive.add(nextWarrior);
        }

        int i = random.nextInt(warriorAlive.size());
        warrior = warriorAlive.get(i);
        return warrior;
    }

    public boolean hasAliveWarriors() {
        for (Character warrior : listSquads) {
            if (warrior.isAlive())
                return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Отряд: " + squadName;
    }

    @Override
    public Squad clone() throws CloneNotSupportedException {
        Squad newSquad = (Squad) super.clone();

        for (Character soldier : this.listSquads) {
            Character character =  (Character)soldier.clone();
            character.setSquadName(newSquad.getSquadName());
            newSquad.addWarriors(character);
        }
        return newSquad;
    }

    public String getSquadName() {
        return squadName;
    }
}

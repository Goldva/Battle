import interfaces.WarriorClass;
import warriors.Archer;
import warriors.Viking;
import warriors.Warrior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Squad implements Cloneable {
    private String squadName;
    private List<WarriorClass> listSquads = new ArrayList<>();
    private Random random = new Random();

    public Squad(String nameSquad) {
        this.squadName = nameSquad;
    }

    public Squad(String squadName, List<WarriorClass> listSquads) {
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

    private void addWarriors(WarriorClass warrior) {
        warrior.setSquadName(this.squadName);
        this.listSquads.add(warrior);
    }

    public WarriorClass getRandomWarrior() {
        WarriorClass warrior;

        List<WarriorClass> warriorAlive = new LinkedList<>();
        for (WarriorClass nextWarrior : listSquads) {
            if (nextWarrior.isAlive())
                warriorAlive.add(nextWarrior);
        }

        int i = random.nextInt(warriorAlive.size());
        warrior = warriorAlive.get(i);
        return warrior;
    }

    public boolean hasAliveWarriors() {
        for (WarriorClass warrior : listSquads) {
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

        for (WarriorClass soldier : this.listSquads) {
            if (soldier instanceof Archer) {
                Archer archer = ((Archer) soldier).clone();
                archer.setSquadName(newSquad.getSquadName());
                newSquad.addWarriors(archer);
            } else if (soldier instanceof Warrior) {
                Warrior warrior = ((Warrior) soldier).clone();
                warrior.setSquadName(newSquad.getSquadName());
                newSquad.addWarriors(warrior);
            } else if (soldier instanceof Viking) {
                Viking viking = ((Viking) soldier).clone();
                viking.setSquadName(newSquad.getSquadName());
                newSquad.addWarriors(viking);
            }
        }
        return newSquad;
    }

    public String getSquadName() {
        return squadName;
    }
}

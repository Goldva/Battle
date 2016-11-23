import interfaces.WarriorClass;
import warriors.Archer;
import warriors.Viking;
import warriors.Warrior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Squad implements Cloneable{
    private String nameSquad;
    private List<WarriorClass> listSquads = new ArrayList<>();
    private Random random = new Random();

    public Squad(String nameSquad) {
        this.nameSquad = nameSquad;
    }

    public void createDefaultSquads(){
        for (int i = 0; i < 5; i++) {
            int numberWarrior = random.nextInt(3);
            switch (numberWarrior){
                case 0:
                    addWarriors(new Archer());
                    break;
                case 1:
                    addWarriors(new Warrior());
                    break;
                case 2:
                    addWarriors(new Viking());
                    break;
            }
        }
    }

    public void addWarriors(WarriorClass warrior){
        warrior.setSquadName(this.nameSquad);
        this.listSquads.add(warrior);
    }

    public WarriorClass getRandomWarrior(){
        WarriorClass warrior = null;

        List<WarriorClass> warriorAlive = new LinkedList<>();
        for (WarriorClass nextWarrior : listSquads){
            if (nextWarrior.isAlive())
                warriorAlive.add(nextWarrior);
        }

        int i = random.nextInt(warriorAlive.size());
        warrior = warriorAlive.get(i);
        return warrior;
    }

    public boolean hasAliveWarriors(){
        for (WarriorClass warrior : listSquads){
            if(warrior.isAlive())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Отряд: " + nameSquad;
    }

    @Override
    protected Squad clone() throws CloneNotSupportedException {
        Squad newSquad = new Squad(this.nameSquad + "(копия)");

        for (WarriorClass warrior : this.listSquads) {
            if (warrior instanceof Archer) {
                newSquad.addWarriors(((Archer)warrior).clone());
            }else if (warrior instanceof Warrior) {
                newSquad.addWarriors(((Warrior)warrior).clone());
            }else if (warrior instanceof Viking) {
                newSquad.addWarriors(((Viking)warrior).clone());
            }
        }
        return newSquad;
    }
}

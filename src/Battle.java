import Utils.DateHelper;
import interfaces.Character;
import warriors.Archer;
import warriors.Viking;
import warriors.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private List<Squad> squads;
    private DateHelper dateHelper;

    public Battle() {
        squads = new ArrayList<>();
        dateHelper = new DateHelper();
    }

    private void battleSoldiers(Character soldierOne, Character soldierTwo) {
        soldierTwo.takeDamage(soldierOne.attack());
    }

    public String battleProgress() {
        boolean queueAttack = true;
        while (squads.get(0).hasAliveWarriors() && squads.get(1).hasAliveWarriors()) {
            if (queueAttack) {
                battleSoldiers(squads.get(0).getRandomWarrior(), squads.get(1).getRandomWarrior());
                queueAttack = false;
            } else {
                battleSoldiers(squads.get(1).getRandomWarrior(), squads.get(0).getRandomWarrior());
                queueAttack = true;
            }
            dateHelper.skipTime();
        }

        if (squads.get(0).hasAliveWarriors())
            return "Победил " + squads.get(0).toString();
        else
            return "Победил " + squads.get(1).toString();
    }

    public void newSquads(String nameSquad, String[] warriors) {
        List<Character> squad = new ArrayList<>();
        for (String warrior : warriors) {
            String character = warrior.split(" - ")[0];
            String nameWarrior = warrior.split(" - ")[1];
            switch (character) {
                case "Archer":
                    squad.add(new Archer(nameWarrior));
                    break;
                case "Warrior":
                    squad.add(new Warrior(nameWarrior));
                    break;
                case "Viking":
                    squad.add(new Viking(nameWarrior));
                    break;
            }
        }
        squads.add(new Squad(nameSquad, squad));
    }

    public DateHelper getDateHelper() {
        return dateHelper;
    }
}

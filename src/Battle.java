import Factory.FactoryCharacters;
import Utils.DateHelper;
import data.InfoAboutPerson;
import interfaces.Character;

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

    public void newSquads(String nameSquad, List<InfoAboutPerson> warriors) {
        List<Character> squad = new ArrayList<>();
        for (InfoAboutPerson warrior : warriors) {
            squad.add(FactoryCharacters.createCharacter(warrior));
        }
        squads.add(new Squad(nameSquad, squad));
    }

    public DateHelper getDateHelper() {
        return dateHelper;
    }
}

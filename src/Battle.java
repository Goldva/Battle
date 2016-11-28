import Utils.DateHelper;
import interfaces.Character;

public class Battle {
    private Squad squadOne;
    private Squad squadTwo;
    private DateHelper dateHelper;

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.dateHelper = new DateHelper();
        battle.squadOne = new Squad("Аргонавты");
        battle.squadTwo = new Squad("Сакура");
        battle.squadOne.createDefaultSquads();
        battle.squadTwo.createDefaultSquads();

        System.out.println(battle.battleProgress());

        System.out.println(battle.dateHelper.getFormattedDiff());
    }

    private void battleSoldiers(Character soldierOne, Character soldierTwo) {
        soldierTwo.takeDamage(soldierOne.attack());
    }

    private String battleProgress() {
        System.out.println("Начало поединка " + dateHelper.getFormattedStartDate());

        boolean queueAttack = true;
        while (squadOne.hasAliveWarriors() && squadTwo.hasAliveWarriors()) {
            if (queueAttack) {
                battleSoldiers(squadOne.getRandomWarrior(), squadTwo.getRandomWarrior());
                queueAttack = false;
            } else {
                battleSoldiers(squadTwo.getRandomWarrior(), squadOne.getRandomWarrior());
                queueAttack = true;
            }
            dateHelper.skipTime();
        }

        if (squadOne.hasAliveWarriors())
            return "Победил " + squadOne.toString();
        else
            return "Победил " + squadTwo.toString();
    }
}

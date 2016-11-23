import Utils.DateHelper;
import interfaces.WarriorClass;

public class Battle {
    public static void main(String[] args) {
        Squad squadOne = new Squad("Аргонавты");
        Squad squadTwo = new Squad("Сакура");
        squadOne.createDefaultSquads();
        squadTwo.createDefaultSquads();

        DateHelper dateHelper = new DateHelper();
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
            System.out.println("Победил " + squadOne.toString());
        else
            System.out.println("Победил " + squadTwo.toString());

        System.out.println(dateHelper.getFormattedDiff());
    }


    public static void battleSoldiers(WarriorClass soldierOne, WarriorClass soldierTwo) {
        soldierTwo.takeDamage(soldierOne.attack());
    }
}

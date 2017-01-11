package warriors;


import java.util.Random;

public class Warrior extends AbstractCharacter {
    public Warrior(String myName) {
        this.myName = myName;
        this.random = new Random(this.myDamage - 10);
        this.myDamage = 50;
        this.myHealth = 160;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage + 11);
    }
}

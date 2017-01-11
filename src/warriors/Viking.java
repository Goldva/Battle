package warriors;

import java.util.Random;

public class Viking extends AbstractCharacter {

    public Viking(String myName) {
        this.myName = myName;
        this.random = new Random(this.myDamage - 20);
        this.myDamage = 120;
        this.myHealth = 100;
    }

    @Override
    public int attack() {
        return random.nextInt(myDamage + 21);
    }

}

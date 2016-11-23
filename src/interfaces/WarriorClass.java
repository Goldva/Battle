package interfaces;

public interface WarriorClass extends Cloneable {
    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    void setSquadName(String name);

}

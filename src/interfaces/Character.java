package interfaces;

public interface Character extends Cloneable {
    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    void setSquadName(String name);

    Object clone() throws CloneNotSupportedException;

}

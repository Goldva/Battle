package interfaces;

import java.io.Closeable;

/**
 * Created by ermakov on 21.11.2016.
 */
public interface WarriorClass extends Cloneable {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);

}

package com.battle.warriors;

public interface Character extends Cloneable {
    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    Object clone() throws CloneNotSupportedException;

    String getMyName();

    String getSquadName();

    void setSquadName(String name);


}

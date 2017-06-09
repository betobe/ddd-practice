package com.schibsted.domain.player;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

public class Player {
    private final String name;
    private int hitPoints = 10;
    private int attackPoints = 2;
    private int defensePoints = 2;
    private int level = 1;
    private int experience = 0;
    private int gold = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        while (shouldLevelUp()){
            increaseLevel();
        }
    }

    private boolean shouldLevelUp(){
        return (this.experience >= abs((50/3) * (level^3 - 6*level^2 + 17*level - 12)));
    }

    private void increaseLevel(){
        this.level++;
        attackPoints = 2 + new Double(floor(level / 3)).intValue();
        defensePoints = 2 + new Double(floor(level / 2)).intValue();
        hitPoints = 10 + new Double((level - 1) * 2).intValue();
    }
}

package com.schibsted.domain.player;

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

    public void addExperience(int experience) { this.experience += experience; }
}

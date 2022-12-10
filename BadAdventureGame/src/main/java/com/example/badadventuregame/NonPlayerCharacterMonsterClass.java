package com.example.badadventuregame;

public class NonPlayerCharacterMonsterClass {
    private int monsterHp;
    private int strength;
    private int dexterity;
    private int intelligence;

    public NonPlayerCharacterMonsterClass(int monsterHp, int strength, int dexterity, int intelligence) {
        this.monsterHp = (int) (Math.random()* 6)+1;
        this.strength = monsterHp * 2;
        this.dexterity = monsterHp * 2;
        this.intelligence = monsterHp * 2;
    }

    public int getMonsterHp() {
        return monsterHp;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setMonsterHp(int monsterHp) {

        this.monsterHp = monsterHp;
    }
}

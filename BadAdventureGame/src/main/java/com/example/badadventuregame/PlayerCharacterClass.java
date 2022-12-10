package com.example.badadventuregame;

public class PlayerCharacterClass {

    private int hp;
    private int strength;
    private int dexterity;
    private int intelligence;

    private int totalGold;

    public PlayerCharacterClass(int hp, int strength, int dexterity, int intelligence, int totalGold) {
        this.hp = 20;
        this.strength = (int) ((Math.random() * 6) + 1)* 3;
        this.dexterity = (int) ((Math.random() * 6) + 1)* 3;
        this.intelligence = (int) ((Math.random() * 6) + 1)* 3;
        this.totalGold = 0;
    }

    public int getHp() {
        return hp;
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

    public int getTotalGold() {
        return totalGold;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }




}


/*
(int) (Math.random() * 18) + 3
*/

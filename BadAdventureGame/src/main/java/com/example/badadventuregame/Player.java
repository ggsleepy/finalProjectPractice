package com.example.badadventuregame;

public class Player extends Character {

    public static final int MAX_PLAYER_HP = 20;

    public static final int MIN_PLAYER_HP = 0;

    private int totalGold;

    private int xPosition;

    private int yPosition;

    //add previous position of the player class

    private PlayerState state;



    public Player() {
        Dice dice = new Dice(6);
        this.hp = 20;
        this.strength = dice.roll(3);
        this.dexterity = dice.roll(3);
        this.intelligence = dice.roll(3);
        this.totalGold = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "hp=" + hp +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", totalGold=" + totalGold +
                '}';
    }

    public int getTotalGold() {
        return totalGold;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    @Override
    public void setHp(int hp) {
        if (hp >= MAX_PLAYER_HP) {
            this.hp = MAX_PLAYER_HP;
        } else if (hp <= MIN_PLAYER_HP) {
            this.hp = MIN_PLAYER_HP;
        } else {
            this.hp = hp;
        }
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    public void collectGold(int gold) {
        this.totalGold = this.totalGold + gold;
    }
}

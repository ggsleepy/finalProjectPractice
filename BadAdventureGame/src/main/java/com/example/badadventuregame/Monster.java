package com.example.badadventuregame;

public class Monster extends Character {

    public static final int MAX_MONSTER_HP = 6;

    public static final int MIN_MONSTER_HP = 0;

    private MonsterState state;
    public Monster() {
        Dice  dice6 = new Dice(6);
        this.hp = dice6.roll(1);
        this.strength = dice6.roll(2);
        this.dexterity = dice6.roll(2);
        this.intelligence = dice6.roll(2);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "hp=" + hp +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                '}';
    }

    @Override
    public void setHp(int hp) {
        System.out.println("Trying to set MonsterHP: " + hp);
        if(hp >= MAX_MONSTER_HP){
            this.hp=MAX_MONSTER_HP;
        } else if (hp <= MIN_MONSTER_HP) {
            this.hp=MIN_MONSTER_HP;
        } else  {
            this.hp = hp;
        }
    }
}

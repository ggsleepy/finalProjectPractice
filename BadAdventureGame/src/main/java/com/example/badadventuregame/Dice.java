package com.example.badadventuregame;

public class Dice implements Rollable {

    int sides = 6;

    public Dice(int sides) {
        System.out.println(this.sides + " "+ sides);
        this.sides = sides;
    }

    public Dice() {

    }
    @Override
    public int roll(int times) {
        return (int) ((Math.random() * sides) + 1) * times;
    }
}

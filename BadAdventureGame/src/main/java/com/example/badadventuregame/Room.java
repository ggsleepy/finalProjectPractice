package com.example.badadventuregame;

import java.util.Random;

public class Room {
    private int gold;
    private boolean isRoomBlocked;

    private Monster monster;

    public Room(boolean isRoomBlocked) {
        this.isRoomBlocked = isRoomBlocked;
        if(!this.isRoomBlocked) {
            this.gold = (int) (Math.random() * 100) + 1;
        }
    }


    public int getGold() {
        return gold;
    }

    public boolean isBlocked() {
        return isRoomBlocked;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setBlocked(boolean blocked) {
        this.isRoomBlocked = blocked;
    }

    public boolean hasMonster() {
        return this.monster != null;
    }

    public int searchTheRoom (Player player){
        int diceRoll = (int)(Math.random()*20)+1;
        if (diceRoll < player.getIntelligence()){
            int goldFromSearch = this.gold;
            this.gold = 0;
            return goldFromSearch;
        }

        return 0;
        }




    public Monster enter(Player player){
        //add monster 1/2 chance if there is no npc you can search room for gold
        this.monster = null;
        if (Math.random() > 0.5){
            this.monster = new Monster();
            return this.monster;
        }
        return this.monster;
    }

    public Monster getMonster(){
        return monster;
    }


    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}

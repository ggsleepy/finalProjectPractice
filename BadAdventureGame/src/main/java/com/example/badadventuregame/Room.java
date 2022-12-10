package com.example.badadventuregame;

import java.util.Random;

public class Room {
    private int gold;
    private boolean isRoomBlocked;

    private boolean monsterInTheRoomClass;

    public Room() {
        this.gold =  (int) (Math.random()*100)+1;;
        this.isRoomBlocked = false;
        this.monsterInTheRoomClass = false;

        int blockedNumber;
        Random randomNumber = new Random();
         blockedNumber = randomNumber.nextInt(10)+1;
        if(blockedNumber < 4){
            isRoomBlocked = true;
            monsterInTheRoomClass = false;
            gold=0;
        }
        else{
            isRoomBlocked=false;
            blockedNumber=randomNumber.nextInt(2)+1;

            if(blockedNumber < 2){
                //based on the lecture I am not sure if I should get class for my monster or..
                //Make boolean attribute
                monster.getClass();
                monsterInTheRoomClass = true;
            }else {
                monsterInTheRoomClass = false;
            }

                blockedNumber = randomNumber.nextInt(10);
                gold=blockedNumber;

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

    //Do I need to make a new instance of my player class to reference INT attribute?


    NonPlayerCharacterMonsterClass monster = new NonPlayerCharacterMonsterClass((int) (Math.random()* 6)+1, (int) ((Math.random()* 6)+1)*2,
            (int) ((Math.random()* 6)+1)*2,(int) ((Math.random()* 6)+1)*3);

    public int searchTheRoom (PlayerCharacterClass player){
        int diceRoll = (int)(Math.random()*20)+1;
        if (diceRoll < player.getIntelligence()){
            int goldFromSearch = this.gold;
            this.gold = 0;
            return goldFromSearch;
        }

        return 0;
        }


    public int fight(PlayerCharacterClass player, NonPlayerCharacterMonsterClass monster){
        int diceRoll = (int)(Math.random()*20)+1;
        if (diceRoll >= monster.getDexterity()){
            
        }
        return 0;

    }


}

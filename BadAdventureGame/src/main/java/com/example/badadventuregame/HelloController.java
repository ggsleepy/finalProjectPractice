package com.example.badadventuregame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Random;

public class HelloController {

    private static final int ROOMSTOBLOCK = 3;

    Maze maze;
    Player player;


    @FXML
    public void initialize() {
        this.player = new Player();
        this.maze = new Maze();
        int x = new Dice(Maze.ROWS - 1).roll(1);
        int y = new Dice(Maze.COLUMNS - 1).roll(1);
        this.placePlayer(x,y);
        this.maze.blockRooms(ROOMSTOBLOCK, this.player);
    }

    private void placePlayer(int x , int y){
        if (y < 0) {
            textArea.appendText("Cannot move further up.\n");
            return;
        }
        if (x < 0) {
            textArea.appendText("Cannot move further right.\n");
            return;
        }
        if (y > Maze.COLUMNS - 1) {
           textArea.appendText("Cannot move further down.\n");
           return;
        }
        if (x > Maze.ROWS - 1) {
            textArea.appendText("Cannot move further left.\n");
            return;
        }
        if (this.maze.getRoom(x, y).isBlocked()) {
            textArea.appendText("Cannot enter room: " + x + "," + y + ". It is blocked.\n");
            return;
        }
            Room room = this.maze.getRoom(this.player.getxPosition(), this.player.getyPosition());
        this.player.setxPosition(x);
        this.player.setyPosition(y);
        Room newRoom = this.maze.getRoom(x, y);
        Monster monster = newRoom.enter(this.player);
        textArea.appendText("Player has entered room " + x + "," + y + "\n");
        if (monster == null) {
            this.player.setState(PlayerState.MOVING);
            textArea.appendText("Found an empty room\n");
        } else {
            this.player.setState(PlayerState.RUNNINGAWAY);
            textArea.appendText("Found monster!\n");
        }
    }

    @FXML
    private TextArea textArea;
    @FXML
    private Button upButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Button downButton;
    @FXML
    private Button searchForGoldButton;
    @FXML
    private Button fightButton;
    @FXML
    private Button runAwayButton;
    @FXML
    private Button sleepButton;



    @FXML
    public void upButtonClicked(ActionEvent actionEvent) {
            if(player.getHp() == player.MIN_PLAYER_HP){
                upButton.setDisable(true);
                textArea.appendText("You cant move your player is dead");
            }else {

                this.placePlayer(this.player.getxPosition(), this.player.getyPosition() - 1);
            }


    }

    @FXML
    public void leftButtonClicked(ActionEvent actionEvent) {
        if(player.getHp() == player.MIN_PLAYER_HP){
            upButton.setDisable(true);
            textArea.appendText("You cant move your player is dead");
        }else {

            this.placePlayer(this.player.getxPosition() + 1, this.player.getyPosition());
        }

    }

    @FXML
    public void rightButtonClicked(ActionEvent actionEvent) {

        if(player.getHp() == player.MIN_PLAYER_HP){
            upButton.setDisable(true);
            textArea.appendText("You cant move your player is dead");
        }else {

            this.placePlayer(this.player.getxPosition() - 1, this.player.getyPosition());
        }
    }

    @FXML
    public void downButtonClicked(ActionEvent actionEvent) {
        if(player.getHp() == player.MIN_PLAYER_HP){
            upButton.setDisable(true);
            textArea.appendText("You cant move your player is dead");
        }else {
            this.placePlayer(this.player.getxPosition(), this.player.getyPosition() + 1);
        }
    }

    @FXML
    public void searchForGoldButtonClicked(ActionEvent actionEvent) {
        Room room = this.maze.getRoom(this.player.getxPosition(), this.player.getyPosition());
        if (room.hasMonster()) {
            textArea.appendText("Cannot collect gold when monster exists in the room!\n");
            return;
        }
        if (room.getGold() > 0 && new Dice(20).roll(1) < this.player.getIntelligence()) {
            this.player.collectGold(room.getGold());
            textArea.appendText("Yay.. Found gold ("+ room.getGold() +")!\n");
            room.setGold(0);
        } else {
            textArea.appendText("No gold Found!\n");
        }
    }

    @FXML
    public void fightButtonClicked(ActionEvent actionEvent) {
        Room room = this.maze.getRoom(this.player.getxPosition(), this.player.getyPosition());
        Monster monster = room.getMonster();
        if (!room.hasMonster()) {
            textArea.appendText("Cannot fight! No monster to fight with!\n");
            return;
        }
        this.player.setState(PlayerState.ATTACKING);
        if (new Dice(20).roll(1) >= monster.getDexterity()){
            this.textArea.appendText("Monster Hp: " + monster.getHp() + "\n");
            System.out.println("Strike: " + (int) Math.ceil((double)this.player.getStrength() / 3));
            monster.setHp(monster.getHp() - (int) Math.ceil((double)this.player.getStrength() / 3));
            this.textArea.appendText("Monster Hp after attack: "+ monster.getHp() + "\n");
            if (monster.getHp() > 0){
                this.textArea.appendText("Player Hp: " + player.getHp() + "\n");
                this.player.setHp(player.getHp() - (int) Math.ceil((double)monster.getStrength() / 3));
                this.textArea.appendText("Player Hp after attack: " + player.getHp() + "\n");
            }else {
                room.setMonster(null);
                textArea.appendText("You killed the monster! \n");
            }
        } else {
            textArea.appendText("Attacked monster but missed! Try again!!!!\n");
        }
    }

    @FXML
    public void runAwayButtonClicked(ActionEvent actionEvent) {
        Room room = this.maze.getRoom(this.player.getxPosition(), this.player.getyPosition());
        Monster monster = room.getMonster();
        if (!room.hasMonster()){
            textArea.appendText("You can't run away there is no monster in here \n");
        }
        this.player.setState(PlayerState.RUNNINGAWAY);
        if(new Dice(20).roll(1) < room.getMonster().getIntelligence()) {
            this.player.setHp(player.getHp() - (int) Math.ceil((double)monster.getStrength() / 3));
            textArea.appendText("The monster saw you running away you your health is now " + player.getHp()+" hp\n");
        }else {
            textArea.appendText("You got away!");
        }
    }

    @FXML
    public void sleepButtonClicked(ActionEvent actionEvent) {
        Room room = this.maze.getRoom(this.player.getxPosition(), this.player.getyPosition());
        if (room.hasMonster()) {
            textArea.appendText("Cannot sleep if monster exists in the room!\n");
            return;
        }
        this.player.setState(PlayerState.SLEEPING);
        this.textArea.appendText("Player went to sleep!\n");
        if (new Dice(6).roll(1) == 1) {
            Monster monster = new Monster();
            room.setMonster(monster);
            this.player.setHp(player.getHp() - (int) Math.ceil((double)monster.getStrength() / 3));
            this.textArea.appendText("Oh no! A monster has appeared while you were sleeping! It just attacked you! \n");
            this.textArea.appendText("Player Hp after attack: " + player.getHp() + "\n");
            return;
        }
        player.setHp(Player.MAX_PLAYER_HP);
        this.textArea.appendText("Player health restored fully!\n");
    }
}
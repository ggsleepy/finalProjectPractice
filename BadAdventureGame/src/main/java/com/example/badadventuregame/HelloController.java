package com.example.badadventuregame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Random;

public class HelloController {
    int x=0;
    int y=0;

    Room[][] rooms = new Room[10][10];
    Random randomNumber = new Random();



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
    public void buttonClicked(ActionEvent actionEvent) {



        for (int row=0; row < 10; row++){
            for (int column=0; column < 10; column++){
                rooms[row][column] = new Room();
            }
        }
        if(actionEvent.getSource()==upButton){
            if (rooms[x][y].isBlocked()){
                textArea.appendText("Room is Blocked");

            }else{

            }
            textArea.appendText("Up button Clicked \n");
        } else if ( actionEvent.getSource() == rightButton){
            textArea.appendText("Right button Clicked \n");
        } else if (actionEvent.getSource() == downButton) {
            textArea.appendText("Down button Clicked \n");
        } else if (actionEvent.getSource() == leftButton ) {
            textArea.appendText("Left button Clicked");

        }

    }
}
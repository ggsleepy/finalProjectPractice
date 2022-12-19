package com.example.badadventuregame;

public class Maze {
    public static int ROWS = 10;
    public static int COLUMNS = 10;
    Room[][] rooms = new Room[ROWS][COLUMNS];

    Maze() {
        rooms = new Room[ROWS][COLUMNS];
        for (int i = 0; i < Maze.ROWS; i++) {
            for (int j = 0; j < Maze.COLUMNS; j++) {
                this.rooms[i][j] = new Room(false);
            }
        }
    }

    public Room getRoom(int x, int y) {
        return rooms[x][y];
    }

    private void blockRoom(int x, int y, Player player) {
        if (player.getxPosition() != x && player.getyPosition() != y) {
            rooms[x][y].setBlocked(true);
            System.out.println("Room: " + x + "," + y + "blocked");
        } else {
            System.out.println("Cannot block the room. Player exists in the room!");
        }
    }


    public void blockRooms(int numberOfRooms, Player player) {
        for (int i = 0; i < numberOfRooms; i++) {
            int x = new Dice(ROWS - 1).roll(1);
            int y = new Dice(COLUMNS - 1).roll(1);
            this.blockRoom(x, y, player);

        }
    }
}

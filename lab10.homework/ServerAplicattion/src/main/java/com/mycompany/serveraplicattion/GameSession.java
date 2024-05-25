package com.mycompany.serveraplicattion;

import java.util.Random;

public class GameSession {
    private final String[][][] boards = new String[2][10][10];
    private final boolean[] playersReady = new boolean[2];
    private int currentPlayer = 0;  
    private int playerCount = 0;

    public GameSession() {
        initializeBoards();
    }

    private void initializeBoards() {
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    boards[p][i][j] = "-";
                }
            }
        }
        placeAllShips();
    }

    public String[][] getBoard(int playerIndex) {
        return boards[playerIndex];
    }

    public String[][] getOpponentView(int playerIndex) {
        int opponentIndex = (playerIndex == 0) ? 1 : 0;
        String[][] opponentView = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (boards[opponentIndex][i][j].equals("#")) {
                    opponentView[i][j] = "-";
                } else {
                    opponentView[i][j] = boards[opponentIndex][i][j];
                }
            }
        }
        return opponentView;
    }

    public String[][] getPlayerView(int playerIndex) {
        return boards[playerIndex];
    }

    public void printBoard(int playerIndex) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print(boards[playerIndex][i][j] + " ");
            }
        }
    }

    public void checkPoint(int playerIndex, int x, int y) {
        if (boards[playerIndex][x][y].equals("#")) {
            boards[playerIndex][x][y] = "X"; // hit
        } else {
            boards[playerIndex][x][y] = "O"; // miss
        }
    }

    private void placeAllShips() {
        placeShip(0, 5, "Aircraft Carrier"); // 5 cells for player 0
        placeShip(0, 4, "Battleship");       // 4 cells for player 0
        placeShip(0, 3, "Submarine");        // 3 cells for player 0
        placeShip(0, 3, "Cruiser");          // 3 cells for player 0
        placeShip(0, 2, "Destroyer");        // 2 cells for player 0

        placeShip(1, 5, "Aircraft Carrier"); // 5 cells for player 1
        placeShip(1, 4, "Battleship");       // 4 cells for player 1
        placeShip(1, 3, "Submarine");        // 3 cells for player 1
        placeShip(1, 3, "Cruiser");          // 3 cells for player 1
        placeShip(1, 2, "Destroyer");        // 2 cells for player 1
    }

    private void placeShip(int playerIndex, int size, String name) {
        Random random = new Random();
        boolean placed = false;

        while (!placed) {
            boolean horizontal = random.nextBoolean();
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (canPlaceShip(playerIndex, x, y, size, horizontal)) {
                for (int i = 0; i < size; i++) {
                    if (horizontal) {
                        boards[playerIndex][x][y + i] = "#";
                    } else {
                        boards[playerIndex][x + i][y] = "#";
                    }
                }
                placed = true;
            }
        }
    }

    private boolean canPlaceShip(int playerIndex, int x, int y, int size, boolean horizontal) {
        if (horizontal) {
            if (y + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (!boards[playerIndex][x][y + i].equals("-")) {
                    return false;
                }
            }
        } else {
            if (x + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (!boards[playerIndex][x + i][y].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    public String processAttack(int playerIndex, int x, int y) {
        int opponentIndex = (playerIndex == 0) ? 1 : 0;
        if (boards[opponentIndex][x][y].equals("#")) {
            boards[opponentIndex][x][y] = "X"; // Hit
            return "Hit!";
        } else {
            boards[opponentIndex][x][y] = "O"; // Miss
            return "Miss!";
        }
    }

    public boolean isPlayerReady(int playerIndex) {
        return playersReady[playerIndex];
    }

    public void setPlayerReady(int playerIndex) {
        playersReady[playerIndex] = true;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 0) ? 1 : 0;
    }

    public boolean isGameOver() {
        for (int p = 0; p < 2; p++) {
            boolean allShipsSunk = true;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (boards[p][i][j].equals("#")) {
                        allShipsSunk = false;
                        break;
                    }
                }
                if (!allShipsSunk) break;
            }
            if (allShipsSunk) return true;
        }
        return false;
    }
}
package pl.hubson404.battleships.classicbattleships;

import pl.hubson404.battleships.Cell;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameboardClassic {

    public List<String> positions = new LinkedList<>();
    private Random random = new Random();
    private static int row = 0;
    private static int col = 0;

    private static int boardSize = 9;

    private Cell[][] board;


    public GameboardClassic() {
        generator(boardSize);
    }

    private void generator(int size) {
        board = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void randomShipSetter(){
        randomShip(5);
        randomShip(4);
        randomShip(3);
        randomShip(3);
        randomShip(2);
    }

    public void showBoard() {
        System.out.print("\n     ");
        for (int i = 1; i < (boardSize + 1); i++) {
            if (i < 10) {
                System.out.printf(" [ %d] ", i);
            } else {
                System.out.printf(" [%d] ", i);
            }
        }
        System.out.print("\n\n");

        for (int i = 0; i < boardSize; i++) {
            if (i < 9) {
                System.out.printf(" [ %d]  ", i + 1);
            } else {
                System.out.printf(" [%d]  ", i + 1);
            }
            for (int j = 0; j < boardSize; j++) {
                board[i][j].drawCell();
                System.out.print("   ");
            }
            System.out.println("\n");
        }
    }

    private void randomShip(int size) {

        int shipSize = size;

        int i = 0;

        while (i < shipSize) {

            i = 0;

            int direction = random.nextInt(4);

            switch (direction){
                case 0:
                    i = placeLeft(shipSize);
                    break;
                case 1:
                    i = placeRight(shipSize);
                    break;
                case 2:
                    i = placeUp(shipSize);
                    break;
                case 3:
                    i = placeDown(shipSize);
                    break;
            }
        }
    }

    private int placeLeft(int shipSize){
        int counter = 0;
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row - j, col);
                if (!positions.contains(placement) && (row - j) < boardSize && (row - j) >= 0) {
                    z++;
                }
            }
        }
        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row - j, col);
            positions.add(placement);
            board[row-j][col].placeShip();
            counter++;
        }
        return counter;
    }

    private int placeRight(int shipSize){
        int counter = 0;
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row + j, col);
                if (!positions.contains(placement) && (row + j) < boardSize && (row + j) >= 0) {
                    z++;
                }
            }
        }

        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row + j, col);
            positions.add(placement);
            board[row+j][col].placeShip();
            counter++;
        }
        return counter;
    }

    private int placeUp(int shipSize){
        int counter = 0;
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row, col +j);
                if (!positions.contains(placement) && (col + j) < boardSize && (col + j) >= 0) {
                    z++;
                }
            }
        }
        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row, col + j);
            positions.add(placement);
            board[row][col+j].placeShip();
            counter++;
        }
        return counter;
    }
    private int placeDown(int shipSize){
        int counter = 0;
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row, col -j);
                if (!positions.contains(placement) && (col - j) < boardSize && (col - j) >= 0) {
                    z++;
                }
            }
        }
        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row, col - j);
            positions.add(placement);
            board[row][col-j].placeShip();
            counter++;
        }
        return counter;
    }
    public Cell[][] getBoard() {
        return board;
    }
}
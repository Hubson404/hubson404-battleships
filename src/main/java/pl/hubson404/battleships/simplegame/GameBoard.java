package pl.hubson404.battleships.simplegame;

import pl.hubson404.battleships.Cell;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameBoard {

    private int boardSize;

    private Cell[][] board;

    public GameBoard(int boardSize){

        setBoardSize(boardSize);
        generator(boardSize);
    }

    private void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    private void generator(int size) {
        board = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
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

    public void randomShipSetter(int numberOfShips) {
        int i = 0;

        Random random = new Random();
        List<String> positions = new LinkedList<>();

        while (i < numberOfShips) {
            int rowPlacement = random.nextInt(boardSize);
            int colPlacement = random.nextInt(boardSize);

            String placement = String.format("%d-%d",rowPlacement,colPlacement);

            boolean listCheck = positions.contains(placement);

            if (listCheck == false) {
                board[rowPlacement][colPlacement].placeShip();
                positions.add(placement);
                i++;
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }
}
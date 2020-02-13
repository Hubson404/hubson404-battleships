package pl.hubson404.battleships;

import java.util.Random;

public class Game {

    public static void main(String[] args) {

        int size = 5;

        Cell[][] board = generator(size);

        showBoard(size, board);

        Random random = new Random();
        int vert = random.nextInt(size);
        int hori = random.nextInt(size);

        board[vert][hori].placeShip();


        System.out.println();

        System.out.println("Board after ship placement:");
        showBoard(size,board);

    }


    public static Cell[][] generator(int size) {

        Cell[][] board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }

    public static void showBoard(int size, Cell[][] board){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j].checkCell();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
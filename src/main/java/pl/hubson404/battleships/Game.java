package pl.hubson404.battleships;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        int boardSize;
        int shipsOnBoard;
        int hitCounter = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Game of Battleships!\n" +
                "Set the gameboard size:");
        boardSize = scanner.nextInt();

        Cell[][] secretBoard = generator(boardSize);
        Cell[][] gameBoard = generator(boardSize);

        System.out.printf("Gameboard size set to: %dx%d\n", boardSize, boardSize);
        showBoard(boardSize, gameBoard);

        System.out.printf("How many ships should be set on the gameboard? Max = %d.\n",
                boardSize * boardSize);
        shipsOnBoard = scanner.nextInt();

        while (shipsOnBoard > boardSize * boardSize || shipsOnBoard <= 0) {
            System.out.println("That many ships wont fit on board or you picked 0. Set new number of ships:");
            shipsOnBoard = scanner.nextInt();
        }

        randomShipSetter(shipsOnBoard, boardSize, secretBoard);


        System.out.printf("There are %d ships set on the gameboard!\n", shipsOnBoard);

        while (hitCounter < shipsOnBoard) {

            int row;
            int col;

            System.out.println("\nAim your shot!");
            System.out.println("Pick a row:");
            row = scanner.nextInt();
            System.out.println("Pick a column:");
            col = scanner.nextInt();

            if (row > boardSize || col > boardSize || row <= 0 || col <= 0) {

                System.out.println("You've missed the board. Aim again.\n");
                showBoard(boardSize, gameBoard);

            }else{

                System.out.printf("\nAiming at cell %d-%d\n", row, col);

                if (secretBoard[row-1][col-1].cellState() == 1) {
                    hitCounter++;
                }
                takeAShot(secretBoard, gameBoard, row-1, col-1);
                showBoard(boardSize, gameBoard);
                System.out.printf("Ships left on board: %d.\n", shipsOnBoard-hitCounter);

            }
        }

        System.out.println("\nYou've destroyed all of the enemy ships!\nYou've won!");

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
        System.out.print("\n     ");
        for (int i = 1 ; i < (size+1); i++){
            if (i<10){
                System.out.printf(" [ %d] ",i);
            }else {
                System.out.printf(" [%d] ",i);
            }
        }
        System.out.print("\n\n");

        for (int i = 0; i < size; i++) {
            if (i < 9){
                System.out.printf(" [ %d]  ", i+1);
            }else {
                System.out.printf(" [%d]  ", i+1);
            }

            for (int j = 0; j < size; j++) {
                board[i][j].drawCell();
                System.out.print("   ");
            }
            System.out.println("\n");
        }
    }

    public static void randomShipSetter(int numberOfShips, int size, Cell[][] board) {
        int i = 0;
        
        Random random = new Random();
        List<String> positions = new LinkedList<>();

        while (i < numberOfShips) {
            int rowPlacement = random.nextInt(size);
            int colPlacement = random.nextInt(size);

            String placement = String.format("%d%d",rowPlacement,colPlacement);

            boolean listCheck = positions.contains(placement);

            if (listCheck == false) {
                board[rowPlacement][colPlacement].placeShip();
                positions.add(placement);
                i++;
            }
        }
    }

    public static void takeAShot(Cell[][] board, Cell[][] playerBoard,int row, int col){

       int state = board[row][col].cellState();

       switch (state){
           case -1:
               System.out.println("Firing a shot,you've hit a shipwreck.");
               break;
           case 0:
               System.out.println("Firing a shot, you've missed.");
               playerBoard[row][col].markMiss();
               break;
           case 1:
               System.out.println("Firing a shot, you've hit the target.");
               board[row][col].wreckShip();
               playerBoard[row][col].wreckShip();
               break;
           case 2:
               System.out.println("You missed again.");
               break;
       }

    }

}
package pl.hubson404.battleships.classicbattleships;

import pl.hubson404.battleships.Cell;

import java.util.Scanner;

public class GameClassic {

    static int hitCounter = 0;
    static int actionCounter = 0;
    static int shipsOnBoard = 17;

    public static void main(String[] args) {

        System.out.println("Welcome to the Game of Battleships!");

        Scanner scanner = new Scanner(System.in);

        GameboardClassic hiddenBoard = new GameboardClassic();
        GameboardClassic gameBoard = new GameboardClassic();
        hiddenBoard.randomShipSetter();

        gameBoard.showBoard();

        while (hitCounter < shipsOnBoard) {

            int row;
            int col;

            System.out.println("\nAim your shot!");
            System.out.println("Pick a row:");
            row = scanner.nextInt();
            System.out.println("Pick a column:");
            col = scanner.nextInt();

            if (row > 10 || col > 10 || row <= 0 || col <= 0) {

                System.out.println("You've missed the board. Aim again.\n");
                gameBoard.showBoard();

            } else {

                System.out.printf("\nAiming at cell %d-%d\n", row, col);

                if (hiddenBoard.getBoard()[row - 1][col - 1].cellState() == 1) {
                    hitCounter++;
                }

                takeAShot(hiddenBoard.getBoard(), gameBoard.getBoard(), row - 1, col - 1);

                gameBoard.showBoard();

                System.out.printf("Targets left on board: %d.\n", shipsOnBoard - hitCounter);
            }
        }

        System.out.printf("\n\nAll of the enemy ships are destroyed!\nYou fired %d shots.\nYou've won!", actionCounter);
    }

    public static void takeAShot(Cell[][] hiddenBoard, Cell[][] gameBoard, int row, int col){

        int state = hiddenBoard[row][col].cellState();

        switch (state){
            case -1:
                System.out.println("Firing a shot.\nYou've hit a shipwreck.");
                actionCounter++;
                break;
            case 0:
                System.out.println("Firing a shot.\nYou've missed.");
                gameBoard[row][col].markMiss();
                actionCounter++;
                break;
            case 1:
                System.out.println("Firing a shot.\nSUCCESS! You've hit the target.");
                hiddenBoard[row][col].hitShip();
                gameBoard[row][col].hitShip();
                actionCounter++;
                break;
        }
    }
}

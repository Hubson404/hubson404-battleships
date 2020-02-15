package pl.hubson404.battleships;

import java.util.Scanner;

public class GameEnc {

    public static void main(String[] args) {

        int boardSize;
        int shipsOnBoard;
        int hitCounter = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game of Battleships!\n" +
                "Set the gameboard size:");
        boardSize = scanner.nextInt();

        GameBoard hiddenBoard = new GameBoard(boardSize);
        GameBoard gameBoard = new GameBoard(boardSize);

        System.out.printf("Gameboard size set to: %dx%d\n", boardSize, boardSize);

        gameBoard.showBoard();

        System.out.printf("How many ships should be set on the gameboard? Max = %d.\n",
                boardSize * boardSize);

        shipsOnBoard = scanner.nextInt();

        while (shipsOnBoard > boardSize * boardSize || shipsOnBoard <= 0) {
            System.out.println("That many ships wont fit on board or you picked 0." +
                    " Set new number of ships:");
            shipsOnBoard = scanner.nextInt();

        }

        hiddenBoard.randomShipSetter(shipsOnBoard);

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
                gameBoard.showBoard();

            } else {

                System.out.printf("\nAiming at cell %d-%d\n", row, col);

                if (hiddenBoard.board[row - 1][col - 1].cellState() == 1) {
                    hitCounter++;
                }
                takeAShot(hiddenBoard.board, gameBoard.board, row - 1, col - 1);
                gameBoard.showBoard();
                System.out.printf("Ships left on board: %d.\n", shipsOnBoard - hitCounter);

            }
        }

        System.out.println("\nYou've destroyed all of the enemy ships!\nYou've won!");

    }

    public static void takeAShot(Cell[][] hiddenBoard, Cell[][] playerBoard,int row, int col){

        int state = hiddenBoard[row][col].cellState();

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
                hiddenBoard[row][col].hitShip();
                playerBoard[row][col].hitShip();
                break;
            case 2:
                System.out.println("You missed again.");
                break;
        }
    }
}


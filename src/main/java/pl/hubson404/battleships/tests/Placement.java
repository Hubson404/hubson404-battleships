package pl.hubson404.battleships.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Placement {

    static List<String> positions = new LinkedList<>();
    static int shipSize = 5;
    static Random random = new Random();
    static int i = 0;
    static int row = 0;
    static int col = 0;

    public static void main(String[] args) {


        while (i < shipSize) {

            i = 0;
            int direction = random.nextInt(4);
            int rowPlacement = random.nextInt(10);
            int colPlacement = random.nextInt(10);


            switch (direction){
                case 0:
                    placeLeft();
                    break;
                case 1:
                    placeRight();
                    break;
                case 2:
                    placeUp();
                    break;
                case 3:
                    placeDown();
                    break;
            }

            for (String placement : positions) {
                System.out.println(placement);
            }
        }
    }

    public static void placeLeft(){
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(10);
            col = random.nextInt(10);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row - j, col);
                if (!positions.contains(placement) && (row - j) < 10 && (row - j) >= 0) {
                    z++;
                }
            }
        }
        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row - j, col);
            positions.add(placement);
            i++;
        }
    }

    public static void placeRight(){
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(10);
            col = random.nextInt(10);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row + j, col);
                if (!positions.contains(placement) && (row + j) < 10 && (row + j) >= 0) {
                    z++;
                }
            }
        }

        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row + j, col);
            positions.add(placement);
            i++;
        }
    }

    public static void placeUp(){
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(10);
            col = random.nextInt(10);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row, col +j);
                if (!positions.contains(placement) && (col + j) < 10 && (col + j) >= 0) {
                    z++;
                }
            }
        }
        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row, col + j);
            positions.add(placement);
            i++;
        }
    }

    public static void placeDown(){
        int z = 0;
        while (z < shipSize) {
            row = random.nextInt(10);
            col = random.nextInt(10);
            z = 0;
            for (int j = 0; j < shipSize; j++) {
                String placement = String.format("%d-%d", row, col -j);
                if (!positions.contains(placement) && (col - j) < 10 && (col - j) >= 0) {
                    z++;
                }
            }
        }
        for (int j = 0; j < shipSize; j++) {
            String placement = String.format("%d-%d", row, col - j);
            positions.add(placement);
            i++;
        }
    }


}

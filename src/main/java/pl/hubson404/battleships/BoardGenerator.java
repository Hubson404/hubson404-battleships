package pl.hubson404.battleships;

public class BoardGenerator {


//    public BoardGenerator(int size) {
//        trueGenerator(size);

        //        Cell board[][] = new Cell[size][size];

//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                board[i][j] = new Cell();
//
//            }
//        }
//    }
    public Cell[][] generator(int size){

        Cell[][] board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }
}

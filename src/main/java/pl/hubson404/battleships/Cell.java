package pl.hubson404.battleships;

public class Cell {

    // status = 0 -- empty cell, default
    // status = 1 -- ship in this cell
    // status = -1 --- ship is destroyed in this cell
    // status = 2 --- shot missed

    private int status = 0;

    public void placeShip(){
        setStatus(1);
    }

    public void hitShip(){
        setStatus(-1);
    }

    public void markMiss(){
        setStatus(2);
    }

    public int cellState(){
        int state = getStatus();
        return state;
    }

    public void drawCell(){
        int cellStatus = getStatus();

        if (cellStatus == -1){
            System.out.print("|X|");
        }else if (cellStatus == 0){
            System.out.print(" # ");
        }else if (cellStatus == 1){
            System.out.print("|o|");
        }else{
            System.out.print("mss");
        }
    }

    private void setStatus(int status) {
        this.status = status;
    }

    private int getStatus() {
        return status;
    }
}

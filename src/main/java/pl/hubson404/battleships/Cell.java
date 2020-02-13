package pl.hubson404.battleships;

public class Cell {

    // status = 0 -- empty cell, default
    // status = 1 -- ship in this cell
    // status = -1 --- ship destroyed in this cell

    private int status = 0;

    public void placeShip(){
        setStatus(1);
    }

    public void wreckShip(){
        setStatus(-1);
    }

    public void checkCell(){
        int cellStatus = getStatus();

        if (cellStatus == -1){
            System.out.print("\\X/");
        }else if (cellStatus == 0){
            System.out.print(" ~ ");
        }else{
            System.out.print("\\_/");
        }
    }

    private void setStatus(int status) {
        this.status = status;
    }

    private int getStatus() {
        return status;
    }
}

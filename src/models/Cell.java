package models;

public  class Cell {
    private int cellNumber;
    private CellType cellType;

    public CellType getCellType() {
        return cellType;
    }


    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }


    public int getCellNumber() {
        return cellNumber;
    }


    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

}

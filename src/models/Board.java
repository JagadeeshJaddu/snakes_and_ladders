package models;

import java.util.List;

public class Board {
    private List<Cell> boardCells;

    public List<Cell> getBoardCells() {
        return boardCells;
    }

    public void setBoardCells(List<Cell> boardCells) {
        this.boardCells = boardCells;
    }
    
}

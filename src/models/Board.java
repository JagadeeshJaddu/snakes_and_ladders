package models;

import java.util.ArrayList;
import java.util.List;

import strategy.BoardCreationStrategy;

public class Board {
    private int boardSize;
    private List<Cell> boardCells;
    private BoardCreationStrategy boardCreationStrategy;

    public Board()
    {
        boardCells = new ArrayList<>();
    }
    public Board(BoardCreationStrategy boardCreationStrategy)
    {
        this();
        this.boardCreationStrategy = boardCreationStrategy;
    }
    public List<Cell> getBoardCells() {
        return boardCells;
    }

    public void setBoardCells(List<Cell> boardCells) {
        this.boardCells = boardCells;
    }

    public int getBoardSize() {
        return boardSize;
    }
    
    public void setBoardSize(int boardSize)
    {
        this.boardSize = boardSize;
    }
    public void createBoard()
    {
        Board board = this.boardCreationStrategy.createBoard();
        this.boardSize = board.getBoardSize();
        this.boardCells = board.getBoardCells();
    }
}

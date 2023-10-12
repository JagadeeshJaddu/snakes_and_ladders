package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Board;
import models.Cell;
import models.CellType;
import models.ObjectCell;

public class NormalBoardCreationStrategy implements BoardCreationStrategy {
    private Scanner scanner;

    public NormalBoardCreationStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Board createBoard() {
        Board board = new Board();
        List<Cell> boardCells = new ArrayList<>();
        System.out.println("Enter the size of board:");
        int boardSize = scanner.nextInt();
        board.setBoardSize(boardSize);
        Cell cell1 = new Cell();
        cell1.setCellNumber(0);
        boardCells.add(cell1);
        for (int i = 1; i <=(boardSize * boardSize); i++) {
            System.out.println("Is " + (i) + "th cell normal or object:(Normal - N / Object - O)");
            String ans = scanner.nextLine();
            if (ans.equalsIgnoreCase("N")) {
                Cell cell = new Cell();
                cell.setCellNumber(i + 1);
                cell.setCellType(CellType.Normal);
                boardCells.add(cell);
            } else {
                ObjectCell cell = new ObjectCell();
                cell.setCellNumber(i + 1);
                System.out.println("Enter the final position of the snake's tail or ladder's top:");
                int finalCellNumber = scanner.nextInt();
                cell.setFinalCellNumber(finalCellNumber);
                System.out.println("Enter if it is a Snake(S) or Ladder(L):");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("S")) {
                    cell.setCellType(CellType.Snake);
                } else {
                    cell.setCellType(CellType.Ladder);
                }
                boardCells.add(cell);
            }
        }
        scanner.close();
        board.setBoardCells(boardCells);
        
        return board;
    }

}

package strategy;

import java.util.List;
import java.util.Scanner;
import models.Cell;
import models.CellType;
import models.Game;
import models.ObjectCell;
import models.Player;

public class AllWinGamePlayingStrategy implements GamePlayingStrategy {

    private Scanner scanner;

    public AllWinGamePlayingStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Game play(Game game) {
        System.out.println("Welcome to the game.");
        int totalWinners = 0;
        int finalCellNumber = game.getBoard().getBoardSize();
        finalCellNumber = finalCellNumber * finalCellNumber;
        int totalPlayers = game.getPlayers().size();
        int currentPlayer = 0;
        List<Player> players = game.getPlayers();
        List<Cell> boardCells = game.getBoard().getBoardCells();
        while (true) {
            if (totalWinners == players.size()) {
                break;
            }
            if (players.get(currentPlayer).getCurrentCell().getCellNumber() == finalCellNumber) {
                currentPlayer = (currentPlayer + 1) % totalPlayers;
            }
            System.out.println("Enter the number(1-6) player " + players.get(currentPlayer).getUser().getName() + ":");
            int currentRoll = scanner.nextInt();
            int currnetCellNumber = players.get(currentPlayer).getCurrentCell().getCellNumber();
            int nextCellNumber = 0;
            Cell nextCell;
            if (currnetCellNumber + currentRoll >= finalCellNumber) {
                nextCellNumber = finalCellNumber;
                nextCell = boardCells.get(nextCellNumber);
                totalWinners++;
            } else {
                nextCellNumber = currnetCellNumber + currentRoll;
                nextCell = boardCells.get(nextCellNumber);
                if (nextCell.getCellType() == CellType.Normal) {
                    nextCell = boardCells.get(nextCellNumber);
                } else {
                    ObjectCell tempCell = (ObjectCell) nextCell;
                    int finalCell = tempCell.getFinalCellNumber();
                    nextCell = boardCells.get(finalCell);
                }
            }
            players.get(currentPlayer).setCurrentCell(nextCell);

        }
        return game;
    }

}

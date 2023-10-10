package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Board;
import models.Cell;
import models.Game;
import models.Player;
import models.User;

public class NormalGameCreationStrategy implements GameCreationStrategy {

    private Scanner scanner;

    public NormalGameCreationStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Game createGame(Board board) {
        Game game = new Game();
        game.setBoard(board);
        System.out.println("Enter the no.of players:");
        int totalPlayers = scanner.nextInt();
        Cell cell = board.getBoardCells().get(0);
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < totalPlayers; i++) {
            System.out.println("Enter the name of the user:");
            String name = scanner.nextLine();
            Player player = new Player();
            player.setUser(new User(name));
            player.setCurrentCell(cell);
            players.add(player);
        }
        scanner.close();
        return game;
    }

}

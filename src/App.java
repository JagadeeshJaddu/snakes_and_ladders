import models.Board;
import models.Game;
import strategy.AllWinGamePlayingStrategy;
import strategy.BoardCreationStrategy;
import strategy.GameCreationStrategy;
import strategy.GamePlayingStrategy;
import strategy.NormalBoardCreationStrategy;
import strategy.NormalGameCreationStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Snakes and Ladders.");
        BoardCreationStrategy boardCreationStrategy = new NormalBoardCreationStrategy();
        GameCreationStrategy gameCreationStrategy = new NormalGameCreationStrategy();
        GamePlayingStrategy gamePlayingStrategy = new AllWinGamePlayingStrategy();
        Board board = boardCreationStrategy.createBoard();
        Game game = gameCreationStrategy.createGame(board);
        game = gamePlayingStrategy.play(game);
    }
}

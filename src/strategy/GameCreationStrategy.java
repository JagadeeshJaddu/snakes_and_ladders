package strategy;

import models.Board;
import models.Game;

public interface GameCreationStrategy {
    Game createGame(Board board);
}

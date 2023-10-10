package strategy;

import models.Game;

public interface GamePlayingStrategy {
    Game play(Game game);
}

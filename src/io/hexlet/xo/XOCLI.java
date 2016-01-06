package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        final Player player1 = new Player("Konstantin", Figure.X);
        final Player player2 = new Player("Diana", Figure.O);
        final Player[] players = {player1, player2};
        final Game gameXO = new Game(players, new Field(3, 3), "GameXO");
        final ConsoleView cv = new ConsoleView();
        while (cv.move(gameXO)) {
            cv.show(gameXO);
        }
    }

}

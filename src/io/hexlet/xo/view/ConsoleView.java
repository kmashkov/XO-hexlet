package io.hexlet.xo.view;

import io.hexlet.xo.controller.CurrentMoveController;
import io.hexlet.xo.controller.MoveController;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController cmc = new CurrentMoveController();
    private final WinnerController wc = new WinnerController();
    private final MoveController mc = new MoveController();

    public void show(Game game) {
        System.out.printf("Game - %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.width; x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(field, x);
        }
    }
    
    public boolean move(Game game) {
        final Field field = game.getField();
        final Figure currentFigure = cmc.currentMove(field);
        final Figure winner = wc.getWinner(field);
        if(winner != null) {
            System.out.printf("\nGAME OVER! The winner is %s!", winner);
            return false;
        }
        if(currentFigure == null) {
            System.out.println("\nGAME OVER!");
        }
        System.out.printf("Plese input point for %s(x, y).\n", currentFigure);
        Point movePoint = askPoint();
        try {
            mc.applyFigure(field, movePoint, currentFigure);
        } catch (AlreadyOccupiedException e) {
            try {
                System.out.printf("Point already occupied by %s.\n", field.getFigure(movePoint));
            } catch (InvalidPointException e1) {
                e1.printStackTrace();
                throw new RuntimeException(e1);
            }
        } catch (InvalidPointException e) {
            System.out.println("Wrong point. Please, input again.");
        }
        return true;
    }

    private Point askPoint() {
        final int x = askCoordinate("x") - 1;
        final int y = askCoordinate("y") - 1;
        return new Point(x, y);
    }

    private int askCoordinate(final String coordinate) {
        System.out.printf("Please input %s: ", coordinate);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.height; y++) {
            if (y != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("\n-----------");
    }

}

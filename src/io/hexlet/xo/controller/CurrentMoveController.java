package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = countFigures(field);
        if(countFigure == field.width * field.height) {
            return null;
        }
        if(countFigure % 2 == 0) {
            return Figure.X;
        }
        return Figure.O;
    }

    private int countFigures(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.width; x++) {
            for (int y = 0; y < field.height; y++) {
                try {
                    if(field.getFigure(new Point(x, y)) != null) {
                        countFigure++;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        return countFigure;
    }

}

package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(Field field) {
        try {
            for (int i = 0; i < field.height; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }
            for (int i = 0; i < field.width; i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }
            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                return field.getFigure(new Point(field.width - 1, field.height - 1));
            }
            if (check(field, new Point(field.width - 1, field.height - 1), p -> new Point(p.x - 1, p.y - 1))) {
                return field.getFigure(new Point(field.width, field.height));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(Field field, Point currentPoint, PointGenerator pointGenerator) {
        final Point nextPoint;
        final Figure currentFigure;
        final Figure nextFigure;
        try {
            currentFigure = field.getFigure(currentPoint);
            nextPoint = pointGenerator.next(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }
        if (currentFigure == null) {
            return false;
        }
        if (currentFigure != nextFigure) {
            return false;
        }
        return check(field, nextPoint, pointGenerator);
    }

    private interface PointGenerator {
        Point next(final Point point);
    }

}

package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {
    public final int width;
    public final int height;
    public static final int MIN_COORDINATE = 0;
    private final Figure[][] field;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Figure[width][height];
    }

    public int getSize() {
        return field.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (field[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, width) && checkCoordinate(point.y, height);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}

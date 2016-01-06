package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class WinnerControllerTest {

    int testFieldWidth = 4;
    int testFieldHeight = 4;

    @Test
    public void testGetWinnerFirstRow() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldWidth; i++) {
            mc.applyFigure(field, new Point(i, 0), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerMiddleRow() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldWidth; i++) {
            mc.applyFigure(field, new Point(i, testFieldHeight / 2), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerLastRow() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldWidth; i++) {
            mc.applyFigure(field, new Point(i, testFieldHeight - 1), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerFirstColumn() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldHeight; i++) {
            mc.applyFigure(field, new Point(0, i), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerMiddleColumn() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldHeight; i++) {
            mc.applyFigure(field, new Point(testFieldWidth / 2, i), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerLastColumn() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldHeight; i++) {
            mc.applyFigure(field, new Point(testFieldWidth - 1, i), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerDiagonalLeft() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldWidth; i++) {
            for (int j = 0; j < testFieldHeight; j++) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerDiagonalRight() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = testFieldWidth - 1; i >= 0; i--) {
            for (int j = testFieldHeight - 1; j >= 0; j--) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

}
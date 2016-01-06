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
    public void testGetWinnerRow() throws Exception {
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldHeight; i++) {
            final Field field = new Field(testFieldWidth, testFieldHeight);
            for (int j = 0; j < testFieldWidth; j++) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
            final Figure actualValue = wc.getWinner(field);
            Assert.assertEquals(inputFigure, actualValue);
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        final Figure wrongFigure = Figure.X;
        for (int i = 0; i < testFieldHeight; i++) {
            final Field field = new Field(testFieldWidth, testFieldHeight);
            for (int j = 0; j < testFieldWidth - 1; j++) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
            mc.applyFigure(field, new Point(i, testFieldWidth - 1), wrongFigure);
            final Figure actualValue = wc.getWinner(field);
            Assert.assertNull(actualValue);
        }
    }

    @Test
    public void testGetWinnerColumn() throws Exception {
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldWidth; i++) {
            final Field field = new Field(testFieldWidth, testFieldHeight);
            for (int j = 0; j < testFieldHeight; j++) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
            final Figure actualValue = wc.getWinner(field);
            Assert.assertEquals(inputFigure, actualValue);
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        final Figure wrongFigure = Figure.X;
        for (int i = 0; i < testFieldWidth; i++) {
            final Field field = new Field(testFieldWidth, testFieldHeight);
            for (int j = 0; j < testFieldHeight - 1; j++) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
            mc.applyFigure(field, new Point(i, testFieldHeight - 1), wrongFigure);
            final Figure actualValue = wc.getWinner(field);
            Assert.assertNull(actualValue);
        }
    }

    @Test
    public void testGetWinnerDiagonalLeft() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = 0; i < testFieldWidth; i++) {
            mc.applyFigure(field, new Point(i, i), inputFigure);
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerDiagonalLeftWhenNoWinner() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        final Figure wrongFigure = Figure.X;
        final int maxX = testFieldWidth - 1;
        final int maxY = testFieldHeight - 1;
        for (int i = 0; i < maxX; i++) {
            mc.applyFigure(field, new Point(i, i), inputFigure);
        }
        mc.applyFigure(field, new Point(maxX, maxY), wrongFigure);
        final Figure actualValue = wc.getWinner(field);
        Assert.assertNull(actualValue);
    }

    @Test
    public void testGetWinnerDiagonalRight() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        for (int i = testFieldWidth - 1; i >= 0; i--) {
            for (int j = 0; j < testFieldHeight - 1; j++) {
                mc.applyFigure(field, new Point(i, j), inputFigure);
            }
        }
        final Figure actualValue = wc.getWinner(field);
        Assert.assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetWinnerDiagonalRightWhenNoWinner() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final Figure inputFigure = Figure.O;
        final Figure wrongFigure = Figure.X;
        final int maxX = testFieldWidth - 1;
        final int maxY = testFieldHeight - 1;
        for (int i = maxX - 1; i >= 0; i--) {
            mc.applyFigure(field, new Point(i, i), inputFigure);
        }
        mc.applyFigure(field, new Point(maxX, maxY), wrongFigure);
        final Figure actualValue = wc.getWinner(field);
        Assert.assertNull(actualValue);
    }

}
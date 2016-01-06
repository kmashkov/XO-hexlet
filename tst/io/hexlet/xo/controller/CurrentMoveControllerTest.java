package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class CurrentMoveControllerTest {

    int testFieldWidth = 3;
    int testFieldHeight = 3;
    
    @Test
    public void testCurrentMoveRow() throws Exception {
        final MoveController mc = new MoveController();
        final CurrentMoveController cmc = new CurrentMoveController();
        final Figure x = Figure.X;
        final Figure o = Figure.O;
        int c = 0;
        final Field field = new Field(testFieldWidth, testFieldHeight);
        mc.applyFigure(field, new Point(c, 0), x);
        mc.applyFigure(field, new Point(++c, 0), o);
        mc.applyFigure(field, new Point(++c, 0), x);
        final Figure actualValue = cmc.currentMove(field);
        Assert.assertEquals(o, actualValue);
    }

    @Test
    public void testCurrentMoveColumn() throws Exception {
        final MoveController mc = new MoveController();
        final CurrentMoveController cmc = new CurrentMoveController();
        final Figure x = Figure.X;
        final Figure o = Figure.O;
        int c = 0;
        final Field field = new Field(testFieldWidth, testFieldHeight);
        mc.applyFigure(field, new Point(0, c), x);
        mc.applyFigure(field, new Point(0, ++c), o);
        final Figure actualValue = cmc.currentMove(field);
        Assert.assertEquals(x, actualValue);
    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws Exception {
        final MoveController mc = new MoveController();
        final CurrentMoveController cmc = new CurrentMoveController();
        final Figure x = Figure.X;
        final Figure o = Figure.O;
        int c = 0;
        final Field field = new Field(testFieldWidth, testFieldHeight);
        mc.applyFigure(field, new Point(0, 0), x);
        mc.applyFigure(field, new Point(0, 1), o);
        mc.applyFigure(field, new Point(0, 2), x);
        mc.applyFigure(field, new Point(1, 0), o);
        mc.applyFigure(field, new Point(1, 1), x);
        mc.applyFigure(field, new Point(1, 2), o);
        mc.applyFigure(field, new Point(2, 0), x);
        mc.applyFigure(field, new Point(2, 1), o);
        mc.applyFigure(field, new Point(2, 2), x);
        final Figure actualValue = cmc.currentMove(field);
        Assert.assertNull(actualValue);
    }
}
package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.fail;

public class MoveControllerTest {

    int testFieldWidth = 3;
    int testFieldHeight = 3;

    @Test
    public void testApplyFigure() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        mc.applyFigure(field, inputPoint, inputFigure);
        final Figure actualValue = field.getFigure(inputPoint);
        Assert.assertEquals(inputFigure, actualValue);
    }
    
    @Test
    public void testApplyFigureWhenOccupied() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final MoveController mc = new MoveController();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        mc.applyFigure(field, inputPoint, inputFigure);
        try {
            mc.applyFigure(field, inputPoint, inputFigure);
            fail();
        } catch (AlreadyOccupiedException e) {
            e.printStackTrace();
        }
    }

}
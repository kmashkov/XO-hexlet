package io.hexlet.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class FieldTest {
    
    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();
        final int actualValue = field.getSize();
        final int expectedValue = 3;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Figure expectedValue = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualValue = field.getFigure(inputPoint);
        assertEquals(expectedValue, actualValue);
    }
}
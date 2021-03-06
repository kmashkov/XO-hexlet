package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    int testFieldWidth = 3;
    int testFieldHeight = 3;

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final int actualValue = field.getSize();
        final int expectedValue = 3;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        field.setFigure(inputPoint, inputFigure);
        final Figure actualValue = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(0, 0);
        final Figure actualValue = field.getFigure(inputPoint);
        assertNull(actualValue);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(-1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(field.getSize() + 1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(0, -1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(0, field.getSize() + 1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenXAndYIsLessThenZero() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(-1, -1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenXAndYIsMoreThenSize() throws Exception {
        final Field field = new Field(testFieldWidth, testFieldHeight);
        final Point inputPoint = new Point(field.getSize() + 1, field.getSize() + 1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

}
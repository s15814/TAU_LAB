package com.pjwstk.figure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleTest {
    private Figure rectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle();
    }

    @Test
    public void Should_ReturnFalse_When_AmountOfSidesIsIncorrect() {
        //Given

        //When
        boolean result = rectangle.isBuildingFigurePossible(1, 2, 3);

        //Then
        assertFalse(result);
    }

    @Test
    public void Should_ReturnTrue_When_AllSidesAreEqual() {
        //Given

        //When
        boolean result = rectangle.isBuildingFigurePossible(2, 2, 2, 2);

        //Then
        assertTrue(result);
    }

    @Test
    public void Should_ReturnTrue_When_TwoPairsOfSidesAreEqual() {
        //Given

        //When
        boolean result = rectangle.isBuildingFigurePossible(2, 4, 4, 2);

        //Then
        assertTrue(result);
    }

    @Test
    public void Should_ReturnFalse_When_AllSidesAreDifferentSize() {
        //Given

        //When
        boolean result = rectangle.isBuildingFigurePossible(1, 2, 3, 4);

        //Then
        assertFalse(result);
    }
}
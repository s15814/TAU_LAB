package com.pjwstk.figure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTest {
    private Figure triangle;

    @BeforeEach
    public void setUp() {
        triangle = new Triangle();
    }

    @Test
    public void Should_ReturnFalse_When_AmountOfSidesIsIncorrect() {
        //Given

        //When
        boolean result = triangle.isBuildingFigurePossible(1, 2, 3, 4);

        //Then
        assertFalse(result);
    }

    @Test
    public void Should_ReturnTrue_When_AllSidesAreEqual() {
        //Given

        //When
        boolean result = triangle.isBuildingFigurePossible(2, 2, 2);

        //Then
        assertTrue(result);
    }

    @Test
    public void Should_ReturnFalse_When_TwoSidesAreVeryShort() {
        //Given

        //When
        boolean result = triangle.isBuildingFigurePossible(1, 2, 10);

        //Then
        assertFalse(result);
    }
}